package com.chat.features.caasandra;

import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Set;

@Configuration
@EnableCassandraRepositories(basePackages = "com.chat.features.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
    ConnectionProperties cassandraBeanConfig;

    @Autowired
    CassandraConfig(ConnectionProperties cassandraBeanConfig) {
        this.cassandraBeanConfig = cassandraBeanConfig;
    }

    @Override
    protected String getKeyspaceName() {
        return cassandraBeanConfig.getKeyspace();
    }

    @Override
    protected String getContactPoints() {
        return cassandraBeanConfig.getHosts();
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.chat.agent.assist.repository"};
    }

    @Override
    public int getPort() {
        return cassandraBeanConfig.getPort();
    }

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setContactPoints(cassandraBeanConfig.getHosts());
        cluster.setPort(cassandraBeanConfig.getPort());

        PlainTextAuthProvider authProvider = new PlainTextAuthProvider(cassandraBeanConfig.getUsername(), cassandraBeanConfig.getPassword());
        cluster.setAuthProvider(authProvider);

        cluster.setKeyspaceCreations(getKeyspaceCreations());
        cluster.setReconnectionPolicy(new ConstantReconnectionPolicy(1000));
        cluster.setMetricsEnabled(false);
        cluster.setSslEnabled(cassandraBeanConfig.isSsl());

        /*SSLConfig trustStoreConfig = cassandraBeanConfig.getTrustStorePath() != null && !cassandraBeanConfig.getTrustStorePath().isEmpty() ? SSLConfig.JKSTrustStoreConfig(cassandraBeanConfig.getTrustStorePath(), cassandraBeanConfig.getTrustStorePassword()) : null;
        SSLUtils.getSSLContext.apply(Optional.empty(), Optional.ofNullable(trustStoreConfig)).
                map(SSLUtils.getSSLOptions).
                ifPresent(cluster::setSslOptions);*/

        return cluster;

    }

    @Bean
    @Override
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setInitialEntitySet(getInitialEntitySet());
        return mappingContext;
    }

    @Override
    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
        return CassandraEntityClassScanner.scan(getEntityBasePackages());
    }
}

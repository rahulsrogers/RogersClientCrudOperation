package com.chat.features.caasandra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
//@ConfigurationProperties()
@EnableCassandraRepositories(
        basePackageClasses = com.chat.features.repository.RogersClientRepo.class)
public class CassandraConfig extends AbstractCassandraConfiguration {



    @Override
    protected String getKeyspaceName() {
        return "vafeature";
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9142);
        cluster.setUsername("cassandra");
        cluster.setPassword("cassandra");
        return cluster;
    }

//
//    protected boolean getMetricsEnabled() {
//        return false;
//    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }


}

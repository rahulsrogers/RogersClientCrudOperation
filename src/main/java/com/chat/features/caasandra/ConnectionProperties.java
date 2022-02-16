package com.chat.features.caasandra;//package com.chat.agent.assist.config.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.function.Predicate;

@ConfigurationProperties(prefix = "cassandra")
@Data
public class ConnectionProperties {
    public static final Predicate<String> isEmpty = value -> value == null || value.isEmpty();
    String hosts;

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public void setTrustStorePath(String trustStorePath) {
        this.trustStorePath = trustStorePath;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    private int port;
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSsl() {
        return ssl;
    }

    public String getTrustStorePath() {
        return trustStorePath;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    boolean ssl;
    String trustStorePath;
    String trustStorePassword;
    String keyspace;


    public String getKeyspace() {
        return keyspace;
    }

    public int getPort() {
        return port;
    }

    public String getHosts() {
        return hosts;
    }
}

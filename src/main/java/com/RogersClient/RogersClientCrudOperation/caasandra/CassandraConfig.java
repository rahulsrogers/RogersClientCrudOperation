package com.RogersClient.RogersClientCrudOperation.caasandra;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;


//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
@Configuration
public class CassandraConfig  extends  AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "vafeature";
    }


    public String getContactPoints() {
        return "localhost";
    }




//
//    @Bean
//    public  CqlSession session() {
//
//        return CqlSession.builder().withKeyspace("vafeature").build();
//
//    }

/*
    @Bean
    public CqlSessionFactoryBean session_1() {

        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
       // session.setContactPoints("localhost");
        session.setKeyspaceName("vafeature");
        session.setPort(9042);

        return session;
    }*/






}

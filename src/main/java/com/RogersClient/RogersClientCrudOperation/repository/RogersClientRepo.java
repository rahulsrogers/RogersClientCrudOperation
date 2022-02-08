package com.RogersClient.RogersClientCrudOperation.repository;

import com.RogersClient.RogersClientCrudOperation.model.RogersClientModel;
//import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface RogersClientRepo extends CassandraRepository<RogersClientModel,Integer> {
}

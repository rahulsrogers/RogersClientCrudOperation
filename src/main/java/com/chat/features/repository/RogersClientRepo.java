package com.chat.features.repository;

import com.chat.features.model.RogersClientModel;
//import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
public interface RogersClientRepo extends CassandraRepository<RogersClientModel,Integer> {

    public RogersClientModel findGid(String id);
}

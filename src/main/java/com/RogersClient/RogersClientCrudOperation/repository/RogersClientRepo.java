package com.RogersClient.RogersClientCrudOperation.repository;

import com.RogersClient.RogersClientCrudOperation.model.RogersClientModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RogersClientRepo extends CassandraRepository<RogersClientModel,Integer> {
}

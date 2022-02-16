package com.chat.features.repository;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;
//import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
public interface RogersClientRepo extends CassandraRepository<RogersClientModel,Integer> {

    public RogersClientModel findByid(String id);
//    public FeatureDetails save(FeatureDetails featureDetails);
//    public void DeleteById(String id);
//    public FeatureRequest save(FeatureRequest featureRequest);
//    public FeatureRequest find_Gid(String id);
    public List<RogersClientModel> findAll();

}

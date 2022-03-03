package com.chat.features.repository;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.RogersClientModel;
//import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
public interface RogersClientRepo extends CassandraRepository<RogersClientModel, String> {
   @AllowFiltering
    public RogersClientModel findByid(String id);
//    public FeatureDetails save(FeatureDetails featureDetails);
//    public void DeleteById(String id);
//    public FeatureRequest save(FeatureRequest featureRequest);
//    public FeatureRequest find_Gid(String id);

    //public List<RogersClientModel> findAll();
   // public List<List<FeatureDetails>> findgroupBy(@RequestParam(required = false) Optional<String>from_date,@RequestParam(required = false)Optional<String> to_date,
     //                                             @RequestParam(required = false)Optional<String> group_by);
    public List<RogersClientModel> findAllByLaunchDateBetween(String toDate, String fromDate);


}

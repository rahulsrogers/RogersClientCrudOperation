package com.chat.features.api;

import com.chat.features.model.RogersClientModel;
import com.chat.features.repository.RogersClientRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Validated
@Api(value = "user", description = "the user API")
public interface RogersApi {

    @Autowired
    public static RogersClientRepo ROGERS_CLIENT_REPO = null;



    default List<RogersClientModel> getData() {
        return  ROGERS_CLIENT_REPO.findAll();
    }
    default Optional<RogersClientModel> getdataById(String id){return  ROGERS_CLIENT_REPO.findById(Integer.valueOf(id));}

    default RogersClientModel addDeatils(){
        RogersClientModel FeatureRequest = new RogersClientModel();
        return ROGERS_CLIENT_REPO.save(FeatureRequest); }


    default List<RogersClientModel> addDeatilsAll(){
        RogersClientModel FeatureRequest = new RogersClientModel();
        List<RogersClientModel> list=new ArrayList<>();
        list.addAll((Collection<? extends RogersClientModel>) FeatureRequest);
        return (List<RogersClientModel>) ROGERS_CLIENT_REPO.saveAll(list); }


    default void _deleteFeature(String id){
        RogersClientModel FeatureRequest = new RogersClientModel();
        ROGERS_CLIENT_REPO.deleteById(Integer.valueOf(id));
    }
    default RogersClientModel updateData(String id ){
        RogersClientModel FeatureRequest = new RogersClientModel();
        RogersClientModel existing=ROGERS_CLIENT_REPO.findGid(FeatureRequest.getGuid());
        existing.setBrand(FeatureRequest.getBrand());
        existing.setBusinessValue(FeatureRequest.getBusinessValue());
        existing.setExpectedRoi(FeatureRequest.getExpectedRoi());
        existing.setTitle(FeatureRequest.getTitle());
        existing.setDescription(FeatureRequest.getDescription());
        existing.setLaunchDate(FeatureRequest.getLaunchDate());
        existing.setLaunchQuarter(FeatureRequest.getLaunchQuarter());
        existing.setLaunchYear(FeatureRequest.getLaunchYear());
        existing.setProductOwner(FeatureRequest.getProductOwner());
        return ROGERS_CLIENT_REPO.save(FeatureRequest);
    }
}

package com.RogersClient.RogersClientCrudOperation.service;

import com.RogersClient.RogersClientCrudOperation.model.RogersClientModel;
import com.RogersClient.RogersClientCrudOperation.repository.RogersClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RogersClientService {
    @Autowired
    private RogersClientRepo rogersClientRepo;
    public RogersClientModel saveRogersClientModel(RogersClientModel RogersClientModel){
        return  rogersClientRepo.save(RogersClientModel);
    }

    public List<RogersClientModel> saveRogersClientModels(List<RogersClientModel> RogersClientModels){
        return  rogersClientRepo.saveAll(RogersClientModels);
    }
    public List<RogersClientModel> getRogersClientModels(){
        return  rogersClientRepo.findAll();
    }
    public RogersClientModel getRogersClientModelsById(int id){
        return  rogersClientRepo.findById(id).orElse(null);
    }

    public  String deleteRogersClientModel(int id){
        rogersClientRepo.deleteById(id);
        return  "RogersClientModel remove from id "+id;
    }


    public  RogersClientModel updateRogersClientModel(RogersClientModel RogersClientModel){
        RogersClientModel existing=rogersClientRepo.findById(RogersClientModel.getGuid()).orElse(null);
        existing.setBrand(RogersClientModel.getBrand());
        existing.setBusiness_value(RogersClientModel.getBusiness_value());
        existing.setExpected_roi(RogersClientModel.getExpected_roi());
        existing.setFeature_title(RogersClientModel.getFeature_title());
        existing.setFeature_description(RogersClientModel.getFeature_description());
        existing.setLaunch_datetime(RogersClientModel.getLaunch_datetime());
        existing.setLaunch_quarter(RogersClientModel.getLaunch_quarter());
        existing.setLaunch_year(RogersClientModel.getLaunch_year());
        existing.setProduct_owner(RogersClientModel.getProduct_owner());

        return  rogersClientRepo.save(existing);
    }

}

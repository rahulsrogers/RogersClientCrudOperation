package com.chat.features.service;

import com.chat.features.model.RogersClientModel;
import com.chat.features.repository.RogersClientRepo;
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
        RogersClientModel existing=rogersClientRepo.findGid(RogersClientModel.getGuid());
        existing.setBrand(RogersClientModel.getBrand());
        existing.setBusinessValue(RogersClientModel.getBusinessValue());
        existing.setExpectedRoi(RogersClientModel.getExpectedRoi());
        existing.setTitle(RogersClientModel.getTitle());
        existing.setDescription(RogersClientModel.getDescription());
        existing.setLaunchDate(RogersClientModel.getLaunchDate());
        existing.setLaunchQuarter(RogersClientModel.getLaunchQuarter());
        existing.setLaunchYear(RogersClientModel.getLaunchYear());
        existing.setProductOwner(RogersClientModel.getProductOwner());

        return  rogersClientRepo.save(existing);
    }

}

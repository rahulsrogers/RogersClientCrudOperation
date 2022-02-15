package com.chat.features.service;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;
import com.chat.features.repository.RogersClientRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RogersClientService implements  RogersService{


     RogersClientRepo rogersClientRepo;

     public RogersClientService(RogersClientRepo rogersClientRepo){
         this.rogersClientRepo=rogersClientRepo;
     }


    @Override
    public List<FeatureDetails> getTodos() {
        List<FeatureDetails> todos = new ArrayList<>();
        rogersClientRepo.findAll();
        return todos;

    }

    public FeatureDetails getTodoById(String id) {

        return rogersClientRepo.findGid(id);
    }

    @Override
    public FeatureDetails insert(FeatureDetails todo) {
        return rogersClientRepo.save(todo);
    }

    @Override
    public void updateTodo(String id,FeatureDetails featureDetails) {
FeatureDetails existing=rogersClientRepo.findGid(id);
        System.out.println(existing.toString());
        existing.setBrand(featureDetails.getBrand());
        existing.setBusinessValue(featureDetails.getBusinessValue());
        existing.setExpectedRoi(featureDetails.getExpectedRoi());
        existing.setTitle(featureDetails.getTitle());
        existing.setDescription(featureDetails.getDescription());
        existing.setLaunchDate(featureDetails.getLaunchDate());
        existing.setLaunchQuarter(featureDetails.getLaunchQuarter());
        existing.setLaunchYear(featureDetails.getLaunchYear());
        existing.setProductOwner(featureDetails.getProductOwner());
rogersClientRepo.save(existing);
    }

    @Override
    public void deleteTodo(String todoId) {
rogersClientRepo.DeleteById(todoId);
    }

    @Override
    public FeatureRequest insert(FeatureRequest todo) {
        return rogersClientRepo.save(todo);
    }

    @Override
    public void updateTodo(String id, FeatureRequest featureRequest) {
        FeatureRequest existing=rogersClientRepo.find_Gid(id);
        System.out.println(existing.toString());
        existing.setBrand(featureRequest.getBrand());
        existing.setBusinessValue(featureRequest.getBusinessValue());
        existing.setExpectedRoi(featureRequest.getExpectedRoi());
        existing.setTitle(featureRequest.getTitle());
        existing.setDescription(featureRequest.getDescription());
        existing.setLaunchDate(featureRequest.getLaunchDate());
        existing.setLaunchQuarter(featureRequest.getLaunchQuarter());
        existing.setLaunchYear(featureRequest.getLaunchYear());
        existing.setProductOwner(featureRequest.getProductOwner());
        rogersClientRepo.save(existing);
    }
}

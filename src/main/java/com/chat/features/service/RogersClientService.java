package com.chat.features.service;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;
import com.chat.features.repository.RogersClientRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class RogersClientService implements  RogersService{


     RogersClientRepo rogersClientRepo;

     public RogersClientService(RogersClientRepo rogersClientRepo){
         this.rogersClientRepo=rogersClientRepo;
     }


    @Override
    public List<RogersClientModel> getTodos() {
        List<RogersClientModel> todos = new ArrayList<>();
        rogersClientRepo.findAll();
        return todos;

    }

    public RogersClientModel getTodoById(String id) {

        return rogersClientRepo.findByid(id);
    }



    @Override
    public String  insert(FeatureRequest todo) {
        RogersClientModel model = new RogersClientModel();

        model.setTitle(todo.getTitle());
        model.setLaunchYear(todo.getLaunchYear());
        model.setProductOwner(todo.getProductOwner());
       // model.setLaunchQuarter(todo.getLaunchQuarter());
        model.setDescription(todo.getDescription());
        model.setLaunchDate(todo.getLaunchDate());
        //model.setBrand(todo.getBrand());
        model.setExpectedRoi(todo.getExpectedRoi());
        model.setBusinessValue(todo.getBusinessValue());

        // similarly set all other details to RogersClientModel
        rogersClientRepo.save(model);
        return model.getGuid();



    }

    @Override
    public void updateTodo(String id,FeatureRequest featureDetails) {
RogersClientModel existing=rogersClientRepo.findByid(id);
        System.out.println(existing.toString());
       // existing.setBrand(featureDetails.getBrand());
        existing.setBusinessValue(featureDetails.getBusinessValue());
        existing.setExpectedRoi(featureDetails.getExpectedRoi());
        existing.setTitle(featureDetails.getTitle());
        existing.setDescription(featureDetails.getDescription());
        existing.setLaunchDate(featureDetails.getLaunchDate());
       // existing.setLaunchQuarter(featureDetails.getLaunchQuarter());
        existing.setLaunchYear(featureDetails.getLaunchYear());
        existing.setProductOwner(featureDetails.getProductOwner());
rogersClientRepo.save(existing);
    }

    @Override
    public void deleteTodo(String id) {
        RogersClientModel rogersClientModel=new RogersClientModel();
       // rogersClientRepo.deleteById(Integer.valueOf(id));
      //  rogersClientModel.setIs_deleted(Boolean.TRUE);
         System.out.println("Deleted the record ");


    }


}

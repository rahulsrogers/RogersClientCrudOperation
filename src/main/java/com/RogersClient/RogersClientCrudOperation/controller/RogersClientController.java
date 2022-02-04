package com.RogersClient.RogersClientCrudOperation.controller;

import com.RogersClient.RogersClientCrudOperation.model.RogersClientModel;
import com.RogersClient.RogersClientCrudOperation.service.RogersClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RogersClientController {
@Autowired
private RogersClientService RogersClientService;

    @PostMapping("/add")
    public RogersClientModel addRogersClientModel(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.saveRogersClientModel (RogersClientModel);
    }
    @PostMapping("/addAllRogersClientModels")
    public List<RogersClientModel> addRogersClientModels(@RequestBody List<RogersClientModel> RogersClientModels){
        return  RogersClientService.saveRogersClientModels(RogersClientModels);
    }

    @GetMapping("/getRogersClientModels")
    public  List<RogersClientModel> findAllRogersClientModel(){
        return  RogersClientService.getRogersClientModels();
    }

    @GetMapping("/getRogersClientModelById/{id}")
    public  RogersClientModel findAllRogersClientModels(@PathVariable int id){
        return  RogersClientService.getRogersClientModelsById(id);
    }
/*
    @GetMapping("/getRogersClientModelsByName/{name}")
    public  RogersClientModel findAllRogersClientModels(@PathVariable String  name){
        return  RogersClientService.getRogersClientModelsByName(name);
    }*/

    @DeleteMapping("/deleteById/{id}")
    public  String deleteRogersClientModel(@PathVariable int id){
        RogersClientService.deleteRogersClientModel(id);
        return "RogersClientModel delete "+id; }


    @PutMapping("/update")
    public  RogersClientModel updateRogersClientModel(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.updateRogersClientModel(RogersClientModel);
    }

}

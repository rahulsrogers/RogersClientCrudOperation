package com.RogersClient.RogersClientCrudOperation.controller;

import com.RogersClient.RogersClientCrudOperation.model.RogersClientModel;
import com.RogersClient.RogersClientCrudOperation.service.RogersClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RogersClientController {
@Autowired
private RogersClientService RogersClientService;

    @PostMapping("/add")
    @ApiOperation(value = "Saving the specific data ",
    notes = "Providing the data from end-users data",
    response = RogersClientModel.class)
    public RogersClientModel addRogersClientModel(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.saveRogersClientModel (RogersClientModel);
    }
    @PostMapping("/addAllRogersClientModels")
    @ApiOperation(value = "Saving bunch of data ",
            notes = "Providing the data from end-users data",
            response = RogersClientModel.class)
    public List<RogersClientModel> addRogersClientModels(@RequestBody List<RogersClientModel> RogersClientModels){
        return  RogersClientService.saveRogersClientModels(RogersClientModels);
    }

    @GetMapping("/getRogersClientModels")
    @ApiOperation(value = "find  the all data ",
            notes = "fetching all the data from the database ",
            response = RogersClientModel.class)
    public  List<RogersClientModel> findAllRogersClientModel(){
        return  RogersClientService.getRogersClientModels();
    }

    @GetMapping("/getRogersClientModelById/{id}")
    @ApiOperation(value = "find  the all data ",
            notes = "fetching  data by passing the id from the database ",
            response = RogersClientModel.class)
    public  RogersClientModel findAllRogersClientModels(@PathVariable int id){
        return  RogersClientService.getRogersClientModelsById(id);
    }
/*
    @GetMapping("/getRogersClientModelsByName/{name}")
    public  RogersClientModel findAllRogersClientModels(@PathVariable String  name){
        return  RogersClientService.getRogersClientModelsByName(name);
    }*/

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(value = "delete  the all data ",
            notes = "deleting the data from the database ",
            response = RogersClientModel.class)
    public  String deleteRogersClientModel(@PathVariable int id){
        RogersClientService.deleteRogersClientModel(id);
        return "RogersClientModel delete "+id; }


    @PutMapping("/update")
    @ApiOperation(value = "updating  the all data ",
            notes = "updating the data by using the id  ",
            response = RogersClientModel.class)
    public  RogersClientModel updateRogersClientModel(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.updateRogersClientModel(RogersClientModel);
    }

}

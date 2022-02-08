package com.chat.features.controller;

import com.chat.features.model.RogersClientModel;
import com.chat.features.service.RogersClientService;
//import io.swagger.annotations.ApiOperation;
//mport io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "RogersCrud", description = "RogersCrud Operation")
public class RogersClientController {
    @Autowired
private RogersClientService RogersClientService;

    @PostMapping("/feature")
//    @ApiOperation(value = "Saving the specific data ",
//    notes = "Providing the data from end-users data",
//    response = RogersClientModel.class)
    @Operation(summary = "Saving the single data", description = "Saving the data", tags = { "RogersClient" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public RogersClientModel addFeature(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.saveRogersClientModel (RogersClientModel);
    }
    @PostMapping("/feature")
    @Operation(summary = "Saving all the data ", description = "Saving the data", tags = { "GID" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public List<RogersClientModel> addFeature(@RequestBody List<RogersClientModel> RogersClientModels){
        return  RogersClientService.saveRogersClientModels(RogersClientModels);
    }

    @GetMapping("/getRogersClientModels")
    @Operation(summary = "Find all the data", description = "Feching the bundle of data", tags = { "GID" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public  List<RogersClientModel> getFeatures(){
        return  RogersClientService.getRogersClientModels();
    }

    @GetMapping("/feature/{id}")
    @Operation(summary = "Find data by GID", description = "Feching the data by passing the GID", tags = { "GID" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public  RogersClientModel getFeature(@PathVariable int id){
        return  RogersClientService.getRogersClientModelsById(id);
    }
/*
    @GetMapping("/getRogersClientModelsByName/{name}")
    public  RogersClientModel findAllRogersClientModels(@PathVariable String  name){
        return  RogersClientService.getRogersClientModelsByName(name);
    }*/

    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "Deleting the data", description = "Deleting the data occurding GID t", tags = { "GID" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public  String deleteFeature(@PathVariable int id){
        RogersClientService.deleteRogersClientModel(id);
        return "RogersClientModel delete "+id; }


    @PutMapping("/update")
    @Operation(summary ="updated the data ", description = "Id search by %name% format", tags = { "GId" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = RogersClientModel.class)))) })

    public  RogersClientModel updateFeature(@RequestBody RogersClientModel RogersClientModel){
        return  RogersClientService.updateRogersClientModel(RogersClientModel);
    }

}

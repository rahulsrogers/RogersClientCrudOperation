package com.chat.features.controller;

import com.chat.features.api.FeatureApi;
import com.chat.features.api.RogersApi;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;
import com.chat.features.repository.RogersClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FeatureApiController implements RogersApi {

    private  final FeatureApi  featureApi;
    @Autowired
    public  RogersApi ROGERS_API = null;

    public FeatureApiController(
            @Autowired(required = false) FeatureApi delegate) {
        this.featureApi = Optional.ofNullable(delegate)
                .orElse(new FeatureApi() {});
    }

@GetMapping("/feature")
public List<RogersClientModel> getData(){
        return  ROGERS_API.getData();
}

@GetMapping("/feature/{id}")
public Optional<RogersClientModel> getdataById(@PathVariable String id){
        return  ROGERS_API.getdataById(id);
    }


@PostMapping("/feature")
@Override
public RogersClientModel addDeatils(){
        return ROGERS_API.addDeatils();
}

@PostMapping("/feature")
    public List<RogersClientModel> addDeatilsAll(){
        return ROGERS_API.addDeatilsAll();

    }

@DeleteMapping("/feature/{id}")
    public void _deleteFeature(@PathVariable  String id){
ROGERS_API._deleteFeature(id);}


    @PutMapping("/feature/{id}")
    public RogersClientModel updateData(@PathVariable  String id){
       return  ROGERS_API.updateData(id);

    }





}

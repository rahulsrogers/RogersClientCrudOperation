package com.chat.features.controller;

import com.chat.features.api.FeatureApi;
import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.ResponseStatus;
import com.chat.features.model.RogersClientModel;
import com.chat.features.service.RogersClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeatureApiController implements FeatureApi {


   private RogersClientService rogersClientService;

   public FeatureApiController(RogersClientService rogersClientService){

       this.rogersClientService=rogersClientService;
   }


@GetMapping("/feature")
public ResponseEntity<FeatureDetails>_getFeature(){
       List<RogersClientModel> list=rogersClientService.getTodos();
        return new ResponseEntity<FeatureDetails>((FeatureDetails) list, HttpStatus.OK);
}

@GetMapping("/feature/{id}")
public ResponseEntity<List<FeatureDetails>> getFeatures(@PathVariable String id) {
    List<FeatureDetails> list= (List<FeatureDetails>) rogersClientService.getTodoById(id);
    return new ResponseEntity<>(list, HttpStatus.OK);
}

@PostMapping("/feature")
    public ResponseEntity<ResponseStatus> _addFeature(  FeatureRequest featureRequest) {
        String id =rogersClientService.insert(featureRequest);
       HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.add("id",id);
        return new ResponseEntity(null, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/feature/{id")
    public ResponseEntity<ResponseStatus> deleteFeature(@PathVariable  String id){
        rogersClientService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/feature/{id}")
       public ResponseEntity<ResponseStatus> updateFeature(@PathVariable String id,@RequestBody FeatureRequest featureRequest){
           rogersClientService.updateTodo(id, featureRequest);
           return new ResponseEntity(rogersClientService.getTodoById(id), HttpStatus.OK);
       }


}

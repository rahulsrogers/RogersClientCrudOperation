package com.chat.features.controller;

import com.chat.features.api.FeatureApi;
import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.ResponseStatus;
import com.chat.features.model.RogersClientModel;
import com.chat.features.service.RogersClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FeatureApiController implements FeatureApi {


   private RogersClientService rogersClientService;

   @Autowired

   public FeatureApiController(RogersClientService rogersClientService){

       this.rogersClientService=rogersClientService;
   }

@Override

@GetMapping("/feature")
public ResponseEntity<List<FeatureDetails>> getFeatures(){
    List<FeatureDetails> featureDetails=rogersClientService.getTodos();
       try{
         if (featureDetails.isEmpty())
             return  new ResponseEntity<>(featureDetails,HttpStatus.NO_CONTENT);
         else return  new ResponseEntity<>(featureDetails,HttpStatus.OK);
     }catch (Exception e){
         return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
     }



}




//
//    try{
//        List<RogersClientModel> list=rogersClientService.getTodos();
//
//        Iterator iterator= list.iterator();
//        while (iterator.hasNext()) {
//        List<FeatureDetails> list1= (List<FeatureDetails>) iterator.next();
//            return new ResponseEntity(list1,HttpStatus.OK);
//        }
//
//
//        } catch(Exception e) {
//           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//   return null;
//}
@Override
@GetMapping("/feature/{id}")
public ResponseEntity<FeatureDetails> getFeature(@PathVariable String id) {

try {
    FeatureDetails featureDetails =  rogersClientService.getTodoById(id);

        return new ResponseEntity(featureDetails, HttpStatus.OK);
    }
catch (Exception e){
    return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
}
//    List<FeatureDetails> list= (List<FeatureDetails>) rogersClientService.getTodoById(id);
//    return new ResponseEntity<>(list, HttpStatus.OK);
}

@PostMapping("/feature")
    public ResponseEntity<ResponseStatus> _addFeature(  FeatureRequest featureRequest) {
     String id =rogersClientService.insert(featureRequest);
       HttpHeaders httpHeaders = new HttpHeaders();

       try {

           ResponseStatus responseStatus = new ResponseStatus();
           responseStatus.setCode("201");
           httpHeaders.add("id",id);
           responseStatus.setCodeName("Success");
           return new ResponseEntity(responseStatus, httpHeaders, HttpStatus.CREATED);

          // return new ResponseEntity(id, httpHeaders, HttpStatus.CREATED);
       }catch (Exception e){

              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/feature/{id}")
    public ResponseEntity<ResponseStatus> deleteFeature(@PathVariable  String id){
        ResponseStatus responseStatus = new ResponseStatus();
       try{
        rogersClientService.deleteTodo(id);
        responseStatus.setCode("201");
           responseStatus.setCodeName("Success");
        return new ResponseEntity<>(responseStatus,HttpStatus.OK);}
       catch (Exception e){
           responseStatus.setCode("500");
           responseStatus.setCodeName("Internal Server Error");
           return  new ResponseEntity<>(responseStatus,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("/feature/{id}")
       public ResponseEntity<ResponseStatus> updateFeature(@PathVariable String id,@RequestBody FeatureRequest featureRequest){
        ResponseStatus responseStatus = new ResponseStatus();
       try {
              rogersClientService.updateTodo(id, featureRequest);

              responseStatus.setCode("201");
              responseStatus.setCodeName("Success");
              return new ResponseEntity<>(responseStatus,HttpStatus.OK);
             // return new ResponseEntity(rogersClientService.getTodoById(id), HttpStatus.OK);
          }catch (Exception e){
           responseStatus.setCode("500");
           responseStatus.setCodeName("Internal Server Error");
              return  new ResponseEntity<>(responseStatus,HttpStatus.INTERNAL_SERVER_ERROR);
          }
       }


}

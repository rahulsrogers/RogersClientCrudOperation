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
@CrossOrigin(origins = "http://10.18.168.219:8080")
@RequestMapping("/api")
public class FeatureApiController implements FeatureApi {


   private RogersClientService rogersClientService;

   @Autowired

   public FeatureApiController(RogersClientService rogersClientService){

       this.rogersClientService=rogersClientService;
   }


@GetMapping("/feature")
public ResponseEntity<List<FeatureDetails>> _getFeatures(@RequestParam(required = false) String id){
       try {
        List<FeatureDetails> tutorials = new ArrayList<FeatureDetails>();
        Iterator iterator=tutorials.iterator();
           while (iterator.hasNext()) {
               if (id == null) {

                   rogersClientService.getTodos();
                   tutorials.add((FeatureDetails) iterator.next());
               }
           }



        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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

@GetMapping("/feature/{id}")
public ResponseEntity<List<FeatureDetails>> getFeatures(@PathVariable String id) {

try {
    List<FeatureDetails> tutorialData = (List<FeatureDetails>) rogersClientService.getTodoById(id);
    if (tutorialData.equals(tutorialData)) {
        return new ResponseEntity(tutorialData, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}catch (Exception e){
    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
//    List<FeatureDetails> list= (List<FeatureDetails>) rogersClientService.getTodoById(id);
//    return new ResponseEntity<>(list, HttpStatus.OK);
}

@PostMapping("/feature")
    public ResponseEntity<ResponseStatus> _addFeature(  FeatureRequest featureRequest) {
     String id =rogersClientService.insert(featureRequest);
       HttpHeaders httpHeaders = new HttpHeaders();
      // httpHeaders.add("id",id);
       try {
           httpHeaders.add("id",id);
           return new ResponseEntity(id, httpHeaders, HttpStatus.CREATED);
       }catch (Exception e){
              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/feature/{id}")
    public ResponseEntity<ResponseStatus> deleteFeature(@PathVariable  String id){
        rogersClientService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/feature/{id}")
       public ResponseEntity<ResponseStatus> updateFeature(@PathVariable String id,@RequestBody FeatureRequest featureRequest){
           rogersClientService.updateTodo(id, featureRequest);
           return new ResponseEntity(rogersClientService.getTodoById(id), HttpStatus.OK);
       }


}

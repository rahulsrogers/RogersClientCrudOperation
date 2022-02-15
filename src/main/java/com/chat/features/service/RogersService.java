package com.chat.features.service;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;

import java.util.List;

public interface RogersService {

    List<FeatureDetails> getTodos();

    FeatureDetails getTodoById(String id);

    FeatureDetails insert(FeatureDetails todo);

    void updateTodo(String id,FeatureDetails featureDetails);

    void deleteTodo(String todoId);

    FeatureRequest insert(FeatureRequest todo);

    void updateTodo(String id,FeatureRequest featureRequest);



}

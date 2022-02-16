package com.chat.features.service;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;

import java.util.List;

public interface RogersService {

    List<RogersClientModel> getTodos();

    RogersClientModel getTodoById(String id);

    String insert(FeatureRequest todo);

    void updateTodo(String id,FeatureRequest featureDetails);

    void deleteTodo(String todoId);






}

package com.chat.features.service;

import com.chat.features.model.FeatureDetails;
import com.chat.features.model.FeatureRequest;
import com.chat.features.model.RogersClientModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface RogersService {

    List<FeatureDetails> getTodos();

    FeatureDetails getTodoById(String id);

    String insert(FeatureRequest todo);

    void updateTodo(String id,FeatureRequest featureDetails);

    void deleteTodo(String todoId);






}

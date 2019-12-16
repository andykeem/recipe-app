package com.example.demorecipe.service;

import com.example.demorecipe.entity.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAll();
}

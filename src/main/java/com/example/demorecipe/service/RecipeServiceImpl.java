package com.example.demorecipe.service;

import com.example.demorecipe.entity.Recipe;
import com.example.demorecipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepo;

    public RecipeServiceImpl(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepo.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}

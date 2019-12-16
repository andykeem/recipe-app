package com.example.demorecipe.service;

import com.example.demorecipe.entity.Recipe;
import com.example.demorecipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    private RecipeServiceImpl sut;

    @Mock
    private RecipeRepository recipeRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    public void test_findAll() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        when(recipeRepo.findAll()).thenReturn(recipes);

        Set<Recipe> actual = sut.findAll();
        assertEquals(recipes, actual);

        verify(recipeRepo, times(1)).findAll();
    }
}
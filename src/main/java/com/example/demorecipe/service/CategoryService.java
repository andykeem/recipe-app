package com.example.demorecipe.service;

import com.example.demorecipe.entity.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> findAll();
}

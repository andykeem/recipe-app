package com.example.demorecipe.service;

import com.example.demorecipe.entity.Category;
import com.example.demorecipe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> set = new HashSet<>();
        categoryRepo.findAll().iterator().forEachRemaining(set::add);
        return set;
    }
}

package com.example.demorecipe.converter;

import com.example.demorecipe.command.CategoryCommand;
import com.example.demorecipe.command.RecipeCommand;
import com.example.demorecipe.entity.Category;
import com.example.demorecipe.entity.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Consumer;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    /*private final RecipeCommandToRecipe recipeCommandToRecipe;

    public CategoryCommandToCategory(RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }*/

    @Synchronized
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }
        final Category target = new Category();
        target.setId(source.getId());
        target.setName(source.getName());

        /*if (source.getRecipes() != null) {
            Set<RecipeCommand> set = source.getRecipes();
            set.forEach(new Consumer<RecipeCommand>() {
                @Override
                public void accept(RecipeCommand recipeCommand) {
                    Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
                    target.getRecipes().add(recipe);
                }
            });
        }*/

        return target;
    }
}

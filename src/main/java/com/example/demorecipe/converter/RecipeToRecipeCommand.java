package com.example.demorecipe.converter;

import com.example.demorecipe.command.CategoryCommand;
import com.example.demorecipe.command.IngredientCommand;
import com.example.demorecipe.command.RecipeCommand;
import com.example.demorecipe.entity.Category;
import com.example.demorecipe.entity.Ingredient;
import com.example.demorecipe.entity.Note;
import com.example.demorecipe.entity.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NoteToNoteCommand noteConverter;
    private final IngredientToIngredientCommand ingredConverter;
    private final CategoryToCategoryCommand catConverter;

    public RecipeToRecipeCommand(NoteToNoteCommand noteConverter,
                                 IngredientToIngredientCommand ingredConverter,
                                 CategoryToCategoryCommand catConverter) {
        this.noteConverter = noteConverter;
        this.ingredConverter = ingredConverter;
        this.catConverter = catConverter;
    }

    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand target = new RecipeCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setPrepTime(source.getPrepTime());
        target.setCookTime(source.getCookTime());
        target.setServings(source.getServings());
        target.setSource(source.getSource());
        target.setUrl(source.getUrl());
        target.setDirection(source.getDirection());
        target.setDifficulty(source.getDifficulty());
        target.setImage(source.getImage());

        Note note = source.getNote();
        target.setNote(noteConverter.convert(note));

        if (source.getIngredients() != null && !source.getIngredients().isEmpty()) {
            source.getIngredients().forEach(new Consumer<Ingredient>() {
                @Override
                public void accept(Ingredient ingredient) {
                    IngredientCommand cmd = ingredConverter.convert(ingredient);
                    target.getIngredients().add(cmd);
                }
            });
        }

        if (source.getCategories() != null && !source.getCategories().isEmpty()) {
            source.getCategories().forEach(new Consumer<Category>() {
                @Override
                public void accept(Category category) {
                    long catId = category.getId();
                    target.getCategoryIds().add(catId);
                }
            });
        }

        return target;
    }
}
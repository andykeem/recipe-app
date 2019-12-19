package com.example.demorecipe.converter;

import com.example.demorecipe.command.CategoryCommand;
import com.example.demorecipe.entity.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryCommand target = new CategoryCommand();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

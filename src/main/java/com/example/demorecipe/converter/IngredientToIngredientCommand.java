package com.example.demorecipe.converter;

import com.example.demorecipe.command.IngredientCommand;
import com.example.demorecipe.entity.Ingredient;
import com.example.demorecipe.entity.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        final IngredientCommand target = new IngredientCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setAmount(source.getAmount());
        UnitOfMeasure uom = source.getUom();
        target.setUom(uomConverter.convert(uom));

        return target;
    }
}
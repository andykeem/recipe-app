package com.example.demorecipe.converter;

import com.example.demorecipe.command.UnitOfMeasureCommand;
import com.example.demorecipe.entity.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasureCommand target = new UnitOfMeasureCommand();
        target.setId(source.getId());
        target.setValue(source.getValue());
        return target;
    }
}

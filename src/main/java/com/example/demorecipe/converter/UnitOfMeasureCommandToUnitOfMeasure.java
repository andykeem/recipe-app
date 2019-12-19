package com.example.demorecipe.converter;

import com.example.demorecipe.command.UnitOfMeasureCommand;
import com.example.demorecipe.entity.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasure target = new UnitOfMeasure();
        target.setId(source.getId());
        target.setValue(source.getValue());
        return target;
    }
}
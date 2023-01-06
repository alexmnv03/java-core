package com.alex.javacore.javaoop.converterentitydto.data;

import java.io.Serializable;

/**
 * Абстракция добавляет автомитически Id к классу
 * @param <T>
 * @param <I>
 * @param <O>
 */
public abstract class AbstractIdentifiableConverter
        <T extends Serializable, I extends Identifiable<T>, O extends Identifiable<T>>
        implements Converter<I, O> {

    @Override
    public O convert(I input) {
        final O output = createOutput();
        output.setId(input.getId());
        return output;
    }

    protected abstract O createOutput();
}


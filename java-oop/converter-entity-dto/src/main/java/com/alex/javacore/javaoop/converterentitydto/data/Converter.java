package com.alex.javacore.javaoop.converterentitydto.data;

public interface Converter<I, O> {

    O convert(I input);
}

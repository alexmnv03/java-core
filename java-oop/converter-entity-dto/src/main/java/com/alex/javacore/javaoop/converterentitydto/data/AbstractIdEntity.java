package com.alex.javacore.javaoop.converterentitydto.data;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Абстрактная Hibernate сущность c id.
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractIdEntity<I extends Serializable> implements Identifiable<I> {

    private static final long serialVersionUID = 6331369708130810826L;

    /**
     * Имя поля таблицы первичного ключа.
     */
    public static final String ID_COLUMN = "id";

    /**
     * Уникальный идентификатор сущности - первичный ключ.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    @Access(AccessType.PROPERTY)
    private I id;
}


package com.alex.javacore.javaoop.converterentitydto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alex.javacore.javaoop.converterentitydto.data.AbstractIdEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity extends AbstractIdEntity<Long> {

    protected static final String TABLE_NAME = "user_tb";

    @Column(name = "user_first_name", nullable = false)
    private String userFirsName;

    @Column(name = "user_last_name")
    private String userLastName;

    private String country;

    @Column(nullable = false)
    private Integer inn;

}

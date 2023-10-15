package com.alex.javacore.javaoop.converterentitydto.dto;

import com.alex.javacore.javaoop.converterentitydto.data.AbstractId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@RequiredArgsConstructor
// @AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class UserDto extends AbstractId<Long> {

    private String userFirsName;

    @NotBlank(message = "The \"userLastName\" attribute must not be empty")
    private String userLastName;

    private String country;

    @NotBlank(message = "The \"inn\" attribute must not be empty")
    private Integer inn;

}

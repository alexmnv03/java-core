package com.alex.javacore.javaoop.converterentitydto.converter;

import com.alex.javacore.javaoop.converterentitydto.data.AbstractIdentifiableConverter;
import com.alex.javacore.javaoop.converterentitydto.dto.UserDto;
import com.alex.javacore.javaoop.converterentitydto.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityConverter extends AbstractIdentifiableConverter<Long, UserDto, UserEntity> {

    @Override
    public UserEntity convert(UserDto input) {
        final UserEntity output = super.convert(input);
        output.setUserFirsName(input.getUserFirsName());
        output.setUserLastName(input.getUserLastName());
        output.setCountry(input.getCountry());
        output.setInn(input.getInn());
        return output;
    }

    @Override
    protected UserEntity createOutput() {
        return new UserEntity();
    }

}

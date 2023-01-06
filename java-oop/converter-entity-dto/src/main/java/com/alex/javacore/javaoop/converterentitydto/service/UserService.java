package com.alex.javacore.javaoop.converterentitydto.service;

import com.alex.javacore.javaoop.converterentitydto.dto.UserDto;
import com.alex.javacore.javaoop.converterentitydto.entity.UserEntity;
import org.springframework.http.ResponseEntity;


public interface UserService {

    void createUser(UserEntity user);

    ResponseEntity<UserDto> findUser(Long id);

}

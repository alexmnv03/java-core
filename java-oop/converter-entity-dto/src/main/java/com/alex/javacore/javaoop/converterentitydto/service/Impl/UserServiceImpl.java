package com.alex.javacore.javaoop.converterentitydto.service.Impl;

import java.util.Optional;

import javax.transaction.Transactional;

import com.alex.javacore.javaoop.converterentitydto.converter.UserEntityToDtoConverter;
import com.alex.javacore.javaoop.converterentitydto.dto.UserDto;
import com.alex.javacore.javaoop.converterentitydto.entity.UserEntity;
import com.alex.javacore.javaoop.converterentitydto.repository.UserRepository;
import com.alex.javacore.javaoop.converterentitydto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityToDtoConverter userEntityToDtoConverter;

    // TODO: добавить получение всех пользователей и конвертор
    @Override
    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    public Optional<UserEntity> getUser(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            log.info("find user by id:{}", userOptional.get());
            return userOptional;
        } else {
            log.info("notFoundEntity");
            return Optional.empty();
        }
    }

    @Override
    public ResponseEntity<UserDto> findUser(Long id) {
        Optional<UserEntity> userOptional = getUser(id);
        if (userOptional.isPresent()) {
            UserDto dto = userEntityToDtoConverter.convert(userOptional.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            log.info("notFoundEntity");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

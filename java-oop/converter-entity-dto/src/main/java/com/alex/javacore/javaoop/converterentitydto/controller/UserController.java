package com.alex.javacore.javaoop.converterentitydto.controller;

import java.util.List;

import com.alex.javacore.javaoop.converterentitydto.dto.UserDto;
import com.alex.javacore.javaoop.converterentitydto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(UserController.API_URL)
@Tag(name = "Content API", description = "Контроллер msu es")
public class UserController {

    protected static final String API_URL = "user";

    private final UserService userService;

    @Operation(summary = "Get user", description = "Get user by id")
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        log.info("getUser by id {}", id);

        return userService.findUser(id);
    }

    @Operation(summary = "Get users", description = "Get users")
    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getUsers() {
        log.info("MachineController -> getAllMachine -> start");
        // return userService.getEntity();
        return null;
    }

}

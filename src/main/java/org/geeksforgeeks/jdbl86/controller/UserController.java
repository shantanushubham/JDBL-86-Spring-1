package org.geeksforgeeks.jdbl86.controller;

import org.geeksforgeeks.jdbl86.entity.ErrorResponse;
import org.geeksforgeeks.jdbl86.entity.UserEntity;
import org.geeksforgeeks.jdbl86.execptions.DuplicateEntryException;
import org.geeksforgeeks.jdbl86.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity) {
        try {
            UserEntity addedUser = this.userService.addUser(userEntity);
            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        } catch (DuplicateEntryException exception) {
            return new ResponseEntity<>(ErrorResponse.builder()
                    .message(exception.getMessage())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }
}

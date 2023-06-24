package com.scaler.bookmyshowjune231.controllers;

import com.scaler.bookmyshowjune231.dtos.SignUpUserRequestDto;
import com.scaler.bookmyshowjune231.dtos.SignUpUserResponseDto;
import com.scaler.bookmyshowjune231.models.User;
import com.scaler.bookmyshowjune231.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpUserResponseDto signUpUser(SignUpUserRequestDto request) {
        User user = userService.signUpUser(
                request.getEmail(), request.getPassword()
        );

        SignUpUserResponseDto response = new SignUpUserResponseDto();
        response.setUserId(user.getId());

        return response;
    }
}

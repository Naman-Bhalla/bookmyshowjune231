package com.scaler.bookmyshowjune231;

import com.scaler.bookmyshowjune231.controllers.UserController;
import com.scaler.bookmyshowjune231.dtos.SignUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bookmyshowjune231Application  implements CommandLineRunner {
    private UserController userController;

    @Autowired
    public Bookmyshowjune231Application(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");

        SignUpUserRequestDto request = new SignUpUserRequestDto();
        request.setEmail("prakhar@scaler.com");
        request.setPassword("password");

        userController.signUpUser(request);
    }

    public static void main(String[] args) {
        SpringApplication.run(Bookmyshowjune231Application.class, args);
//
//        UserController userController = new UserController();
    }

}

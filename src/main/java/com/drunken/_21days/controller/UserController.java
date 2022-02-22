package com.drunken._21days.controller;

import com.drunken._21days.domain.User;
import com.drunken._21days.domain.enums.UseYn;
import com.drunken._21days.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Transactional
    @GetMapping("/users")
    public List<User> allUsers() {

        User findMember = userService.findByName("member1");

        if (findMember == null) {

            User user = User.builder().name("member1").email("member1@21days.com").useYn(UseYn.Y).regUser(1L).modUser(1L).build();
            userService.saveUser(user);
        }
        log.info("user={}", userService.findByName("member1"));
        return userService.findAllUsers();
    }


}

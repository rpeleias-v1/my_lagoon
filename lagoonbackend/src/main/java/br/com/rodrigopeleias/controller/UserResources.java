package br.com.rodrigopeleias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserResources {

    @RequestMapping(value = "/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }
}

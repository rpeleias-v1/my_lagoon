package br.com.rodrigopeleias.controller;

import br.com.rodrigopeleias.models.User;
import br.com.rodrigopeleias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserResources {

    private UserService userService;

    @Autowired
    public UserResources(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }

    @RequestMapping(value = "/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {
        return userService.findByUserName(userName);
    }
}

package br.senai.sc.devinhouse.servletboot.controllers;

import br.senai.sc.devinhouse.servletboot.models.User;
import br.senai.sc.devinhouse.servletboot.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> get() {
        System.out.println("GET :");
        List<User> users;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            return null;
        }
        return users;
    }

    @GetMapping("/{id}")
    public User getId(@PathVariable("id") Integer id) {
        System.out.println("GET :" + id);
        User user;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @PostMapping
    public User post(@RequestBody User user) {
        System.out.println("POST :" + user);
        user = userService.create(user);
        return user;
    }

    @PutMapping("/{id}")
    public User put(@PathVariable("id") Integer id, @RequestBody User user) throws Exception {
        System.out.println("PUT: " + user);
        user = userService.update(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        System.out.println("DELETE: " + id);
        try {
            userService.remove(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

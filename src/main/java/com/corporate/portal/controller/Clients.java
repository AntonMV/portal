package com.corporate.portal.controller;

import com.corporate.portal.dao.UsersDao;
import com.corporate.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Clients {

    private final UsersDao usersDAO;

    @Autowired
    public Clients(UsersDao usersDAO) {
        this.usersDAO = usersDAO;
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user) {
        usersDAO.saveUser(user);
        return user;
    }

    @GetMapping("/clients/{sigmaLogin}")
    public User getUsers(@PathVariable("sigmaLogin") String sigmaLogin) {
        return usersDAO.findUser(sigmaLogin);
    }


    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> putUsers(@RequestBody User user, @PathVariable("id") int id) {
        usersDAO.putUser(user, id);
        return usersDAO.allList();
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> deleteUsers(@PathVariable("id") int id) {
        usersDAO.deleteUser(id);
        return usersDAO.allList();
    }

}

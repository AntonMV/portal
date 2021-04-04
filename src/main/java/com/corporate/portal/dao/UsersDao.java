package com.corporate.portal.dao;

import com.corporate.portal.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersDao {

    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(1,"19115159", "Anton","anton@gamail.com"));
        userList.add(new User(2,"34516734", "Pavel","pavel@gamail.com"));
        userList.add(new User(3,"67812345", "Gleb", "gleb@gamail.com"));
    }

    public User show(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public List<User> allList(){
        return userList.stream().collect(Collectors.toList());
    }

    public void saveUser(User user){
        userList.add(user);
    }

    public User findUser(String sigmaLogin){
        return userList.stream()
                .filter(item -> item.getSigmaLogin().equals(sigmaLogin)).findFirst().orElse(null);
    }

    public void putUser(User updateUser, int id){
        User userToBeUpdated = show(id);
        userToBeUpdated.setId(updateUser.getId());
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSigmaLogin(updateUser.getSigmaLogin());
        userToBeUpdated.setEmail(updateUser.getEmail());

    }

    public void deleteUser(int id){
        userList.removeIf(user -> user.getId() == id);
    }

}

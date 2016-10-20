package ua.com.service;

import ua.com.entity.User;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
public interface UserService{

    void createUser(User user);
    List<User> getUsers();
    void deleteUser(String login);
}

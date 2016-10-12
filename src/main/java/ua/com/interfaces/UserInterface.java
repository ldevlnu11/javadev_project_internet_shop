package ua.com.interfaces;

import ua.com.entity.User;

import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
public interface UserInterface{

    void createUser(User user);
    List<User> getUsers();
    void deleteUser(String login);
}

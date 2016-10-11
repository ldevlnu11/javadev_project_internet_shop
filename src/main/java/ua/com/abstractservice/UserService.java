package ua.com.abstractservice;

import ua.com.entity.User;
import ua.com.interfaces.UserInterface;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
public interface UserService{

    void createUser(User user);
    List<UserInterface> getUsers();
    void deleteUser(String login);
}

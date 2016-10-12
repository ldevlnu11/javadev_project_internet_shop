package ua.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.abstractservice.UserService;
import ua.com.entity.User;
import ua.com.interfaces.UserInterface;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("UserService")
public class UserFuncService implements UserService{

    @Autowired
    private UserInterface userService;

    @Override
    public void createUser(User user){
        userService.createUser(user);
    }

    @Override
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @Override
    public void deleteUser(String login){
        userService.deleteUser(login);
    }
}

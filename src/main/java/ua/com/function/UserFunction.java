package ua.com.function;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.User;
import ua.com.interfaces.UserInterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
@Repository
public class UserFunction implements UserInterface{
    @PersistenceContext(name="primary")
    private EntityManager man;
    private final static String userTable = " User ";
    @Transactional
    public void createUser(User user){
        man.persist(user);
    }

    @Transactional
    public List<UserInterface> getUsers(){
        return man.createQuery("from"+userTable+"u").getResultList();
    }

    @Transactional
    public void deleteUser(String login){
        User user = null;
        try{
            user = (User)man.createQuery("select u from"+userTable+"u where login=:login").setParameter("login", login).getSingleResult();
        }catch(NoResultException e){}
        if(user != null){
            man.remove(user);
        }
    }
}

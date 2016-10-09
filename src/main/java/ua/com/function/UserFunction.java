package ua.com.function;

import ua.com.entity.User;
import ua.com.interfaces.UserInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
public class UserFunction implements UserInterface{
    private static EntityManagerFactory fac;
    private static EntityManager man;
    private final static String userTable = " User ";
    static{
        fac = Persistence.createEntityManagerFactory("primary");
        man = fac.createEntityManager();
    }
    @Override
    public void createUser(User user){
        man.getTransaction().begin();
        man.persist(user);
        man.getTransaction().commit();
    }

    @Override
    public List<UserInterface> getUsers(){
        return man.createQuery("select u from"+userTable+"u").getResultList();
    }

    @Override
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

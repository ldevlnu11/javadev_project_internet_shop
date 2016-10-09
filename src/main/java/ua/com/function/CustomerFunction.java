package ua.com.function;

import ua.com.entity.Customer;
import ua.com.interfaces.CustomerInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Created by devnull on 09.10.16.
 */
public class CustomerFunction implements CustomerInterface{

    private static EntityManagerFactory fac;
    private static EntityManager man;
    private final static String customerTable = " Customer ";
    private Scanner sc = new Scanner(System.in);

    static{
        fac = Persistence.createEntityManagerFactory("primary");
        man = fac.createEntityManager();
    }

    @Override
    public void createCustomer(Customer customer){
        man.getTransaction().begin();
        man.persist(customer);
        man.getTransaction().commit();
    }

    @Override
    public List<Customer> showAllCustomers(){
        return man.createQuery("select c from" + customerTable + "c").getResultList();
    }

    @Override
    public Customer findCustomer(String name){
        Customer customer = null;
        try{
            customer = (Customer)man.createQuery("select c from" + customerTable + "c where c.firstname =:name or c.secondname =:name ")
                    .setParameter("name", name).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Пользователь с данным именем или фамилией не найден.");
        }
        return customer;
    }

    @Override
    public void deleteCustomer(String firstname, String secondname){
        Customer customer = null;
        try{
            customer = (Customer)man.createQuery("select c from" + customerTable + "c where c.firstname =:firstname or c.secondname =:secondname")
                    .setParameter("firstname", firstname)
                    .setParameter("secondname", secondname).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Пользователь с данным именем и фамилией не найден.");
        }
        if(customer != null){
            man.getTransaction().begin();
            man.remove(customer);
            man.getTransaction().commit();
        }
    }

    @Override
    public void updateCustomer(String firstname, String secondname){
        Customer customer = null;
        try{
            customer = (Customer)man.createQuery("select c from" + customerTable + "c where c.firstname =:firstname or c.secondname =:secondname")
                    .setParameter("firstname", firstname)
                    .setParameter("secondname", secondname).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Пользователь с данным именем и фамилией не найден.");
        }
        if(customer != null){
            int x = 0;
            while(x != 1){
                System.out.println("Введите 1, чтобы изменить имя");
                System.out.println("Введите 2, чтобы изменить фамилию");
                System.out.println("Введите 3, чтобы изменить отчество");
                System.out.println("Введите 4, чтобы изменить город");
                System.out.println("Введите 5, чтобы изменить область");
                System.out.println("Введите 6, чтобы изменить район");
                System.out.println("Введите 7, чтобы изменить улицу");
                System.out.println("Введите 8, чтобы изменить номер дома");
                System.out.println("Введите 9, чтобы изменить номер телефона");
                System.out.println("Введите 0, чтобы изменить вернуться");

                switch(sc.next()){
                    case "1":{
                        System.out.println("Введите новое имя");
                        customer.setFirstname(sc.next());
                        break;
                    }case "2":{
                        System.out.println("Введите новую фамилию");
                        customer.setSecondname(sc.next());
                        break;
                    }case "3":{
                        System.out.println("Введите новое отчество");
                        customer.setFathername(sc.next());
                        break;
                    }case "4":{
                        System.out.println("Введите новый город");
                        customer.setCity(sc.next());
                        break;
                    }case "5":{
                        System.out.println("Введите новую область");
                        customer.setProvince(sc.next());
                        break;
                    }case "6":{
                        System.out.println("Введите новый район");
                        customer.setRegion(sc.next());
                        break;
                    }case "7":{
                        System.out.println("Введите новую улицу");
                        customer.setStreet(sc.next());
                        break;
                    }case "8":{
                        System.out.println("Введите новый номер дома");
                        customer.setNumber(sc.nextInt());
                        break;
                    }case "9":{
                        System.out.println("Введите новый номер телефона");
                        customer.setPhone(sc.next());
                        break;
                    }case "0":{
                        x = 1;
                        break;
                    }default:{
                        System.out.println("Выберите действие из списка.");
                        break;
                    }
                }
                man.getTransaction().begin();
                man.merge(customer);
                man.getTransaction().commit();

            }
        }
    }
}


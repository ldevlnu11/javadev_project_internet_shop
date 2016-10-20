package ua.com.dao;

import ua.com.entity.Customer;

import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
public interface CustomerInterface{

    void createCustomer(Customer customer);
    List<Customer> showAllCustomers();
    List<Customer> findCustomer(String name);
    void deleteCustomer(String firstname, String secondname);
    void updateCustomer(String firstname, String secondname);
    void setCustomer(Customer customer);

}

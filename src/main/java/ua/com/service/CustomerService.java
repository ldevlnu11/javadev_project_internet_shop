package ua.com.service;

import ua.com.entity.Customer;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
public interface CustomerService{

    void createCustomer(Customer customer);
    List<Customer> showAllCustomers();
    List<Customer> findCustomer(String name);
    void deleteCustomer(String firstname, String secondname);
    void updateCustomer(String firstname, String secondname);
    Customer getCustomer(String firstname, String secondname);
    void setCustomer(Customer customer);
}

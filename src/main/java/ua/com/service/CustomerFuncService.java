package ua.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.abstractservice.CustomerService;
import ua.com.entity.Customer;
import ua.com.function.CustomerFunction;
import ua.com.interfaces.CustomerInterface;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("CustomerService")
public class CustomerFuncService implements CustomerService{

    @Autowired
    private CustomerInterface customerInterface;

    @Override
    public void createCustomer(Customer customer){
        customerInterface.createCustomer(customer);
    }

    @Override
    public List<Customer> showAllCustomers(){
        return customerInterface.showAllCustomers();
    }

    @Override
    public Customer findCustomer(String name){
        return customerInterface.findCustomer(name);
    }

    @Override
    public void deleteCustomer(String firstname, String secondname){
        customerInterface.deleteCustomer(firstname, secondname);
    }

    @Override
    public void updateCustomer(String firstname, String secondname){
        customerInterface.updateCustomer(firstname, secondname);
    }
}

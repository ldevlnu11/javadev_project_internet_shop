package ua.com.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.dao.CustomerInterface;
import ua.com.entity.Customer;
import ua.com.service.CustomerService;

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
    public List<Customer> findCustomer(String name){
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

    @Override
    public Customer getCustomer(String firstname, String secondname){
        List<Customer> allCustomers = showAllCustomers();
        Customer customer = null;
        for(Customer c : allCustomers){
            if(c.getFirstname().equalsIgnoreCase(firstname) && c.getSecondname().equalsIgnoreCase(secondname)){
                customer = c;
                break;
            }
        }
        return customer;
    }

    @Override
    public void setCustomer(Customer customer){
        customerInterface.setCustomer(customer);
    }
}

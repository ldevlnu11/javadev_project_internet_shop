package ua.com.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ua.com.dao.CustomerInterface;
import ua.com.entity.Customer;
import ua.com.repository.CustomerRepository;
import ua.com.service.CustomerService;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("CustomerService")
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> showAllCustomers(){
        return customerRepository.findAll();
    }


    public List<Customer> findCustomer(String name){
        return customerRepository.findCustomer(name);
    }

    public void deleteCustomer(String firstname, String secondname){
        customerRepository.deleteCustomer(firstname, secondname);
    }

//    public void updateCustomer(String firstname, String secondname){
//        customerRepository.updateCustomer(firstname, secondname);
//    }
//
//    public Customer getCustomer(String firstname, String secondname){
//        List<Customer> allCustomers = showAllCustomers();
//        Customer customer = null;
//        for(Customer c : allCustomers){
//            if(c.getFirstname().equalsIgnoreCase(firstname) && c.getSecondname().equalsIgnoreCase(secondname)){
//                customer = c;
//                break;
//            }
//        }
//        return customer;
//    }
//
//    public void setCustomer(Customer customer){
//        customerRepository.setCustomer(customer);
//    }
}

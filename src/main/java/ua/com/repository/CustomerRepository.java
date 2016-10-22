package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("select c from Customer c where c.firstname =:name or c.secondname =:name ")
	List<Customer> findCustomer(@Param(value = "name")String name);
	
	@Query("delete from Customer c where c.firstname =:fname or c.secondname =:sname ")
	void deleteCustomer(@Param(value = "fname")String fname, @Param(value = "sname") String sname);
	
}

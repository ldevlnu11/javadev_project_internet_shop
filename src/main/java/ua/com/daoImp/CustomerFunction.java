package ua.com.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.dao.CustomerInterface;
import ua.com.entity.Customer;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by devnull on 09.10.16.
 */
@Repository
public class CustomerFunction implements CustomerInterface {

	@PersistenceContext(name = "primary")
	private EntityManager man;
	private final static String customerTable = " Customer ";
	private Scanner sc = new Scanner(System.in);

	@Transactional
	public void createCustomer(Customer customer) {
		man.persist(customer);
	}

	@Transactional
	public List<Customer> showAllCustomers() {
		return man.createQuery("from" + customerTable + "c").getResultList();
	}

	@Transactional
	public List<Customer> findCustomer(String name) {
		List<Customer> customer;
		customer = man
				.createQuery("select c from" + customerTable + "c where c.firstname =:fname or c.secondname =:sname ")
				.setParameter("fname", name).setParameter("sname", name).getResultList();
		return customer;
	}

	@Transactional
	public void deleteCustomer(String firstname, String secondname) {
		Customer customer;
		customer = (Customer) man
				.createQuery("select c from" + customerTable
						+ "c where c.firstname =:firstname and c.secondname =:secondname")
				.setParameter("firstname", firstname).setParameter("secondname", secondname).getSingleResult();
		if (customer != null) {
			man.remove(customer);
		}
	}

	@Transactional
	public void setCustomer(Customer customer) {
		if (customer != null) {
			man.merge(customer);
		}
	}

	@Transactional
	public void updateCustomer(String firstname, String secondname) {
		Customer customer = null;
		customer = (Customer) man
				.createQuery("select c from" + customerTable
						+ "c where c.firstname =:firstname and c.secondname =:secondname")
				.setParameter("firstname", firstname).setParameter("secondname", secondname).getSingleResult();
		man.merge(customer);

	}
}

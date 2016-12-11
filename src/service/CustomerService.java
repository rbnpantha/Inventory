package service;

import java.util.List;

import dao.CustomerDAO;
import dao.UserDAO;
import models.Customer;
import models.User;

public class CustomerService {
	private CustomerDAO customerDAO = new CustomerDAO();
	
     public void add(Customer customer) {
          customerDAO.add(customer);
     }

     public List<Customer> list() {
          return customerDAO.findAll();
     }

     public void deleteById(int id) {
         customerDAO.deleteById(id);
     }
     
     public void findById(int id) {
         customerDAO.findById(id);
     }


     public void update(Customer customer) {
         customerDAO.update(customer);
     }
	
	
	
	
	
	

}

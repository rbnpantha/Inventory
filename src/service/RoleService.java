package service;

import java.util.List;

import dao.RoleDAO;
import dao.UserDAO;
import models.Role;
import models.User;

public class RoleService {
	private RoleDAO roleDAO = new RoleDAO();
	
     public void add(Role role) {
    	 roleDAO.add(role);          
     }

     public List<Role> list() {
          return roleDAO.findAll();          
     }

     public void deleteById(int id) {
    	 roleDAO.deleteById(id);          
     }
     
     public void findById(int id) {
    	 roleDAO.findById(id);          
     }


     public void update(Role role) {
    	 roleDAO.update(role);          
     }
	
	
	
	
	
	

}

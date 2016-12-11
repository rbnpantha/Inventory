package service;

import java.util.List;

import dao.BillDAO;
import dao.UserDAO;
import models.Bill;
import models.User;

public class BillService {
	private BillDAO billDAO = new BillDAO();
	
     public void add(Bill bill) {
          billDAO.add(bill);
     }

     public List<Bill> list() {
          return billDAO.findAll();
     }

     public void deleteById(int id) {
    	 billDAO.deleteById(id);
     }
     
     public void findById(int id) {
    	 billDAO.findById(id);
     }

     public void update(Bill bill) {
    	 billDAO.update(bill);
     }
	
	
	
	
	
	

}

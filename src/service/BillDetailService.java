package service;

import java.util.List;

import dao.BillDAO;
import dao.BillDetailDAO;
import dao.UserDAO;
import models.Bill;
import models.BillDetail;
import models.User;

public class BillDetailService {
	private BillDetailDAO billDetailDAO = new BillDetailDAO();
	
     public void add(BillDetail billDetail) {
         billDetailDAO.add(billDetail);
     }

     public List<BillDetail> list() {
          return billDetailDAO.findAll();
     }

     public void deleteById(int id) {
         billDetailDAO.deleteById(id);
     }
     
     public void findById(int id) {
         billDetailDAO.findById(id);
     }


     public void update(BillDetail billDetail) {
         billDetailDAO.update(billDetail);
     }
	
	
	
	
	
	

}

package dao;

import java.util.ArrayList;
import java.util.List;

import models.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;
import models.User;

public class CustomerDAO implements DAO<Customer>{

	@Override
	public void add(Customer entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/customer.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(Customer entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/customer.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/user.hbm.xml");
		Transaction t = session.beginTransaction();
		Customer customer = (Customer) session.load(Customer.class, id);
		session.delete(customer);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Customer findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Customer customer = new Customer();
		Session session = getSession(cfg, "xml/customer.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(customer, id);
		t.commit();
		session.close();
		return customer;
	}

	@Override
	public List<Customer> findAll() {
	    List<Customer> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/customer.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Customer").getResultList();
        t.commit();
        session.close();
        return list;
	}

	@Override
	public List<Customer> findAllByExample(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public List<User> findByFields(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
*/



}

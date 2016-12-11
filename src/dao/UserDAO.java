package dao;

import java.util.ArrayList;
import java.util.List;

import controllers.AlertController;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import models.User;

public class UserDAO implements DAO<User>{

	@Override
	public void add(User entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/user.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(User entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/user.hbm.xml");
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
		User user = (User) session.load(User.class, id);
		session.delete(user);
		t.commit();
		session.close();

		AlertController a = new AlertController();
		a.deleteConfirmation();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		User user = new User();
		Session session = getSession(cfg, "xml/user.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(user, id);
		t.commit();
		session.close();
		return user;
	}
	
	

	


	@Override
	public List<User> findAll() {
	    List<User> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/user.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from User").getResultList();
        t.commit();
        session.close();
        return list;
	}

	@Override
	public List<User> findAllByExample(User entity) {
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

/*	@Override
	public List<User> findByFields() {
		// TODO Auto-generated method stub
		return null;
	}*/




}

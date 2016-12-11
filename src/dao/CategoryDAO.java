package dao;

import java.util.ArrayList;
import java.util.List;

import models.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;
import models.User;

public class CategoryDAO implements DAO<Category>{

	@Override
	public void add(Category entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/category.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(Category entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/category.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/category.hbm.xml");
		Transaction t = session.beginTransaction();
		Category category = (Category) session.load(Category.class, id);
		session.delete(category);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Category findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Category category = new Category();
		Session session = getSession(cfg, "category/category.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(category, id);
		t.commit();
		session.close();
		return category;
	}

	@Override
	public List<Category> findAll() {
	    List<Category> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/category.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Category").getResultList();
        t.commit();
        session.close();
        return list;
	}

	@Override
	public List<Category> findAllByExample(Category entity) {
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

/*
	@Override
	public List<Category> findByFields(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}
*/




}

package dao;

import java.util.ArrayList;
import java.util.List;

import models.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;
import models.User;

public class ItemDAO implements DAO<Item>{

	@Override
	public void add(Item entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(Item entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		Item item = (Item) session.load(Item.class, id);
		session.delete(item);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Item findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Item item = new Item();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(item, id);
		t.commit();
		session.close();
		return item;
	}

	@Override
	public List<Item> findAll() {
	    List<Item> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Item").getResultList();
        t.commit();
        session.close();
        return list;
	}

	public List<Item> findSales() {
		List<Item> list =new ArrayList<>();
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		list=  session.createQuery("from Item  where status= :status").setParameter("status",1).getResultList();
		t.commit();
		session.close();
		return list;
	}

	public List<Item> findStock() {
		List<Item> list =new ArrayList<>();
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/item.hbm.xml");
		Transaction t = session.beginTransaction();
		list=  session.createQuery("from Item where status= :status").setParameter("status",0).getResultList();
		t.commit();
		session.close();
		return list;
	}


	@Override
	public List<Item> findAllByExample(Item entity) {
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

	




}

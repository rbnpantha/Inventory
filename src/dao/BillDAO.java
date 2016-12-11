package dao;

import java.util.ArrayList;
import java.util.List;

import models.Bill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;
import models.User;

public class BillDAO implements DAO<Bill>{

	@Override
	public void add(Bill entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/bill.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(Bill entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/bill.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/bill.hbm.xml");
		Transaction t = session.beginTransaction();
		Bill bill = (Bill) session.load(Bill.class, id);
		session.delete(bill);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Bill findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Bill bill = new Bill();
		Session session = getSession(cfg, "xml/bill.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(bill, id);
		t.commit();
		session.close();
		return bill;
	}

	@Override
	public List<Bill> findAll() {
	    List<Bill> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/bill.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Bill").getResultList();
        t.commit();
        session.close();
        return list;
	}

	@Override
	public List<Bill> findAllByExample(Bill entity) {
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

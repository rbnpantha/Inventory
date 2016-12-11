package dao;

import java.util.ArrayList;
import java.util.List;

import models.Bill;
import models.BillDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;
import models.User;

public class BillDetailDAO implements DAO<BillDetail>{

	@Override
	public void add(BillDetail entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/BillDetail.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(BillDetail entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/billDetail.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/billDetail.hbm.xml");
		Transaction t = session.beginTransaction();
		BillDetail billDetail = (BillDetail) session.load(BillDetail.class, id);
		session.delete(billDetail);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BillDetail findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		BillDetail billDetail = new BillDetail();
		Session session = getSession(cfg, "xml/billDetail.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(billDetail, id);
		t.commit();
		session.close();
		return billDetail;
	}

	@Override
	public List<BillDetail> findAll() {
	    List<BillDetail> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/billDetail.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from BillDetail").getResultList();
        t.commit();
        session.close();
        return list;
	}

	@Override
	public List<BillDetail> findAllByExample(BillDetail entity) {
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

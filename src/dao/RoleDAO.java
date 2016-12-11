package dao;

import hibernate.HibernateUtil;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements DAO<Role>{

	@Override
	public void add(Role entity) {
		
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/role.hbm.xml");
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
	}

	@Override
	public void update(Role entity) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/role.hbm.xml");
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/role.hbm.xml");
		Transaction t = session.beginTransaction();
		Role role = (Role) session.load(Role.class, id);
		session.delete(role);
		t.commit();
		session.close();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Role findById(int id) {
		Configuration cfg = HibernateUtil.getConfiguration();
		Role role = new Role();
		Session session = getSession(cfg, "xml/role.hbm.xml");
		Transaction t = session.beginTransaction();
		session.load(role, id);
		t.commit();
		session.close();
		return role;
	}

	@Override
	public List<Role> findAll() {
	    List<Role> list =new ArrayList<>();
	    Configuration cfg = HibernateUtil.getConfiguration();
		Session session = getSession(cfg, "xml/role.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Role").getResultList();
        t.commit();
        session.close();
        return list;
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findAllByExample(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}





}

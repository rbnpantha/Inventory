package service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dao.UserDAO;
import hibernate.HibernateUtil;
import models.User;

public class UserService {
	private UserDAO userDAO = new UserDAO();
	
     public void add(User user) {
          userDAO.add(user);          
     }

     public List<User> list() {
          return userDAO.findAll();          
     }

     public void deleteById(int id) {
    	 userDAO.deleteById(id);          
     }
     
     public void findById(int id) {
    	 userDAO.findById(id);          
     }


     public void update(User user) {
    	 userDAO.update(user);          
     }
     
 	public boolean checkIfAdminExists(){
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = userDAO.getSession(cfg, "xml/user.hbm.xml");
//		Query query = session.createQuery(" from User where isAdmin= :isAdmin AND username=:name");

		Query query = session.createQuery(" from User where isAdmin= :isAdmin");
		query.setParameter("isAdmin", 1);
//		query.setParameter("name", "hawa");
		return !query.getResultList().isEmpty();
		
	}
 	
	public User findUserByUsernameAndPassword(String username,String password){
        User first = null;
		Configuration cfg = HibernateUtil.getConfiguration();
		Session session = userDAO.getSession(cfg, "xml/user.hbm.xml");
//		Query query = session.createQuery(" from User where isAdmin= :isAdmin AND username=:name");

		Query query = session.createQuery(" from User where username= :username AND password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<User> userList = query.getResultList();
		Iterator iter = userList.iterator();
        if(iter.hasNext()){
             first = (User)iter.next();
        }

        return  first;




	

}


    public boolean isUniqueEmail(String email) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = userDAO.getSession(cfg, "xml/user.hbm.xml");
//		Query query = session.createQuery(" from User where isAdmin= :isAdmin AND username=:name");

        Query query = session.createQuery(" from User where email= :email");
        query.setParameter("email", email);
//		query.setParameter("name", "hawa");
        return query.getResultList().isEmpty();
    }

    public boolean isUniqueUsername(String username) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = userDAO.getSession(cfg, "xml/user.hbm.xml");
//		Query query = session.createQuery(" from User where isAdmin= :isAdmin AND username=:name");
        Query query = session.createQuery(" from User where username= :username");
        query.setParameter("username", username);
//		query.setParameter("name", "hawa");
        return query.getResultList().isEmpty();
    }
}

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.User;


/**
* Interface to provide common DAO methods
* 
*/

public interface DAO<E>
{
	
	default public Session getSession(Configuration cfg, String resource) {
		cfg.addResource(resource);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	/**
	* 
	* @param entity: entity to save
	* @return Identifier of saved entity
	*/
	void add(E entity);
	
	/**
	* 
	* @param entity:entity to save or update
	*/
	public void update(E entity);
	
	/**
	* 
	* @param entity: entity to delete
	*/
	void deleteById( int id );
	
	/**
	* Delete all records
	*/
	void deleteAll();
	
	/**
	* Find all records
	* @return
	*/
	List<E> findAll();
	
	/**
	* Find all records matching provided entity
	* @param entity: entity object used for search
	* @return
	*/
	List<E> findAllByExample( E entity );
	
	/**
	* Find by primary key
	* @param id
	* @return unique entity 
	*/
	E findById( int  id );
	
	/**
	* Clear session
	*/
	void clear();
	
	/**
	* Flush session
	*/
	void flush();


}

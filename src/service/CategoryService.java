package service;

import java.util.List;

import dao.CategoryDAO;
import dao.UserDAO;
import hibernate.HibernateUtil;
import models.Category;
import models.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public void add(Category category) {
        categoryDAO.add(category);
    }

    public List<Category> list() {
        return categoryDAO.findAll();
    }

    public void deleteById(int id) {
        categoryDAO.deleteById(id);
    }

    public void findById(int id) {
        categoryDAO.findById(id);
    }


    public void update(Category category) {
        categoryDAO.update(category);
    }


    public boolean isUniqueCategory(String name) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = categoryDAO.getSession(cfg, "xml/user.hbm.xml");
        Query query = session.createQuery(" from Category where name= :name");
        query.setParameter("name", name);
        return query.getResultList().isEmpty();
    }
}

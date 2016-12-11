package dao;

import hibernate.HibernateUtil;
import models.Bill;
import models.Sale;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabin on 10/12/2016.
 */
public class SaleDAO implements DAO<Sale> {

    @Override
    public void add(Sale entity) {

        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = getSession(cfg, "xml/sale.hbm.xml");
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();
    }

    @Override
    public void update(Sale entity) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = getSession(cfg, "xml/sale.hbm.xml");
        Transaction t = session.beginTransaction();
        session.update(entity);
        t.commit();
        session.close();

    }

    @Override
    public void deleteById(int id) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = getSession(cfg, "xml/sale.hbm.xml");
        Transaction t = session.beginTransaction();
        Sale sale = (Sale) session.load(Sale.class, id);
        session.delete(sale);
        t.commit();
        session.close();

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public Sale findById(int id) {
        Configuration cfg = HibernateUtil.getConfiguration();
        Sale sale = new Sale();
        Session session = getSession(cfg, "xml/bill.hbm.xml");
        Transaction t = session.beginTransaction();
        session.load(sale, id);
        t.commit();
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        List<Sale> list =new ArrayList<>();
        Configuration cfg = HibernateUtil.getConfiguration();
        Session session = getSession(cfg, "xml/bill.hbm.xml");
        Transaction t = session.beginTransaction();
        list=  session.createQuery("from Sale").getResultList();
        t.commit();
        session.close();
        return list;
    }

    @Override
    public List<Sale> findAllByExample(Sale entity) {
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

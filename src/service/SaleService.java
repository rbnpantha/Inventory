package service;

import dao.CustomerDAO;
import dao.SaleDAO;
import models.Customer;
import models.Sale;

import java.util.List;

/**
 * Created by Rabin on 10/12/2016.
 */
public class SaleService {
    private SaleDAO saleDAO = new SaleDAO();

    public void add(Sale sale) {
        saleDAO.add(sale);
    }

    public List<Sale> list() {
        return saleDAO.findAll();
    }

    public void deleteById(int id) {
        saleDAO.deleteById(id);
    }

    public void findById(int id) {
        saleDAO.findById(id);
    }

    public void update(Sale sale) {
        saleDAO.update(sale);
    }
}

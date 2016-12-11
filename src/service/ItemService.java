package service;

import java.util.List;

import dao.ItemDAO;
import dao.UserDAO;
import models.Item;
import models.User;

public class ItemService {
    private ItemDAO itemDAO = new ItemDAO();

    public void add(Item item) {
        itemDAO.add(item);
    }

    public List<Item> list() {
        return itemDAO.findAll();
    }

    public void deleteById(int id) {
        itemDAO.deleteById(id);
    }

    public Item findById(int id) {
        return itemDAO.findById(id);
    }


    public void update(Item item) {
        itemDAO.update(item);
    }

    public List<Item> findSales() {
        return itemDAO.findSales();

    }

    public List<Item> findStock() {
        return itemDAO.findStock();

    }
}




package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Category;
import models.Item;
import models.Role;
import models.RuleException;
import service.CategoryService;
import service.ItemService;
import service.RoleService;
import service.SaleService;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class ItemController implements Initializable {
    @FXML
    private AnchorPane newItemLayout;

    @FXML
    private TextField lblId1;

    @FXML
    private TextField txtName1;

    @FXML
    private TextField lblPrice1;

    @FXML
    private TextField lblStatus1;

    @FXML
    private ComboBox categoryListComboBox;

    @FXML
    private TextField lblUnit1;

    @FXML
    private TextField lblQuantity1;

    @FXML
    private TextField itemsEdit1;

    @FXML
    private Button btnItemsBack;

    @FXML
    private Button btnItemsNext;

    @FXML
    private Button btnItemsAddNew;

    @FXML
    private Button btnSave;

    private HashMap<String, Integer> categoryStringKeyHashMap = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Category> categoryList = new CategoryService().list();
        for (Category category : categoryList) {
            categoryStringKeyHashMap.put(category.getName(), category.getId());
            categoryListComboBox.getItems().add(category.getName());
        }

        categoryListComboBox.setValue(categoryList.get(0).getName());

    }


    public void addItem(ActionEvent e) {
        AlertController c = new AlertController();
        String error = "";
        Item item = new Item();
        try{
            item.setName(txtName1.getText());
            try{
                int price = Integer.parseInt(lblPrice1.getText());
                item.setPrice(price);
                int quantity = Integer.parseInt(lblQuantity1.getText());
                item.setQuantity(quantity);

            }catch (NumberFormatException eo){
                
            }

            item.setCategoryId(categoryStringKeyHashMap.get(categoryListComboBox.getSelectionModel().getSelectedItem().toString()));
            item.setStatus(0);
            item.setUnit(lblUnit1.getText());
            item.applyRules();

        }catch (RuleException ex){
            error+=ex.getMessage();

        }

        if(error.isEmpty()) {

            ItemService itemService = new ItemService();
            itemService.add(item);
            c.addItems();
            ((Node) (e.getSource())).getScene().getWindow().hide();
        }else{
            c.addErrors(error);
        }
    }

    public void btnBack(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }


}

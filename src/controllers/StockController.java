package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Category;
import models.Item;
import service.CategoryService;
import service.ItemService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rabin on 10/13/2016.
 */
public class StockController {
    @FXML
    private AnchorPane StockItemLayout;

    @FXML
    TableView<StockTest> stockTable;

    @FXML
    TableColumn itemsId;
    @FXML
    TableColumn itemsCatId;

    @FXML
    TableColumn itemsNameId;
    @FXML
    TableColumn itemsUnitId;
    @FXML
    TableColumn itemsPriceId;

    @FXML
    TableColumn itemsQuantity;

    @FXML
    Label totalStockLabel;

    public class StockTest {
        private final SimpleStringProperty id;
        private final SimpleStringProperty categoryId;
        private final SimpleStringProperty name;
        private final SimpleStringProperty unit;
        private final SimpleStringProperty price;
        private final SimpleStringProperty quantity;

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getCategoryId() {
            return categoryId.get();
        }

        public SimpleStringProperty categoryIdProperty() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId.set(categoryId);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getUnit() {
            return unit.get();
        }

        public SimpleStringProperty unitProperty() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit.set(unit);
        }

        public String getPrice() {
            return price.get();
        }

        public SimpleStringProperty priceProperty() {
            return price;
        }

        public void setPrice(String price) {
            this.price.set(price);
        }

        public String getQuantity() {
            return quantity.get();
        }

        public SimpleStringProperty quantityProperty() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity.set(quantity);
        }


        public StockTest(
                String id,
                String name,
                String categoryId,
                String unit,
                String price,
                String quantity

        ) {
            this.id = new SimpleStringProperty( id );
            this.name = new SimpleStringProperty( name );
            this.categoryId = new SimpleStringProperty( categoryId );
            this.unit = new SimpleStringProperty( unit );
            this.price = new SimpleStringProperty( price );
            this.quantity = new SimpleStringProperty( quantity );
    }


    }

    ObservableList<StockTest> data;



    @FXML
    public void initialize(){
        itemsId.setCellValueFactory(
                new PropertyValueFactory<Item,String>("id")
        );
        itemsCatId.setCellValueFactory(
                new PropertyValueFactory<StockTest,String>("categoryId")
        );
        itemsNameId.setCellValueFactory(
                new PropertyValueFactory<StockTest,String>("name")
        );
        itemsUnitId.setCellValueFactory(
                new PropertyValueFactory<StockTest,String>("unit")
        );
        itemsPriceId.setCellValueFactory(
                new PropertyValueFactory<StockTest,String>("price")
        );
        itemsQuantity.setCellValueFactory(
                new PropertyValueFactory<StockTest,String>("quantity")
        );



        data = FXCollections.observableArrayList();
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.findStock();
        totalStockLabel.setText(String.valueOf(itemList.size()));

        List<Category> categoryList = new CategoryService().list();
        for (Item item : itemList) {
            String category1 = null;
            for (Category category : categoryList) {
                if(category.getId()== item.getCategoryId()){
                    category1 =category.getName();
                }

            }
            data.add(new StockTest(String.valueOf(item.getId()),item.getName(),category1,String.valueOf(item.getUnit()),String.valueOf(item.getPrice()),String.valueOf(item.getQuantity())));
        }

        stockTable.setItems(data);

    }
}

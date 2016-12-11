package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Category;
import models.Item;
import service.CategoryService;
import service.ItemService;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Rabin on 10/13/2016.
 */
public class SalesmanController{
    @FXML
    private AnchorPane ItemTestLayout;

    @FXML
    private TextField searchFieldText;

    @FXML
    private Button searchButton;

    @FXML
    TableView<ItemTest> itemTestTable;

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
    TableColumn itemsStatus;
    @FXML
    TableColumn itemsEdit;

    @FXML
    TableColumn itemsDelete;


    List<Category> categoryList = new CategoryService().list();
    ObservableList<ItemTest> data;









    public class ItemTest {
        private final SimpleStringProperty id;
        private final SimpleStringProperty categoryId;
        private final SimpleStringProperty name;
        private final SimpleStringProperty unit;
        private final SimpleStringProperty price;
        private final SimpleStringProperty quantity;
        private final SimpleStringProperty status;

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

        public String getStatus() {
            return status.get();
        }

        public SimpleStringProperty statusProperty() {
            return status;
        }

        public void setStatus(String status) {
            this.status.set(status);
        }

        public ItemTest(
                String id,
                String name,
                String categoryId,
                String unit,
                String price,
                String quantity,
                String status
        ) {
            this.id = new SimpleStringProperty( id );
            this.name = new SimpleStringProperty( name );
            this.categoryId = new SimpleStringProperty( categoryId );
            this.unit = new SimpleStringProperty( unit );
            this.price = new SimpleStringProperty( price );
            this.quantity = new SimpleStringProperty( quantity );
            this.status = new SimpleStringProperty( status );
        }


    }



    public void addItemButton() {
        System.out.println("heheh");
        Stage stage = (Stage) ItemTestLayout.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/NewItem.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("CustomCss.css");
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @FXML
    public void initialize(){


        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("called");
                String searchText = searchFieldText.getText();
                int productId = Integer.parseInt(searchText);
                Item item  = new ItemService().findById(productId);
                itemTestTable.getItems().clear() ;
                data.add(new ItemTest(String.valueOf(item.getId()),item.getName(),categoryList.get(item.getCategoryId()-1).getName(),String.valueOf(item.getUnit()),String.valueOf(item.getPrice()),String.valueOf(item.getQuantity()),String.valueOf(item.getStatus())));

            }
        });
        itemsId.setCellValueFactory(
                new PropertyValueFactory<Item,String>("id")
        );
        itemsCatId.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("categoryId")
        );
        itemsNameId.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("name")
        );
        itemsUnitId.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("unit")
        );
        itemsPriceId.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("price")
        );
        itemsQuantity.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("quantity")
        );
        itemsStatus.setCellValueFactory(
                new PropertyValueFactory<ItemTest,String>("status")
        );



        data = FXCollections.observableArrayList();
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.list();

        for(Item item:itemList){

            data.add(new ItemTest(String.valueOf(item.getId()),item.getName(),categoryList.get(item.getCategoryId()-1).getName(),String.valueOf(item.getUnit()),String.valueOf(item.getPrice()),String.valueOf(item.getQuantity()),String.valueOf(item.getStatus())));
        }

        itemTestTable.setItems(data);

    }

    public void markSelectedItemAsSold() {
        ItemTest selectedItem= itemTestTable.getSelectionModel().getSelectedItem();

        Item item = new Item();
        item.setId(Integer.parseInt(selectedItem.getId()));
        item.setName(selectedItem.getName());
        item.setPrice(Integer.parseInt(selectedItem.getPrice()));
        item.setQuantity(Integer.parseInt(selectedItem.getQuantity()));
        //item.setCategoryId(categoryList.indexOf(selectedItem.categoryId));
        item.setStatus(1);
        item.setUnit(selectedItem.getUnit());
        ItemService itemService = new ItemService();
        itemService.update(item);
    }

    public void clearSearch(){

        itemTestTable.getItems().clear() ;
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.list();
        for(Item item:itemList){


            data.add(new ItemTest(String.valueOf(item.getId()),item.getName(),categoryList.get(item.getCategoryId()-1).getName(),String.valueOf(item.getUnit()),String.valueOf(item.getPrice()),String.valueOf(item.getQuantity()),String.valueOf(item.getStatus())));
        }

    }
}

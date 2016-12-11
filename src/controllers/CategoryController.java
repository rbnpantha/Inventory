package controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Category;
import models.RuleException;
import service.CategoryService;
import service.UserService;

import java.io.IOException;
import java.util.List;

public class CategoryController {

    private static  int maxId ;

    @FXML
    private TextField categoryNameField;



    @FXML
     AnchorPane categoryTab;

    @FXML
    TableView<ItemCategory> itemTbCategoryList;

    @FXML
    TableColumn idCol;

    @FXML
    TableColumn tblName;



    public class ItemCategory {
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;

        public ItemCategory(
                int id,String name

        ) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty( name );
        }
        public int getId() {
            return id.get();
        }

        public void setId(int id) {
            this.id.set(id);
        }



        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }
    }

    ObservableList<ItemCategory> data;


    public void addCategoryButton() {
        System.out.println("inside add Category");
        Stage stage = (Stage) categoryTab.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/newCategory.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add("CustomCss.css");
            stage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void addCategory(){
            AlertController a = new AlertController();
            String error = "";
            Category category = new Category();

        try{
                String name = categoryNameField.getText();

                category.setName(name);
                ++maxId;
                category.setId(maxId);
                category.applyRules();

            }catch (RuleException e){
                error+= e.getMessage();
            }

            if(error.isEmpty()) {


                new CategoryService().add(category);
                data.add(new ItemCategory(category.getId(), category.getName()));
                categoryNameField.clear();
                a.addCategory();
            }else{
                a.addErrors(error);
            }

    }


    public void deleteSelectedCategory() {
        CategoryController.ItemCategory item = itemTbCategoryList.getSelectionModel().getSelectedItem();
        new CategoryService().deleteById(item.getId());
        data.remove(item);


    }

    @FXML
    public void initialize(){
        idCol.setCellValueFactory(
                new PropertyValueFactory<ItemCategory,Integer>("id")
        );

        tblName.setCellValueFactory(
                new PropertyValueFactory<ItemCategory,String>("name")
        );

        data = FXCollections.observableArrayList();
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.list();
        for(Category category:categoryList){
            maxId = category.getId();

            data.add(new ItemCategory(category.getId(),category.getName()));
        }

        itemTbCategoryList.setItems(data);

    }




}

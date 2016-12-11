package controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Role;
import models.User;
import service.RoleService;
import service.UserService;

import java.io.IOException;
import java.util.List;

public class UserTestController {
    @FXML
    private AnchorPane userTab;

    @FXML
    TableView<Item> itemTblUserList;

    @FXML
    TableColumn idCol;
    @FXML
    TableColumn nameCol;
    @FXML
    TableColumn emailCol;
    @FXML
    TableColumn roleCol;
    @FXML
    TableColumn phoneNumberCol;




    public class Item {
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty email;
        private final SimpleStringProperty role;
        private final SimpleIntegerProperty phoneNumber;


        public Item(int id, String name, String email, String role, int phoneNumber) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.email = new SimpleStringProperty(email);
            this.role = new SimpleStringProperty(role);
            this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
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

        public String getRole() {
            return role.get();
        }

        public void setRole(String role) {
            this.role.set(role);
        }


        public String getEmail() {
            return email.get();
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public int getPhoneNumber() {
            return phoneNumber.get();
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber.set(phoneNumber);
        }

    }

     ObservableList<Item> data;


    public void addUserButton() {

        Stage stage = (Stage) userTab.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/Register.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setTitle("Register user");
            stage.setScene(scene);
            scene.getStylesheets().add("CustomCss.css");
            stage.show();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void deleteSelectedUser() {
        Item item = itemTblUserList.getSelectionModel().getSelectedItem();
        new UserService().deleteById(item.getId());
        data.remove(item);


    }



    @FXML
    public void initialize() {
        idCol.setCellValueFactory(
                new PropertyValueFactory<Item, Integer>("id")
        );
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Item, String>("name")
        );

        emailCol.setCellValueFactory(
                new PropertyValueFactory<Item, String>("email")
        );

        phoneNumberCol.setCellValueFactory(
                new PropertyValueFactory<Item, String>("phoneNumber")
        );

        roleCol.setCellValueFactory(new PropertyValueFactory<Item, String>("role"));



        data = FXCollections.observableArrayList();
        UserService userService = new UserService();
        List<User> userList = userService.list();
       List<Role> roleList = new RoleService().list();


        for (User user : userList) {
            String role1 = null;
            for (Role role : roleList) {
                if(role.getId()== user.getRoleId()){
                        role1 =role.getName();
                }

            }

            data.add(new Item(user.getId(), user.getName(), user.getEmail(), role1,(int)user.getPhoneNumber()));
        }

        itemTblUserList.setItems(data);

    }

}

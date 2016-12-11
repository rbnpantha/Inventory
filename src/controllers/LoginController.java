package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import models.User;
import service.UserService;


public class LoginController {
    @FXML
    private AnchorPane LoginLayout;
    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


    public void login(ActionEvent event) throws Exception {
        User user = new UserService().findUserByUsernameAndPassword(username.getText(), password.getText());

        if (user != null) {
            Parent root = null;
            try {
                int roleId = user.getRoleId();
                if (roleId == 1) {
                    root = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Admin Panel");
                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                } else if (roleId == 2) {
                    root = FXMLLoader.load(getClass().getResource("/views/Salesmanager.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Manager");
                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    root = FXMLLoader.load(getClass().getResource("/views/SalesMan.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Salesman");
                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                }

                AlertController a = new AlertController();
                a.getLoginConfirmation();

                // hide this current window (if this is want you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            AlertController a = new AlertController();
            a.loginFail();
        }
    }


    public void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void onEnter(ActionEvent ae) throws Exception {
        User user = new UserService().findUserByUsernameAndPassword(username.getText(), password.getText());

        if (user != null) {
            Parent root = null;

            try {
                int roleId = user.getRoleId();
                if (roleId == 1) {
                    root = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Admin Panel");
                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                } else if (roleId == 2) {
                    root = FXMLLoader.load(getClass().getResource("/views/SalesManager.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Manager");

                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    root = FXMLLoader.load(getClass().getResource("/views/SalesMan.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Salesman");

                    Scene scene = new Scene(root, 700,440);
                    scene.getStylesheets().add("CustomCss.css");
                    stage.setScene(scene);
                    stage.show();

                }

                AlertController a = new AlertController();
                a.getLoginConfirmation();

                // hide this current window (if this is want you want)
                ((Node) (ae.getSource())).getScene().getWindow().hide();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            AlertController a = new AlertController();
            a.loginFail();
        }
    }

}

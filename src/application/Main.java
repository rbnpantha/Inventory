package application;

import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Role;
import service.RoleService;
import service.UserService;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = null;
            Scene scene = null;


            if (new UserService().checkIfAdminExists()) {
                root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
                scene = new Scene(root);
                scene.getStylesheets().add("CustomCss.css");
                primaryStage.setTitle("Login");

            } else {
                root = FXMLLoader.load(getClass().getResource("/views/Register.fxml"));
                List<Role> roleList = new RoleService().list();
                scene = new Scene(root);
                primaryStage.setTitle("Register");
                scene.getStylesheets().add("CustomCss.css");
            }

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertController {	
	
	public void addItems(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Item added successfully.");
        alert.setTitle("Item");
        alert.setHeaderText(null);
        alert.show();
	}

	public void getLoginConfirmation(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Login successful");
        alert.setTitle("Login Confirmation");
        alert.setHeaderText(null);
        alert.show();
    }

    public void loginFail(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Invalid username or password");
        alert.setTitle("Login Confirmation");
        alert.setHeaderText(null);
        alert.show();
    }

    public void errors(String error){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText(error);
        alert.setTitle("Error");
        alert.setHeaderText("Please fix the following errors.");
        alert.show();
    }


    public void addUserConfirmation(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Register successful");
        alert.setTitle("Register");
        alert.setHeaderText(null);
        alert.show();
    }

    public void addNewCatogery(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Category added successful");
        alert.setTitle("Catogery");
        alert.setHeaderText(null);
        alert.show();
    }

    public void deleteConfirmation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("User deleted");
        alert.setTitle("Delete user");
        alert.setHeaderText(null);
        alert.show();
    }

    public void addCategory(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Category added");
        alert.setTitle("Category");
        alert.setHeaderText(null);
        alert.show();
    }

    public void addErrors(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(error);
        alert.setTitle("Errors");
        alert.setHeaderText("Please fix the following errors");
        alert.show();
    }


    public void deleteItem(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Item deleted");
        alert.setTitle("Delete Item");
        alert.setHeaderText(null);
        alert.show();
    }
    public void addItem(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Item Added");
        alert.setTitle("Add Item");
        alert.setHeaderText(null);
        alert.show();
    }

	public void closeMethod(ActionEvent event) {

        System.exit(0);
	}
	
}
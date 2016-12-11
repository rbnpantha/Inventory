package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Role;
import models.RuleException;
import models.User;
import service.RoleService;
import service.UserService;

public class RegistrationController implements Initializable {
	@FXML
	private AnchorPane LoginLayout;
	@FXML
	private ComboBox<String> roleListComboBox;
	@FXML
	private TextField name;
	@FXML
	private TextField username;
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField status;
	@FXML
	private TextField address;
	@FXML
	private TextField city;
	@FXML
	private TextField country;

	private HashMap<String,Integer> roleStringKeyHashMap = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Role> roleList = new RoleService().list();
		for (Role role : roleList) {
			roleStringKeyHashMap.put(role.getName(),role.getId());

			roleListComboBox.getItems().add(role.getName());
		}

		roleListComboBox.setValue(roleList.get(0).getName());

	}

	@FXML
	private void register(ActionEvent event) throws IOException {
        String error = "";
        User user = new User();

        AlertController a = new AlertController();
        try {
            user.setName(name.getText());
            user.setUsername(username.getText());
            user.setEmail(email.getText());
            user.setPassword(password.getText());
            try{
                int phone = Integer.parseInt(phoneNumber.getText());
                user.setPhoneNumber(phone);
            }catch (NumberFormatException en){

            }

            user.setAddress(address.getText());
            user.setCity(city.getText());
            user.setCountry(country.getText());
            user.setRoleId(roleStringKeyHashMap.get(roleListComboBox.getSelectionModel().getSelectedItem().toString()));
            user.setIsAdmin(1);
            user.applyRules();
        }catch (RuleException e){
            error+= e.getMessage();

        }

        if(error.isEmpty()){


		UserService userService = new UserService();
		userService.add(user);
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("views/AdminPanel.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Admin Panel");
			Scene scene = new Scene(root, 720, 420);
            stage.setScene(scene);
			stage.show();
            scene.getStylesheets().add("CustomCss.css");

			a.addUserConfirmation();

			// hide this current window (if this is want you want)
			((Node) (event.getSource())).getScene().getWindow().hide();

		} catch (IOException e) {
			e.printStackTrace();
		}
        }else{
            a.errors(error);

        }

	}

	@FXML
	private void cancel(ActionEvent event) {

		System.exit(0);

	}

}



package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Customer;
import service.CustomerService;
import service.UserService;

import javax.swing.*;

/**
 * Created by Rabin on 10/12/2016.
 */
public class CustomerController {

    @FXML
    private Button btnAddNewCus;

    @FXML
    private Button btnBack;

    @FXML
    private TextField lblNewCusId;

    @FXML
    private TextField lblName;

    @FXML
    private TextField lblPurchase;

    @FXML
    private TextField lblStatus;

    @FXML
    private TextField lblAddressId;

    @FXML
    private TextField lblPhoneId;
    @FXML
    private TextField lblCountry;

    @FXML
    private TextField lablCity;

public void addCustomer(ActionEvent e)
{
    Customer customer = new Customer();
    customer.setName(lblName.getText());
    customer.setPurchased(Integer.parseInt(lblPurchase.getText()));
    customer.setAddress(lblAddressId.getText());
    customer.setPhoneNumber(Integer.parseInt(lblPhoneId.getText()));
    customer.setCity(lablCity.getText());
    customer.setCountry(lblCountry.getText());
    customer.setStatus(Integer.parseInt(lblStatus.getText()));
    CustomerService customerService = new CustomerService();
    customerService.add(customer);
}


}


package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Item;
import models.Sale;
import models.User;
import service.CustomerService;
import service.ItemService;
import service.SaleService;
import service.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Rabin on 10/12/2016.
 */
public class SalesController implements Initializable{

    int total= 0;


    @FXML
    private AnchorPane salesManLayout;

    @FXML
    private TextField lblId;

    @FXML
    private Label txtTotal;

    @FXML
    private TextField lblName;

    @FXML
    private TextField lblPrice;

    @FXML
    private TextField lblStatus;

    @FXML
    private TextField lblCategoryId;

    @FXML
    private TextField lblUnit;

    @FXML
    private TextField lblQuantity;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnAddNewItem;

    @FXML
    private TextField  searchFieldText;

    @FXML
    private Button searchButton;

    @FXML
    TableView<Item> itemTblUserList;

    @FXML
    TableColumn nameCol;
    @FXML
    TableColumn emailCol;

    @FXML
    TableColumn usernameCol;
    @FXML
    TableColumn PhoneNumberCol;
    @FXML
    TableColumn LastLoginCol;



    public void addSales(ActionEvent e)
    {
        Sale sale = new Sale();
        sale.setId(Integer.parseInt(lblId.getText()));
        sale.setName(lblName.getText());
        sale.setPrice(Integer.parseInt(lblPrice.getText()));
        sale.setQuantity(Integer.parseInt(lblQuantity.getText()));
        sale.setCategoryId(Integer.parseInt(lblCategoryId.getText()));
        sale.setStatus(Integer.parseInt(lblStatus.getText()));
        sale.setUnit(lblUnit.getText());
        SaleService saleService = new SaleService();
        saleService.update(sale);
        addTable();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        lblPrice.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
//                total += Integer.parseInt(lblPrice.getText());
//                txtTotal.setText((String.valueOf(total)));
//            }
//        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String searchText = searchFieldText.getText();
                int productId = Integer.parseInt(searchText);
                Item item  = new ItemService().findById(productId);
                System.out.println(item.getName());

            }
        });


    }
    public void addNewSale(ActionEvent e)
    {
        try
        {
            lblId.setText("");
            lblName.setText("");
            lblPrice.setText("0");
            lblQuantity.setText("");
            lblCategoryId.setText("");
            lblStatus.setText("");
            lblUnit.setText("");
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }

    }

    public void goHome(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/SalesMan.fxml"));
            Scene scene = new Scene(root, 340, 300);
            scene.getStylesheets().add("CustomCss.css");
            Stage st = (Stage) salesManLayout.getScene().getWindow();
            st.setScene(scene);
            st.setX(150);
            st.setY(50);
            st.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   @FXML private TableView tableView;
    @FXML private TableColumn id;
    @FXML private TableColumn name;
    @FXML private TableColumn category;
    @FXML private TableColumn price;
    @FXML private TableColumn status;
    @FXML private TableColumn unit;
    @FXML private TableColumn quantity;





   /* @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory("lblId"));
        id.setCellValueFactory(new PropertyValueFactory<Sale, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblName"));
        category.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblCategoryId"));
        price.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblPrice"));
        status.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblStatus"));
        unit.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblUnit"));
        quantity.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblQuantity"));
        tableView.getItems().setAll();
    }*/

    public void addTable() {
        System.out.println("Inside add Table");
        id.setCellValueFactory(new PropertyValueFactory<Sale, String>("test"));
        name.setCellValueFactory(new PropertyValueFactory<Sale, String>(lblName.getText()));
        category.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblCategoryId"));
        price.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblPrice"));
        status.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblStatus"));
        unit.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblUnit"));
        quantity.setCellValueFactory(new PropertyValueFactory<Sale, String>("lblQuantity"));

       // tableView.getItems().setAll();
    }




}

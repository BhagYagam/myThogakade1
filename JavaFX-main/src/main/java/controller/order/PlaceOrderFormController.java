package controller.order;

import com.jfoenix.controls.JFXTextField;
import controller.customer.CustomerController;
import controller.item.ItemController;
import db.DBConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    public ComboBox <String> cmbitemcode;
    public JFXTextField txtorderid;
    @FXML
    private JFXTextField TxtStock;

    @FXML
    private JFXTextField TxtUPrice;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private ComboBox<String> cutIdComboBox;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblNetTot;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<CartTM> tblPlaceOrder;

    @FXML
    private JFXTextField txtCustAddress;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private JFXTextField txtDes;

    @FXML
    private JFXTextField txtQty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateAndTime();
        loadCustomerIds();
        loadItemCodes();

        cutIdComboBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, newVal) -> {
            if(newVal!=null){
                searchCustomer(newVal);
            }
        });

        cmbitemcode.getSelectionModel().selectedItemProperty().addListener((observableValue, s, newVal) -> {
            if(newVal!=null){
                searchItem(newVal);
            }
        });
    }


    private void loadDateAndTime(){
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = f.format(date);
        lblDate.setText(dateNow);

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,e->{
            LocalTime now = LocalTime.now();
            lblTime.setText(now.getHour()+" : "+now.getMinute()+" : "+now.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    ObservableList<CartTM> cartTM = FXCollections.observableArrayList();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        colCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        String itemCode = cmbitemcode.getValue();
        String description = txtDes.getText();
        Integer qty = Integer.parseInt(txtQty.getText());
        Double unitPrice = Double.parseDouble(TxtUPrice.getText());
        Double total = unitPrice*qty;

        if (Integer.parseInt(TxtStock.getText())< qty) {
            new Alert(Alert.AlertType.WARNING,"Invalid QTY").show();
        }else {
            cartTM.add(new CartTM(itemCode,description,qty,unitPrice,total));
            calcNetTotal();
        }
        tblPlaceOrder.setItems(cartTM);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException {
        String orderId = txtorderid.getText();
        LocalDate orderDate = LocalDate.now();
        String customerId = cutIdComboBox.getValue();

        List<OrderDetail> orderDetails = new ArrayList<>();

        cartTM.forEach(obj->{
            orderDetails.add(new OrderDetail(orderId,obj.getItemCode(),obj.getQty(),0.0));
        });
        Order order = new Order(orderId,orderDate,customerId,orderDetails);
        OrderController.placeOrder(order);
    }

    private void loadCustomerIds(){
        cutIdComboBox.setItems(CustomerController.getInstance().getCustomerIds());
    }

    private void loadItemCodes(){
        cmbitemcode.setItems(ItemController.getInstance().getItemCodes());
    }

    private void searchItem(String newVal) {
        Item item = ItemController.getInstance().searchItem(newVal);
        txtDes.setText(item.getDescription());
        TxtStock.setText(item.getQty().toString());
        TxtUPrice.setText(item.getUnitPrice().toString());
    }

    private void searchCustomer(String customerID){
        Customer customer = CustomerController.getInstance().searchCustomer(customerID);
        txtCustName.setText(customer.getName());
        txtCustAddress.setText(customer.getAddress());
        System.out.println(customerID);
    }

    private void calcNetTotal(){
        Double total = 0.0;

        for(CartTM cartTM1:cartTM){
            total+=cartTM1.getTotal();
        }

        lblNetTot.setText(total.toString()+"/=");
    }

    public void btnCommitOnAction(ActionEvent actionEvent) throws SQLException {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    public void btnAddCustFormOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

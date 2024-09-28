package controller.customer;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    public JFXTextField txtsal;
    public JFXTextField txtcity;
    public JFXTextField txtprovince;
    public JFXTextField txtpostalcode;
    public DatePicker datePick;
    @FXML
    private JFXComboBox<String> cmbtitle;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtdob;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtno;

    private int num = 1;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        Customer customer = new Customer(
                txtid.getText(),
                cmbtitle.getValue().toString(),
                txtname.getText(),
                datePick.getValue(),
                Double.parseDouble(txtsal.getText()),
                txtaddress.getText(),
                txtcity.getText(),
                txtprovince.getText(),
                txtpostalcode.getText()
        );


//        if(service.addCustomer(customer)){
//            new Alert(Alert.AlertType.INFORMATION,"Customer Added!!");
//        }else {
//            new Alert(Alert.AlertType.ERROR,"Customer not added!").show();
//        }
        //System.out.println(customer);
        boolean b = CustomerController.getInstance().addCustomer(customer);
        if (b){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
//        if (validatePhoneNumber()) {
//            String title = cmbtitle.getValue();
//
//            if (title == null) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Invalid Input");
//                alert.setHeaderText(null);
//                alert.setContentText("Please select a title before adding the customer!");
//                alert.showAndWait();
//                return;
//            }
//            if(txtname.getText().isEmpty()) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Nothing Entered");
//                alert.setHeaderText(null);
//                alert.setContentText("Please enter the customer name !");
//                alert.showAndWait();
//                return;
//            }
//            if(txtaddress.getText().isEmpty()) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Nothing Entered");
//                alert.setHeaderText(null);
//                alert.setContentText("Please enter the customer address !");
//                alert.showAndWait();
//                return;
//            }
//
//            List<Customer> customerList = DBConnection.getInstance().getConnection();
////            customerList.add(new Customer(
////                    txtid.getText(),
////                    txtname.getText(),
////                    cmbtitle.getValue(),
////                    txtaddress.getText(),
////                    txtno.getText()
////            ));
//
//            clearText();
//            generateId();
//            txtid.setEditable(false);
//
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Add Customer");
//            alert.setHeaderText(null);
//            alert.setContentText("Customer was Added Successfully !");
//            alert.showAndWait();
//        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        txtid.setEditable(false);
        ObservableList<String> titles=FXCollections.observableArrayList();
        titles.add("MR");
        titles.add("Miss");
        cmbtitle.setItems(titles);
    }

    private void clearText(){
        txtid.setText(null);
        txtname.setText(null);
        txtaddress.setText(null);
        txtno.setText(null);
    }

    private void generateId(){

        String id="";
        if(num<10){
            id=("C000"+ num++);
            txtid.setText(id);
        }else if(num<100){
            id=("C00"+ num++);
            txtid.setText(id);
        }else if(num<1000){
            id=("C0"+ num++);
            txtid.setText(id);
        }else if(num<10000){
            id="C"+ num++;
            txtid.setText(id);
        }
    }

//    private boolean validatePhoneNumber() {
//
//        String number = txtno.getText();
//
//        if (number.length() == 10 && number.charAt(0) == '0') {
//            for (int i = 0; i < number.length(); i++) {
//                char digit = number.charAt(i);
//
//                if (digit < '0' || digit > '9') {
//
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Invalid Input");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Invalid Phone Number, Please try again !");
//                    alert.showAndWait();
//                    txtno.setText(null);
//
//                    return false;
//                }
//            }
//            return true;
//        }
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Invalid Input");
//        alert.setHeaderText(null);
//        alert.setContentText("Invalid Phone Number, Please try again !");
//        alert.showAndWait();
//        txtno.setText(null);
//
//        return false;
//    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearText();
    }
}

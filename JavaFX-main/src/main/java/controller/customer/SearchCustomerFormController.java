package controller.customer;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class SearchCustomerFormController {

    @FXML
    private JFXTextField textids;

    @FXML
    private JFXTextField txtaddresss;

    @FXML
    private JFXTextField txtnames;

    @FXML
    private JFXTextField txtnids;

    @FXML
    private JFXTextField txtnos;

    @FXML
    void btnSeearchOnAction(ActionEvent event) {
//        String id = textids.getText();
//        //List<Customer> customerList = DBConnection.getInstance().getConnection();
//        boolean customerFound = false;
//
//        for (Customer customer : customerList) {
//            if (customer.getId().equals(id)) {
//                System.out.println(customer);
//                textids.setText(customer.getId());
//                txtnames.setText(customer.getName());
//                txtaddresss.setText(customer.getAddress());
//                txtnos.setText(customer.getCnum());
//                editText();
//                customerFound = true;
//            }
//        }
//
//
//        if (customerFound) {
//            askForAnotherSearch();
//        }else{
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Customer Not Found");
//            alert.setHeaderText(null);
//            alert.setContentText("No customer found with ID: " + id);
//            alert.showAndWait();
//            txtnids.setText(null);
//        }
    }



    private void editText(){
        txtnids.setEditable(false);
        txtnames.setEditable(false);
        txtaddresss.setEditable(false);
        txtnos.setEditable(false);
    }

    private void clearText(){
        txtnids.setText(null);
        txtnames.setText(null);
        txtaddresss.setText(null);
        txtnos.setText(null);
    }

    private void askForAnotherSearch() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Search");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to search another customer ?");

        ButtonType yesButton = new ButtonType("yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton,noButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yesButton) {
            clearText();
            txtnids.setEditable(true);
        }
    }
}


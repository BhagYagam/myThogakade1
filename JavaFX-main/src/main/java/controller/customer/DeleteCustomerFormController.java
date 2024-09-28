package controller.customer;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DeleteCustomerFormController {

    @FXML
    private JFXTextField searchid;

    @FXML
    private JFXTextField txtaddressd;

    @FXML
    private JFXTextField txtdob;

    @FXML
    private JFXTextField txtidd;

    @FXML
    private JFXTextField txtnamed;

    @FXML
    private JFXTextField txtnod;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
//    if(servise.deleteCustomer(txtidd.getText())){
//      new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!".show();
//    }else{
//        new Alert(Alert.AlertType.ERROR).show();
//    }



//        askForSureToDelete();
    }




       private String id ;
//
//    List<Customer> customerList = DBConnection.getInstance().getConnection();
//    Customer customerToDelete=null;
//
//    private void clearText(){
//        txtidd.setText(null);
//        txtnamed.setText(null);
//        txtaddressd.setText(null);
//        txtnod.setText(null);
//    }
//
//    private void editText(){
//        txtidd.setEditable(false);
//        txtnamed.setEditable(false);
//        txtaddressd.setEditable(false);
//        txtnod.setEditable(false);
//    }

//    private void askForSureToDelete() {
//
//        id = txtidd.getText();
//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Delete");
//        alert.setHeaderText(null);
//        alert.setContentText("Are you sure you want to delete the customer with ID: " + id + "?");
//
//        ButtonType yesButton = new ButtonType("Yes");
//        ButtonType noButton = new ButtonType("No");
//
//        alert.getButtonTypes().setAll(yesButton, noButton);
//
//         Optional<ButtonType> result = alert.showAndWait();
//
//        if (result.isPresent() && result.get() == yesButton) {
//            customerList.remove(customerToDelete);
//
//            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//            alert1.setTitle("DELETE");
//            alert1.setHeaderText(null);
//            alert1.setContentText("Customer was Deleted Successfully !");
//            alert1.showAndWait();
//            askForAnotherDelete();
//        } else {
//            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//            alert1.setTitle("NOT DELETE");
//            alert1.setHeaderText(null);
//            alert1.setContentText("Customer was Not Deleted ");
//            alert1.showAndWait();
//
//            askForAnotherDelete();
//        }
//    }

//    private void askForAnotherDelete() {
//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Delete");
//        alert.setHeaderText(null);
//        alert.setContentText("Do you want to delete another customer ?");
//
//        ButtonType yesButton = new ButtonType("Yes");
//        ButtonType noButton = new ButtonType("No");
//
//        alert.getButtonTypes().setAll(yesButton,noButton);
//
//        Optional<ButtonType> result = alert.showAndWait();
//
//        if(result.isPresent() && result.get() == yesButton){
//            clearText();
//            txtidd.setEditable(true);
//        } else {
//            clearText();
//            txtidd.setEditable(true);
//        }
//    }


//    @FXML
//    void btnSearchOnAction(ActionEvent event) {
//        id = searchid.getText();
//
//        boolean isDelete = false;
//
//        for (Customer customer : customerList) {
//            System.out.println(customer);
//            if (customer.getId().equals(id)) {
//                txtnamed.setText(customer.getName());
//                txtaddressd.setText(customer.getAddress());
//                txtnod.setText(customer.getCnum());
//                customerToDelete = customer;
//                editText();
//                isDelete = true;
//            }
//        }
//        if(!isDelete){
//
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Customer Not Found");
//            alert.setHeaderText(null);
//            alert.setContentText("No customer found with ID: " + id);
//            alert.showAndWait();
//            txtidd.setText(null);
//        }
//    }

}

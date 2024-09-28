package controller.customer;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomerFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> coladdressu;

    @FXML
    private TableColumn<?, ?> colconumu;

    @FXML
    private TableColumn<?, ?> coldobu;

    @FXML
    private TableColumn<?, ?> colidu;

    @FXML
    private TableColumn<?, ?> colnameu;

    @FXML
    private TableColumn<?, ?> coltitleu;

    @FXML
    private TableView<Customer> tbldata;

    @FXML
    private JFXTextField txtaddressu;

    @FXML
    private JFXTextField txtdobu;

    @FXML
    private JFXTextField txtnameu;

    @FXML
    private JFXTextField txtnidu;

    @FXML
    private JFXTextField txtnou;

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Customer selectedCustomer = tbldata.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {

            selectedCustomer.setId(txtnidu.getText());
            selectedCustomer.setName(txtnameu.getText());
            selectedCustomer.setAddress(txtaddressu.getText());

            tbldata.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("UPDATE");
            alert.setHeaderText(null);
            alert.setContentText("Customer was Updated Successfully !");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("NOT UPDATE");
            alert.setHeaderText(null);
            alert.setContentText("No Customer Selected for Update ?");
            alert.showAndWait();
        }

    }

    private void loadTable(){
//       // List<Customer> customerList = DBConnection.getInstance().getConnection();
//        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
//
//        //customerList.forEach(obj->{
//            customerObservableList.add(obj);
//        });
//
//        tbldata.setItems(customerObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        colidu.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colnameu.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        coladdressu.setCellValueFactory(new PropertyValueFactory<>("Address"));
//        colconumu.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
//
//        tbldata.getSelectionModel().selectedItemProperty().addListener(((observableValue,newValue , oldValue) -> {
//            if(newValue != null) {
//                setTexttoValue(newValue);
//            }
//        }));
//
//        loadTable();
    }

//    private void setTexttoValue(Customer newValue){
//        txtnidu.setText(newValue.getId());
//        txtnidu.setEditable(false);
//        txtnameu.setText(newValue.getName());
//        txtaddressu.setText(newValue.getAddress());
//        txtnou.setText(newValue.getCnum());
//    }

//    @FXML
//    void btnRelooadOnAction(ActionEvent event) {
////        loadTable();
//    }
}


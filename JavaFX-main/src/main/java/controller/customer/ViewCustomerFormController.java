package controller.customer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    public TableColumn colsalary;
    public TableColumn colcity;
    public TableColumn colprovince;
    public TableColumn colpostalcode;
    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colconum;

    @FXML
    private TableColumn<?, ?> coldob;

    @FXML
    private TableView<Customer> tbldata;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coltitle;

    CustomerService service =  CustomerController.getInstance();

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }



    private void loadTable(){
        ObservableList<Customer> customerObservableList=service.getAll();
        tbldata.setItems(customerObservableList);
     }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colprovince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
//      colconum.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));

        loadTable();
    }

//    private void setTextToValues(Customer newValue) {
//        txtId.setText(newValue.getId());
//        txtName.setText(newValue.getName());
//        txtAddress.setText(newValue.getAddress());
//
//    }


}
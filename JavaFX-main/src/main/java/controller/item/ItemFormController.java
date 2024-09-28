package controller.item;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> coldescription;

    @FXML
    private TableColumn<?, ?> colitemcode;

    @FXML
    private TableColumn<?, ?> colpacksize;

    @FXML
    private TableColumn<?, ?> colqtyonhand;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableView<Item> tblitem;

    @FXML
    private JFXTextField txtdescription;

    @FXML
    private JFXTextField txtitemcode;

    @FXML
    private JFXTextField txtpacksize;

    @FXML
    private JFXTextField txtqtyonhand;

    @FXML
    private JFXTextField txtunitprice;

    ItemService service = ItemController.getInstance();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Item item = new Item(
                txtitemcode.getText(),
                txtdescription.getText(),
                txtpacksize.getText(),
                Double.parseDouble(txtunitprice.getText()),
                Integer.parseInt(txtqtyonhand.getText())
        );

        if(service.addItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Added!!").show();
            loadTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Item Not Added!!").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(service.deleteItem(txtitemcode.getText())){
            new Alert(Alert.AlertType.INFORMATION,"Item Deleted!!").show();
            loadTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Item Not Deleted!!").show();
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Item item = service.searchItem(txtitemcode.getText());
        setTextValues(item);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Item item = new Item(
                txtitemcode.getText(),
                txtdescription.getText(),
                txtpacksize.getText(),
                Double.parseDouble(txtunitprice.getText()),
                Integer.parseInt(txtqtyonhand.getText())
        );
        if(service.updateItem(item)){
            new Alert(Alert.AlertType.INFORMATION,"Item Updated!!").show();
            loadTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Item not Updated").show();
        }
    }

    private void loadTable(){
        ObservableList<Item> all = service.getAll();
        tblitem.setItems(all);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colpacksize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colqtyonhand.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadTable();
        tblitem.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setTextValues(newValue);
            }
        } ));
           
    }

    private void setTextValues(Item newValue) {
        txtitemcode.setText(newValue.getItemCode());
        txtdescription.setText(newValue.getDescription());
        txtpacksize.setText(newValue.getPackSize());
        txtunitprice.setText(newValue.getUnitPrice().toString());
        txtqtyonhand.setText(newValue.getQty().toString());
    }
}



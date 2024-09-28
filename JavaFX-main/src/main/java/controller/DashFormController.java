package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashFormController {

    @FXML
    void btnAddCusOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/delete_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSearchCusOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/search_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateCusOnAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/update_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnViewCusOAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/view_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnItemViewOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.show();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/item_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

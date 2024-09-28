package controller.order;

import controller.item.ItemController;
import db.DBConnection;
import javafx.scene.control.Alert;
import lombok.SneakyThrows;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderController {

    public static boolean placeOrder(Order order) throws SQLException {
        Connection connection =DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String SQL = "INSERT INTO orders VALUE(?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setObject(1,order.getOrderId());
            pstm.setObject(2,order.getOrderDate());
            pstm.setObject(3,order.getCustomerId());
            boolean isOrderAdded = pstm.executeUpdate()>0;
            if(isOrderAdded){
                boolean isOrderDetailAdd = new OrderDetailController().addOrderDetail(order.getOrderDetails());
                if(isOrderDetailAdd){
                    boolean isStockUpdated = ItemController.getInstance().updateStock(order.getOrderDetails());
                    if (isStockUpdated){
                        connection.commit();
                        new Alert(Alert.AlertType.INFORMATION,"Order Placed").show();
                    }
                }
            }
            connection.rollback();
            return false;
         }finally {
            connection.setAutoCommit(true);
        }
}
}


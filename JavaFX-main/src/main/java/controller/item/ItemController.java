package controller.item;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Item;
import model.OrderDetail;
import util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemController implements ItemService{

    private static ItemController instance;

    private ItemController(){}

    public static ItemController getInstance(){
        return instance==null?instance=new ItemController():instance;
    }
    @Override
    public boolean addItem(Item item) {
        String SQL = "INSERT INTO item VALUES(?,?,?,?,?)";

        try {
           return CrudUtil.execute(SQL,
                   item.getItemCode(),
                   item.getDescription(),
                   item.getPackSize(),
                   item.getUnitPrice(),
                   item.getQty()
           );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteItem(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            return connection.createStatement().executeUpdate("DELETE FROM item WHERE itemCode='"+id+"'")>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Item> getAll() {
        String SQL = "SELECT * FROM item";

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = CrudUtil.execute(SQL);

            while (resultSet.next()){
                itemObservableList.add(new Item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                ));
            }

            return itemObservableList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateItem(Item item) {
        String SQL = "UPDATE item SET Description=?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setObject(1,item.getDescription());
            pstm.setObject(2,item.getPackSize());
            pstm.setObject(3,item.getUnitPrice());
            pstm.setObject(4,item.getQty());
            pstm.setObject(5,item.getItemCode());

            return pstm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item searchItem(String itemCode) {
        String SQL ="SELECT * FROM item WHERE itemCode='"+itemCode+"'";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SQL);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
               return new Item(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updateStock(List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail: orderDetails){
            boolean updateStock = updateStock(orderDetail);
            if (!updateStock){
                return false;
            }
        }
        return true;
    }

    public boolean updateStock(OrderDetail orderDetails) {
        String SQL = "UPDATE Item SET QtyHand=QtyHand-? WHERE ItemCode=?";
        try {
            return CrudUtil.execute(SQL,orderDetails.getQty(),orderDetails.getItemCode());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<String> getItemCodes(){
        ObservableList<String> itemCodes = FXCollections.observableArrayList();
        ObservableList<Item> all = getAll();

        all.forEach(item -> {
            itemCodes.add(item.getItemCode());
        });
        return itemCodes;
    }
}

package controller.item;

import javafx.collections.ObservableList;
import model.Customer;
import model.Item;
import model.OrderDetail;

import java.util.List;

public interface ItemService {

    boolean addItem(Item item);
    boolean deleteItem(String id);
    ObservableList<Item> getAll();
    boolean updateItem(Item item);
    Item searchItem(String itemCode);

    boolean updateStock(List<OrderDetail> orderDetails);
}

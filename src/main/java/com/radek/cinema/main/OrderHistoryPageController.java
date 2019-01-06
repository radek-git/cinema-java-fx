package com.radek.cinema.main;

import com.radek.cinema.Database;
import com.radek.cinema.hibernate.Order;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderHistoryPageController implements Initializable {

    @FXML ListView listView;

    @FXML Button removeButton;

    ObservableList<Order> orders = Database.getInstance().getUserOrders(1);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(orders);
    }

    public void initData(String data) {

    }

    @FXML
    private void onRemoveButtonClick(ActionEvent event) throws Exception {
        if (orders.size() > 0) {
            orders.remove(orders.size() - 1);
        }
    }

}

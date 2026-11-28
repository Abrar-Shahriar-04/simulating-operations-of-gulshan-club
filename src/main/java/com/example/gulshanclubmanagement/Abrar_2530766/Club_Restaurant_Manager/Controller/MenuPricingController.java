package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuPricingController {

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField priceField;

    @FXML
    private TableView<MenuItem> menuTable;

    @FXML
    private TableColumn<MenuItem, String> colItemName;

    @FXML
    private TableColumn<MenuItem, Double> colPrice;

    @FXML
    private TableColumn<MenuItem, String> colStock;

    private final ObservableList<MenuItem> menuList = FXCollections.observableArrayList();
    private final String fileName = "menu_items.bin";

    @FXML
    public void initialize() {
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stockStatus"));
        menuTable.setItems(menuList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        menuList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<MenuItem> savedList = (ArrayList<MenuItem>) ois.readObject();
            menuList.addAll(savedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private void saveToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(new ArrayList<>(menuList));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    public void addMenuItem(ActionEvent event) {
        String name = itemNameField.getText();
        String priceText = priceField.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText.trim());
        } catch (NumberFormatException e) {
            return;
        }

        MenuItem item = new MenuItem(name, price, "In Stock");
        menuList.add(item);
        saveToFile();

        itemNameField.clear();
        priceField.clear();
    }

    public void deleteMenuItem(ActionEvent event) {
        MenuItem selected = menuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            menuList.remove(selected);
            saveToFile();
        }
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Restaurant_Manager/restaurant_manager_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
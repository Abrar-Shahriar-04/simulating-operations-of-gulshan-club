package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.PrivateDiningReservation;
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

public class PdrReservationsController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField timeSlotField;

    @FXML
    private TextField guestCountField;

    @FXML
    private TableView<PrivateDiningReservation> reservationTable;

    @FXML
    private TableColumn<PrivateDiningReservation, String> colMemberId;

    @FXML
    private TableColumn<PrivateDiningReservation, String> colDate;

    @FXML
    private TableColumn<PrivateDiningReservation, String> colTimeSlot;

    @FXML
    private TableColumn<PrivateDiningReservation, Integer> colGuests;

    private final ObservableList<PrivateDiningReservation> reservationList = FXCollections.observableArrayList();
    private final String fileName = "vip_reservations.bin";

    @FXML
    public void initialize() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTimeSlot.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        colGuests.setCellValueFactory(new PropertyValueFactory<>("guestCount"));
        reservationTable.setItems(reservationList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        reservationList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<PrivateDiningReservation> savedList = (ArrayList<PrivateDiningReservation>) ois.readObject();
            reservationList.addAll(savedList);
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
            oos.writeObject(new ArrayList<>(reservationList));
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

    public void addReservation(ActionEvent event) {
        String memberId = memberIdField.getText();
        String date = dateField.getText();
        String timeSlot = timeSlotField.getText();
        String guestsText = guestCountField.getText();

        if (memberId.isEmpty() || date.isEmpty() || guestsText.isEmpty()) {
            return;
        }

        int guests;
        try {
            guests = Integer.parseInt(guestsText.trim());
        } catch (NumberFormatException e) {
            return;
        }

        PrivateDiningReservation res = new PrivateDiningReservation(memberId, date, timeSlot, guests);
        reservationList.add(res);
        saveToFile();

        memberIdField.clear();
        dateField.clear();
        timeSlotField.clear();
        guestCountField.clear();
    }

    public void reloadReservations(ActionEvent event) {
        loadFromFile();
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
package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.BanquetEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BanquetEventsController {

    @FXML
    private TextField eventNameField;

    @FXML
    private TextField themeField;

    @FXML
    private TextField attendeesField;

    @FXML
    private TextField hallField;

    @FXML
    private ListView<String> eventListView;

    private final ArrayList<BanquetEvent> eventList = new ArrayList<>();
    private final ObservableList<String> displayList = FXCollections.observableArrayList();
    private final String fileName = "banquet_events.bin";

    @FXML
    public void initialize() {
        eventListView.setItems(displayList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        eventList.clear();
        displayList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<BanquetEvent> savedList = (ArrayList<BanquetEvent>) ois.readObject();
            eventList.addAll(savedList);
            for (BanquetEvent ev : eventList) {
                displayList.add(ev.getEventName() + " | Theme: " + ev.getTheme() + " | Guests: " + ev.getTargetAttendees() + " | Hall: " + ev.getAssignedHall());
            }
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
            oos.writeObject(new ArrayList<>(eventList));
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

    public void addEvent(ActionEvent event) {
        String name = eventNameField.getText();
        String theme = themeField.getText();
        String attendeesText = attendeesField.getText();
        String hall = hallField.getText();

        if (name.isEmpty() || attendeesText.isEmpty()) {
            return;
        }

        int attendees;
        try {
            attendees = Integer.parseInt(attendeesText.trim());
        } catch (NumberFormatException e) {
            return;
        }

        BanquetEvent ev = new BanquetEvent(name, theme, attendees, hall);
        eventList.add(ev);
        displayList.add(ev.getEventName() + " | Theme: " + ev.getTheme() + " | Guests: " + ev.getTargetAttendees() + " | Hall: " + ev.getAssignedHall());
        saveToFile();

        eventNameField.clear();
        themeField.clear();
        attendeesField.clear();
        hallField.clear();
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
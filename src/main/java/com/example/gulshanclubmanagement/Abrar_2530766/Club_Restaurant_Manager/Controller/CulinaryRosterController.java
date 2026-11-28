package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.CulinaryRosterEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

public class CulinaryRosterController {

    @FXML
    private TextField staffNameField;

    @FXML
    private ComboBox<String> stationComboBox;

    @FXML
    private TextField shiftField;

    @FXML
    private TableView<CulinaryRosterEntry> rosterTable;

    @FXML
    private TableColumn<CulinaryRosterEntry, String> colStaffName;

    @FXML
    private TableColumn<CulinaryRosterEntry, String> colStation;

    @FXML
    private TableColumn<CulinaryRosterEntry, String> colShift;

    private final ObservableList<CulinaryRosterEntry> rosterList = FXCollections.observableArrayList();
    private final String fileName = "culinary_roster.bin";

    @FXML
    public void initialize() {
        stationComboBox.setItems(FXCollections.observableArrayList("Main Dining", "Terrace", "Lounge"));
        colStaffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        colStation.setCellValueFactory(new PropertyValueFactory<>("diningStation"));
        colShift.setCellValueFactory(new PropertyValueFactory<>("shiftSchedule"));
        rosterTable.setItems(rosterList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        rosterList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<CulinaryRosterEntry> savedList = (ArrayList<CulinaryRosterEntry>) ois.readObject();
            rosterList.addAll(savedList);
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
            oos.writeObject(new ArrayList<>(rosterList));
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

    public void assignRoster(ActionEvent event) {
        String name = staffNameField.getText();
        String station = stationComboBox.getValue();
        String shift = shiftField.getText();

        if (name.isEmpty() || station == null) {
            return;
        }

        CulinaryRosterEntry entry = new CulinaryRosterEntry(name, station, shift);
        rosterList.add(entry);
        saveToFile();

        staffNameField.clear();
        stationComboBox.setValue(null);
        shiftField.clear();
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
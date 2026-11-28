package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.MobilityRental;
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

import java.io.IOException;

public class MobilityRentalController {

    @FXML
    private ComboBox<String> equipmentComboBox;

    @FXML
    private TextField borrowerNameField;

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField timeOutField;

    @FXML
    private TableView<MobilityRental> rentalTable;

    @FXML
    private TableColumn<MobilityRental, String> colEquipment;

    @FXML
    private TableColumn<MobilityRental, String> colBorrower;

    @FXML
    private TableColumn<MobilityRental, String> colMemberId;

    @FXML
    private TableColumn<MobilityRental, String> colTimeOut;

    @FXML
    private TableColumn<MobilityRental, String> colStatus;

    private static final ObservableList<MobilityRental> rentalList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        equipmentComboBox.setItems(FXCollections.observableArrayList("Wheelchair", "Walker"));
        colEquipment.setCellValueFactory(new PropertyValueFactory<>("equipmentType"));
        colBorrower.setCellValueFactory(new PropertyValueFactory<>("borrowerName"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colTimeOut.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        rentalTable.setItems(rentalList);
    }

    public void checkoutEquipment(ActionEvent event) {
        String equipment = equipmentComboBox.getValue();
        String borrower = borrowerNameField.getText();
        String memberId = memberIdField.getText();
        String timeOut = timeOutField.getText();

        if (equipment == null || borrower.isEmpty()) {
            return;
        }

        MobilityRental rental = new MobilityRental(equipment, borrower, memberId, timeOut, "Rented");
        rentalList.add(rental);

        equipmentComboBox.setValue(null);
        borrowerNameField.clear();
        memberIdField.clear();
        timeOutField.clear();
    }

    public void returnEquipment(ActionEvent event) {
        MobilityRental selected = rentalTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Returned");
            rentalTable.refresh();
        }
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Receptionist/receptionist_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
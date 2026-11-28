package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import com.example.gulshanclubmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogVehicleExitController
{
    @javafx.fxml.FXML
    private TableColumn<VehicleRecord, LocalDateTime> EntryTimeTC;
    @javafx.fxml.FXML
    private TextField VehicleNumberTF;
    @javafx.fxml.FXML
    private TableColumn<VehicleRecord, LocalDateTime> ExitTimeTC;
    @javafx.fxml.FXML
    private TableColumn<VehicleRecord, String> StatusTC;
    @javafx.fxml.FXML
    private TableView<VehicleRecord> VehicleEntryExitTV;
    @javafx.fxml.FXML
    private TableColumn<VehicleRecord, String> VehicleNumberTC;
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    ArrayList<VehicleRecord> a=new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        VehicleNumberTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, String>("vehicleNumber"));
        EntryTimeTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, LocalDateTime>("entryTime"));
        ExitTimeTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, LocalDateTime>("exitTime"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, String>("status"));


        File f=new File("VehicleRecord.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                VehicleRecord v;
                while(true) {
                    try{
                        v = (VehicleRecord) ois.readObject();
                        VehicleEntryExitTV.getItems().add(v);
                        a.add(v);
                    }
                    catch(Exception e){
                        break;
                    }
                }
            }
        }

        catch (Exception e){
            if(ois!=null) {
                try {
                    ois.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

    }

    @javafx.fxml.FXML
    public void LogExitButtonOA(ActionEvent actionEvent) {
        if (VehicleNumberTF.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please fill the required field");
            a.showAndWait();
            return;
        }

        for (VehicleRecord v:a){
            if (v.getVehicleNumber().equals(VehicleNumberTF.getText()) && v.getStatus().equals("Exited")){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("The Vehicle is exited");
                a.showAndWait();
                return;

            }
        }

        boolean d=false;
        for (VehicleRecord v:a) {
            if (v.getVehicleNumber().equals(VehicleNumberTF.getText())){
                d=true;
            }
        }

        if (d==false){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("The Vehicle is not found");
            a.showAndWait();
            return;
        }

        for (VehicleRecord m:a){
            if (m.getVehicleNumber().equals(VehicleNumberTF.getText()) && m.getStatus().equals("Inside")){
                m.setStatus("Exited");
                m.setExitTime(LocalDateTime.now());
                break;
            }
        }

        File f=new File("VehicleRecord.bin");
        FileOutputStream fos;
        ObjectOutputStream oos=null;
        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, false);
                oos = new ObjectOutputStream(fos);
            }
            VehicleEntryExitTV.getItems().clear();
            for (VehicleRecord n:a){
                oos.writeObject(n);
                VehicleEntryExitTV.getItems().add(n);
            } oos.close();

        } catch (Exception e) {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

    }

    @javafx.fxml.FXML
    public void BackButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
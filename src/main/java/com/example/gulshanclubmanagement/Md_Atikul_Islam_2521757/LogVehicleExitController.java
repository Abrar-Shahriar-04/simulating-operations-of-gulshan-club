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


    @javafx.fxml.FXML
    public void initialize() {
        VehicleNumberTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, String>("vehicleNumber"));
        EntryTimeTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, LocalDateTime>("entryTime"));
        ExitTimeTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, LocalDateTime>("exitTime"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<VehicleRecord, String>("status"));


        File f=new File("VehicleRecord.bin");
        try{
            FileInputStream fis=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fis);
            if (f.exists()){
                VehicleRecord v;
                while(true) {
                    try{
                        v = (VehicleRecord)ois.readObject();
                        VehicleEntryExitTV.getItems().add(v);
                    }
                    catch(Exception e){
                        break;
                    }
                }
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void LogExitButtonOA(ActionEvent actionEvent) {
        String t=VehicleNumberTF.getText();
        File f=new File("VehicleRecord.bin");
        ArrayList<VehicleRecord> a=new ArrayList<>();
        try{
            if (f.exists()){
                FileInputStream fis=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fis);
                while(true) {
                    try{
                        VehicleRecord v = (VehicleRecord)ois.readObject();
                        if (v.getVehicleNumber().equals(t) && v.getStatus().equals("Inside")){
                            v.setExitTime(LocalDateTime.now());
                            v.setStatus("Exited");
                            VehicleEntryExitTV.getItems().clear();
                        }
                        a.add(v);
                    }

                    catch(Exception e){
                        break;
                    }
                }
                for (VehicleRecord b:a) {
                    VehicleEntryExitTV.getItems().add(b);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            File l=new File("VehicleRecord.bin");
            FileOutputStream fos=new FileOutputStream(l, false);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            for(VehicleRecord v:a){
                oos.writeObject(a);
            }
            oos.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void BackButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
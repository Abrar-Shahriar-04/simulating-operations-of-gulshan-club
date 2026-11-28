package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import com.example.gulshanclubmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.sql.ParameterMetaData;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalculateParkingFeeController
{
    @FXML
    private TableView<ParkingFee> ParkingFeeTV;
    @FXML
    private TextField VehicleNoTF;
    @FXML
    private TableColumn<ParkingFee, String> VehicleNoTC;
    @FXML
    private Label ParkingFeeTextArea;
    @FXML
    private TableColumn<ParkingFee, LocalDate> DateTC;
    @FXML
    private TableColumn<ParkingFee, Float> ParkingFeeTC;
    @FXML
    private TableColumn<ParkingFee, Float> HoursTC;
    @FXML
    private AnchorPane mainPane;

    ArrayList<ParkingFee> a=new ArrayList<>();
    ArrayList<VehicleRecord> z=new ArrayList<>();

    @FXML
    public void initialize() {
        VehicleNoTC.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        HoursTC.setCellValueFactory(new PropertyValueFactory<>("hours"));
        ParkingFeeTC.setCellValueFactory(new PropertyValueFactory<>("parkingFee"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        File f=new File("ParkingFee.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                ParkingFee v;
                while(true) {
                    try{
                        v = (ParkingFee) ois.readObject();
                        ParkingFeeTV.getItems().add(v);
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





        File ff=new File("VehicleRecord.bin");
        FileInputStream fiss;
        ObjectInputStream oiss=null;
        try{
            if (f.exists()){
                fiss=new FileInputStream(f);
                oiss=new ObjectInputStream(fiss);
                while (true){
                    try{
                        VehicleRecord v=(VehicleRecord) ois.readObject();
                        z.add(v);

                    }
                    catch(Exception e){
                        break;
                    }
                }
            }
        }

        catch(Exception e){
            if (oiss!=null){
                try{
                    oiss.close();
                }
                catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        }


    }

    @FXML
    public void CalculateFeeButtonOA(ActionEvent actionEvent) {
        if (VehicleNoTF.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter the vehicle number");
            a.showAndWait();
            return;
        }

        boolean r=false;
        for (VehicleRecord y:z){
            if (y.getVehicleNumber().equals(VehicleNoTF.getText())){
                r=true;
            }
        }

        if (r==false){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("The Vehicle is not found");
            a.showAndWait();
            return;
        }

        for (VehicleRecord e:z){
            if (e.getVehicleNumber().equals(VehicleNoTF.getText()) && e.getStatus().equals("Inside")){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("The Vehicle is not exited");
                a.showAndWait();
                return;
            }
        }

        Duration du = null;
        boolean x=false;
        for (VehicleRecord e:z){
            if (e.getVehicleNumber().equals(VehicleNoTF.getText()) && e.getStatus().equals("Exited")){
                du=Duration.between(e.getEntryTime(), e.getExitTime());
                x=true;
                break;
            }
        }


        long h;
        if (x==true){
            h=du.toHours();
            float parkingFee=h*30;
            ParkingFeeTextArea.setText(Float.toString(parkingFee));

            ParkingFee c=new ParkingFee(VehicleNoTF.getText(), h, parkingFee, LocalDate.now());

            File f=new File("ParkingFee.bin");
            FileOutputStream fos;
            ObjectOutputStream oos=null;
            try {
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(c);
                oos.close();
                a.add(c);
                ParkingFeeTV.getItems().clear();
                for (ParkingFee n:a){
                    ParkingFeeTV.getItems().add(n);
                }

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
    }

    @FXML
    public void BackButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
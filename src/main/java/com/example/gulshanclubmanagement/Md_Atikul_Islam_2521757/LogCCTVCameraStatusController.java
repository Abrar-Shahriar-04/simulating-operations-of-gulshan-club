package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import com.example.gulshanclubmanagement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LogCCTVCameraStatusController
{
    @javafx.fxml.FXML
    private TableColumn<CCTVCamera, Integer> CameraNoTC;
    @javafx.fxml.FXML
    private TableColumn<CCTVCamera, String> StatusTC;
    @javafx.fxml.FXML
    private TextField CameraNoTF;
    @javafx.fxml.FXML
    private TableView<CCTVCamera> CameraTV;
    @javafx.fxml.FXML
    private TableColumn<CCTVCamera, LocalDate> LastCheckedDateTC;
    @javafx.fxml.FXML
    private ComboBox<String> StatusCB;
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    ArrayList<CCTVCamera> a=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        CameraNoTC.setCellValueFactory(new PropertyValueFactory<>("cameraNo"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        LastCheckedDateTC.setCellValueFactory(new PropertyValueFactory<>("lastChecked"));

        StatusCB.getItems().addAll("Working", "Faulty");


        File f=new File("CCTVCamera.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                CCTVCamera v;
                while(true) {
                    try{
                        v = (CCTVCamera) ois.readObject();
                        CameraTV.getItems().add(v);
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
    public void BackButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }


    @javafx.fxml.FXML
    public void SaveStatusButtonOA(ActionEvent actionEvent) {
       if (CameraNoTF.getText().isEmpty() || StatusCB.getValue().isEmpty()){
           Alert a=new Alert(Alert.AlertType.ERROR);
           a.setContentText("Please fill the all required fields");
           a.showAndWait();
           return;
       }

       if (Integer.parseInt(CameraNoTF.getText()) > 10){
           Alert a=new Alert(Alert.AlertType.ERROR);
           a.setContentText("Camera No. can't be greater than 10");
           a.showAndWait();
           return;
       }

       CCTVCamera c=new CCTVCamera(Integer.parseInt(CameraNoTF.getText()), StatusCB.getValue(), LocalDate.now());

        File f=new File("CCTVCamera.bin");
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
            CameraTV.getItems().clear();
            for (CCTVCamera n:a){
                CameraTV.getItems().add(n);
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
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

public class ReportSecurityIncidentController
{
    @javafx.fxml.FXML
    private TextArea DescriptionTextArea;
    @javafx.fxml.FXML
    private TableView<SecurityIncident> IncidentTV;
    @javafx.fxml.FXML
    private TableColumn<SecurityIncident, String> DescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<SecurityIncident, String> ReportedByTC;
    @javafx.fxml.FXML
    private TableColumn<SecurityIncident, String> LocationTC;
    @javafx.fxml.FXML
    private TextField ReportedByTF;
    @javafx.fxml.FXML
    private TextField LocationTF;
    @javafx.fxml.FXML
    private TableColumn<SecurityIncident, String> IncidentTypeTC;
    @javafx.fxml.FXML
    private AnchorPane mainPane;
    @javafx.fxml.FXML
    private DatePicker DateDP;
    @javafx.fxml.FXML
    private TableColumn<SecurityIncident, LocalDate> DateTC;
    @javafx.fxml.FXML
    private ComboBox<String> IncidentTypeCB;

    ArrayList<SecurityIncident> a=new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        IncidentTypeTC.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        LocationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        DescriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        ReportedByTC.setCellValueFactory(new PropertyValueFactory<>("reportedBy"));

        IncidentTypeCB.getItems().addAll("Theft", "Trespassing", " Fire/Safety Hazard", "Dispute", "Suspicious Activity", "Other");

        File f=new File("SecurityIncident.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                SecurityIncident v;
                while(true) {
                    try{
                        v = (SecurityIncident) ois.readObject();
                        IncidentTV.getItems().add(v);
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
    public void SubmitReportButtonOA(ActionEvent actionEvent) {
        if (ReportedByTF.getText().isEmpty() || LocationTF.getText().isEmpty() || IncidentTypeCB.getValue().isEmpty() || DateDP.getValue()==null){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please fill all the required fields");
            a.showAndWait();
            return;
        }

        if (DateDP.getValue().isAfter(LocalDate.now())){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Date can not be in the future");
            a.showAndWait();
            return;
        }

        SecurityIncident c=new SecurityIncident(IncidentTypeCB.getValue(), LocationTF.getText(), DescriptionTextArea.getText(), DateDP.getValue(), ReportedByTF.getText());

        File f=new File("SecurityIncident.bin");
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
            IncidentTV.getItems().clear();
            for (SecurityIncident n:a){
                IncidentTV.getItems().add(n);
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

    @javafx.fxml.FXML
    public void BackButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
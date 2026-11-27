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

public class RegisterContractorEntryController
{
    @javafx.fxml.FXML
    private TableColumn<ContractorEntry, String> CompanyTC;
    @javafx.fxml.FXML
    private TableColumn<ContractorEntry, LocalDateTime> EntryTimeTC;
    @javafx.fxml.FXML
    private TextField CompanyTF;
    @javafx.fxml.FXML
    private TextField WorkPurposeTF;
    @javafx.fxml.FXML
    private TableColumn<ContractorEntry, String> ContactNumberTC;
    @javafx.fxml.FXML
    private TextField ContractorNameTF;
    @javafx.fxml.FXML
    private TextField ContactNumberTF;
    @javafx.fxml.FXML
    private TableView<ContractorEntry> ContractorTV;
    @javafx.fxml.FXML
    private TableColumn<ContractorEntry, String> WorkPurposeTC;
    @javafx.fxml.FXML
    private TableColumn<ContractorEntry, String> NameTC;

    ArrayList<ContractorEntry> a=new ArrayList<>();
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    @javafx.fxml.FXML
    public void initialize() {
        NameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        CompanyTC.setCellValueFactory(new PropertyValueFactory<>("company"));
        ContactNumberTC.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        WorkPurposeTC.setCellValueFactory(new PropertyValueFactory<>("workPurpose"));
        EntryTimeTC.setCellValueFactory(new PropertyValueFactory<>("entryTime"));

        File f=new File("ContractorEntry.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                ContractorEntry v;
                while(true) {
                    try{
                        v = (ContractorEntry) ois.readObject();
                        ContractorTV.getItems().add(v);
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
    public void RegisterEntryButtonOA(ActionEvent actionEvent) {
        if (ContractorNameTF.getText().isEmpty() || CompanyTF.getText().isEmpty() || WorkPurposeTF.getText().isEmpty() || ContactNumberTF.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please fill the required fields");
            a.showAndWait();
            return;
        }
        else if (ContactNumberTF.getText().length()!=11){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Invalid Contact Number");
            a.showAndWait();
            return;
        }
        for (ContractorEntry b:a){
            if (b.getContactNumber().equals(ContactNumberTF.getText())){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("The Contractor is already inside");
                a.showAndWait();
                return;
            }
        }

        ContractorEntry c=new ContractorEntry(ContactNumberTF.getText(), CompanyTF.getText(), ContactNumberTF.getText(), WorkPurposeTF.getText(), LocalDateTime.now());

        File f=new File("ContractorEntry.bin");
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
            ContractorTV.getItems().clear();
            for (ContractorEntry n:a){
                ContractorTV.getItems().add(n);
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
    public void BackButtonOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
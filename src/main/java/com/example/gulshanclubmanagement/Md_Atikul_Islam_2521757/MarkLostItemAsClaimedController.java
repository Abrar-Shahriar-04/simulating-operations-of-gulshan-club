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

public class MarkLostItemAsClaimedController
{
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> ClaimedByTC;
    @javafx.fxml.FXML
    private TextField ClaimantsNameTF;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> ItemTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> LocationFoundTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> StatusTC;
    @javafx.fxml.FXML
    private TextField ItemTF;
    @javafx.fxml.FXML
    private TableView<LostFoundItem> ItemTV;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> FinderNameTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, LocalDate> DateFoundTC;

    ArrayList<LostFoundItem> a=new ArrayList<>();
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    @javafx.fxml.FXML
    public void initialize() {
        ItemTC.setCellValueFactory(new PropertyValueFactory<>("Item"));
        LocationFoundTC.setCellValueFactory(new PropertyValueFactory<>("locationFound"));
        FinderNameTC.setCellValueFactory(new PropertyValueFactory<>("finderName"));
        DateFoundTC.setCellValueFactory(new PropertyValueFactory<>("dateFound"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        ClaimedByTC.setCellValueFactory(new PropertyValueFactory<>("ClaimedBy"));

        File f=new File("LostFoundItem.bin");
        FileInputStream fis;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            if (f.exists()){
                LostFoundItem v;
                while(true) {
                    try{
                        v = (LostFoundItem) ois.readObject();
                        ItemTV.getItems().add(v);
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
    public void MarkASClaimedButtonOA(ActionEvent actionEvent) {
        if (ItemTF.getText().isEmpty() || ClaimantsNameTF.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Item and Name can't be empty");
            a.showAndWait();
            return;
        }

        for (LostFoundItem k:a){
            if (ItemTF.getText().equals(k.getItem())){
                k.setClaimedBy(ClaimantsNameTF.getText());
                k.setStatus("Claimed");
            }
        }

        File f=new File("LostFoundItem.bin");
        FileOutputStream fos;
        ObjectOutputStream oos=null;

        try{
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (LostFoundItem t:a){
                oos.writeObject(t);
            }
            ItemTV.getItems().clear();
            for (LostFoundItem j:a){
                ItemTV.getItems().add(j);
            }

        } catch (Exception e){
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
    public void BackButtonOA(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Md_Atikul_Islam_2521757/SecurityGuardDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainPane.getChildren().setAll(node);
    }
}
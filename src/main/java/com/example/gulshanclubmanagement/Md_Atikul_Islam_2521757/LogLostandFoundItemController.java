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

public class LogLostandFoundItemController
{
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> ClaimedByTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> ItemTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> LocationFoundTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> StatusTC;
    @javafx.fxml.FXML
    private TextField ItemTF;
    @javafx.fxml.FXML
    private TextField LocationFoundTF;
    @javafx.fxml.FXML
    private TableView<LostFoundItem> ItemTV;
    @javafx.fxml.FXML
    private TextField FinderNameTF;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, String> FinderNameTC;
    @javafx.fxml.FXML
    private TableColumn<LostFoundItem, LocalDate> DateFoundTC;
    @javafx.fxml.FXML
    private DatePicker DateFoundDP;

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
    public void SaveItemButtonOA(ActionEvent actionEvent) {
        if (ItemTF.getText().length()<3){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Item must be 3 Characters");
            a.showAndWait();
            return;
        }

        else if (LocationFoundTF.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Location can not be Empty");
            a.showAndWait();
            return;
        }

        else if (DateFoundDP.getValue().isAfter(LocalDate.now())){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Date can not be in the future");
            a.showAndWait();
            return;
        }

        for (LostFoundItem l:a){
            if (l.getItem().equals(ItemTF.getText()) && l.getDateFound().isEqual(DateFoundDP.getValue()) && l.getLocationFound().equals(LocationFoundTF.getText())){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("This item is already logged");
                a.showAndWait();
                return;
            }
        }

        LostFoundItem c=new LostFoundItem(ItemTF.getText(), LocationFoundTF.getText(), FinderNameTF.getText(), DateFoundDP.getValue(),"Unclaimed", null);

        File f=new File("LostFoundItem.bin");
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
            ItemTV.getItems().clear();
            for (LostFoundItem n:a){
                ItemTV.getItems().add(n);
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
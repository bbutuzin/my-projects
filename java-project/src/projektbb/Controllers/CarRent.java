package projektbb.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import projektbb.Database.ConvertibleDatabase;
import projektbb.Database.CoupeDatabase;
import projektbb.Database.SUVDatabase;
import projektbb.Database.SedanDatabase;
import projektbb.Utilities.Convertible;
import projektbb.Utilities.Coupe;
import projektbb.Utilities.SUV;
import projektbb.Utilities.Sedan;

import java.util.List;
import java.util.UUID;

public class CarRent {
    //CONVERTIBLE
    @FXML
    private TableColumn<Convertible, String> colorConvertible;

    @FXML
    private TableColumn<Convertible, String> conditionConvertible;

    @FXML
    private TableColumn<Convertible, UUID> idConvertible;

    @FXML
    private TableColumn<Convertible, String> nameConvertible;

    @FXML
    private TableColumn<Convertible, Double> priceConvertible;

    @FXML
    private TableView<Convertible> tableConvertible;

    @FXML
    private TableColumn<Convertible, Double> tireWidthConvertible;

    @FXML
    private TableColumn<Convertible,Double> topSpeedConvertible;
    
    @FXML
    private CheckBox cbAddEqipment;

    @FXML
    private CheckBox cbInsurance;

    @FXML
    private Button checkOut;

    @FXML
    private Button filter;

    @FXML
    private ListView<?> lbCars;

    @FXML
    private TextField tbChoose;

    @FXML
    void getAllConvertibles(ActionEvent event) {
        idConvertible.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        nameConvertible.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colorConvertible.setCellValueFactory(new PropertyValueFactory<>("Color"));
        conditionConvertible.setCellValueFactory(new PropertyValueFactory<>("Condition"));
        priceConvertible.setCellValueFactory(new PropertyValueFactory<Convertible,Double>("Price"));
        topSpeedConvertible.setCellValueFactory(new PropertyValueFactory<Convertible,Double>("Top speed"));


        tableConvertible.getItems().clear();
        ConvertibleDatabase cd=new ConvertibleDatabase();
        cd.getAllConvertibles().stream().forEach(convertible -> System.out.println(convertible.toString()));

        List<Convertible> convertibles=cd.getAllConvertibles();


        for(Convertible c : convertibles){
            tableConvertible.getItems().add(c);
        }
    }
    //CONVERTIBLE

    //SUV
    @FXML
    private TableColumn<SUV, String> colorSUV;

    @FXML
    private TableColumn<SUV, String> conditionSUV;

    @FXML
    private TableColumn<SUV, String> driveSUV;

    @FXML
    private TableColumn<SUV, UUID> idSUV;

    @FXML
    private TableColumn<SUV, String> nameSUV;

    @FXML
    private Button offerSUV;

    @FXML
    private TableColumn<SUV, Double> priceSUV;

    @FXML
    private TableView<SUV> tableSUV;

    @FXML
    void getAllSUVs(ActionEvent event) {
        idSUV.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        nameSUV.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colorSUV.setCellValueFactory(new PropertyValueFactory<>("Color"));
        conditionSUV.setCellValueFactory(new PropertyValueFactory<>("Condition"));
        priceSUV.setCellValueFactory(new PropertyValueFactory<SUV ,Double>("Price"));
        driveSUV.setCellValueFactory(new PropertyValueFactory<SUV,String>("Drive"));


        tableSUV.getItems().clear();
        SUVDatabase sd=new SUVDatabase();
        sd.getAllSUVs().stream().forEach(suv -> System.out.println(suv.toString()));

        List<SUV> suvs=sd.getAllSUVs();


        for(SUV s : suvs){
            tableSUV.getItems().add(s);
        }

    }
    //SUV
    //SEDAN
    @FXML
    private TableColumn<Sedan,String> conditionSedan;

    @FXML
    private TableColumn<Sedan,String> doors;

    @FXML
    private TableColumn<Sedan,UUID> idSedan;

    @FXML
    private TableColumn<Sedan,String> nameSedan;

    @FXML
    private Button offersSedan;

    @FXML
    private TableColumn<Sedan,Double> priceSedan;

    @FXML
    private TableView<Sedan> tableSedan;

    @FXML
    private TableColumn<Sedan, String> colorSedan;

    @FXML
    void getAllSedans(ActionEvent event) {
        idSedan.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        nameSedan.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colorSedan.setCellValueFactory(new PropertyValueFactory<>("Color"));
        conditionSedan.setCellValueFactory(new PropertyValueFactory<>("Condition"));
        priceSedan.setCellValueFactory(new PropertyValueFactory<Sedan ,Double>("Price"));
        doors.setCellValueFactory(new PropertyValueFactory<Sedan,String>("Top speed"));


        tableSedan.getItems().clear();
        SedanDatabase sed=new SedanDatabase();
        sed.getAllSedan().stream().forEach(sedan -> System.out.println(sedan.toString()));

        List<Sedan> sedans=sed.getAllSedan();


        for(Sedan seda : sedans){
            tableSedan.getItems().add(seda);
        }

    }
    //SEDAN
    //COUPE
    @FXML
    private TableColumn<Coupe,String> colorCoupe;

    @FXML
    private TableColumn<Coupe,String> conditionCoupe;

    @FXML
    private TableColumn<Coupe,UUID> idCoupe;

    @FXML
    private TableColumn<Coupe,String> nameCoupe;

    @FXML
    private TableColumn<Coupe, Double> priceCoupe;

    @FXML
    private TableColumn<Coupe,String> roof;

    @FXML
    private TableView<Coupe> tableCoupe;

    @FXML
    private Button offersCoupe;

    @FXML
    void getAllCoupe(ActionEvent event) {
        idCoupe.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        nameCoupe.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colorCoupe.setCellValueFactory(new PropertyValueFactory<>("Color"));
        conditionCoupe.setCellValueFactory(new PropertyValueFactory<>("Condition"));
        priceCoupe.setCellValueFactory(new PropertyValueFactory<Coupe,Double>("Price"));
        roof.setCellValueFactory(new PropertyValueFactory<Coupe,String>("Top speed"));


        tableCoupe.getItems().clear();
        CoupeDatabase cd=new CoupeDatabase();
        cd.getAllCoupe().stream().forEach(coupe -> System.out.println(coupe.toString()));

        List<Coupe> coupes=cd.getAllCoupe();


        for(Coupe coupe : coupes){
            tableCoupe.getItems().add(coupe);
        }
    }



}

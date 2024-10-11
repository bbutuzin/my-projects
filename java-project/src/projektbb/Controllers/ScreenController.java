package projektbb.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import javafx.event.ActionEvent;

import java.io.IOException;



public class ScreenController {
    private Parent root;
    private Stage stage;
    private Scene scene;


    public void switchToSceneStart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/CarRent.fxml"));
        System.out.println(getClass().getResource("../Fxmls/CarRent.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,650,410);
        stage.setScene(scene);
        stage.show();

    }


}

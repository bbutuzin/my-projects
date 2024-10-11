package projektbb.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;


import java.io.IOException;

public class LoginController {
    @FXML
    private CheckBox cbNotices;

    @FXML
    private Button logInButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private AnchorPane infolLabel;

    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        if(usernameField.getText().equalsIgnoreCase("b") && passwordField.getText().equalsIgnoreCase("b")){
            ScreenController sc=new ScreenController();
            sc.switchToSceneStart(event);
        }else {
            infolLabel.setAccessibleText("Wrong login information!");
        }

    }
}
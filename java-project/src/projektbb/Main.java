package projektbb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main extends Application {

        static Logger log=Logger.getLogger(projektbb.Utilities.Logger.LOGGER_STRING);
    @Override
    public void start(Stage primaryStage) {
        FileHandler fileHandler=null;
        try{
            fileHandler=new FileHandler("ApplicationsLogs.log");
            log.addHandler(fileHandler);
            SimpleFormatter formatter=new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            log.info("Logger initialised");
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Fxmls/sample.fxml"));
            primaryStage.setTitle("Auto Kuca BB");
            primaryStage.setScene(new Scene(root, 650, 400));
            primaryStage.show();
        }catch (Exception e){
            log.warning("Problem with initial screen"+e.getMessage());
        }
        final FileHandler finalFileHandler=fileHandler;
        primaryStage.setOnCloseRequest(windowEvent -> {
            finalFileHandler.close();
        });
    }


    public static void main(String[] args) {
        log.info("Application start");
        launch(args);
        log.info("Application end");
    }
}

package applicationconfigurationfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashController implements Initializable {

    @FXML
    private StackPane rootStack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new splashScreen().start();
    }
    
    public class splashScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(scene);
                        stage.show();
                        rootStack.getScene().getWindow().hide();
                    }
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

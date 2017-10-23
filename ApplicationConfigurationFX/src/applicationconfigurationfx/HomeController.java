/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfigurationfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author home
 */
public class HomeController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private Pane popUpHolder;

    @FXML
    private JFXButton btnLogoff;

    @FXML
    private JFXButton btnClose;

    @FXML
    private VBox groupHome;

    @FXML
    private AnchorPane menuHome;

    @FXML
    private ImageView menuHomeImg;

    @FXML
    private AnchorPane menuReports;

    @FXML
    private VBox groupConfiguration;

    @FXML
    private AnchorPane menuConfig;

    @FXML
    private AnchorPane menuLogs;

    @FXML
    private VBox groupTestManual;

    @FXML
    private AnchorPane menuTestManual;

    @FXML
    private AnchorPane menuRegression;

    @FXML
    private VBox groupTestSuite;

    @FXML
    private AnchorPane menuTestSuite;

    @FXML
    private AnchorPane menuSmokeOnly;

    @FXML
    private VBox groupAbout;

    @FXML
    private AnchorPane menuAbout;

    private AnchorPane remoteRun;

    @FXML
    private JFXButton btnAccount;
    @FXML
    private ImageView menuConfigImg;
    @FXML
    private AnchorPane summaryAndModules;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpRipples();
        LoginController login = new LoginController();
        System.out.println(login.pName);
    }

    private void setUpRipples() {
        JFXRippler fXRippler = new JFXRippler(menuAbout, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler fXRippler2 = new JFXRippler(remoteRun, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        groupAbout.getChildren().addAll(fXRippler2, fXRippler);

        JFXRippler fXRippler3 = new JFXRippler(menuConfig, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler fXRippler4 = new JFXRippler(menuLogs, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        groupConfiguration.getChildren().addAll(fXRippler3, fXRippler4);

        JFXRippler fXRippler5 = new JFXRippler(menuTestManual, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler fXRippler6 = new JFXRippler(menuRegression, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        groupTestManual.getChildren().addAll(fXRippler5, fXRippler6);

        JFXRippler fXRippler7 = new JFXRippler(menuTestSuite, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler fXRippler8 = new JFXRippler(menuSmokeOnly, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        groupTestSuite.getChildren().addAll(fXRippler7, fXRippler8);

        JFXRippler fXRippler9 = new JFXRippler(menuHome, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        JFXRippler fXRippler10 = new JFXRippler(menuReports, JFXRippler.RipplerMask.RECT, JFXRippler.RipplerPos.FRONT);
        groupHome.getChildren().addAll(fXRippler9, fXRippler10);

    }

    private void setStage(String fxml) {
        try {
            //dim overlay on new stage opening
            Region veil = new Region();
            veil.setPrefSize(1100, 650);
            veil.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
            Stage newStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));

            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.getScene().getRoot().setEffect(new DropShadow());
            newStage.showingProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    rootPane.getChildren().add(veil);
                } else if (rootPane.getChildren().contains(veil)) {
                    rootPane.getChildren().removeAll(veil);
                }

            });
            newStage.centerOnScreen();
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ConfigSetting(MouseEvent event) {
        setStage("/modules/Configuration.fxml");
    }

    @FXML
    void RegressionSuite(MouseEvent event) {

    }

    @FXML
    void ShowTestManual(MouseEvent event) {
        setStage("/modules/TestManual.fxml");
    }

    @FXML
    void showAbout(MouseEvent event) {
        setStage("/modules/About.fxml");
    }

    @FXML
    void showHomePage(MouseEvent event) {

    }

    @FXML
    void showTestSuite(MouseEvent event) {
        setStage("/modules/TestSuite.fxml");
    }

    @FXML
    void smokeOnly(MouseEvent event) {

    }

    @FXML
    void viewLogs(MouseEvent event) {

    }

    @FXML
    void viewReports(MouseEvent event) {

    }

    @FXML
    private void loggOff(ActionEvent event) throws IOException {
        btnAccount.getScene().getWindow().hide();
        Stage news = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene s = new Scene(root);
        news.setScene(s);
        news.show();
    }

    @FXML
    private void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void showActions(ActionEvent event) {
        JFXPopup popup = new JFXPopup();
        popup.setPopupContent(popUpHolder);
        popup.show(rootPane, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -45, 65);
    }

    @FXML
    private void summaryAndModules(MouseEvent event) {
        setStage("/modules/SummaryAndModules.fxml");
    }

}

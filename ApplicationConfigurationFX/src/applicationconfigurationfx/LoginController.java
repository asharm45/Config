/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfigurationfx;

import classes.DbHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.util.FXLoader;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;

public class LoginController implements Initializable {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;

    final ObservableList projects = FXCollections.observableArrayList();
    ArrayList uLoginIdList = new ArrayList();

    @FXML
    private StackPane rootStack;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    public JFXComboBox<String> SelectProject;

    public String pName;

    @FXML
    private JFXCheckBox RememberMe;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Hyperlink createNewAccount;

    private DbHandler handler;
    @FXML
    private MaterialDesignIconView closeIcon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        handler = new DbHandler();
        getProjects();
        SelectProject.setItems(projects);

        try {
            List<String> list = dataBaseUsername();
            TextFields.bindAutoCompletion(username, list);

        } catch (SQLException ex) {
        }
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        validateProjectAccess();
    }

    public List<String> dataBaseUsername() throws SQLException {
        try {
            conn = handler.getConnection();
            String uLoginID = "select * from userInfo";
            ps = conn.prepareStatement(uLoginID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String loginID = rs.getString("username");
                uLoginIdList.add(loginID);
            }
        } catch (Exception e) {

        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return uLoginIdList;
    }


    public void validateProjectAccess() {
        try {
            int flag = 1;
            //String uName = username.getText();
            //System.out.println("Username is " + uName);
            conn = handler.getConnection();

            //Write a query to insert data into database
            String projectName = "select * from userInfo";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("username").equals(username.getText()) 
                        && rs.getString("password").equals(password.getText()) 
                        && rs.getString("projectName").equals(SelectProject.getValue())) {
                    flag = 0;
                    break;
                }
            }
            
            
            pName = SelectProject.getValue();
            System.out.println();
            if (flag == 0) {
                loginBtn.getScene().getWindow().hide();
                FXMLLoader loder = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loder.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                addPopUp("You don't have access to this project");
            }
            //System.out.println("You have access of " + projects.size() + " project/s");
        } catch (Exception ex) {
            System.out.println("Couldn't featch value from database");
        } finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }

    @FXML
    void CreateNewAccount(ActionEvent event) throws IOException {
        createNewAccount.getScene().getWindow().hide();
        FXMLLoader loder = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loder.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void getProjects() {
        try {
            conn = handler.getConnection();

            //Write a query to insert data into database
            String projectName = "select projectName from userInfo";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();

            while (rs.next()) {
                projects.add(rs.getString("projectName"));
                //System.out.println(rs.getString("projectName"));

            }
            //System.out.println("You have access of " + projects.size() + " project/s");
        } catch (Exception ex) {
            System.out.println("Couldn't featch value from database");
        } finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {

            }
        }
    }

    public void addPopUp(String text) {
        // Heading text
        Text t = new Text(text);
        t.setStyle("-fx-font-size:14px;");

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(t);

        JFXDialog dialog = new JFXDialog(rootStack, dialogLayout, JFXDialog.DialogTransition.CENTER);
        // close button
        JFXButton closeButton = new JFXButton("OK");
        closeButton.setStyle("-fx-button-type: RAISED;-fx-background-color: rgb(77,102,204);-fx-font-size: 14px;-fx-text-fill: WHITE;");

        closeButton.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });

        HBox box = new HBox();
        box.setSpacing(20);
        box.setPrefSize(200, 50);
        box.setAlignment(Pos.CENTER_RIGHT);
        box.getChildren().addAll(closeButton);
        dialogLayout.setActions(box);
        dialog.show();
    }

    @FXML
    private void closeStage(MouseEvent event) {

        loginBtn.getScene().getWindow().hide();
    }
}

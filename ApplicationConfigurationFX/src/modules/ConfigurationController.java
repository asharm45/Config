/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import classes.DbHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author home
 */
public class ConfigurationController implements Initializable {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;
    final ObservableList browser = FXCollections.observableArrayList();
    final ObservableList language = FXCollections.observableArrayList();
    final ObservableList inputMethod = FXCollections.observableArrayList();
    final ObservableList dbconnection = FXCollections.observableArrayList();
    final ObservableList winAuthenticationFlag = FXCollections.observableArrayList();

    @FXML
    private StackPane rootStack;

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField urlField;

    @FXML
    private JFXTextField appNameField;

    @FXML
    private JFXTextField waitTimeField;

    @FXML
    private JFXTextField authenticationWinField;

    @FXML
    private JFXTextField dbDriverField;

    @FXML
    private JFXTextField dbDHostField;

    @FXML
    private JFXTextField dbUsernameField;

    @FXML
    private JFXTextField dbPasswordField;

    @FXML
    private JFXTextField FailIterationField;

    @FXML
    private JFXTextField noOFTestDataField;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton loadDataBtn;

    @FXML
    private JFXButton UpdateBtn;

    ObservableList<String> browserList = FXCollections.observableArrayList("Chrome", "IE", "FireFox");
    @FXML
    public ComboBox<String> browserCombo;

    ObservableList<String> languageList = FXCollections.observableArrayList("English", "French");
    @FXML
    public ComboBox<String> languageCombo;

    ObservableList<String> inputMethodsList = FXCollections.observableArrayList("Manual", "System");
    @FXML
    public ComboBox<String> inputMethodsCombo;

    ObservableList<String> dbConnectionFlagList = FXCollections.observableArrayList("Yes", "No");
    @FXML
    public ComboBox<String> dbConnectionFlagCombo;

    ObservableList<String> authenticationWIndowPresentList = FXCollections.observableArrayList("Yes", "No");
    @FXML
    public ComboBox<String> authenticationWindowPresentCombo;
    private DbHandler handler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new DbHandler();
        browserCombo.setItems(browserList);
        languageCombo.setItems(languageList);
        inputMethodsCombo.setItems(inputMethodsList);
        dbConnectionFlagCombo.setItems(dbConnectionFlagList);
        authenticationWindowPresentCombo.setItems(authenticationWIndowPresentList);
    }

    @FXML
    private void closeStage(MouseEvent event) {
        addBtn.getScene().getWindow().hide();
    }

    @FXML
    private void add(MouseEvent event) {
        validateProjectAccess();
    }

    private void validateProjectAccess() {
        try {
            int count = 0;
            conn = handler.getConnection();
            //Write a query to insert data into database
            String projectName = "select count(url) from config";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String c = rs.getString("count(url)");
                count = Integer.parseInt(c);
                System.out.println("Number of Row/s are :" + count);
            }
            if (count >= 1) {
                addPopUp("You are NOT allowed to add more then one project's configutartion");
                clearConfig();
            } else {
                String insertData = "insert into config(url,browser,appName,inputMethod,deConnectionFlag,waitfor,autoITPath,autoITFlag,language,deDriver,dbHost,dbUser,dbPass,failRunIteration,noOfTestData) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                ps = conn.prepareStatement(insertData);
                ps.setString(1, urlField.getText());
                ps.setString(2, browserCombo.getSelectionModel().getSelectedItem());
                ps.setString(3, appNameField.getText());
                ps.setString(4, inputMethodsCombo.getSelectionModel().getSelectedItem());
                ps.setString(5, dbConnectionFlagCombo.getSelectionModel().getSelectedItem());
                ps.setString(6, waitTimeField.getText());
                ps.setString(7, authenticationWinField.getText());
                ps.setString(8, authenticationWindowPresentCombo.getSelectionModel().getSelectedItem());
                ps.setString(9, languageCombo.getSelectionModel().getSelectedItem());
                ps.setString(10, dbDriverField.getText());
                ps.setString(11, dbDHostField.getText());
                ps.setString(12, dbUsernameField.getText());
                ps.setString(13, dbPasswordField.getText());
                ps.setString(14, FailIterationField.getText());
                ps.setString(15, noOFTestDataField.getText());
                if (!urlField.getText().equals("")) {
                    ps.execute();
                    addPopUp("Data Added successfully");
                    clearConfig();
                } else {
                    addPopUp("insufficent informations");
                }
            }
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
    void load(MouseEvent event) {
        loadData();
    }

    private void loadData() {
        try {
            int count = 0;
            conn = handler.getConnection();
            //Write a query to insert data into database
            String projectName = "select * from config";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();
            if (rs.next()) {
                urlField.setText(rs.getString("url"));
                browserCombo.setValue(rs.getString("browser"));
                appNameField.setText(rs.getString("appName"));
                inputMethodsCombo.setValue(rs.getString("inputMethod"));
                dbConnectionFlagCombo.setValue(rs.getString("deConnectionFlag"));
                waitTimeField.setText(rs.getString("waitfor"));
                authenticationWinField.setText(rs.getString("autoITPath"));
                authenticationWindowPresentCombo.setValue(rs.getString("autoITFlag"));
                languageCombo.setValue(rs.getString("language"));
                winAuthenticationFlag.add(rs.getString("autoITFlag"));
                dbDriverField.setText(rs.getString("deDriver"));
                dbDHostField.setText(rs.getString("dbHost"));
                dbUsernameField.setText(rs.getString("dbUser"));
                dbPasswordField.setText(rs.getString("dbPass"));
                FailIterationField.setText(rs.getString("failRunIteration"));
                noOFTestDataField.setText(rs.getString("noOfTestData"));
                

                addPopUp("Data loaded into the textFields successfully");
            }
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
    void update(MouseEvent event) {
        try {

            conn = handler.getConnection();

            String url = urlField.getText();
            String browser = browserCombo.getSelectionModel().getSelectedItem();
            String appName = appNameField.getText();
            String inputMethod = inputMethodsCombo.getSelectionModel().getSelectedItem();
            String dbConnectionFlag = dbConnectionFlagCombo.getSelectionModel().getSelectedItem();
            String waitTime = waitTimeField.getText();
            String authenticationWindow = authenticationWinField.getText();
            String authenticationWindowPresent = authenticationWindowPresentCombo.getSelectionModel().getSelectedItem();
            String language = languageCombo.getSelectionModel().getSelectedItem();
            String dbDriver = dbDriverField.getText();
            String dbHost = dbDHostField.getText();
            String dbUsername = dbUsernameField.getText();
            String dbPass = dbPasswordField.getText();
            String FailRunIteration = FailIterationField.getText();
            String noOfTestData = noOFTestDataField.getText();

            String updateQuery = "update config set url = '" + url + "', browser= '" + browser + "', appName= '" + appName + "', inputMethod= '" + inputMethod + "', deConnectionFlag= '" + dbConnectionFlag + "', waitfor= '" + waitTime + "', autoITPath= '" + authenticationWindow + "', autoITFlag= '" + authenticationWindowPresent + "', language= '" + language + "', deDriver= '" + dbDriver + "', dbHost= '" + dbHost + "', dbUser= '" + dbUsername + "', dbPass= '" + dbPass + "', failRunIteration= '" + FailRunIteration + "', noOfTestData= '" + noOfTestData + "'";

            s = conn.createStatement();

            s.executeUpdate(updateQuery);

            addPopUp("Data Updated Successfully");
            
            clearConfig();
        } catch (Exception e) {
            //MessageSummary.setText("Somthing went wrong while updating table data");
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (Exception e) {

            }
        }
    }

    public void clearConfig() {
        urlField.setText("");
        appNameField.setText("");
        waitTimeField.setText("");
        authenticationWinField.setText("");
        dbDriverField.setText("");
        dbDHostField.setText("");
        dbUsernameField.setText("");
        dbPasswordField.setText("");
        FailIterationField.setText("");
        noOFTestDataField.setText("");
        browser.add("");
        
    }
}

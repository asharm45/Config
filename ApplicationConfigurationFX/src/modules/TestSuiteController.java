/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import classes.DbHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author home
 */
public class TestSuiteController implements Initializable {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;

    @FXML
    private MaterialDesignIconView closeIcon;
    @FXML
    private JFXButton addBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private TableView<TestSuiteList> testSuiteTable;
    @FXML
    private TableColumn<TestSuiteList, String> moduleName_Col;
    @FXML
    private TableColumn<TestSuiteList, String> Scenarion_Col;
    @FXML
    private TableColumn<TestSuiteList, String> TC_Col;
    @FXML
    private TableColumn<TestSuiteList, String> TCDescription_Col;
    @FXML
    private TableColumn<TestSuiteList, String> ExecutionFlag_Col;
    @FXML
    private JFXTextField Filtertxt;
    ObservableList<String> executionFlagList = FXCollections.observableArrayList("Yes", "No");
    ObservableList testSuiteList = FXCollections.observableArrayList();

    FilteredList testSuiteFilter = new FilteredList(testSuiteList, e -> true);

    DbHandler handler;
    @FXML
    private StackPane rootStack;
    @FXML
    private JFXTextField moduleName;
    @FXML
    private JFXTextField scenarioName;
    @FXML
    private JFXTextField tcName;
    @FXML
    private JFXTextField tcDescription;
    @FXML
    private JFXComboBox<String> executionFlag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new DbHandler();
        executionFlag.setItems(executionFlagList);
        refreshtableData();
        setCellValueFromTableToTextField();
    }

    public void refreshtableData() {
        try {
            testSuiteList.clear();
            setCellTable();
            loadDataFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(SummaryAndModulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCellTable() {
        moduleName_Col.setCellValueFactory(new PropertyValueFactory<>("ModuleName"));
        Scenarion_Col.setCellValueFactory(new PropertyValueFactory<>("ScenarionName"));
        TC_Col.setCellValueFactory(new PropertyValueFactory<>("TestCaseName"));
        TCDescription_Col.setCellValueFactory(new PropertyValueFactory<>("TestCaseDescription"));
        ExecutionFlag_Col.setCellValueFactory(new PropertyValueFactory<>("ExecutionFlag"));
    }

    private void loadDataFromDB() throws SQLException {
        try {
            conn = handler.getConnection();
            ps = conn.prepareStatement("select * from testsuite");
            rs = ps.executeQuery();
            while (rs.next()) {
                testSuiteList.add(new TestSuiteList(rs.getString("Module_Name"), rs.getString("Scenario_Name"), rs.getString("TestCase_Name"), rs.getString("ScenarioDescription"), rs.getString("ExecutionFlag")));
                System.out.println("Flag is "+rs.getString("ExecutionFlag"));
            }
        } catch (Exception e) {

        }
        testSuiteTable.setItems(testSuiteList);
    }

    @FXML
    private void closeStage(MouseEvent event) {

        addBtn.getScene().getWindow().hide();
    }

    @FXML
    private void addBtnAction(MouseEvent event) {
        try {
            String insertData = "insert into testsuite(Module_Name,Scenario_Name,TestCase_Name,ScenarioDescription,ExecutionFlag) values(?,?,?,?,?)";

            ps = conn.prepareStatement(insertData);
            ps.setString(1, moduleName.getText());
            ps.setString(2, scenarioName.getText());
            ps.setString(3, tcName.getText());
            ps.setString(4, tcDescription.getText());
            ps.setString(5, executionFlag.getSelectionModel().getSelectedItem());

            if (!tcName.getText().equals("")) {
                ps.execute();
                addPopUp("Data Added successfully");
                refreshtableData();
                clearTestSuiteFieldsData();
            } else {
                addPopUp("insufficent informations");
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
    private void updateBtnAction(MouseEvent event) {

        try {
            conn = handler.getConnection();

            String modulename = moduleName.getText();
            String scenarioName = this.scenarioName.getText();
            String tesCaseName = tcName.getText();
            String testCaseDescription = tcDescription.getText();
            String executionFlag = this.executionFlag.getSelectionModel().getSelectedItem();

            String updateQuery = "update testsuite set Module_Name = '" + modulename + "', Scenario_Name ='" + scenarioName + "' ,TestCase_Name= '" + tesCaseName + "', ScenarioDescription = '" + testCaseDescription + "',ExecutionFlag = '" + executionFlag + "' where TestCase_Name= '" + tesCaseName + "'";

            s = conn.createStatement();

            s.executeUpdate(updateQuery);

            refreshtableData();
            clearTestSuiteFieldsData();

            addPopUp("Data updated successfully");

        } catch (Exception e) {
            addPopUp("Somthing went wrong while updating table data");
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (Exception e) {

            }
        }
    }

    @FXML
    private void DeleteBtnAction(MouseEvent event) {
        try {
            conn = handler.getConnection();
            String deleteQuery = "delete from testsuite where TestCase_Name = ?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setString(1, tcName.getText());
            int i = ps.executeUpdate();
            if (i == 1) {
                addPopUp("Deteted successfully");
                refreshtableData();
                clearTestSuiteFieldsData();
            }

        } catch (SQLException ex) {
            addPopUp("Somthing went wrong while deleting the data from the table");
        } catch (Exception ex) {
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (Exception e) {

            }
        }
    }

    public void clearTestSuiteFieldsData() {
        moduleName.setText("");
        scenarioName.setText("");
        tcName.setText("");
        tcDescription.setText("");
        executionFlag.setValue("");
    }

    public void setCellValueFromTableToTextField() {
        testSuiteTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TestSuiteList ts = testSuiteTable.getItems().get(testSuiteTable.getSelectionModel().getSelectedIndex());
                moduleName.setText(ts.getModuleName());
                scenarioName.setText(ts.getScenarionName());
                tcName.setText(ts.getTestCaseName());
                tcDescription.setText(ts.getTestCaseDescription());
                executionFlag.setValue(ts.getExecutionFlag());
            }

        });

    }

    @FXML
    private void search(KeyEvent event) {

        Filtertxt.textProperty().addListener((observable, oldValue, newValue) -> {
            testSuiteFilter.setPredicate(((Predicate<? super TestSuiteList>) list -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (list.getModuleName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getScenarionName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getTestCaseName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getTestCaseDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getExecutionFlag().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            }));
        });

        SortedList<TestSuiteList> sortedData = new SortedList<TestSuiteList>(testSuiteFilter);
        sortedData.comparatorProperty().bind(testSuiteTable.comparatorProperty());
        testSuiteTable.setItems(sortedData);
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

}

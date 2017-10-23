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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author home
 */
public class TestManualController implements Initializable {

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

    private DbHandler handler;
    @FXML
    private TableView<TestManualList> TestManualTable;
    @FXML
    private TableColumn<TestManualList, String> TestCase_Col;
    @FXML
    private TableColumn<TestManualList, String> Username_Col;
    @FXML
    private TableColumn<TestManualList, String> Password_Col;

    @FXML
    private JFXTextField FilterTxt;

    ObservableList testManualList = FXCollections.observableArrayList();
    FilteredList testManualFilter = new FilteredList(testManualList, e -> true);
    @FXML
    private StackPane rootStack;
    @FXML
    private JFXTextField tcNumber;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new DbHandler();
        refreshtableData();
        setCellValueFromTableToTextField();
    }

    public void refreshtableData() {
        try {
            testManualList.clear();
            setCellTable();
            loadDataFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(SummaryAndModulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCellTable() {
        TestCase_Col.setCellValueFactory(new PropertyValueFactory<>("TestCaseName"));
        Username_Col.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Password_Col.setCellValueFactory(new PropertyValueFactory<>("Password"));
    }

    private void loadDataFromDB() throws SQLException {
        try {
            conn = handler.getConnection();
            ps = conn.prepareStatement("select * from testdata_manual");
            rs = ps.executeQuery();
            while (rs.next()) {
                testManualList.add(new TestManualList(rs.getString("TestCaseName"), rs.getString("Username"), rs.getString("Password")));
            }
        } catch (Exception e) {

        }
        TestManualTable.setItems(testManualList);
    }

    @FXML
    private void closeStage(MouseEvent event) {
        addBtn.getScene().getWindow().hide();
    }

    @FXML
    private void addBtnAction(MouseEvent event) {
        try {
            conn = handler.getConnection();
            String insertData = "insert into testdata_manual(TestCaseName,Username,Password) values(?,?,?)";

            ps = conn.prepareStatement(insertData);
            ps.setString(1, tcNumber.getText());
            ps.setString(2, username.getText());
            ps.setString(3, password.getText());
            if (!tcNumber.getText().equals("")) {
                ps.execute();
                addPopUp("Data saved successfully");
                refreshtableData();
                clearTextFields();
            } else {
                addPopUp("insufficent informations");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to close connection");
            }
        }

    }

    @FXML
    private void updateBtnAction(MouseEvent event) {
        try {

            conn = handler.getConnection();

            String tc_name = tcNumber.getText();
            String u_name = username.getText();
            String password = this.password.getText();

            String updateQuery = "update testdata_manual set TestCaseName = '" + tc_name + "', Username ='" + u_name + "' ,Password= '" + password + "' where TestCaseName= '" + tc_name + "'";

            s = conn.createStatement();

            s.executeUpdate(updateQuery);

            refreshtableData();
            clearTextFields();
            addPopUp("Data updated successfully");

        } catch (Exception e) {
            addPopUp("Somthing went wrong while updating table data");
            JOptionPane.showMessageDialog(null, e);
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
    private void DeleteBtnAction(MouseEvent event) {
               try {
            conn = handler.getConnection();
            String deleteQuery = "delete from testdata_manual where TestCaseName = ?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setString(1, tcNumber.getText());
            int i = ps.executeUpdate();
            if (i == 1) {
                addPopUp("Deteted successfully");
                refreshtableData();
                clearTextFields();
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

    public void setCellValueFromTableToTextField() {
        TestManualTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TestManualList ts = TestManualTable.getItems().get(TestManualTable.getSelectionModel().getSelectedIndex());
                tcNumber.setText(ts.getTestCaseName());
                username.setText(ts.getUsername());
                password.setText(ts.getPassword());
                //executionFlag.setText(ts.getExecutionFlag());
            }
        });
    }

    @FXML
    private void search(KeyEvent event) {
        FilterTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            testManualFilter.setPredicate(((Predicate<? super TestManualList>) list -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (list.getTestCaseName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                if (list.getPassword().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            }));
        });

        SortedList<TestManualList> sortedData = new SortedList<TestManualList>(testManualFilter);
        sortedData.comparatorProperty().bind(TestManualTable.comparatorProperty());
        TestManualTable.setItems(sortedData);
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

    public void clearTextFields() {
        tcNumber.setText("");
        username.setText("");
        password.setText("");
    }

}

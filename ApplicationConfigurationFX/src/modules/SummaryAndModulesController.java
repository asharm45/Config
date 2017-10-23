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
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class SummaryAndModulesController implements Initializable {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;

    @FXML
    private MaterialDesignIconView close;
    @FXML
    private JFXButton addSummary;
    @FXML
    private JFXButton updateSummary;
    @FXML
    private JFXButton loadSummary;
    @FXML
    private JFXButton AddModule;
    @FXML
    private JFXButton updateModule;
    @FXML
    private JFXButton deleteModule;

    private DbHandler handler;
    @FXML
    private JFXTextField domain;
    @FXML
    private JFXTextField subDomain;
    @FXML
    private JFXTextField project;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField environment;
    @FXML
    private JFXTextField language;
    @FXML
    private JFXTextField module_no;
    @FXML
    private JFXTextField module_name;
    @FXML
    private StackPane rootStack;

    private ObservableList<ModuleList> moduleList;

    @FXML
    private TableView<ModuleList> moduleTable;
    @FXML
    private TableColumn<?, ?> moduleNo_Col;
    @FXML
    private TableColumn<?, ?> moduleName_Col;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new DbHandler();
        moduleList = FXCollections.observableArrayList();
        refreshtableData();
        //first populate the values in the textfields, after that u can either update or delete the record
        populateTableDataInTextFields();
    }

    @FXML
    private void closeStage(MouseEvent event) {
        addSummary.getScene().getWindow().hide();
    }

    @FXML
    private void addSummaryAction(MouseEvent event) {
        try {
            int count = 0;
            conn = handler.getConnection();
            //Write a query to insert data into database
            String projectName = "select count(project) from summarydetails";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String c = rs.getString("count(project)");
                count = Integer.parseInt(c);
                System.out.println("Number of Row/s are :" + count);
            }
            if (count >= 1) {
                addPopUp("You are NOT allowed to add more then one project's Summary");
                clearSummary();
            } else {
                String insertData = "insert into summarydetails(domain,subDomain,project,type,environment,Language) values(?,?,?,?,?,?)";

                ps = conn.prepareStatement(insertData);
                ps.setString(1, domain.getText());
                ps.setString(2, subDomain.getText());
                ps.setString(3, project.getText());
                ps.setString(4, type.getText());
                ps.setString(5, environment.getText());
                ps.setString(6, language.getText());

                if (!project.getText().equals("")) {
                    ps.execute();
                    addPopUp("Data Added successfully");
                    clearSummary();
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

    @FXML
    private void updateSummaryAction(MouseEvent event) {
        try {

            conn = handler.getConnection();

            String dom = domain.getText();
            String subdomain = subDomain.getText();
            String pro = project.getText();
            String typ = this.type.getText();
            String env = environment.getText();
            String lang = language.getText();

            String updateQuery = "update summarydetails set domain = '" + dom + "', subDomain= '" + subdomain + "', project= '" + pro + "', type= '" + typ + "', environment= '" + env + "', Language= '" + lang + "'";

            s = conn.createStatement();

            s.executeUpdate(updateQuery);

            addPopUp("Data Updated Successfully");

            clearSummary();
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

    @FXML
    private void loadSummaryAction(MouseEvent event) {
        loadData();
    }

    private void loadData() {
        try {
            int count = 0;
            conn = handler.getConnection();
            //Write a query to insert data into database
            String projectName = "select * from summarydetails";
            ps = conn.prepareStatement(projectName);
            rs = ps.executeQuery();
            if (rs.next()) {
                domain.setText(rs.getString("domain"));
                subDomain.setText(rs.getString("subDomain"));
                project.setText(rs.getString("project"));
                type.setText(rs.getString("type"));
                environment.setText(rs.getString("environment"));
                language.setText(rs.getString("Language"));

                addPopUp("Data loaded into the textFields successfully");
            }
        } catch (Exception ex) {
            addPopUp("Unable to loaded data into the textFields");

        } finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {

            }
        }
    }

    public void clearSummary() {
        domain.setText("");
        subDomain.setText("");
        project.setText("");
        type.setText("");
        environment.setText("");
        language.setText("");
    }

    @FXML
    private void addModuleAction(MouseEvent event) {
        try {
            conn = handler.getConnection();

            //Write a query to insert data into database
            String insertData = "insert into moduledetails(ModuleNo,moduleName) values(?,?)";

            ps = conn.prepareStatement(insertData);
            ps.setString(1, module_no.getText());
            ps.setString(2, module_name.getText());
            if (!module_name.getText().equals("")) {
                ps.execute();
                addPopUp("Data added successfully");
                clearModule();
                refreshtableData();
            } else {
                addPopUp("insufficent informations");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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
    private void updateModuleAction(MouseEvent event) {
        try {

            conn = handler.getConnection();
            String moduleno = module_no.getText();
            String moduleName = module_name.getText();
            String updateQuery = "update moduledetails set ModuleNo = '" + moduleno + "' ,moduleName= '" + moduleName + "' where ModuleNo= '" + moduleno + "'";
            s = conn.createStatement();
            s.executeUpdate(updateQuery);
            addPopUp("Data updated successfully");
            refreshtableData();
            clearModule();
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
    private void deleteModuleAction(MouseEvent event) {
        try {
            conn = handler.getConnection();
            String deleteQuery = "delete from moduledetails where ModuleNo = ?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setString(1, module_no.getText());
            int i = ps.executeUpdate();
            if (i == 1) {
                addPopUp("Deteted successfully");
                refreshtableData();
                clearModule();
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

    public void refreshtableData() {
        try {
            moduleList.clear();
            setCellTable();
            loadDataFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(SummaryAndModulesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCellTable() {
        moduleNo_Col.setCellValueFactory(new PropertyValueFactory<>("moduleNo"));
        moduleName_Col.setCellValueFactory(new PropertyValueFactory<>("moduleName"));
    }

    private void loadDataFromDB() throws SQLException {
        try {
            conn = handler.getConnection();
            ps = conn.prepareStatement("select * from moduledetails");
            rs = ps.executeQuery();
            while (rs.next()) {
                moduleList.add(new ModuleList(rs.getString("ModuleNo"), rs.getString("moduleName")));
            }
        } catch (Exception e) {

        }
        moduleTable.setItems(moduleList);
    }

    private void populateTableDataInTextFields() {
        moduleTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ModuleList ml = moduleTable.getItems().get(moduleTable.getSelectionModel().getSelectedIndex());
                module_no.setText(ml.getModuleNo());
                module_name.setText(ml.getModuleName());
            }
        });
    }

    public void clearModule() {
        module_no.setText("");
        module_name.setText("");
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

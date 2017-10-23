package applicationconfigurationfx;

import classes.DbHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignUpController implements Initializable {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;

    @FXML
    private AnchorPane signUpPane;

    @FXML
    private StackPane rootStack;

    @FXML
    private JFXTextField fullName;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField Projectname;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton AddNewProject;

    private JFXTextField NewProjectname;

    private DbHandler handler;

    @FXML
    private Hyperlink alreadyRegistered;
    @FXML
    private MaterialDesignIconView closeIcon;

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        saveProject();
        signup.getScene().getWindow().hide();
        switchToLoginWin();
    }

    @FXML
    private void addProject(ActionEvent event) {
        //Body Input text
        NewProjectname = new JFXTextField();
        NewProjectname.setPromptText("Enter new project name");
        NewProjectname.setLabelFloat(false);
        NewProjectname.setPrefSize(150, 50);
        NewProjectname.setPadding(new Insets(10, 5, 10, 5));
        NewProjectname.setStyle("-fx-font-size:13px; -fx-font-weight:bold;-fx-text-fill:#00B3A0");
        // Heading text
        Text t = new Text("Add New Project");
        t.setStyle("-fx-font-size:14px;");

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(t);
        dialogLayout.setBody(NewProjectname);

        JFXDialog dialog = new JFXDialog(rootStack, dialogLayout, JFXDialog.DialogTransition.CENTER);
        // close button
        JFXButton closeButton = new JFXButton("Dismiss");
        closeButton.setStyle("-fx-button-type: RAISED;-fx-background-color: rgb(77,102,204);-fx-font-size: 14px;-fx-text-fill: WHITE;");
        //Add button
        JFXButton addBtn = new JFXButton("Add");
        addBtn.setStyle("-fx-button-type: RAISED;-fx-background-color: rgb(77,102,204);-fx-font-size: 14px;-fx-text-fill: WHITE;"
                + "");
        closeButton.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        addBtn.setOnAction((ActionEvent event1) -> {
            Projectname.setText(NewProjectname.getText());
            saveProject();
            dialog.close();
        });

        HBox box = new HBox();
        box.setSpacing(20);
        box.setPrefSize(200, 50);
        box.setAlignment(Pos.CENTER_RIGHT);
        box.getChildren().addAll(addBtn, closeButton);
        dialogLayout.setActions(box);
        dialog.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handler = new DbHandler();
    }

    private void saveProject() {
        try {
            conn = handler.getConnection();

            //Write a query to insert data into database
            String insertData = "insert into userInfo(fullName,username,password,projectName) values(?,?,?,?)";

            ps = conn.prepareStatement(insertData);
            ps.setString(1, fullName.getText());
            ps.setString(2, username.getText());
            ps.setString(3, password.getText());
            ps.setString(4, Projectname.getText());
            if (!fullName.getText().equals("")) {
                ps.execute();
                System.out.println("User registered successfully");
            } else {

            }

        } catch (Exception ex) {

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
    private void AlreadyRegiseredUserClick(ActionEvent event) throws IOException {
        alreadyRegistered.getScene().getWindow().hide();
        switchToLoginWin();
    }
    
    
    private void switchToLoginWin() throws IOException{
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loder.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void closeStage(MouseEvent event) {
        
        signup.getScene().getWindow().hide();
    }

}

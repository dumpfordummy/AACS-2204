package com.example.javafx_login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;


public class LoginController extends Draggable implements Initializable {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button cancelButton, signupButton;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField enterUsernameField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private BorderPane borderpane;

    @FXML
    @Override
    public void borderpaneOnDrag(MouseEvent event) {
        Draggable.Drag(event, borderpane);
    }

    @FXML
    @Override
    public void borderpaneOnPress(MouseEvent event) {
        Draggable.Press(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/ooptlogowithtext.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void loginButtonOnAction(ActionEvent event) {
        try {
            if(isLoginValid(enterUsernameField.getText(), enterPasswordField.getText())) {
                loginMessageLabel.setText("Logged in");
                Stage stage = (Stage) signupButton.getScene().getWindow();
                stage.close();
                Main.loadStage("Main.fxml", 725, 480);
            }else {
                loginMessageLabel.setText("Invalid username or password");
            }
        } catch (Exception ex) {
            try {
                LogError(ex.getMessage());
            } catch(IOException ioEx) {
                loginMessageLabel.setText(ioEx.getMessage());
            }
        }

    }

    private boolean isLoginValid(String username, String password){
        return !username.isBlank() && !password.isBlank() && LoginApi.IsLoginExist(username, password);
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private static void LogError(String errorMessage) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try (FileWriter file = new FileWriter("ooptErrorLog.txt", true)) {
            file.append(dtf.format(now)).append(" - ").append(errorMessage).append("\n");
        }
    }

    public void signupButtonOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) signupButton.getScene().getWindow();
            stage.close();
            Main.loadStage("Signup.fxml", 472, 535);

        } catch(Exception ex) {
            ex.printStackTrace();
            ex.getCause();
        }
    }


}
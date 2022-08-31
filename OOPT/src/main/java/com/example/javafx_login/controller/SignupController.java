package com.example.javafx_login.controller;

import com.example.javafx_login.api.LoginApi;
import com.example.javafx_login.classes.abstracts.Draggable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.http.HttpResponse;

public class SignupController extends Draggable {
    @FXML
    private TextField setUsernameField;
    @FXML
    private PasswordField setPasswordField, setConfirmPasswordField;
    @FXML
    private Button backButton;
    @FXML
    private Label signupMessageLabel;
    @FXML
    private BorderPane borderpane;

    private static double xOffset = 0;
    private static double yOffset = 0;

    @FXML
    public void borderpaneOnDrag(MouseEvent event) {
        Draggable.Drag(event, borderpane);
    }

    @FXML
    public void borderpaneOnPress(MouseEvent event) {
        Draggable.Press(event);
    }


    public void registerButtonOnAction(ActionEvent event) throws InterruptedException, IOException {
        if(isSignupValid(setUsernameField.getText(), setPasswordField.getText(), setConfirmPasswordField.getText())) {
            HttpResponse<Void> response = null;
            response = LoginApi.postSignupRequest(setUsernameField.getText(), setPasswordField.getText());
            if(response.statusCode() == 201)
                signupMessageLabel.setText("Account Created Successfully");
        } else {
            signupMessageLabel.setText("Invalid username or password");
        }
    }

    private boolean isSignupValid(String username, String password, String confirmPassword) {
        return !username.isBlank() && !password.isBlank() && !confirmPassword.isBlank() && username.matches("^[a-zA-Z0-9]*$") && password.matches("^[a-zA-Z0-9]*$") && confirmPassword.matches("^[a-zA-Z0-9]*$") && password.equals(confirmPassword);
    }

    public void backButtonOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            Main.loadStage("/com/example/javafx_login/Login.fxml", 520, 400);
        } catch(Exception ex) {
            ex.printStackTrace();
            ex.getCause();
        }
    }
}

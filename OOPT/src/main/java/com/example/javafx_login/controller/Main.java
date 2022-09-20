package com.example.javafx_login.controller;

import com.example.javafx_login.classes.Item;
import com.example.javafx_login.classes.SalesPerson;
import com.example.javafx_login.classes.ShoppingCart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

// This is starter java class
// test
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        loadStage(stage, "/com/example/javafx_login/Login.fxml", 520, 400);
    }

     public static void loadStage(String fxmlName, int width, int height) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));
         Scene scene = new Scene(fxmlLoader.load(), width, height);
         Stage stage = new Stage();
         stage.initStyle(StageStyle.UNDECORATED);
         stage.setScene(scene);
         stage.show();

         stage.setOnCloseRequest(event -> {
             event.consume();
             Quit(stage);
         });
     }

     public static void loadStage(Stage stage, String fxmlName, int width, int height) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));
         Scene scene = new Scene(fxmlLoader.load(), width, height);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.setScene(scene);
         stage.show();

         stage.setOnCloseRequest(event -> {
             event.consume();
             Quit(stage);
         });
     }

     public static void Quit(Stage stage){
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Quit");
         alert.setContentText("Do you wish to quit?");

         if (alert.showAndWait().get() == ButtonType.OK){
             stage.close();
         }
     }

    public static void main(String[] args) {
        launch();
    }

 }


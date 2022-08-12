package com.example.javafx_login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Draggable implements Initializable {
    @FXML
    private BorderPane borderpane;
    @FXML
    private ImageView desktopImageView;
    @FXML
    private ImageView laptopImageView;
    @FXML
    private ImageView mobileImageView;
    @FXML
    private ImageView accessoryImageView;
    @FXML
    private ImageView settingsImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File desktopFile = new File("image/desktop.png");
        Image desktopImage = new Image(desktopFile.toURI().toString());
        desktopImageView.setImage(desktopImage);

        File laptopFile = new File("image/laptop.png");
        Image laptopImage = new Image(laptopFile.toURI().toString());
        laptopImageView.setImage(laptopImage);

        File mobileFile = new File("image/mobile.png");
        Image mobileImage = new Image(mobileFile.toURI().toString());
        mobileImageView.setImage(mobileImage);

        File accessoryFile = new File("image/accessory.png");
        Image accessoryImage = new Image(accessoryFile.toURI().toString());
        accessoryImageView.setImage(accessoryImage);

        File settingsFile = new File("image/settings.png");
        Image settingsImage = new Image(settingsFile.toURI().toString());
        settingsImageView.setImage(settingsImage);
    }

    @Override
    public void borderpaneOnDrag(MouseEvent event) {
        Draggable.Drag(event, borderpane);
    }

    @Override
    public void borderpaneOnPress(MouseEvent event) {
        Draggable.Press(event);
    }
}

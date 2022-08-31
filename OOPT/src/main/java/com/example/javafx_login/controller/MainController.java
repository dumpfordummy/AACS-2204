package com.example.javafx_login.controller;

import com.example.javafx_login.interfaces.Draggable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Draggable implements Initializable {
    @FXML
    private BorderPane borderpane;
    @FXML
    private ImageView desktopImageView, desktopImageView_1, desktopImageView_2, desktopImageView_3, desktopImageView_4, desktopImageView_5, desktopImageView_6;
    @FXML
    private ImageView laptopImageView, laptopImageView_1, laptopImageView_2, laptopImageView_3, laptopImageView_4, laptopImageView_5, laptopImageView_6;
    @FXML
    private ImageView mobileImageView, mobileImageView_1, mobileImageView_2, mobileImageView_3, mobileImageView_4, mobileImageView_5, mobileImageView_6;
    @FXML
    private ImageView accessoryImageView, accessoryImageView_1, accessoryImageView_2, accessoryImageView_3, accessoryImageView_4, accessoryImageView_5;

    @FXML
    private ImageView settingsImageView;
    @FXML
    private AnchorPane desktopAnchorPane;
    @FXML
    private AnchorPane laptopAnchorPane;
    @FXML
    private AnchorPane mobileAnchorPane;
    @FXML
    private AnchorPane accessoryAnchorPane;
    @FXML
    private AnchorPane settingsAnchorPane;
    @FXML
    private AnchorPane rightAnchorPane;
    @FXML
    private AnchorPane rightAnchorPaneContent;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DesktopImageViewRenderer();
        LaptopImageViewRenderer();
        MobileImageViewRenderer();
        AccessoryImageViewRenderer();
        SettingsImageViewRenderer();
    }

    @Override
    public void borderpaneOnDrag(MouseEvent event) {
        Draggable.Drag(event, borderpane);
    }

    @Override
    public void borderpaneOnPress(MouseEvent event) {
        Draggable.Press(event);
    }

    public void DesktopImageViewRenderer() {
        File desktopFile = new File("image/desktop.png");
        Image desktopImage = new Image(desktopFile.toURI().toString());
        desktopImageView.setImage(desktopImage);

        File desktopFile_1 = new File("image/Acer_Aspire_XC_Seires.png");
        Image desktopImage_1 = new Image(desktopFile_1.toURI().toString());
        desktopImageView_1.setImage(desktopImage_1);

        File desktopFile_2 = new File("image/Asus_S500SA.png");
        Image desktopImage_2 = new Image(desktopFile_2.toURI().toString());
        desktopImageView_2.setImage(desktopImage_2);

        File desktopFile_3 = new File("image/Dell_Inspiron_Compact_Desktop.png");
        Image desktopImage_3 = new Image(desktopFile_3.toURI().toString());
        desktopImageView_3.setImage(desktopImage_3);

        File desktopFile_4 = new File("image/HP_ProDesk_400_G7.png");
        Image desktopImage_4 = new Image(desktopFile_4.toURI().toString());
        desktopImageView_4.setImage(desktopImage_4);

        File desktopFile_5 = new File("image/Lenovo_ThinkCentre_M80t.png");
        Image desktopImage_5 = new Image(desktopFile_5.toURI().toString());
        desktopImageView_5.setImage(desktopImage_5);

        File desktopFile_6 = new File("image/Apple_iMac_24-Inch.png");
        Image desktopImage_6 = new Image(desktopFile_6.toURI().toString());
        desktopImageView_6.setImage(desktopImage_6);
    }

    public void LaptopImageViewRenderer() {
        File laptopFile = new File("image/laptop.png");
        Image laptopImage = new Image(laptopFile.toURI().toString());
        laptopImageView.setImage(laptopImage);

        File laptopFile_1 = new File("image/Acer_Nitro_5.png");
        Image laptopImage_1 = new Image(laptopFile_1.toURI().toString());
        laptopImageView_1.setImage(laptopImage_1);

        File laptopFile_2 = new File("image/Acer_Swift_3X.png");
        Image laptopImage_2 = new Image(laptopFile_2.toURI().toString());
        laptopImageView_2.setImage(laptopImage_2);

        File laptopFile_3 = new File("image/Asus_ROG_Strix_G15.png");
        Image laptopImage_3 = new Image(laptopFile_3.toURI().toString());
        laptopImageView_3.setImage(laptopImage_3);

        File laptopFile_4 = new File("image/Asus_TUF_Dash_F15.png");
        Image laptopImage_4 = new Image(laptopFile_4.toURI().toString());
        laptopImageView_4.setImage(laptopImage_4);

        File laptopFile_5 = new File("image/Lenove_Legion_5.png");
        Image laptopImage_5 = new Image(laptopFile_5.toURI().toString());
        laptopImageView_5.setImage(laptopImage_5);

        File laptopFile_6 = new File("image/Lenovo_IdeaPad_5_Pro.png");
        Image laptopImage_6 = new Image(laptopFile_6.toURI().toString());
        laptopImageView_6.setImage(laptopImage_6);
    }

    public void MobileImageViewRenderer() {
        File mobileFile = new File("image/mobile.png");
        Image mobileImage = new Image(mobileFile.toURI().toString());
        mobileImageView.setImage(mobileImage);

        File mobileFile_1 = new File("image/Oppo_Find_X3_Pro_5G.png");
        Image mobileImage_1 = new Image(mobileFile_1.toURI().toString());
        mobileImageView_1.setImage(mobileImage_1);

        File mobileFile_2 = new File("image/Oppo_Realme_GT.png");
        Image mobileImage_2 = new Image(mobileFile_2.toURI().toString());
        mobileImageView_2.setImage(mobileImage_2);

        File mobileFile_3 = new File("image/Vivo_iQOO_8_Pro.png");
        Image mobileImage_3 = new Image(mobileFile_3.toURI().toString());
        mobileImageView_3.setImage(mobileImage_3);

        File mobileFile_4 = new File("image/Vivo_iQOO_Neo_5.png");
        Image mobileImage_4 = new Image(mobileFile_4.toURI().toString());
        mobileImageView_4.setImage(mobileImage_4);

        File mobileFile_5 = new File("image/Xiaomi_Mi_11_Pro.png");
        Image mobileImage_5 = new Image(mobileFile_5.toURI().toString());
        mobileImageView_5.setImage(mobileImage_5);

        File mobileFile_6 = new File("image/Xiaomi_Poco_F3.png");
        Image mobileImage_6 = new Image(mobileFile_6.toURI().toString());
        mobileImageView_6.setImage(mobileImage_6);
    }

    public void AccessoryImageViewRenderer() {
        File accessoryFile = new File("image/accessory.png");
        Image accessoryImage = new Image(accessoryFile.toURI().toString());
        accessoryImageView.setImage(accessoryImage);

        File accessoryFile_1 = new File("image/Apple_iPad_2020.png");
        Image accessoryImage_1 = new Image(accessoryFile_1.toURI().toString());
        accessoryImageView_1.setImage(accessoryImage_1);

        File accessoryFile_2 = new File("image/Apple_iPad_Pro_2021.png");
        Image accessoryImage_2 = new Image(accessoryFile_2.toURI().toString());
        accessoryImageView_2.setImage(accessoryImage_2);

        File accessoryFile_3 = new File("image/Huawei_MatePad_11.png");
        Image accessoryImage_3 = new Image(accessoryFile_3.toURI().toString());
        accessoryImageView_3.setImage(accessoryImage_3);

        File accessoryFile_4 = new File("image/Lenovo_Pad_Pro.png");
        Image accessoryImage_4 = new Image(accessoryFile_4.toURI().toString());
        accessoryImageView_4.setImage(accessoryImage_4);

        File accessoryFile_5 = new File("image/Samsung_Galaxy_Tab_S7.png");
        Image accessoryImage_5 = new Image(accessoryFile_5.toURI().toString());
        accessoryImageView_5.setImage(accessoryImage_5);
    }

    public void SettingsImageViewRenderer() {
        File settingsFile = new File("image/settings.png");
        Image settingsImage = new Image(settingsFile.toURI().toString());
        settingsImageView.setImage(settingsImage);
    }

    public void DesktopSectionOnAction(MouseEvent event) {
        desktopAnchorPane.setVisible(true);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
    }

    public void LaptopSectionOnAction(MouseEvent event) {
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(true);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
    }

    public void MobileSectionOnAction(MouseEvent event) {
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(true);
        accessoryAnchorPane.setVisible(false);
    }

    public void AccessorySectionOnAction(MouseEvent event) {
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(true);
    }

    public void SettingsSectionOnAction(MouseEvent event) {
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
    }
}
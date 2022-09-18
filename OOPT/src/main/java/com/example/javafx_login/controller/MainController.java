package com.example.javafx_login.controller;

import com.example.javafx_login.api.LoginApi;
import com.example.javafx_login.classes.*;
import com.example.javafx_login.classes.abstracts.Draggable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private ImageView settingsImageView, userIconImageView;
    @FXML
    private ImageView cardTerminalImageView, cardTerminal_2ImageView, QRCodeImageView;
    @FXML
    private AnchorPane desktopAnchorPane, laptopAnchorPane, mobileAnchorPane, accessoryAnchorPane, settingsAnchorPane, checkoutAnchorPane, userAnchorPane, contentAnchorPane;
    @FXML
    private AnchorPane rightAnchorPaneContent;
    @FXML
    private AnchorPane paymentDetailsAnchorPane, cashPaymentAnchorPane, cardPaymentAnchorPane, QRCodePaymentAnchorPane, cardTerminalAnchorPane, cardTerminal_2AnchorPane;
    @FXML
    private Label checkoutAlert, voucherDetails, paymentMethodAlert, paymentAlert;
    @FXML
    private Label changeRM100Qty, changeRM50Qty, changeRM20Qty, changeRM10Qty, changeRM5Qty, changeRM1Qty, change50SenQty, change20SenQty, change10SenQty, change5SenQty, totalChangeRM100, totalChangeRM50, totalChangeRM20, totalChangeRM10, totalChangeRM5, totalChangeRM1, totalChange50Sen, totalChange20Sen, totalChange10Sen, totalChange5Sen, totalChange;
    @FXML
    private Label messageLabel, subtotalLabel, userName, userDate, userID;
    @FXML
    private ComboBox<String> voucherCodeComboBox, paymentMethodComboBox;
    @FXML
    private TextField paymentFromUser, cardNumTextField;
    @FXML
    private PasswordField cardPINPasswordField;
    @FXML
    private Button insertCardButton;
    private String currentSelectedItemName, currentSelectedItemParentId;
    private final String[] voucherCodes = {"(Please Choose)", "RM5VOUCHER", "RM10VOUCHER", "RM20VOUCHER"};
    private final double[] voucherCodeDiscounts = {0, 5, 10, 20};
    private final String[] paymentMethods = {"(Please Choose)", "Cash", "Card", "QR Code"};
    private boolean isCardInserted = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DesktopImageViewRenderer();
        LaptopImageViewRenderer();
        MobileImageViewRenderer();
        AccessoryImageViewRenderer();
        SettingsImageViewRenderer();
        userImageViewRenderer();
        initUser();
        cardTerminalImageViewRenderer();
        QRCodeImageViewRenderer();
        voucherCodeComboBox.getItems().addAll(voucherCodes);
        paymentMethodComboBox.getItems().addAll(paymentMethods);
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

    public void userImageViewRenderer() {
        File userIconFile = new File("image/userIcon.png");
        Image userIconImage = new Image(userIconFile.toURI().toString());
        userIconImageView.setImage(userIconImage);
    }

    public void SettingsImageViewRenderer() {
        File settingsFile = new File("image/settings.png");
        Image settingsImage = new Image(settingsFile.toURI().toString());
        settingsImageView.setImage(settingsImage);
    }

    public void cardTerminalImageViewRenderer(){
        File cardTerminalFile = new File("image/CardTerminal.png");
        Image cardTerminalImage = new Image(cardTerminalFile.toURI().toString());
        cardTerminalImageView.setImage(cardTerminalImage);

        File cardTerminalFile_2 = new File("image/CardTerminalInserted.png");
        Image cardTerminalImage_2 = new Image(cardTerminalFile_2.toURI().toString());
        cardTerminal_2ImageView.setImage(cardTerminalImage_2);
    }

    public void QRCodeImageViewRenderer(){
        File qrCodeFile = new File("image/qr.png");
        Image qrCodeImage = new Image(qrCodeFile.toURI().toString());
        QRCodeImageView.setImage(qrCodeImage);
    }

    public void desktopSectionOnAction(MouseEvent event) {
        contentAnchorPane.setVisible(true);
        desktopAnchorPane.setVisible(true);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
        userAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void laptopSectionOnAction(MouseEvent event) {
        contentAnchorPane.setVisible(true);
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(true);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
        userAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void mobileSectionOnAction(MouseEvent event) {
        contentAnchorPane.setVisible(true);
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(true);
        accessoryAnchorPane.setVisible(false);
        userAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void accessorySectionOnAction(MouseEvent event) {
        contentAnchorPane.setVisible(true);
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(true);
        userAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void userSectionOnAction(MouseEvent event) {
        userAnchorPane.setVisible(true);
        contentAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void checkoutSectionOnAction() {
        userAnchorPane.setVisible(false);
        contentAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(true);
        settingsAnchorPane.setVisible(false);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void settingsSectionOnAction(MouseEvent event) {
        contentAnchorPane.setVisible(false);
        desktopAnchorPane.setVisible(false);
        laptopAnchorPane.setVisible(false);
        mobileAnchorPane.setVisible(false);
        accessoryAnchorPane.setVisible(false);
        userAnchorPane.setVisible(false);
        checkoutAnchorPane.setVisible(false);
        settingsAnchorPane.setVisible(true);
        cashPaymentAnchorPane.setVisible(false);
    }

    public void itemImageAddToSelectedOnClick(MouseEvent event) {
        for (Node node : ((ImageView) event.getSource()).getParent().getChildrenUnmodifiable()) {
            if (node instanceof Label) {
                currentSelectedItemName = ((Label) node).getText();
                currentSelectedItemParentId = node.getParent().getParent().getId();
                messageLabel.setText("Current selected: " + currentSelectedItemName);
            }
        }
    }

    public void clearCurrentSelectedItemName(MouseEvent event) {
        currentSelectedItemName = null;
        messageLabel.setText("");
    }

    public void addToCartOnAction(ActionEvent event) {
        ArrayList<Item> itemList = ShoppingCart.getCart();
        boolean isItemContainedInList = false;

        if (currentSelectedItemName == null) {
            messageLabel.setText("Please select an item!");
            return;
        }

        messageLabel.setText("");

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equals(currentSelectedItemName)) {
                isItemContainedInList = true;
                itemList.get(i).addQuantity();
                ShoppingCart.setCart(itemList);
                break;
            }
        }
        if (itemList.size() == 5) {
            messageLabel.setText("You can only add up to 5 items to the cart.");
            return;
        }

        if (!isItemContainedInList) {
            switch (currentSelectedItemParentId) {
                case "desktopAnchorPane" -> ShoppingCart.addToCart(new Desktop(currentSelectedItemName));
                case "laptopAnchorPane" -> ShoppingCart.addToCart(new Laptop(currentSelectedItemName));
                case "mobileAnchorPane" -> ShoppingCart.addToCart(new Mobile(currentSelectedItemName));
                case "accessoryAnchorPane" -> ShoppingCart.addToCart(new Accessory(currentSelectedItemName));
            }
        }
        updateUICart();
        System.out.println(ShoppingCart.getCart().size());
    }

    public void popCart(ActionEvent event) {
        if (ShoppingCart.getCart().size() == 0) {
            checkoutAlert.setText("Your Cart Is Empty");
            return;
        }
        else
            checkoutAlert.setText("");
        ShoppingCart.removeCartAtIndex(ShoppingCart.getCart().size() - 1);
        resetUICart();
        updateUICart();
    }

    public void resetUICart() {
        for (int i = 0; i < 5; i++) {
            AnchorPane anchorPane = (AnchorPane) rightAnchorPaneContent.getChildren().get(i);
            Label name = ((Label) anchorPane.getChildren().get(0));
            Label qty = ((Label) anchorPane.getChildren().get(1));
            Label total = ((Label) anchorPane.getChildren().get(2));

            name.setText("");
            qty.setText("");
            total.setText("");
        }
    }

    private void updateUICart() {
        List<Item> items = ShoppingCart.getCart();
        double subtotal = 0;

        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                AnchorPane anchorPane = (AnchorPane) rightAnchorPaneContent.getChildren().get(i);
                Label name = ((Label) anchorPane.getChildren().get(0));
                Label qty = ((Label) anchorPane.getChildren().get(1));
                Label total = ((Label) anchorPane.getChildren().get(2));

                name.setText(items.get(i).getName());
                qty.setText(((Integer) items.get(i).getQuantity()).toString());
                total.setText(((Double) (items.get(i).getPrice() * items.get(i).getQuantity())).toString());

                subtotal += items.get(i).getQuantity() * items.get(i).getPrice();
                subtotalLabel.setText(((Double) subtotal).toString());
            }
        } else {
            subtotalLabel.setText("");
        }
    }

    public void checkOutOnAction(ActionEvent event){
        List<Item> cart = ShoppingCart.getCart();
        if (cart.size() == 0){
            checkoutAlert.setText("Cart Is Empty");
            return;
        }
        else
            checkoutAlert.setText("");
        checkoutSectionOnAction();
        //validationOnCheckout();
        List<Item> totalSold = SalesPerson.getTotalSold();
        voucherCodeComboBox.setValue(voucherCodes[0]);
        voucherDetails.setText("");
        paymentMethodComboBox.setValue(paymentMethods[0]);
        paymentMethodAlert.setText("");
        paymentFromUser.setText("");
        paymentAlert.setText("");
    }

    public void voucherCodeComboBoxOnAction(ActionEvent event){
        if (paymentMethodComboBox.getValue() == null){
            return;
        }

        if(paymentMethodComboBox.getValue().equals(paymentMethods[1])){
            paymentFromUser.setEditable(true);
            paymentFromUser.setText("");
        }
        else if(paymentMethodComboBox.getValue().equals(paymentMethods[2])){
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - getDiscountAmount()));
        }
        else if(paymentMethodComboBox.getValue().equals(paymentMethods[3])){
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - getDiscountAmount()));
        }

        for (int i = 0; i < voucherCodes.length; i++){
            if(voucherCodeComboBox.getValue().equals(voucherCodes[i])){
                voucherDetails.setText("New Subtotal = RM" + String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - voucherCodeDiscounts[i]));
                return;
            }
            else
                voucherDetails.setText("");
        }
    }

    public void paymentMethodComboBoxOnAction(ActionEvent event){
        if(paymentMethodComboBox.getValue().equals(paymentMethods[0])){
            paymentFromUser.setEditable(false);
            paymentFromUser.setText("");
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(false);
        }
        if(paymentMethodComboBox.getValue().equals(paymentMethods[1])){
            paymentFromUser.setEditable(true);
            paymentFromUser.setText("");
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(false);
        }
        else if(paymentMethodComboBox.getValue().equals(paymentMethods[2])){
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - getDiscountAmount()));
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(true);
            QRCodePaymentAnchorPane.setVisible(false);
        }
        else if(paymentMethodComboBox.getValue().equals(paymentMethods[3])){
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - getDiscountAmount()));
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(true);
        }
    }

    public void makePaymentOnAction(ActionEvent event){
        int sizeOfCart = ShoppingCart.getCart().size();
        if (paymentMethodComboBox.getValue().equals(paymentMethods[0])){
            paymentMethodAlert.setText("Please Choose Payment Method!");
            return;
        }
        else
            paymentMethodAlert.setText("");

        if (paymentMethodComboBox.getValue().equals(paymentMethods[1])){
            if (paymentFromUser.getText().equals("")){
                paymentAlert.setText("Please Enter Payment Amount!");
                return;
            }
            else if (!isCorrectPaymentAmountFormat(paymentFromUser.getText())){
                paymentAlert.setText("Digits With/Without 2 Decimal Places!");
                return;
            }
            else if (Double.parseDouble(paymentFromUser.getText()) + getDiscountAmount() - Double.parseDouble(subtotalLabel.getText()) < 0){
                paymentAlert.setText("Payment Amount Not Enough!");
                return;
            }
            else
                paymentAlert.setText("");
        }
        else if (paymentMethodComboBox.getValue().equals(paymentMethods[2])){
            if (cardNumTextField.getText().equals("")){
                paymentAlert.setText("Please Enter Card Number!");
                return;
            }
            else if (isCardNumFormatInvalid(cardNumTextField.getText())){
                paymentAlert.setText("8 Digits Card Number!");
                return;
            }
            else if (!isCardInserted){
                paymentAlert.setText("Please Insert Card!");
                return;
            }
            else if (cardPINPasswordField.getText().equals("")){
                paymentAlert.setText("Please Enter PIN Number!");
                return;
            }
            else if (!isCorrectCardPINFormat(cardPINPasswordField.getText())){
                paymentAlert.setText("6 Digits Card PIN!");
                return;
            }
            else
                paymentAlert.setText("");
        }
        else if (paymentMethodComboBox.getValue().equals(paymentMethods[3])){
            if (!LoginApi.getIsQRScanned()){
                paymentAlert.setText("Please Scan The QR Code!");
                return;
            }
            else
                paymentAlert.setText("");
        }
        Purchase.makePayment(voucherCodeComboBox.getValue(), paymentMethodComboBox.getValue(), Double.parseDouble(paymentFromUser.getText()), Double.parseDouble(subtotalLabel.getText()), getDiscountAmount());
        //Finish Payment
        if(paymentMethodComboBox.getValue().equals(paymentMethods[1])){
            changeRM100Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM100Qty()));
            changeRM50Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM50Qty()));
            changeRM20Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM20Qty()));
            changeRM10Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM10Qty()));
            changeRM5Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM5Qty()));
            changeRM1Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeRM1Qty()));
            change50SenQty.setText(String.valueOf(Purchase.getCashPayment().getChange50SenQty()));
            change20SenQty.setText(String.valueOf(Purchase.getCashPayment().getChange20SenQty()));
            change10SenQty.setText(String.valueOf(Purchase.getCashPayment().getChange10SenQty()));
            change5SenQty.setText(String.valueOf(Purchase.getCashPayment().getChange10SenQty()));
            totalChangeRM100.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM100Qty() * 100));
            totalChangeRM50.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM50Qty() * 50));
            totalChangeRM20.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM20Qty() * 20));
            totalChangeRM10.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM10Qty() * 10));
            totalChangeRM5.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM5Qty() * 5));
            totalChangeRM1.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChangeRM1Qty()));
            totalChange50Sen.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChange50SenQty() * 0.5));
            totalChange20Sen.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChange20SenQty() * 0.2));
            totalChange10Sen.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChange10SenQty() * 0.1));
            totalChange5Sen.setText(String.format("%.2f", (double)Purchase.getCashPayment().getChange10SenQty() *0.05));
            totalChange.setText(String.format("%.2f", (Double.parseDouble(paymentFromUser.getText()) + getDiscountAmount() - Double.parseDouble(subtotalLabel.getText()))));
            paymentMethodComboBox.setValue(paymentMethods[0]);
            cashPaymentAnchorPane.setVisible(true);
        }
        else if (paymentMethodComboBox.getValue().equals(paymentMethods[2])){
            paymentMethodComboBox.setValue(paymentMethods[0]);
            cardNumTextField.setText("");
            insertCardButton.setText("Insert Card");
            cardPINPasswordField.setText("");
            cardTerminal_2AnchorPane.setVisible(false);
            isCardInserted = false;
        }
        else if (paymentMethodComboBox.getValue().equals(paymentMethods[3])){
            paymentMethodComboBox.setValue(paymentMethods[0]);
        }
        voucherCodeComboBox.setValue(voucherCodes[0]);
        voucherDetails.setText("");
        paymentMethodAlert.setText("");
        paymentFromUser.clear();
        paymentAlert.setText("");
        LoginApi.setIsQRScanned(false);
        for (int i = 0; i < sizeOfCart; i++){
            popCart(null);
        }

        //PUA JIN JIAN
    }

    public boolean isCorrectPaymentAmountFormat(String paymentAmount){
        int countDecimalPoint = 0;
        int countDecimalPlace = 0;
        for(int i = 0; i < paymentAmount.length(); i++){
            if (countDecimalPoint == 1){
                countDecimalPlace++;
            }
            if (paymentAmount.charAt(i) == '.'){
                countDecimalPoint++;
            }
            if (paymentAmount.charAt(i) != '0' && paymentAmount.charAt(i) != '1' && paymentAmount.charAt(i) != '2' && paymentAmount.charAt(i) != '3' && paymentAmount.charAt(i) != '4' && paymentAmount.charAt(i) != '5' && paymentAmount.charAt(i) != '6' && paymentAmount.charAt(i) != '7' && paymentAmount.charAt(i) != '8' && paymentAmount.charAt(i) != '9' && paymentAmount.charAt(i) != '.'){
                return false;
            }
        }

        if (countDecimalPoint != 0 && countDecimalPoint != 1){
            return false;
        }

        if (countDecimalPoint == 1 && countDecimalPlace != 2){
            return false;
        }

        return true;
    }

    public boolean isCardNumFormatInvalid(String cardNum){
        if (cardNum.length() != 8){
            return true;
        }
        for(int i = 0; i < cardNum.length(); i++){
            if (cardNum.charAt(i) != '0' && cardNum.charAt(i) != '1' && cardNum.charAt(i) != '2' && cardNum.charAt(i) != '3' && cardNum.charAt(i) != '4' && cardNum.charAt(i) != '5' && cardNum.charAt(i) != '6' && cardNum.charAt(i) != '7' && cardNum.charAt(i) != '8' && cardNum.charAt(i) != '9'){
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectCardPINFormat(String cardPIN){
        if (cardPIN.length() != 6){
            return false;
        }
        for(int i = 0; i < cardPIN.length(); i++){
            if (cardPIN.charAt(i) != '0' && cardPIN.charAt(i) != '1' && cardPIN.charAt(i) != '2' && cardPIN.charAt(i) != '3' && cardPIN.charAt(i) != '4' && cardPIN.charAt(i) != '5' && cardPIN.charAt(i) != '6' && cardPIN.charAt(i) != '7' && cardPIN.charAt(i) != '8' && cardPIN.charAt(i) != '9'){
                return false;
            }
        }
        return true;
    }

    public double getDiscountAmount(){
        if (voucherCodeComboBox.getValue() == null){
            return 0;
        }
        for (int i = 0; i < voucherCodes.length; i++){
            if(voucherCodeComboBox.getValue().equals(voucherCodes[i])){
                return voucherCodeDiscounts[i];
            }
        }
        return 0;
    }

    public void insertCardOnAction(ActionEvent event){
        if (!isCardInserted){
            if (cardNumTextField.getText().equals("")){
                paymentAlert.setText("Please Enter Card Number!");
                return;
            }
            else if (isCardNumFormatInvalid(cardNumTextField.getText())){
                paymentAlert.setText("8 Digits Card Number!");
                return;
            }
            else {
                paymentAlert.setText("");
            }
            insertCardButton.setText("Remove Card");
            cardTerminal_2AnchorPane.setVisible(true);
            isCardInserted = true;
        }
        else{
            if (!cardPINPasswordField.getText().equals("")){
                paymentAlert.setText("Please Empty Your PIN!");
                return;
            }
            insertCardButton.setText("Insert Card");
            cardNumTextField.setText("");
            cardPINPasswordField.setText("");
            cardTerminal_2AnchorPane.setVisible(false);
            isCardInserted = false;
        }
    }

    public void initUser(){
        userName.setText(SalesPerson.getLoginUserName());
        userID.setText(String.valueOf(SalesPerson.getID()));
        userDate.setText(String.valueOf(SalesPerson.getYearJoined()));
    }

    public void validationOnCheckout() {
        List<Item> items = ShoppingCart.getCart();
        for (int i = 0; i < items.size(); i++) {
            AnchorPane anchorPane = (AnchorPane) rightAnchorPaneContent.getChildren().get(i);
            Label name = ((Label) anchorPane.getChildren().get(0));
            Label qty = ((Label) anchorPane.getChildren().get(1));

            String prodName = items.get(i).getName();
            int numberOfItems = items.get(i).getQuantity();
            if(Stock.getProductStockQuantity(prodName) > numberOfItems){
                checkoutSectionOnAction();
            }
            else {
                alertNotAvailable(prodName);
            }
        }
    }

    public void alertNotAvailable(String productName){
        Alert alert = new Alert(Alert.AlertType.ERROR,"", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Error!");
        alert.setHeaderText("Error occured in checkout: Product out of stock/not available!");
        alert.setContentText(productName + " is out of stock/not available!\n Would you like to proceed to checkout?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.YES){
            checkoutSectionOnAction();
        }
    }

    public void Quit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Program");
        alert.setHeaderText("You are about to quit the program");
        alert.setContentText("Do you wish to quit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) borderpane.getScene().getWindow();
            stage.close();
        }
    }
}

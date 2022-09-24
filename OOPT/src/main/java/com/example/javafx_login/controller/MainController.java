package com.example.javafx_login.controller;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.*;

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
    private ImageView settingsImageView, userIconImageView, staffPicView;
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
    private Label changeRM100Qty, changeRM50Qty, changeRM20Qty, changeRM10Qty, changeRM5Qty, changeRM1Qty, change50SenQty, change20SenQty, change10SenQty, change5SenQty, change1SenQty, totalChangeRM100, totalChangeRM50, totalChangeRM20, totalChangeRM10, totalChangeRM5, totalChangeRM1, totalChange50Sen, totalChange20Sen, totalChange10Sen, totalChange5Sen, totalChange1Sen, totalChange;
    @FXML
    private Label messageLabel, subtotalLabel, userName, userType, userID, grossSale, itemSold;
    @FXML
    private Label recentlySold1, recentlySold2, recentlySold3, recentlySold4, recentlySold5;
    @FXML
    private Label soldQuantity1, soldQuantity2, soldQuantity3, soldQuantity4, soldQuantity5;
    @FXML
    private Label soldPrice1, soldPrice2, soldPrice3, soldPrice4, soldPrice5;
    @FXML
    private Label[] recentlySoldArr, qtySoldArr, priceSoldArr;
    @FXML
    private Queue<String> recentlySoldNameQueue = new LinkedList<>();
    @FXML
    private Queue<Integer> qtySoldQueue = new LinkedList<>();
    @FXML
    private Queue<Double> priceSoldQueue = new LinkedList<>();
    @FXML
    private ComboBox<String> voucherCodeComboBox, paymentMethodComboBox;
    @FXML
    private TextField paymentFromUser, cardNumTextField;
    @FXML
    private PasswordField cardPINPasswordField;
    @FXML
    private Button insertCardButton, generatePaySlipButton;
    private String currentSelectedItemName, currentSelectedItemParentId;
    static SalesPerson salesPerson;

    static {
        salesPerson = new SilverStaff("Pua Jin Jian", "asdf", 1, 0, 0, 15);
    }

    public static void setSalesPersonLogins(int id, String username, String password) {
      salesPerson.setID(id);
      salesPerson.setLoginUserName(username);
      salesPerson.setLoginPassword(password);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DesktopImageViewRenderer();
        LaptopImageViewRenderer();
        MobileImageViewRenderer();
        AccessoryImageViewRenderer();
        SettingsImageViewRenderer();
        userImageViewRenderer();
        staffPicViewRenderer();
        updateUserUI();
        cardTerminalImageViewRenderer();
        QRCodeImageViewRenderer();
        voucherCodeComboBox.getItems().addAll(Purchase.getVoucherCodes());
        paymentMethodComboBox.getItems().addAll(Purchase.getPaymentMethods());
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

        File desktopFile_1 = new File("image/Acer_Aspire_XC_Series.png");
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

        File laptopFile_5 = new File("image/Lenovo_Legion_5.png");
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

    public void staffPicViewRenderer() {
        File staffPicFile = new File("image/staffPic.jpeg");
        Image staffPic = new Image(staffPicFile.toURI().toString());
        staffPicView.setImage(staffPic);
    }

    public void SettingsImageViewRenderer() {
        File settingsFile = new File("image/settings.png");
        Image settingsImage = new Image(settingsFile.toURI().toString());
        settingsImageView.setImage(settingsImage);
    }

    public void cardTerminalImageViewRenderer() {
        File cardTerminalFile = new File("image/CardTerminal.png");
        Image cardTerminalImage = new Image(cardTerminalFile.toURI().toString());
        cardTerminalImageView.setImage(cardTerminalImage);

        File cardTerminalFile_2 = new File("image/CardTerminalInserted.png");
        Image cardTerminalImage_2 = new Image(cardTerminalFile_2.toURI().toString());
        cardTerminal_2ImageView.setImage(cardTerminalImage_2);
    }

    public void QRCodeImageViewRenderer() {
        File QRCodeFile = new File("image/qr.png");
        Image QRCodeImage = new Image(QRCodeFile.toURI().toString());
        QRCodeImageView.setImage(QRCodeImage);
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
    }

    public void popCart(ActionEvent event) {
        if (ShoppingCart.getCart().size() == 0) {
            checkoutAlert.setText("Your Cart Is Empty");
            return;
        } else
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

    public void checkOutOnAction(ActionEvent event) {
        List<Item> cart = ShoppingCart.getCart();
        if (cart.size() == 0) {
            checkoutAlert.setText("Cart Is Empty");
            return;
        } else
            checkoutAlert.setText("");
        if (!validationOnCheckout())
            return;

        voucherCodeComboBox.setValue(Purchase.getVoucherCodes()[0]);
        voucherDetails.setText("");
        paymentMethodComboBox.setValue(Purchase.getPaymentMethods()[0]);
        paymentMethodAlert.setText("");
        paymentFromUser.setText("");
        paymentAlert.setText("");
    }

    public void voucherCodeComboBoxOnAction(ActionEvent event) {
        if (paymentMethodComboBox.getValue() == null) {
            return;
        }

        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[1])) {
            paymentFromUser.setEditable(true);
            paymentFromUser.setText("");
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[2])) {
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - calculateDiscountAmount()));
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[3])) {
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - calculateDiscountAmount()));
        }

        for (int i = 0; i < Purchase.getVoucherCodes().length; i++) {
            if (voucherCodeComboBox.getValue().equals(Purchase.getVoucherCodes()[i])) {
                voucherDetails.setText("New Subtotal = RM" + String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - Purchase.getVoucherCodeDiscounts()[i]));
                return;
            } else
                voucherDetails.setText("");
        }
    }

    public void paymentMethodComboBoxOnAction(ActionEvent event) {
        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[0])) {
            paymentFromUser.setEditable(false);
            paymentFromUser.setText("");
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(false);
        }
        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[1])) {
            paymentFromUser.setEditable(true);
            paymentFromUser.setText("");
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(false);
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[2])) {
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - calculateDiscountAmount()));
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(true);
            QRCodePaymentAnchorPane.setVisible(false);
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[3])) {
            paymentFromUser.setEditable(false);
            paymentFromUser.setText(String.format("%.2f", Double.parseDouble(subtotalLabel.getText()) - calculateDiscountAmount()));
            cashPaymentAnchorPane.setVisible(false);
            cardPaymentAnchorPane.setVisible(false);
            QRCodePaymentAnchorPane.setVisible(true);
        }
    }

    public void makePaymentOnAction(ActionEvent event) {
        int sizeOfCart = ShoppingCart.getCart().size();
        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[0])) {
            paymentMethodAlert.setText("Please Choose Payment Method!");
            return;
        } else
            paymentMethodAlert.setText("");

        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[1])) {
            if (paymentFromUser.getText().equals("")) {
                paymentAlert.setText("Please Enter Payment Amount!");
                return;
            } else if (Cash.isPaymentAmountFormatInvalid(paymentFromUser.getText())) {
                paymentAlert.setText("Digits With/Without 2 Decimal Places!");
                return;
            } else if (Double.parseDouble(paymentFromUser.getText()) + calculateDiscountAmount() - Double.parseDouble(subtotalLabel.getText()) < 0) {
                paymentAlert.setText("Payment Amount Not Enough!");
                return;
            } else
                paymentAlert.setText("");
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[2])) {
            if (cardNumTextField.getText().equals("")) {
                paymentAlert.setText("Please Enter Card Number!");
                return;
            } else if (Card.isCardNumFormatInvalid(cardNumTextField.getText())) {
                paymentAlert.setText("8 Digits Card Number!");
                return;
            } else if (!Card.isIsCardInserted()) {
                paymentAlert.setText("Please Insert Card!");
                return;
            } else if (cardPINPasswordField.getText().equals("")) {
                paymentAlert.setText("Please Enter PIN Number!");
                return;
            } else if (Card.isCardPINFormatInvalid(cardPINPasswordField.getText())) {
                paymentAlert.setText("6 Digits Card PIN!");
                return;
            } else
                paymentAlert.setText("");
        } else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[3])) {
            if (!QRCode.getIsQrScanned()) {
                paymentAlert.setText("Please Scan The QR Code!");
                return;
            } else
                paymentAlert.setText("");
        }
        Purchase.makePayment(voucherCodeComboBox.getValue(), calculateDiscountAmount(), paymentMethodComboBox.getValue(), Double.parseDouble(paymentFromUser.getText()), Double.parseDouble(subtotalLabel.getText()), cardNumTextField.getText());
        updateTotalItemSold();
        updateGrossSales();
        initializeRecentlySoldArr();
        updateRecentlySoldTable();
        updateQtyRecentlySoldTable();
        updateTotalPriceSoldTable();
        updateUserUI();
        //Finish Payment
        List<Item> items = ShoppingCart.getCart();
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                Stock.updateStock(items.get(i).getName(), (Stock.getProductStockQuantity(items.get(i).getName()) - items.get(i).getQuantity()));
            }
        }

        if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[1])) {
            changeRM100Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM100.0")));
            changeRM50Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM50.0")));
            changeRM20Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM20.0")));
            changeRM10Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM10.0")));
            changeRM5Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM5.0")));
            changeRM1Qty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM1.0")));
            change50SenQty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM0.5")));
            change20SenQty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM0.2")));
            change10SenQty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM0.1")));
            change5SenQty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM0.05")));
            change1SenQty.setText(String.valueOf(Purchase.getCashPayment().getChangeQty().get("RM0.01")));
            totalChangeRM100.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM100.0")));
            totalChangeRM50.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM50.0")));
            totalChangeRM20.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM20.0")));
            totalChangeRM10.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM10.0")));
            totalChangeRM5.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM5.0")));
            totalChangeRM1.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM1.0")));
            totalChange50Sen.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM0.5")));
            totalChange20Sen.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM0.2")));
            totalChange10Sen.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM0.1")));
            totalChange5Sen.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM0.05")));
            totalChange1Sen.setText(String.format("%.2f", Purchase.getCashPayment().getTotalChange().get("RM0.01")));
            totalChange.setText(String.format("%.2f", Purchase.getCashPayment().getPaymentFromUser() + Purchase.getCashPayment().getDiscountAmount() - Purchase.getCashPayment().getSubtotal()));
            paymentMethodComboBox.setValue(Purchase.getPaymentMethods()[0]);
            cashPaymentAnchorPane.setVisible(true);//Put here to avoid cashPaymentAnchorPane.setVisible(false) as paymentMethodComboBoxOnAction(event)
        }
        else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[2])) {
            paymentMethodComboBox.setValue(Purchase.getPaymentMethods()[0]);
            cardNumTextField.setText("");
            insertCardButton.setText("Insert Card");
            cardPINPasswordField.setText("");
            cardTerminal_2AnchorPane.setVisible(false);
            Card.setIsCardInserted(false);
        }
        else if (paymentMethodComboBox.getValue().equals(Purchase.getPaymentMethods()[3])) {
            paymentMethodComboBox.setValue(Purchase.getPaymentMethods()[0]);
            QRCode.resetIsQrScanned();
        }
        voucherCodeComboBox.setValue(Purchase.getVoucherCodes()[0]);
        voucherDetails.setText("");
        paymentMethodAlert.setText("");
        paymentFromUser.clear();
        paymentAlert.setText("");
        for (int i = 0; i < sizeOfCart; i++) {
            popCart(null);
        }
    }

    public double calculateDiscountAmount() {
        if (voucherCodeComboBox.getValue() == null) {
            return 0;
        }
        for (int i = 0; i < Purchase.getVoucherCodes().length; i++) {
            if (voucherCodeComboBox.getValue().equals(Purchase.getVoucherCodes()[i])) {
                return Purchase.getVoucherCodeDiscounts()[i];
            }
        }
        return 0;
    }

    public void insertCardOnAction(ActionEvent event) {
        if (!Card.isIsCardInserted()) {
            if (cardNumTextField.getText().equals("")) {
                paymentAlert.setText("Please Enter Card Number!");
                return;
            } else if (Card.isCardNumFormatInvalid(cardNumTextField.getText())) {
                paymentAlert.setText("8 Digits Card Number!");
                return;
            } else {
                paymentAlert.setText("");
            }
            insertCardButton.setText("Remove Card");
            cardTerminal_2AnchorPane.setVisible(true);
            Card.setIsCardInserted(false);
        } else {
            if (!cardPINPasswordField.getText().equals("")) {
                paymentAlert.setText("Please Empty Your PIN!");
                return;
            }
            insertCardButton.setText("Insert Card");
            cardNumTextField.setText("");
            cardPINPasswordField.setText("");
            cardTerminal_2AnchorPane.setVisible(false);
            Card.setIsCardInserted(false);
        }
    }

    public void updateUserUI() {
        userName.setText(salesPerson.getLoginUserName());
        userID.setText(String.valueOf(salesPerson.getID()));
        userType.setText((salesPerson instanceof GoldStaff) ? "Gold" : "Silver");
        itemSold.setText(String.valueOf(salesPerson.getItemSold()));
        grossSale.setText(String.valueOf(salesPerson.getGrossSale()));
    }

    public void updateTotalItemSold() {
        List<Item> cart = ShoppingCart.getCart();
        for (int i = 0; i < cart.size(); i++) {
            salesPerson.setItemSold(salesPerson.getItemSold() + cart.get(i).getQuantity());
        }
    }

    public void updateGrossSales() {
        List<Item> cart = ShoppingCart.getCart();
        for (int i = 0; i < cart.size(); i++) {
            salesPerson.setGrossSale(salesPerson.getGrossSale() + (cart.get(i).getPrice() * cart.get(i).getQuantity()));
        }
        salesPerson = (salesPerson.getGrossSale() > 10000) ? new GoldStaff(salesPerson.getLoginUserName(), salesPerson.getLoginPassword(), salesPerson.getID(), salesPerson.getGrossSale(), salesPerson.getItemSold(), salesPerson.getBonus()) : new SilverStaff(salesPerson.getLoginUserName(), salesPerson.getLoginPassword(), salesPerson.getID(), salesPerson.getGrossSale(), salesPerson.getItemSold(), salesPerson.getBonus());
    }

    public void initializeRecentlySoldArr() {
        recentlySoldArr = new Label[]{recentlySold1, recentlySold2, recentlySold3, recentlySold4, recentlySold5};
        qtySoldArr = new Label[]{soldQuantity1, soldQuantity2, soldQuantity3, soldQuantity4, soldQuantity5};
        priceSoldArr = new Label[]{soldPrice1, soldPrice2, soldPrice3, soldPrice4, soldPrice5};
    }

    public void updateRecentlySoldTable() {
        List<Item> cart = ShoppingCart.getCart();
        int counter;
        for (int i = 0; i < cart.size(); i++) {
            if (recentlySoldNameQueue.size() == 5) {
                recentlySoldNameQueue.remove();
            }
            recentlySoldNameQueue.add(cart.get(i).getName());
            counter = recentlySoldNameQueue.size();
            for (String str : new ArrayList<>(recentlySoldNameQueue)) {
                recentlySoldArr[counter - 1].setText(str);
                counter--;
            }
        }
    }

    public void updateQtyRecentlySoldTable() {
        List<Item> cart = ShoppingCart.getCart();
        int counter;
        for (int i = 0; i < cart.size(); i++) {
            if (qtySoldQueue.size() == 5) {
                qtySoldQueue.remove();
            }
            qtySoldQueue.add(cart.get(i).getQuantity());
            counter = qtySoldQueue.size();
            for (Integer intLoop : new ArrayList<>(qtySoldQueue)) {
                qtySoldArr[counter - 1].setText(String.valueOf(intLoop));
                counter--;
            }
        }
    }

    public void updateTotalPriceSoldTable() {
        List<Item> cart = ShoppingCart.getCart();
        int counter;
        for (int i = 0; i < cart.size(); i++) {
            if (priceSoldQueue.size() == 5) {
                priceSoldQueue.remove();
            }
            priceSoldQueue.add(cart.get(i).getPrice() * cart.get(i).getQuantity());
            counter = priceSoldQueue.size();
            for (Double doubleLoop : new ArrayList<>(priceSoldQueue)) {
                priceSoldArr[counter - 1].setText(String.valueOf(doubleLoop));
                counter--;
            }
        }
    }

    public void generatePaySlipOnAction(ActionEvent event) {
        ButtonType saveAsButton = new ButtonType("Save as", ButtonBar.ButtonData.OK_DONE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().lookupButton(ButtonType.OK).setVisible(false);
        alert.setTitle("Payslip");
        alert.setHeaderText("Payslip for " + salesPerson.getLoginUserName());
        //alert.setContentText("Basic Salary: RM "+salesPerson.getBasicSalary() + "\nCommission Earned: RM "+salesPerson.getCommissionRate()* salesPerson.getGrossSale() + "\nBonus Earned: RM "+ salesPerson.getBonus() + "\n\nTotal Pay: RM "+salesPerson.getTotalPay());
        alert.setContentText(salesPerson.paySlipString());
        alert.getDialogPane().getButtonTypes().add(saveAsButton);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get()==saveAsButton){
            saveAsOnAction();
        }
    }

    public void saveAsOnAction() {
        Stage myStage = new Stage();
        String fileMsg = salesPerson.paySlipString();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(myStage);
        if (file != null) {
            try{
                PrintStream printStream = new PrintStream(file);
                printStream.println(fileMsg);
                printStream.flush();
            }catch (FileNotFoundException e){
                System.out.println("not found");
            }
        }
    }

    public boolean validationOnCheckout() {
        List<Item> items = ShoppingCart.getCart();
        for (int i = 0; i < items.size(); i++) {
            AnchorPane anchorPane = (AnchorPane) rightAnchorPaneContent.getChildren().get(i);
            Label name = ((Label) anchorPane.getChildren().get(0));
            Label qty = ((Label) anchorPane.getChildren().get(1));

            String prodName = items.get(i).getName();
            int numberOfItems = items.get(i).getQuantity();
            if (Stock.getProductStockQuantity(prodName) >= numberOfItems) {
                checkoutSectionOnAction();
            } else {
                alertNotAvailable(prodName);
                return false;
            }
        }
        return true;
    }

    public void alertNotAvailable(String productName) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
        alert.setTitle("Error!");
        alert.setHeaderText("Error occurred in checkout: Product out of stock/not available!");
        Optional<ButtonType> result = alert.showAndWait();
    }

    public void Quit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Program");
        alert.setHeaderText("You are about to quit the program");
        alert.setContentText("Do you wish to quit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) borderpane.getScene().getWindow();
            stage.close();
        }
    }
}

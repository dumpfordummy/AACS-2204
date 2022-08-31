module com.example.javafx_login {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.net.http;
    requires org.json;
    requires org.assertj.core;

    opens com.example.javafx_login to javafx.fxml;
    exports com.example.javafx_login.controller;
    opens com.example.javafx_login.controller to javafx.fxml;
    exports com.example.javafx_login.api;
    exports com.example.javafx_login.classes;
    opens com.example.javafx_login.api to javafx.fxml;
}
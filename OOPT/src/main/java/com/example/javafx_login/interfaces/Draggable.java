package com.example.javafx_login.interfaces;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class Draggable {
    static double xOffset = 0;
    static double yOffset = 0;
    public abstract void borderpaneOnDrag(MouseEvent event);
    public abstract void borderpaneOnPress(MouseEvent event);

    protected static void Drag(MouseEvent event, BorderPane borderPane) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    protected static void Press(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }
}

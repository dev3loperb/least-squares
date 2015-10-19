package com.github.ipergenitsa.Frame;/**
 * MFrame
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MFrame extends Application {

    private static final String TITLE = "Least squares";

    public static void launch(String... args) {
        launch(MFrame.class, args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")));
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);
        setPositionAndSize(primaryStage);
        primaryStage.show();
    }

    private void setPositionAndSize(final Stage primaryStage) {
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(700);
    }
}

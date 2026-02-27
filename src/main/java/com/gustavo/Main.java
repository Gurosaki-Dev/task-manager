package com.gustavo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Label label = new Label("Task Manager");
        Button button = new Button("Add Task");
        root.getChildren().add(label);
        root.getChildren().add(button);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);

        Scene scene = new Scene(root,400,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

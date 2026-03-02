package com.gustavo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.getStyleClass().add("root");
        root.setMaxWidth(500);
        root.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(root);
        stackPane.setAlignment(Pos.CENTER);

        Label label = new Label("Task Manager");
        label.getStyleClass().add("label");

        TextField taskName = new TextField();
        taskName.getStyleClass().add("textfield");

        Label error = new Label("*Please enter a valid task name*");
        error.getStyleClass().add("error");
        error.setVisible(false);

        Button button = new Button("Add Task");

        ListView<String> listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        button.setOnAction(_ -> {
            if(taskName.getText().isBlank()) {
                error.setVisible(true);
            } else {
                error.setVisible(false);
                listView.getItems().add(taskName.getText());
            }
        });

        root.getChildren().add(label);
        root.getChildren().add(taskName);
        root.getChildren().add(button);
        root.getChildren().add(error);
        root.getChildren().add(listView);

        Scene scene = new Scene(stackPane,400,300);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/style.css")).toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

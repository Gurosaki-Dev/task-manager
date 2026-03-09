package com.gustavo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.setMaxWidth(500);
        root.setAlignment(Pos.CENTER);

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setPadding(new Insets(10));

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);

        Label label = new Label("Task Manager");
        label.getStyleClass().add("label");

        TextField taskName = new TextField();
        taskName.getStyleClass().add("text-field");

        Label error = new Label("*Please enter a valid task name*");
        error.getStyleClass().add("error");
        error.setVisible(false);

        Button button = new Button("Add Task");
        VBox.setMargin(button, new Insets(10, 0, 0, 0));

        ListView<String> listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        button.setOnAction(_ -> {
            if(taskName.getText().isBlank()) {
                error.setVisible(true);
            } else {
                error.setVisible(false);
                listView.getItems().add(taskName.getText());
                taskName.clear();
            }
        });

        root.getChildren().addAll(topBar, label, taskName, button, error, listView);

        stackPane.getStyleClass().add("light");

        Scene scene = new Scene(stackPane,400,300);

        Button themeButton = new Button("🌙");
        themeButton.getStyleClass().add("theme-button");

        themeButton.setOnAction(_ -> {
            if (stackPane.getStyleClass().contains("light")) {

                stackPane.getStyleClass().remove("light");
                stackPane.getStyleClass().add("dark");

                themeButton.setText("☀");

            } else {

                stackPane.getStyleClass().remove("dark");
                stackPane.getStyleClass().add("light");

                themeButton.setText("🌙");

            }
        });

        topBar.getChildren().add(themeButton);

        StackPane.setAlignment(themeButton, Pos.TOP_RIGHT);
        StackPane.setMargin(themeButton, new Insets(10));

        stackPane.getChildren().addAll(root, themeButton);

        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/style.css")).toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/light-theme.css")).toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/dark-theme.css")).toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
package com.example.moreexample;

import com.example.moreexample.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunFile extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tải file FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Điều khiển Controller
        Controller controller = loader.getController();

        // Set up the stage
        primaryStage.setTitle("File Directory");
        primaryStage.setScene(new Scene(root, 750, 700));
        primaryStage.show();
primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

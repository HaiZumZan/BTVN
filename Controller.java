package com.example.moreexample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    @FXML
    Label welcomeText;

    @FXML
    Button browser;

    @FXML
    public void onBrowserButton(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Directory");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) browser.getScene().getWindow();
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            welcomeText.setText("");

            // Hiển thị đường dẫn đến thư mục
            welcomeText.setText("Hiển thị các file của: " + selectedDirectory.getAbsolutePath() + "\n\n");

            printDirectoryTree(selectedDirectory, "", welcomeText);
        } else {
            // Hủy hộp thoại
            welcomeText.setText("No directory selected.");
        }
    }

    // Hàm đệ quy để in ra cây thư mục
    private void printDirectoryTree(File directory, String prefix, Label label) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                label.setText(label.getText() + prefix + file.getName() + "\n");
                if (file.isDirectory()) {
                    printDirectoryTree(file, prefix + "  ", label);
                }
            }
        }
    }
}

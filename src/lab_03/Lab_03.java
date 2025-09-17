/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jacques-Conrad Calagui-Painchaud
 * https://github.com/waffleprinter/Lab_03.git
 */
public class Lab_03 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        
        GridPane grid = new GridPane();
        root.setCenter(grid);

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label firstName = new Label("First Name:");
        grid.add(firstName, 0, 0);
        TextField firstNameField = new TextField();
        grid.add(firstNameField, 1, 0);
        
        Label lastName = new Label("Last Name:");
        grid.add(lastName, 0, 1);
        TextField lastNameField = new TextField();
        grid.add(lastNameField, 1, 1);
        
        Label email = new Label("Email:");
        grid.add(email, 0, 2);
        TextField emailField = new TextField();
        grid.add(emailField, 1, 2);
        
        Label password = new Label("Password:");
        grid.add(password, 0, 3);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 3);
        
        Button register = new Button("Register");
        register.setDisable(false);
        grid.add(register, 0, 4);
        
        Text loginStatus = new Text();
        grid.add(loginStatus, 0, 5);
        
        register.setOnAction((ActionEvent t) -> {
            boolean validEmail = emailField.getText().contains("@");
            
            boolean passwordContainsLetter = passwordField.getText().matches(".*[a-zA-Z].*");
            boolean passwordContainsNumber = passwordField.getText().matches(".*[0-9].*");
            boolean validPassword = passwordContainsLetter && passwordContainsNumber;
            
            if (validEmail && validPassword) {
                loginStatus.setText("Success!");
            } else {
                loginStatus.setText("Invalid.");
            }
        });
        
        Button clear = new Button("Clear");
        grid.add(clear, 1, 4);
        
        clear.setOnAction((ActionEvent t) -> {
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            passwordField.setText("");
        });
        
        Scene scene = new Scene(root, 300, 275);
        stage.setScene(scene);
        
        stage.setTitle("User Registration Form");
        stage.show();
    }
}

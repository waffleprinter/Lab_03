/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jacques-Conrad Calagui-Painchaud 6298805
 * 2025/09/17
 * https://github.com/waffleprinter/Lab_03.git
 */
public class Lab_03 extends Application {
    // Variables global scope to class to let handler have access
    Button register;
    
    TextField firstNameField;
    TextField lastNameField;
    TextField emailField;
    PasswordField passwordField;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // ----STRUCTURE-----
        BorderPane root = new BorderPane();
        
        GridPane grid = new GridPane();
        root.setCenter(grid);

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // ----INPUT FIELDS----
        Label firstName = new Label("First Name:");
        grid.add(firstName, 0, 0);
        firstNameField = new TextField();
        firstNameField.setOnKeyPressed(new FieldUpdateHandler());
        grid.add(firstNameField, 1, 0);
        
        Label lastName = new Label("Last Name:");
        grid.add(lastName, 0, 1);
        lastNameField = new TextField();
        lastNameField.setOnKeyPressed(new FieldUpdateHandler());
        grid.add(lastNameField, 1, 1);
        
        Label email = new Label("Email:");
        grid.add(email, 0, 2);
        emailField = new TextField();
        emailField.setOnKeyPressed(new FieldUpdateHandler());
        grid.add(emailField, 1, 2);
        
        Label password = new Label("Password:");
        grid.add(password, 0, 3);
        passwordField = new PasswordField();
        passwordField.setOnKeyPressed(new FieldUpdateHandler());
        grid.add(passwordField, 1, 3);
        
        // ----BUTTONS----
        register = new Button("Register");
        register.setDisable(true); // Button requires all fields to be filled
        grid.add(register, 0, 4);
        
        Label loginStatus = new Label();
        grid.add(loginStatus, 0, 5);
        
        register.setOnAction((ActionEvent t) -> {
            int atSymbols = 0;
            int periodsAfterAtSymbol = 0;
            
            for (char c : emailField.getText().toCharArray()) {
                if (c == '@') {
                    atSymbols++;
                } else if (atSymbols > 0 && c == '.') {
                    periodsAfterAtSymbol++;
                }
            }
            
            // Professor said that a domain is valid iff it contains exactly one
            // period after the '@' symbol.
            boolean validEmail = atSymbols == 1 && periodsAfterAtSymbol == 1;
            
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
        
        // ----SHOW SCENE----
        Scene scene = new Scene(root, 300, 275);
        stage.setScene(scene);
        
        stage.setTitle("User Registration Form");
        stage.show();
    }
    
    class FieldUpdateHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent t) {
            boolean firstNameFilled = !firstNameField.getText().isEmpty();
            boolean lastNameFilled = !lastNameField.getText().isEmpty();
            boolean emailFilled = !emailField.getText().isEmpty();
            boolean passwordFilled = !passwordField.getText().isEmpty();
            
            if (firstNameFilled && lastNameFilled && emailFilled && passwordFilled) {
                register.setDisable(false);
            }
        }
    }
}

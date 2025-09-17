/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        
        Scene scene = new Scene(root, 300, 275);
        stage.setScene(scene);
        
        stage.setTitle("User Registration Form");
        stage.show();
    }
}

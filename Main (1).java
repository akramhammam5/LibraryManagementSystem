import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main pane
        
        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(10));
        mainPane.setHgap(10);
        mainPane.setVgap(10);

        // Add the welcome label to the main pane
        Label welcomeLabel = new Label("Welcome to Library Managemet System!");
        mainPane.add(welcomeLabel, 0, 0);
        welcomeLabel.setTranslateX(67.5);
         welcomeLabel.setTranslateY(20);
       welcomeLabel.setFont(new Font("Arial", 14));
        welcomeLabel.setTextFill(Color.RED);
        welcomeLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        // Add the register button to the main pane
        Button registerButton = new Button("Register");
        registerButton.setTranslateX(100);
        registerButton.setTranslateY(100);
        
        registerButton.setOnAction(event -> {
        GridPane mainPane2 = new GridPane();
        mainPane2.setPadding(new Insets(10));
        mainPane2.setHgap(10);
        mainPane2.setVgap(10);
         Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();
        mainPane2.add(nameLabel, 0, 0);
        mainPane2.add(nameTextField, 1, 0);

        Label emailLabel = new Label("Email:");
        TextField emailTextField = new TextField();
        mainPane2.add(emailLabel, 0, 1);
        mainPane2.add(emailTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordTextField = new PasswordField();
        mainPane2.add(passwordLabel, 0, 2);
        mainPane2.add(passwordTextField, 1, 2);
        
        // Add the submit button to the main pane
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event2 -> {
            // Get the user input
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String password = passwordTextField.getText();

            // Validate the user input
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please enter all required fields.");
                alert.show();
            } else {
                // Register the user
                 File file = new File("src/registration.txt");

                // Write the information to the file
                try {
                    PrintWriter writer = new PrintWriter(file);
                    writer.println("Name: " + name);
                    writer.println("Email: " + email);
                    writer.println("Password: " + password);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Successfully Registered!");
                alert.show();
            
                // Create a new stage
            }
        
        });
        
        mainPane2.add(submitButton, 0, 3);

        // Create the scene and show the stage
        Scene scene = new Scene(mainPane2, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        });
    
    
        mainPane.add(registerButton, 0, 0);

        // Add the login button to the main pane
        Button loginButton = new Button("Login");
        loginButton.setTranslateX(200);
        loginButton.setTranslateY(65);
    
        
                mainPane.add(loginButton, 0, 1);
                
                // Create the scene and show the stage

        // Add the login button to the main pane
       
        loginButton.setOnAction(event -> {
        GridPane mainPane3 = new GridPane();
        mainPane3.setPadding(new Insets(10));
        mainPane3.setHgap(10);
        mainPane3.setVgap(10);

        // Add the labels and text fields to the main pane
        Label usernameLabel = new Label("Username:");
        TextField usernameTextField = new TextField();
        mainPane3.add(usernameLabel, 0, 0);
        mainPane3.add(usernameTextField, 1, 0);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordTextField = new PasswordField();
        mainPane3.add(passwordLabel, 0, 1);
        mainPane3.add(passwordTextField, 1, 1);
            // Get the user input
            
        Button submit = new Button("Login");
        submit.setOnAction(event2 -> {
            // Get the user input
            String name = usernameTextField.getText();
            
            String password = passwordTextField.getText();

            // Validate the user input
            if (name.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please enter all required fields.");
                alert.show();
            } else {
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Successfully Logged In!");
                alert.show();
            
                // Create a new stage
            }
        
        });
        
        mainPane3.add(submit, 0, 3);

        // Create the scene and show the stage
        Scene scene = new Scene(mainPane3, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        });
    
        // Create the scene and show the stage
        Scene scene = new Scene(mainPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();          

    
        }

    public static void main(String[] args) {
         launch(args);
}
}


   
        



        

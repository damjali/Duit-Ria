package duitria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a root node (here, using a StackPane)
        StackPane root = new StackPane();

        // Create the scene and set the root node
        Scene scene = new Scene(root, 300, 250);

        // Set the title of the window
        primaryStage.setTitle("Basic JavaFX Window");

        // Set the scene for the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
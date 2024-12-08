package edu.sdccd.cisc190.generalstuff;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TitleScreen {
    private final Scene scene;

    public TitleScreen(Stage primaryStage) {
        /**
         * This sets up the title screen of the game
         */
        // Create the title text
        Text titleText = new Text("The NightShift at SevenGuys\n" +
                "The bad demo");
        titleText.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Create the start button
        Button startButton = new Button("Prelude to Insanity");
        startButton.setStyle("-fx-font-size: 20px;");

        // Create the MainMenu instance, but do not create the scene yet
        MainMenu mainMenu = new MainMenu(primaryStage);

        // Set the action of the button to switch to the MainMenu scene
        startButton.setOnAction(e -> primaryStage.setScene(mainMenu.getScene()));

        // Set up the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add the titleText to the top of the BorderPane
        layout.setTop(titleText);

        // Add the startButton to the center of the BorderPane
        layout.setCenter(startButton);

        // Create the scene with the layout and set the preferred size
        scene = new Scene(layout, 1080, 720);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}

package edu.sdccd.cisc190.generalstuff;

import edu.sdccd.cisc190.scenes.TwelveAM;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PreLude {
    /**
     * This class explains how the choice mechanic works after choosing a choice
     */

    private Scene scene;

    // Constructor to accept conviction and madness
    public PreLude(Stage primaryStage, int conviction, int madness) {
        // Create the game status text
        Text gameStatus = new Text("What is that? " +
                "\n At the bottom of the screen to the left" +
                "\nDid the stat points that should be appearing on a “screen” increase. " +
                "Apparently, everything you do is judge. Of Judgey devs. Huh what did we do-.\n" +
                "“Whatever, I can do this” you say anxiously of the sanity meter that is also there.\n" +
                "\nHere you are, sitting in your new office. " +
                "\nThere’s the door to the main stage on your left, a table filled with monitors of the different cameras around the restaurant, " +
                "a fan on top that barely works, and of course,\n" +
                "\na flashlight and a badge on your moldy chair " +
                "\nthat you’re sure hasn’t been cleaned in weeks… you have a bad feeling about this. How… cliche.\n");
        gameStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold;");

        // Create the display for stats (Conviction and Madness)
        Text statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create the action button
        Button actionButton = new Button("Feeling a little 12AM?");
        actionButton.setStyle("-fx-font-size: 14px;");
        actionButton.setOnAction(e -> primaryStage.setScene(new TwelveAM(primaryStage).getScene()));


        // Set up the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add the gameStatus text to the top of the BorderPane
        layout.setTop(gameStatus);

        // Add the statsText below the gameStatus
        layout.setBottom(statsText);

        // Add the actionButton to the center of the BorderPane
        VBox buttonLayout = new VBox(10, actionButton);
        layout.setCenter(buttonLayout);

        // Create the scene with the layout and set the preferred size
        scene = new Scene(layout, 1080, 720);
    }

    public PreLude(Stage primaryStage) {
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}

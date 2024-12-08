package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TwelveAM {
    private final Scene scene;
    private int conviction = 1;   // Variable to track the conviction stat
    private int madness = 1;      // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button continueButton;
    private final Button endButton;

    public TwelveAM(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You've been sitting in your office, playing Brawl Stars, " +
                "ignoring any work because there’s nothing to do besides staring at the ceiling,\n " +
                "lights on and off, and looking at the animatronics on the SCAM.\nThe clock struck midnight." +
                "\nIn the background, the SCAM flashes statics.\nThat’s important, probably.\n" +
                "Looking closer, your eyes opened wide realizing the stage was missing a person.\n" +
                "Wait... is one of them gone?\nLooking closer, you noticed Chica was gone.\n" +
                "Weird, what should you do?");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Check the cameras");
        twoButton = new Button("Be Ignorant and not do that");
        threeButton = new Button("This place is crazy, leave");
        continueButton = new Button("Are you ready for the 1AM craze?");
        endButton = new Button("End 1/? - Hell Nah");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");
        endButton.setStyle("-fx-font-size: 14px;");

        // Set the buttons after to not appear
        endButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("You’ve decided to check the cameras, from the nearby halls to adjacent rooms from the main stage." +
                    "\nYou find no trace of the missing animatronic, starting to feel quite worried about how it disappeared," +
                    "\nbut you were more worried about how the management would react hearing about one of their mascots just disappearing" +
                    "\nwith just a single shift with you. You feel the looming dread of corporate lawsuits.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        twoButton.setOnAction(e -> {
            gameStatus.setText("Whatever! The pay wasn’t good in the first place! Besides, you got more important things to do, such as getting that victory in Brawl Stars! ALright, get that power cube, dodge the bullets, shoot the enemy, and bam! You won!\n" +
                    "You got up from your chair and cheered, but it was a short victory as you noticed the animatronic right behind you. *SLASH*\n" +
                    "… You feel like you’re dead but sadly you’re still alive. Pushed to the ground, you look above at the animatronic standing above you." +
                    "\nIt’s just standing there… menacingly! But before it finishes you off it looks hesitant to hurt you.\n" +
                    "\n" +
                    "At a stalemate you consider running but Daniel the Dog answers that for you. The last thing you saw was a big olde paw coming your way." +
                    "\nYou get completely knocked out as the dog walks away in contemplation, however that may look like.\n" +
                    "\n" +
                    "Waking up, you groan at the headache you got. At least you’re still alive.\n");
            updateStats();  // Update the stats text
            boolean ispunched = true;

            // Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        threeButton.setOnAction(e -> {
            gameStatus.setText(
                    "This place is nuts! No way you’re going to deal with something like this on a late evening, let alone on the FIRST HOUR." +
                            "\nYou prepare to ditch this job without a single care of what will happen next, you exit the office, and then the building." +
                            "\nYou were decent enough to lock down the building but not enough to not chuck the keys to god-knows where." +
                            "\nYou leave, pissed out of shits, you decide it's better to celebrate Christmas earlier than this.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            endButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for continueButton to change to next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new OneAM(primaryStage).getScene()));

        //Ends the game for the ending
        endButton.setOnAction(e -> System.exit(0));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Add buttons to the layout
        BorderPane.setAlignment(oneButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(twoButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(threeButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(continueButton, javafx.geometry.Pos.CENTER);

        VBox buttonLayout = new VBox(10, oneButton, twoButton, threeButton, continueButton, endButton);
        layout.setCenter(buttonLayout);

        // Scene creation with appropriate size
        scene = new Scene(layout, 1080, 720);  // Adjusted width for better appearance
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // Helper method to hide the action buttons
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
        threeButton.setVisible(false);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}

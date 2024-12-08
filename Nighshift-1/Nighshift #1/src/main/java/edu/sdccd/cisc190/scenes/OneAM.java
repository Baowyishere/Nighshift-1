package edu.sdccd.cisc190.scenes;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.util.prefs.Preferences;

public class OneAM {
    /**
     * This sets up the entire oneAM sequence including 1 death and 2 possible outcomes based on stats also is where
     * timer starts
     */
    private Scene scene;
    private int conviction = 1; // Variable to track the conviction stat
    private int madness = 1; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;


    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button fiveButton;
    private final Button sixButton;
    private final Button deathEndButton;
    private final Button secondtwoButton;
    private final Button judgementButton;
    private final Button endingButton;

    public OneAM(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("All that excitement, and you’re still bored. " +
                "Back again scrolling through your phone, bored out of your mind, totally doing your job.\n" +
                "After the hour’s… quirky encounters? You’re pretty good. Did you have a choice?\n" +
                "No. Ironic, a game like this doesn’t give you the cho- anyways.\n" +
                "The manager of the place shoved a big old note right on the SCAM.\n" +
                "“Hello? Hello? I’m writing this like I’m speaking to you over the phone.\n" +
                "Imma need you to clean the bathrooms…” You panic over reading that part.\n" +
                "“Yes. Both of them. So good luck.”\n" +
                "Good luck? GOOD LUCK? WHAT. No way, does that imply… whatever.\n" +
                "Finishing the note, “note: if you don’t do this, I’ll terminate you.”\n" +
                "You don’t know what to say to that. So you’ll have to take care of that eventually.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Actually do your job");
        twoButton = new Button("Procrastinating is nice...");
        secondtwoButton = new Button("Into the Bathrooms...");
        threeButton = new Button("Hide under the tables");
        fourButton = new Button("Hide behind the arcade machines");
        fiveButton = new Button("Run out");
        sixButton = new Button("Look for other way out");
        deathEndButton = new Button("Running is for losers - End 2/?");
        judgementButton = new Button("To be continued...And the end of this :D");
        endingButton = new Button ("the end... probably");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        fiveButton.setStyle("-fx-font-size: 14px;");
        sixButton.setStyle("-fx-font-size: 14px;");
        deathEndButton.setStyle("-fx-font-size: 14px;");
        secondtwoButton.setStyle("-fx-font-size: 14px;");
        judgementButton.setStyle("-fx-font-size: 14px;");
        endingButton.setStyle("-fx-font-size: 14px;");


        // Set the continue button to be initially invisible
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        deathEndButton.setVisible(false);
        secondtwoButton.setVisible(false);
        judgementButton.setVisible(false);
        endingButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            try {
                gameStatus.setText("Good choice. Before heading off you check the cameras in case anything nefarious was going on… Nothing." +
                        "\nNice. You head off into the dining area but as you look onto the stage.\n" +
                        "Something was obviously wrong. Missing, for sure you knew. Ozzy and Daniel were gone.\n" +
                        "All you could see was the empty husk of Rumble’s body on stage.\n" +
                        "You hear stomping from the backstage of the establishment. It’s approaching.\n" +
                        "The dining area has an arcade nearby, chairs too.\n" +
                        "Hiding the arcade machine… would seem like a good idea but you’re not a fan of those cobwebs and lack of space.\n" +
                        "Under the tables seems nicer… and what is that… a piece of newspaper? Maybe the table would hold some information about this madness.\n");
                updateStats();  // Update the stats text

                // Show the continue button and hide other buttons
                threeButton.setVisible(true);
                fourButton.setVisible(true);
                hideOtherButtons();
            } catch (Exception ex) {
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        twoButton.setOnAction(e -> {try {
            gameStatus.setText("Being bored out of your mind maybe you'll actually go clean the bathroom." +
                    "\nWho cares about what the note on the SCAM says anyways right? You'll do what you want when you want\n" +
                    "You looked around for anything interesting, not surprisingly finding some graffiti and doodles in some of the walls" +
                    "and covers.\n" +
                    "One catches your attention however:\n" +
                    "“Merry Jurrell is bitch ass mothe-”\n" +
                    "Hmm… maybe I shouldn’t read that. Uh anyways.\n" +
                    "Picked up some cleaning supplies, and wiped off any signs of the graffiti from the restroom. \n" +
                    "[Obtained 1 Madness]\n" +
                    "Leaving, you realize the doors are locked… from the outside. This night couldn’t get any worse-" +
                    "\n You’ll need to get out eventually.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideOtherButtons();
        } catch (Exception ex) {
            // Print error message if an exception occurs
            System.err.println("Error handling the action: " + ex.getMessage());
        }
        });

        threeButton.setOnAction(e -> {
            try {
            conviction++;
            gameStatus.setText("Quickly crawling under the table, you wait in silence as giant stops fill the room. Anxiously waiting, you grab the newspaper and read it.\n" +
                    "October 12, 20XX - DISAPPEARANCE NOTICES\n" +
                    "\nRecently, two security guards have been missing after working at Seven Guys. They were last seen going to their night shifts. \n" +
                    "Strange. Maybe there's something else fishy going on here." +
                    "\nAfter that fiasco you finally arrive in the bathrooms.\n");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            secondtwoButton.setVisible(true);
            oneButton.setVisible(false);
            twoButton.setVisible(false);
            threeButton.setVisible(false);
            fourButton.setVisible(false);
            fiveButton.setVisible(false);
            sixButton.setVisible(false);
            deathEndButton.setVisible(false);
            }
            catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        fourButton.setOnAction(e -> {
            try {
                madness++;
                gameStatus.setText("SO MANY SPIDERS. The animatronic may have passed but your mind didn’t.\n" +
                        "After that fiasco you finally arrive in the bathrooms.\n");
                updateStats();  // Update the stats text

                // Show the continue button and hide other buttons
                secondtwoButton.setVisible(true);
                oneButton.setVisible(false);
                twoButton.setVisible(false);
                threeButton.setVisible(false);
                fourButton.setVisible(false);
                fiveButton.setVisible(false);
                sixButton.setVisible(false);
                deathEndButton.setVisible(false);
            } catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        fiveButton.setOnAction(e -> {
            try {
                madness++;
                gameStatus.setText("Running out. You face your worse fears. Death right in the face." +
                        "\n Would say I'm sorry for you but unfortunately death is sad. But not for you" +
                        "\n Game over mate. Maybe you'll find what happens after if you try again perhaps?");

                // Show the continue button and hide other buttons
                deathEndButton.setVisible(true);
                hideMoreButtons();
            }
            catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        sixButton.setOnAction(e -> {
            try {
                conviction++;
                gameStatus.setText("Crawling through the vents, you find a lost paper.\n" +
                        "\nSeems to you that there were many security guards that were lost here" +
                        "\n somethings off and you're going to figure out what" +
                        "\n and anyways this vent is oddly big enough to fit you" +
                        "\n so crawling trough the vent you get back to the office");  // Update the stats text

                // Show the continue button and hide other buttons
                deathEndButton.setVisible(false);
                hideMoreButtons();
                judgementButton.setVisible(true);
            }
            catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        secondtwoButton.setOnAction(e -> {
            try {
                gameStatus.setText("Being bored out of your mind maybe you'll actually go clean the bathroom." +
                        "\nWho cares about what the note on the SCAM says anyways right? You'll do what you want when you want\n" +
                        "You looked around for anything interesting, not surprisingly finding some graffiti and doodles in some of the walls" +
                        "and covers.\n" +
                        "One catches your attention however:\n" +
                        "“Merry Jurrell is bitch ass mothe-”\n" +
                        "Hmm… maybe I shouldn’t read that. Uh anyways.\n" +
                        "Picked up some cleaning supplies, and wiped off any signs of the graffiti from the restroom. \n" +
                        "[Obtained 1 Madness]\n" +
                        "Leaving, you realize the doors are locked… from the outside. This night couldn’t get any worse-" +
                        "\n You’ll need to get out eventually.\n");
                updateStats();  // Update the stats text

                // Show the continue button and hide other buttons
                fiveButton.setVisible(true);
                sixButton.setVisible(true);
                hideOtherButtons();
                secondtwoButton.setVisible(false);
            }
            catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        judgementButton.setOnAction(e -> {
            try {

                if (madness == 2) {
                    gameStatus.setText("You start going crazy. Crawling under the desk for someone to help. That's what we felt like." +
                            "\n When trying to code and make this game. Sadly this is where your story ends");
                } else {
                    gameStatus.setText("Luckily, you avoided some of the dangers. You lucked out." +
                            "\nContinuing the night will be deadly but I'm sure you poor thing will make it.");

                }
                oneButton.setVisible(false);
                twoButton.setVisible(false);
                threeButton.setVisible(false);
                fourButton.setVisible(false);
                fiveButton.setVisible(false);
                sixButton.setVisible(false);
                secondtwoButton.setVisible(false);
                judgementButton.setVisible(false);
                endingButton.setVisible(true);
            }
            catch (Exception ex) {
                // Print error message if an exception occurs
                System.err.println("Error handling the action: " + ex.getMessage());
            }
        });

        endingButton.setOnAction(e -> {
            primaryStage.close();
        });

        // Action for continueButton to change to next scene
        deathEndButton.setOnAction(e -> primaryStage.close());

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, deathEndButton, secondtwoButton, judgementButton, endingButton);
        layout.setCenter(buttonBox);

        // Scene creation with appropriate size
        scene = new Scene(layout, 1080, 720);
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // Helper method to hide the action buttons
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
    }

    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }



    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}

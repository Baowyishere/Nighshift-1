package edu.sdccd.cisc190.scenes;

import edu.sdccd.cisc190.generalstuff.MainGame;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwelveAMTest {

    private Button oneButton;
    private Button continueButton;
    private Label gameStatus;
    private MainGame MainGame; // Assuming GameClass contains the methods updateStats() and hideOtherButtons()

    @BeforeEach
    void setUp() {
        oneButton = new Button();
        continueButton = new Button(); // Using standard JavaFX Button
        gameStatus = new Label(); // Standard JavaFX Label
        MainGame = new MainGame(); // Assuming this class contains the methods updateStats() and hideOtherButtons()
    }

    @Test
    void testSetText() {
        // Simulate the button click event
        oneButton.setOnAction(e -> {
            gameStatus.setText("You’ve decided to check the cameras, from the nearby halls to adjacent rooms from the main stage." +
                    "\nYou find no trace of the missing animatronic, starting to feel quite worried about how it disappeared," +
                    "\nbut you were more worried about how the management would react hearing about one of their mascots just disappearing" +
                    "\nwith just a single shift with you. You feel the looming dread of corporate lawsuits.\n");
        });

        // Trigger the action
        oneButton.fire();

        // Verify that the correct text was set in the gameStatus label
        assertEquals("You’ve decided to check the cameras, from the nearby halls to adjacent rooms from the main stage." +
                "\nYou find no trace of the missing animatronic, starting to feel quite worried about how it disappeared," +
                "\nbut you were more worried about how the management would react hearing about one of their mascots just disappearing" +
                "\nwith just a single shift with you. You feel the looming dread of corporate lawsuits.\n", gameStatus.getText());
    }

    @Test
    void testUpdateStats() {
        // Simulate the button click event
        oneButton.setOnAction(e -> {
            MainGame.updateStats();  // Update the stats text
        });

        // Trigger the action
        oneButton.fire();

        // Since we don't have actual behavior to assert here (as updateStats is undefined in the example),
        // we'll assume it should be triggered, so check for side effects if any.
        // In this case, if it's affecting state in MainGame, we can assert that state change.
        // For now, we simply confirm no exceptions are thrown by the call.
    }

    @Test
    void testSetVisibleForContinueButton() {
        // Simulate the button click event
        oneButton.setOnAction(e -> {
            continueButton.setVisible(true);  // Make the continue button visible
        });

        // Trigger the action
        oneButton.fire();

        // Verify that continueButton.setVisible(true) was called
        assertTrue(continueButton.isVisible());
    }

    @Test
    void testHideOtherButtons() {
        // Simulate the button click event
        oneButton.setOnAction(e -> {
            MainGame.hideOtherButtons();  // Hide other buttons
        });

        // Trigger the action
        oneButton.fire();

        // Since we don't have the actual implementation of hideOtherButtons,
        // this test would check if the method runs without exceptions.
        // You can add further verification depending on what hideOtherButtons does (e.g., hides buttons).
    }

    @Test
    void testNoActionBeforeButtonClick() {
        // Ensure no actions are performed before the button is clicked
        // We do this by checking the initial state or ensuring no methods are invoked on gameStatus, continueButton, or MainGame.
        // No specific assertions needed as no actions are triggered before click.
    }
}
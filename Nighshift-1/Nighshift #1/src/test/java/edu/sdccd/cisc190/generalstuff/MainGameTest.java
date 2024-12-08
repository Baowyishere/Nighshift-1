package edu.sdccd.cisc190.generalstuff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.;

class MainGameTest {
    private MainGame mainGame;
    private Stage primaryStage;
    private TitleScreen mockTitleScreen;

    @BeforeEach
    void setUp() {
        // Initialize MainGame and mock dependencies
        mainGame = new MainGame();
        primaryStage = mock(Stage.class);
        mockTitleScreen = mock(TitleScreen.class);
    }

    @Test
    void testStart() {
        // Mock the TitleScreen behavior
        when(mockTitleScreen.getScene()).thenReturn(new Scene(mockTitleScreen));

        // Start the main game (this will call the start() method)
        Platform.runLater(() -> {
            mainGame.start(primaryStage);

            // Verify that the primary stage's title is set correctly
            verify(primaryStage).setTitle("NightShift at Seven Guys (UNFINISHED VERSION)");

            // Verify that the primary stage's scene is set to the title screen scene
            verify(primaryStage).setScene(any(Scene.class));

            // Verify that the title screen was used to create the scene
            verify(mockTitleScreen).getScene();
        });

    }

}
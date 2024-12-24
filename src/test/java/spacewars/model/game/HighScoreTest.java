package spacewars.model.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HighScoreTest {
    private static final String TEST_FILE_PATH = System.getProperty("user.home") + "/test_highscores.txt";

    @BeforeEach
    void setUp() {
        // Clean up before each test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveHighScoreCreatesFile() {
        HighScore.saveHighScore(100);

        File file = new File(HighScore.FILE_PATH);
        assertTrue(file.exists(), "High score file should be created");
    }

    @Test
    void testSaveHighScoreWritesCorrectContent() {
        HighScore.saveHighScore(100);

        int highScore = HighScore.loadHighScore();
        assertEquals(100, highScore, "High score should match the saved value");
    }


    @Test
    void testLoadHighScoreReadsCorrectContent() {
        HighScore.saveHighScore(200);

        int loadedHighScore = HighScore.loadHighScore();
        assertEquals(200, loadedHighScore, "Loaded high score should match the saved value");
    }

    @Test
    void testSaveHighScoreOverwritesExistingFile() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);

        int highScore = HighScore.loadHighScore();
        assertEquals(200, highScore, "High score should be overwritten with the new value");
    }

    @Test
    void testFileContentHasSingleLine() throws IOException {
        HighScore.saveHighScore(100);

        File file = new File(HighScore.FILE_PATH);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        assertEquals("100", line, "File content should only have the saved high score");
        assertNull(reader.readLine(), "File should contain only one line");
        reader.close();
    }

}

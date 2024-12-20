package spacewars.model.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

public class HighScoreTest {

    @Mock
    private BufferedWriter writer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveHighScore() throws IOException {
        doNothing().when(writer).write(anyString());
        doNothing().when(writer).newLine();

        HighScore.saveHighScore(100);

        int highScore = HighScore.loadHighScore();
        assertEquals(100, highScore);
    }


    /*@Test
    public void testLoadHighScore() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        List<Integer> highScores = HighScore.loadHighScore();
        assertTrue(highScores.contains(100));
        assertTrue(highScores.contains(200));
        assertTrue(highScores.contains(300));
        assertTrue(highScores.contains(400));
        assertTrue(highScores.contains(500));
    }*/

    /*@Test
    public void testGetHighScore() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        assertEquals(500, HighScore.getHighScore());
    }*/

    /*@Test
    public void testGetHighScoreEmpty() {
        clearHighScores();
        assertEquals(0, HighScore.getHighScore());
    }*/

    /*@Test
    public void testClearHighScores() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        clearHighScores();
        List<Integer> highScores = HighScore.loadHighScore();
        assertTrue(highScores.isEmpty());
    }*/
}

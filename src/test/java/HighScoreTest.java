
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spacewars.model.game.HighScore;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static spacewars.model.game.HighScore.clearHighScores;

public class HighScoreTest {

    @Mock
    private BufferedWriter writer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        clearHighScores();
    }

    @Test
    public void testSaveHighScore() throws IOException {
        doNothing().when(writer).write(anyString());
        doNothing().when(writer).newLine();

        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        List<Integer> highScores = HighScore.loadHighScores();
        assertTrue(highScores.contains(100));
        assertTrue(highScores.contains(200));
        assertTrue(highScores.contains(300));
        assertTrue(highScores.contains(400));
        assertTrue(highScores.contains(500));
    }


    @Test
    public void testLoadHighScores() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        List<Integer> highScores = HighScore.loadHighScores();
        assertTrue(highScores.contains(100));
        assertTrue(highScores.contains(200));
        assertTrue(highScores.contains(300));
        assertTrue(highScores.contains(400));
        assertTrue(highScores.contains(500));
    }

    @Test
    public void testGetHighScore() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        assertEquals(500, HighScore.getHighScore());
    }

    @Test
    public void testGetHighScoreEmpty() {
        clearHighScores();
        assertEquals(0, HighScore.getHighScore());
    }

    @Test
    public void testClearHighScores() {
        HighScore.saveHighScore(100);
        HighScore.saveHighScore(200);
        HighScore.saveHighScore(300);
        HighScore.saveHighScore(400);
        HighScore.saveHighScore(500);

        clearHighScores();
        List<Integer> highScores = HighScore.loadHighScores();
        assertTrue(highScores.isEmpty());
    }
}

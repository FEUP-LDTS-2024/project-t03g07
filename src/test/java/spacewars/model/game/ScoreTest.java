package spacewars.model.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @Test
    public void testInitialScore() {
        Score score = new Score();
        assertEquals("00000", score.getScore());
        assertEquals(0, score.getRawScore());
    }

    @Test
    public void testIncreaseScore() {
        Score score = new Score();
        score.increaseScore(10);
        assertEquals("00010", score.getScore());
        assertEquals(10, score.getRawScore());
    }

    @Test
    public void testIncreaseScoreMultipleTimes() {
        Score score = new Score();
        score.increaseScore(5);
        score.increaseScore(15);
        assertEquals("00020", score.getScore());
        assertEquals(20, score.getRawScore());
    }
}
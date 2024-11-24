package spacewars.model.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest
{
    @Test
    public void testIncreaseScore()
    {
        Score score = new Score();
        score.increaseScore(10);
        assertEquals(10, score.getScore());
    }

    @Test
    public void testResetScore()
    {
        Score score = new Score();
        score.increaseScore(10);
        score.resetScore();
        assertEquals(0, score.getScore());
    }

    @Test
    public void testCheckScoreNotHighScore() {
        Score score = new Score();
        score.increaseScore(5);
        HighScore.saveHighScore(10);
        score.checkScore();
        assertEquals(5, score.getScore());
    }

    @Test
    public void testCheckScoreHighScore() {
        Score score = new Score();
        score.increaseScore(15);
        HighScore.saveHighScore(10);
        score.checkScore();
        assertEquals(15, score.getScore());
    }

}

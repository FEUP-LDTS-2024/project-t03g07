package spacewars.model.game.menu;

import org.junit.jupiter.api.Test;
import spacewars.model.menu.GameOver;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {
    @Test
    public void getFinalScoreMessage() {
        GameOver gameOver = new GameOver("100", false);
        String finalScoreMessage = gameOver.getFinalScoreMessage();

        assertNotNull(finalScoreMessage, "Final score message should not be null");

        assertEquals("Your final score is: 100", finalScoreMessage, "Final score message should be 'Your final score is: 100'");
    }

    @Test
    public void isNewHighScore() {
        GameOver highScoreGameOver = new GameOver("100", true);
        boolean newHighScore = highScoreGameOver.isNewHighScore();
        assertTrue(newHighScore, "New high score should be true");
        
        GameOver noHighScoreGameOver = new GameOver("100", false);
        boolean notHighScore = noHighScoreGameOver.isNewHighScore();
        assertFalse(notHighScore, "New high score should be false");
    }


    @Test
    public void getNewHighScoreMessage() {
        GameOver gameOver = new GameOver("100", true);
        String subtitle = gameOver.getNewHighScoreMessage();

        assertNotNull(subtitle, "Subtitle should not be null");

        assertFalse(subtitle.isEmpty(), "Subtitle should not be empty");

        assertEquals("NEW HIGH SCORE!", subtitle, "Subtitle should be 'Points'");
    }
}

import org.junit.jupiter.api.Test;
import spacewars.model.game.Lives;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LivesTest
{
    @Test
    public void testDecreaseLives()
    {
        Lives lives = new Lives(3);
        lives.decreaseLives();
        assertEquals(2, lives.getLives());
    }

    @Test
    public void testSetLives()
    {
        Lives lives = new Lives(3);
        lives.setLives(5);
        assertEquals(5, lives.getLives());
    }

    @Test
    public void testGetLives()
    {
        Lives lives = new Lives(3);
        assertEquals(3, lives.getLives());
    }
}

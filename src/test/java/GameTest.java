import org.junit.jupiter.api.Test;
import spacewars.model.game.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest
{
    @Test
    public void testGetWidth()
    {
        Game game = new Game(1024, 576);
        assertEquals(1024, game.getWidth());
    }

    @Test
    public void testGetHeight()
    {
        Game game = new Game(1024, 576);
        assertEquals(576, game.getHeight());
    }
}

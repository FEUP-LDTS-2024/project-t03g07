package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.game.Lives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest
{
    @Test
    public void testPlayer()
    {
        Player player = new Player(0, 0);
        assertNotNull(player.getLives());
        assertEquals(3, player.getLives().getLives());
    }

    @Test
    public void testSetLives()
    {
        Player player = new Player(0, 0);
        player.setLives(new Lives(5));
        assertEquals(5, player.getLives().getLives());
    }

    @Test
    public void testUpdate()
    {
        Player player = new Player(0, 0);
        player.update();
    }
}

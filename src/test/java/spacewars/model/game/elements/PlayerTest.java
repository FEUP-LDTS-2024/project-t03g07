package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.game.Game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    @Test
    void testPlayerInitialization() {
        Game game = mock(Game.class);
        Player player = new Player(0, 0, game);

        assertEquals(0, player.getPosition().x());
        assertEquals(0, player.getPosition().y());
        assertEquals(2, player.getSpeed());
        assertEquals(10, player.getPlayerSize());
        assertEquals(game, player.getGame());
        assertNull(player.getBulletPlayer());
        assertEquals(0, player.getLastShootTime());
    }

    @Test
    void testPlayerShoot() {
        Game game = mock(Game.class);
        Player player = new Player(0, 0, game);

        player.shoot();
        assertNotNull(player.getBulletPlayer());
        assertEquals(0, player.getBulletPlayer().getKey().getPosition().x());
        assertEquals(1, player.getBulletPlayer().getKey().getPosition().y());
        assertTrue(player.getBulletPlayer().getValue());
        assertTrue(player.getLastShootTime() > 0);
    }

    @Test
    void testSetSpeed() {
        Game game = mock(Game.class);
        Player player = new Player(0, 0, game);

        player.setSpeed(5);
        assertEquals(5, player.getSpeed());
    }

    @Test
    void testSetBulletPlayerNull() {
        Game game = mock(Game.class);
        Player player = new Player(0, 0, game);
        player.setBulletPlayer(null);
        assertNull(player.getBulletPlayer());
    }
}

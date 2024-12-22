package spacewars.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameBuilderTest {

    private GameBuilder gameBuilder;
    private Game game;

    @BeforeEach
    public void setUp() {
        gameBuilder = new GameBuilder();
        game = new Game(gameBuilder);
    }

    @Test
    public void testCreatePlayer() {
        Player player = gameBuilder.createPlayer(game);
        assertNotNull(player);
        assertEquals(155, player.getPosition().x());
        assertEquals(170, player.getPosition().y());
    }

    @Test
    public void testCreateInvaders1() {
        List<NormalInvader1> invaders1 = gameBuilder.createInvaders1(game);
        assertNotNull(invaders1);
        assertEquals(10, invaders1.size());
        for (int i = 0; i < invaders1.size(); i++) {
            assertEquals(64 + i * 20, invaders1.get(i).getPosition().x());
            assertEquals(110, invaders1.get(i).getPosition().y());
        }
    }

    @Test
    public void testCreateInvaders2() {
        List<NormalInvader2> invaders2 = gameBuilder.createInvaders2(game);
        assertNotNull(invaders2);
        assertEquals(10, invaders2.size());
        for (int i = 0; i < invaders2.size(); i++) {
            assertEquals(64 + i * 20, invaders2.get(i).getPosition().x());
            assertEquals(90, invaders2.get(i).getPosition().y());
        }
    }

    @Test
    public void testCreateInvaders3() {
        List<NormalInvader3> invaders3 = gameBuilder.createInvaders3(game);
        assertNotNull(invaders3);
        assertEquals(10, invaders3.size());
        for (int i = 0; i < invaders3.size(); i++) {
            assertEquals(64 + i * 20, invaders3.get(i).getPosition().x());
            assertEquals(70, invaders3.get(i).getPosition().y());
        }
    }

    @Test
    public void testCreateBossInvader() {
        BossInvader bossInvader = gameBuilder.createBossInvader();
        assertNotNull(bossInvader);
        assertEquals(0, bossInvader.getPosition().x());
        assertEquals(30, bossInvader.getPosition().y());
    }

    @Test
    public void testCreateLives() {
        List<Live> lives = gameBuilder.createLives();
        assertNotNull(lives);
        assertEquals(3, lives.size());
        for (int i = 0; i < lives.size(); i++) {
            assertEquals(273 + i * 15, lives.get(i).getPosition().x());
            assertEquals(5, lives.get(i).getPosition().y());
        }
    }
}
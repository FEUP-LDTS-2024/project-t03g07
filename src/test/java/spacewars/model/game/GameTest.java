package spacewars.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.*;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

class GameTest {

    private Game game;
    private GameBuilder builder;
    private Player player;
    private List<NormalInvader1> invaders1;
    private List<NormalInvader2> invaders2;
    private List<NormalInvader3> invaders3;
    private BossInvader bossInvader;
    private List<Live> lives;
    private BulletInvader1 bulletInvader1;
    private BulletInvader2 bulletInvader2;
    private BulletInvader3 bulletInvader3;
    private BulletBossInvader bossBullet;
    private Score score;
    private int highScore;


    @BeforeEach
    void setUp() {
        this.builder = mock(GameBuilder.class);
        this.player = mock(Player.class);
        this.invaders1 = mock(List.class);
        this.invaders2 = mock(List.class);
        this.invaders3 = mock(List.class);
        this.bossInvader = mock(BossInvader.class);
        this.lives = mock(List.class);
        this.score = mock(Score.class);

        when(builder.createPlayer(any(Game.class))).thenReturn(player);
        when(builder.createInvaders1(any(Game.class))).thenReturn(invaders1);
        when(builder.createInvaders2(any(Game.class))).thenReturn(invaders2);
        when(builder.createInvaders3(any(Game.class))).thenReturn(invaders3);
        when(builder.createBossInvader()).thenReturn(bossInvader);
        when(builder.createLives()).thenReturn(lives);

        this.game = new Game(builder);
        this.highScore = 0;
    }

    @Test
    public void getPlayerTest() {
        Player player = game.getPlayer();
        assertNotNull(player);
        verify(builder).createPlayer(any(Game.class));
    }

    @Test
    public void getInvaders1Test() {
        List<NormalInvader1> invaders1 = game.getInvaders1();
        assertNotNull(invaders1);
        assertNotEquals(Collections.emptyList(), invaders1);
        verify(builder).createInvaders1(any(Game.class));
    }

    @Test
    public void getInvaders2Test() {
        List<NormalInvader2> invaders2 = game.getInvaders2();
        assertNotNull(invaders2);
        assertNotEquals(Collections.emptyList(), invaders2);
        verify(builder).createInvaders2(any(Game.class));
    }

    @Test
    public void getInvaders3Test() {
        List<NormalInvader3> invaders3 = game.getInvaders3();
        assertNotNull(invaders3);
        assertNotEquals(Collections.emptyList(), invaders3);
        verify(builder).createInvaders3(any(Game.class));
    }

    @Test
    public void getBossInvaderTest() {
        BossInvader bossInvader = game.getBossInvader();
        assertNotNull(bossInvader);
        verify(builder).createBossInvader();
    }

    @Test
    public void getLivesTest() {
        List<Live> lives = game.getLives();
        assertNotNull(lives);
        assertNotEquals(Collections.emptyList(), lives);
        verify(builder).createLives();
    }

    @Test
    public void getScoreTest() {
        String score = game.getScore();
        assertNotNull(score);
        assertNotEquals("", score);
    }

    @Test
    public void getRawScoreTest() {
        int score = game.getRawScore();
        assertEquals(0, score);
    }

    @Test
    public void getScoreTextTest() {
        String score = game.getScoreText();
        assertNotNull(score);
        assertNotEquals("", score);
    }

    @Test
    public void getHighScoreTextTest() {
        String highScore = game.getHighScoreText();
        assertNotNull(highScore);
        assertNotEquals("", highScore);
    }
}

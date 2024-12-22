package spacewars.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.game.elements.invaders.normal_invaders.RespawnObserver;
import spacewars.model.Position;
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
import java.util.stream.Stream;

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

    private static final double COLLISION_THRESHOLD = 8.0;


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

    @Test
    public void checkSideBoundariesTest() {
        // Case 1: x1 < 20 and x2 > 300 (both true)
        assertTrue(game.checkSideBoundaries(10, 310));

        // Case 2: x1 < 20 and x2 <= 300 (x1 true, x2 false)
        assertTrue(game.checkSideBoundaries(10, 290));

        // Case 3: x1 >= 20 and x2 > 300 (x1 false, x2 true)
        assertTrue(game.checkSideBoundaries(30, 310));

        // Case 4: x1 >= 20 and x2 <= 300 (both false)
        assertFalse(game.checkSideBoundaries(30, 290));
    }

    @Test
    public void checkSideBoundariesEdgeCasesTest() {
        // Case where x1 == 20 and x2 == 300 (edge boundary, both conditions false)
        assertFalse(game.checkSideBoundaries(20, 300));
    }

    @Test
    public void checkTopBoundaryTest() {
        // Case 1: y < 20 (should return true)
        assertTrue(game.checkTopBoundary(5));

        // Case 2: y == 20 (boundary, should return false)
        assertFalse(game.checkTopBoundary(20));

        // Case 3: y > 20 (should return false)
        assertFalse(game.checkTopBoundary(25));
    }


    @Test
    public void checkCollisionTest() {
        // Case 1: Collision occurs because topLeft.x() < 20
        Position topLeft = new Position(10, 100);
        Position bottomRight = new Position(290, 200);
        assertTrue(game.checkCollision(topLeft, bottomRight));

        // Case 2: Collision occurs because bottomRight.x() > 300
        topLeft = new Position(30, 100);
        bottomRight = new Position(310, 200);
        assertTrue(game.checkCollision(topLeft, bottomRight));

        // Case 3: No collision (x1 >= 20 and x2 <= 300)
        topLeft = new Position(30, 100);
        bottomRight = new Position(290, 200);
        assertFalse(game.checkCollision(topLeft, bottomRight));

        // Case 4: Edge case (x1 == 20 and x2 == 300)
        topLeft = new Position(20, 100);
        bottomRight = new Position(300, 200);
        assertFalse(game.checkCollision(topLeft, bottomRight));
    }

    @Test
    public void collidesLeftTest() {
        // Case 1: Left collision occurs (topLeft.x < 20)
        Position position = new Position(10, 100); // x < 20 triggers collision
        double size = 50;
        assertTrue(game.collidesLeft(position, size));

        // Case 2: No left collision (topLeft.x >= 20)
        position = new Position(30, 100); // x >= 20 means no collision
        assertFalse(game.collidesLeft(position, size));

        // Case 3: Edge case where topLeft.x == 20 (no collision)
        position = new Position(20, 100); // x == 20 is within bounds
        assertFalse(game.collidesLeft(position, size));
    }

    @Test
    public void collidesRightTest() {
        // Case 1: Right collision occurs (bottomRight.x > 300)
        Position position = new Position(260, 100); // x + size - 1 > 300 triggers collision
        double size = 50;
        assertTrue(game.collidesRight(position, size));

        // Case 2: No right collision (bottomRight.x <= 300)
        position = new Position(200, 100); // x + size - 1 <= 300 means no collision
        assertFalse(game.collidesRight(position, size));

        // Case 3: Edge case where bottomRight.x == 300 (no collision)
        position = new Position(251, 100); // x + size - 1 == 300 is within bounds
        assertFalse(game.collidesRight(position, size));
    }

    @Test
    public void isCollisionTest() {
        // Assuming COLLISION_THRESHOLD is accessible (e.g., via a public constant or reflection)
        double threshold = COLLISION_THRESHOLD;

        // Case 1: Collision detected (distance < threshold)
        Position pos1 = new Position(10, 10);
        Position pos2 = new Position(10, 10 + (threshold / 2)); // Distance is less than threshold
        assertTrue(game.isCollision(pos1, pos2));

        // Case 2: No collision (distance > threshold)
        pos1 = new Position(10, 10);
        pos2 = new Position(10, 10 + (threshold * 2)); // Distance is greater than threshold
        assertFalse(game.isCollision(pos1, pos2));

        // Case 3: Edge case (distance == threshold)
        pos1 = new Position(10, 10);
        pos2 = new Position(10, 10 + threshold); // Distance is exactly threshold
        assertFalse(game.isCollision(pos1, pos2)); // Assuming "distance < threshold" excludes equal values
    }

    @Test
    public void decreaseLivesTest() {
        // Mock two Live objects with different x-coordinates
        Live live1 = mock(Live.class);
        Live live2 = mock(Live.class);
        when(live1.getPosition()).thenReturn(new Position(10, 0)); // x = 10
        when(live2.getPosition()).thenReturn(new Position(5, 0));  // x = 5

        // Set up the mocked lives list
        when(lives.isEmpty()).thenReturn(false); // List is not empty
        when(lives.stream()).thenReturn(Stream.of(live1, live2));

        // Call the decreaseLives method
        game.decreaseLives();

        // Verify that the Live object with the smallest x-coordinate was removed
        verify(lives).remove(live2);

        // Case 2: Lives == 0
        when(lives.isEmpty()).thenReturn(true); // Simulate an empty list
        game.decreaseLives();

        // Verify that remove was not called when the list is empty
        verify(lives, times(1)).remove(any()); // Ensure no additional calls are made
    }

    @Test
    public void addObserverTest() {
        // Create a mock observer
        RespawnObserver observer = mock(RespawnObserver.class);

        // Call the addObserver method
        game.addObserver(observer);

        // Verify that the observer was added to the list
        assertTrue(game.getObservers().contains(observer));
    }

    @Test
    public void notifyObserversTest() {
        // Create mock observers
        RespawnObserver observer1 = mock(RespawnObserver.class);
        RespawnObserver observer2 = mock(RespawnObserver.class);

        // Add the observers to the game
        game.addObserver(observer1);
        game.addObserver(observer2);

        // Call the notifyObservers method
        game.notifyObservers();

        // Verify that both observers were notified
        verify(observer1).onRespawn();
        verify(observer2).onRespawn();
    }

    @Test
    public void getObserversTest() {
        List<RespawnObserver> observers = game.getObservers();
        assertNotNull(observers);
        assertEquals(0, observers.size());
    }

}

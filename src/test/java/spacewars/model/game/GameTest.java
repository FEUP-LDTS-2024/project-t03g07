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

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
        this.game = mock(Game.class);
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
        Position position = new Position(10, 100);
        double size = 50;
        assertTrue(game.collidesLeft(position, size));

        // Case 2: No left collision (topLeft.x >= 20)
        position = new Position(30, 100);
        assertFalse(game.collidesLeft(position, size));

        // Case 3: Edge case where topLeft.x == 20 (no collision)
        position = new Position(20, 100);
        assertFalse(game.collidesLeft(position, size));
    }

    @Test
    public void collidesRightTest() {
        // Case 1: Right collision occurs (bottomRight.x > 300)
        Position position = new Position(260, 100);
        double size = 50;
        assertTrue(game.collidesRight(position, size));

        // Case 2: No right collision (bottomRight.x <= 300)
        position = new Position(200, 100);
        assertFalse(game.collidesRight(position, size));

        // Case 3: Edge case where bottomRight.x == 300 (no collision)
        position = new Position(251, 100);
        assertFalse(game.collidesRight(position, size));
    }

    @Test
    public void isCollisionTest() {
        double threshold = COLLISION_THRESHOLD;

        // Case 1: Collision detected (distance < threshold)
        Position pos1 = new Position(10, 10);
        Position pos2 = new Position(10, 10 + (threshold / 2));
        assertTrue(game.isCollision(pos1, pos2));

        // Case 2: No collision (distance > threshold)
        pos1 = new Position(10, 10);
        pos2 = new Position(10, 10 + (threshold * 2));
        assertFalse(game.isCollision(pos1, pos2));

        // Case 3: Edge case (distance == threshold)
        pos1 = new Position(10, 10);
        pos2 = new Position(10, 10 + threshold);
        assertFalse(game.isCollision(pos1, pos2));
    }

    @Test
    public void checkBulletInvader1CollisionsWithCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader1 bullet = mock(BulletInvader1.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(100, 100));

        spyGame.checkBulletInvader1Collisions(bullet);

        verify(spyGame).decreaseLives();
    }

    @Test
    public void checkBulletInvader1CollisionsWithNoCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader1 bullet = mock(BulletInvader1.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(200, 200));

        spyGame.checkBulletInvader1Collisions(bullet);

        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void checkBulletInvader1CollisionsWithNullBullet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);
        spyGame.checkBulletInvader1Collisions(null);
        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void checkBulletInvader2CollisionsWithCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader2 bullet = mock(BulletInvader2.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(100, 100));

        spyGame.checkBulletInvader2Collisions(bullet);

        verify(spyGame).decreaseLives();
    }

    @Test
    public void checkBulletInvader2CollisionsWithNoCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader2 bullet = mock(BulletInvader2.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(200, 200));

        spyGame.checkBulletInvader2Collisions(bullet);

        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void checkBulletInvader2CollisionsWithNullBullet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);
        spyGame.checkBulletInvader2Collisions(null);
        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void checkBulletInvader3CollisionsWithCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader3 bullet = mock(BulletInvader3.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(100, 100));

        spyGame.checkBulletInvader3Collisions(bullet);

        verify(spyGame).decreaseLives();
    }

    @Test
    public void checkBulletInvader3CollisionsWithNoCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletInvader3 bullet = mock(BulletInvader3.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(200, 200));

        spyGame.checkBulletInvader3Collisions(bullet);

        verify(spyGame, never()).decreaseLives();  // Ensures decreaseLives wasn't called
    }

    @Test
    public void checkBulletInvader3CollisionsWithNullBullet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);
        spyGame.checkBulletInvader3Collisions(null);
        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void checkBulletBossInvaderCollisionsWithCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletBossInvader bullet = mock(BulletBossInvader.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(100, 100));

        spyGame.checkBulletBossInvaderCollisions(bullet);

        verify(spyGame).decreaseLives();
    }

    @Test
    public void checkBulletBossInvaderCollisionsWithNoCollision() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        BulletBossInvader bullet = mock(BulletBossInvader.class);
        when(bullet.getPosition()).thenReturn(new Position(100, 100));
        when(spyGame.getPlayer().getPosition()).thenReturn(new Position(200, 200));

        spyGame.checkBulletBossInvaderCollisions(bullet);

        verify(spyGame, never()).decreaseLives();  // Ensures decreaseLives wasn't called
    }

    @Test
    public void checkBulletBossInvaderCollisionsWithNullBullet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);
        spyGame.checkBulletBossInvaderCollisions(null);
        verify(spyGame, never()).decreaseLives();
    }

    @Test
    public void invader1Shoot_createsBulletWhenConditionsMet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        // Ensure invaders1 list is initialized and add at least one invader
        NormalInvader1 invader1 = mock(NormalInvader1.class);
        when(invader1.getPosition()).thenReturn(new Position(100, 100));
        spyGame.invaders1 = new ArrayList<>();
        spyGame.invaders1.add(invader1);

        // Mock System.currentTimeMillis to return a specific time for the test
        long currentTime = 1000L;
        doReturn(currentTime).when(spyGame).getCurrentTimeMillis();

        // Call invader1Shoot() when no bullet is present
        spyGame.invader1Shoot();

        // Verify that bulletInvader1 is not null after the call
        assertNotNull(spyGame.getBulletInvader1());

        // Verify that the bullet is created at the right position
        assertEquals(100, spyGame.getBulletInvader1().getPosition().x());
        assertEquals(101, spyGame.getBulletInvader1().getPosition().y());

        // Verify the last shooting time has been updated
        assertTrue(spyGame.lastInvader1ShootTime >= currentTime);
    }

    @Test
    public void invader2Shoot_createsBulletWhenConditionsMet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        // Ensure invaders2 list is initialized and add at least one invader
        NormalInvader2 invader2 = mock(NormalInvader2.class);
        when(invader2.getPosition()).thenReturn(new Position(100, 100));
        spyGame.invaders2 = new ArrayList<>();
        spyGame.invaders2.add(invader2);

        // Mock System.currentTimeMillis to return a specific time for the test
        long currentTime = 1000L;
        doReturn(currentTime).when(spyGame).getCurrentTimeMillis();

        // Call invader2Shoot() when no bullet is present
        spyGame.invader2Shoot();

        // Verify that bulletInvader1 is not null after the call
        assertNotNull(spyGame.getBulletInvader2());

        // Verify that the bullet is created at the right position
        assertEquals(100, spyGame.getBulletInvader2().getPosition().x());
        assertEquals(101, spyGame.getBulletInvader2().getPosition().y());

        // Verify the last shooting time has been updated
        assertTrue(spyGame.lastInvader2ShootTime >= currentTime);
    }

    @Test
    public void invader3Shoot_createsBulletWhenConditionsMet() {
        Game game = new Game(builder);
        Game spyGame = spy(game);

        // Ensure invaders3 list is initialized and add at least one invader
        NormalInvader3 invader3 = mock(NormalInvader3.class);
        when(invader3.getPosition()).thenReturn(new Position(100, 100));
        spyGame.invaders3 = new ArrayList<>();
        spyGame.invaders3.add(invader3);

        // Mock System.currentTimeMillis to return a specific time for the test
        long currentTime = 1000L;
        doReturn(currentTime).when(spyGame).getCurrentTimeMillis();

        // Call invader3Shoot() when no bullet is present
        spyGame.invader3Shoot();

        // Verify that bulletInvader1 is not null after the call
        assertNotNull(spyGame.getBulletInvader3());

        // Verify that the bullet is created at the right position
        assertEquals(100, spyGame.getBulletInvader3().getPosition().x());
        assertEquals(101, spyGame.getBulletInvader3().getPosition().y());

        // Verify the last shooting time has been updated
        assertTrue(spyGame.lastInvader3ShootTime >= currentTime);
    }

    @Test
    public void bossInvaderShoot_createsBulletWhenConditionsMet() {
        Game game = new Game(builder);

        // Create a mock BossInvader
        BossInvader bossInvader = mock(BossInvader.class);
        when(bossInvader.isAlive()).thenReturn(true); // Make sure boss is alive
        when(bossInvader.getPosition()).thenReturn(new Position(100, 100));

        Game spyGame = spy(game);

        // Mock the current time to return a specific time for the test (e.g., 1000)
        long currentTime = 1000L;
        doReturn(currentTime).when(spyGame).getCurrentTimeMillis();

        // Call bossInvaderShoot() when no bullet is present and enough time has passed
        spyGame.bossInvaderShoot(bossInvader);

        // Verify that the bulletBossInvader is not null after the call
        assertNotNull(spyGame.getBulletBossInvader());
        assertEquals(100, spyGame.getBulletBossInvader().getPosition().x());
        assertEquals(101, spyGame.getBulletBossInvader().getPosition().y());

        // Verify that the lastBossShootTime has been updated
        assertTrue(spyGame.lastBossShootTime >= currentTime);
    }

    @Test
    void testUpdateInvader1Bullet_NullBullet() {
        game = mock(Game.class, CALLS_REAL_METHODS);
        bulletInvader1 = mock(BulletInvader1.class);

        // Given
        game.setBulletInvader1(null);

        // When
        game.updateInvader1Bullet();

        // Then
        // Ensure no changes or interactions happen when bullet is null
        assertNull(game.getBulletInvader1());
    }

    @Test
    void testUpdateInvader1Bullet_BulletOnScreen() {
        game = mock(Game.class, CALLS_REAL_METHODS);
        bulletInvader1 = mock(BulletInvader1.class);
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getPosition()).thenReturn(new Position(50, 180)); // Mock player's position
        game.setPlayer(mockPlayer);


        // Given
        when(bulletInvader1.getPosition()).thenReturn(new Position(50, 100));
        game.setBulletInvader1(bulletInvader1);

        // When
        game.updateInvader1Bullet();

        // Then
        // Verify that the bullet was updated
        verify(bulletInvader1, times(1)).update();
        // Verify the bullet is still present
        assertEquals(bulletInvader1, game.getBulletInvader1());
    }

    @Test
    void testUpdateInvader1Bullet_BulletOffScreen() {
        game = mock(Game.class, CALLS_REAL_METHODS);
        bulletInvader1 = mock(BulletInvader1.class);

        // Given
        when(bulletInvader1.getPosition()).thenReturn(new Position(50, 200));
        game.setBulletInvader1(bulletInvader1);

        // When
        game.updateInvader1Bullet();

        // Then
        // Verify the bullet is removed (set to null)
        assertNull(game.getBulletInvader1());
    }

    @Test
    void testUpdateInvader1Bullet_CollisionCheck() {
        game = mock(Game.class, CALLS_REAL_METHODS);
        bulletInvader1 = mock(BulletInvader1.class);
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getPosition()).thenReturn(new Position(50, 180)); // Mock player's position
        game.setPlayer(mockPlayer);


        // Given
        when(bulletInvader1.getPosition()).thenReturn(new Position(50, 100));
        game.setBulletInvader1(bulletInvader1);

        // Spy on the game to verify collision checks
        Game spyGame = spy(game);

        // When
        spyGame.updateInvader1Bullet();

        // Then
        // Verify collision check is performed
        verify(spyGame, times(1)).checkBulletInvader1Collisions(bulletInvader1);
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

        game.decreaseLives();

        verify(lives).remove(live2);

        // Case 2: Lives == 0
        when(lives.isEmpty()).thenReturn(true);
        game.decreaseLives();

        verify(lives, times(1)).remove(any());
    }

    @Test
    public void addObserverTest() {
        RespawnObserver observer = mock(RespawnObserver.class);
        game.addObserver(observer);
        assertTrue(game.getObservers().contains(observer));
    }

    @Test
    public void notifyObserversTest() {
        RespawnObserver observer1 = mock(RespawnObserver.class);
        RespawnObserver observer2 = mock(RespawnObserver.class);

        game.addObserver(observer1);
        game.addObserver(observer2);

        game.notifyObservers();

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

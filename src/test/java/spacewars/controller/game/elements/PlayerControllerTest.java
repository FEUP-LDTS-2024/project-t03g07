package spacewars.controller.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerControllerTest {
    private PlayerController playerController;
    private Player player;
    private Game game;

    @BeforeEach
    public void setUp() {
        player = mock(Player.class);
        game = mock(Game.class);
        when(player.getGame()).thenReturn(game);
        playerController = new PlayerController(player);
    }

    @Test
    public void testMoveLeftBoundary() {
        Position position = new Position(1, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-1.0);
        when(game.collidesLeft(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveLeft();

        verify(player, times(1)).setSpeed(-1.0);
        verify(player, times(1)).setPosition(new Position(0, 5));
    }

    @Test
    public void testMoveRightBoundary() {
        Position position = new Position(9, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(1.0);
        when(game.collidesRight(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveRight();

        verify(player, times(1)).setSpeed(1.0);
        verify(player, times(1)).setPosition(new Position(10, 5));
    }

    @Test
    public void testMoveLeftWithNoCollision() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-1.0);
        when(game.collidesLeft(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveLeft();

        verify(player, times(1)).setSpeed(-1.0);
        verify(player, times(1)).setPosition(new Position(4, 5));
    }

    @Test
    public void testMoveRightWithNoCollision() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(1.0);
        when(game.collidesRight(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveRight();

        verify(player, times(1)).setSpeed(1.0);
        verify(player, times(1)).setPosition(new Position(6, 5));
    }

    @Test
    public void testMoveLeftWithSpeedChange() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-2.0);
        when(game.collidesLeft(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveLeft();

        verify(player, times(1)).setSpeed(-2.0);
        verify(player, times(1)).setPosition(new Position(3, 5));
    }

    @Test
    public void testMoveRightWithSpeedChange() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(2.0);
        when(game.collidesRight(any(Position.class), anyInt())).thenReturn(false);

        playerController.moveRight();

        verify(player, times(1)).setSpeed(2.0);
        verify(player, times(1)).setPosition(new Position(7, 5));
    }

    @Test
    public void testShootWithExactDelay() {
        when(player.getBulletPlayer()).thenReturn(null);
        when(player.getLastShootTime()).thenReturn(System.currentTimeMillis() - 1000);

        playerController.shoot();

        verify(player, times(1)).shoot();
    }

    @Test
    public void testShootWithNegativeDelay() {
        when(player.getBulletPlayer()).thenReturn(null);
        when(player.getLastShootTime()).thenReturn(System.currentTimeMillis() + 1000);

        playerController.shoot();

        verify(player, never()).shoot();
    }

    @Test
    public void testApplyCollisionsLeft() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-3.0);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true, true, false);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(3)).collidesLeft(any(Position.class), anyDouble());
        assertEquals(new Position(4, 5), newPosition);
    }

    @Test
    public void testApplyCollisionsRight() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(3.0);
        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(true, true, false);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(3)).collidesRight(any(Position.class), anyDouble());
        assertEquals(new Position(6, 5), newPosition);
    }

    @Test
    public void testApplyCollisionsWithPositiveSpeed() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(3.0);
        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(false);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(1)).collidesRight(any(Position.class), anyDouble());
        assertEquals(new Position(8, 5), newPosition);
    }

    @Test
    public void testApplyCollisionsWithNegativeSpeed() {
        Position position = new Position(5, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-3.0);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(1)).collidesLeft(any(Position.class), anyDouble());
        assertEquals(new Position(2, 5), newPosition);
    }

    @Test
    public void testApplyCollisionsAtLeftBoundary() {
        Position position = new Position(0, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(-1.0);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(1)).collidesLeft(any(Position.class), anyDouble());
        assertEquals(new Position(0, 5), newPosition); // Position should not change due to collision
    }

    @Test
    public void testApplyCollisionsAtRightBoundary() {
        Position position = new Position(10, 5);
        when(player.getPosition()).thenReturn(position);
        when(player.getSpeed()).thenReturn(1.0);
        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(true);

        Position newPosition = playerController.applyCollisions();

        verify(game, times(1)).collidesRight(any(Position.class), anyDouble());
        assertEquals(new Position(10, 5), newPosition); // Position should not change due to collision
    }
    
}
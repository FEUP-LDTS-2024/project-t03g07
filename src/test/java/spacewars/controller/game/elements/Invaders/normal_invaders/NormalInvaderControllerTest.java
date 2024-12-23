package spacewars.controller.game.elements.Invaders.normal_invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvaderController;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NormalInvaderControllerTest {

    private NormalInvaderController<NormalInvader> controller;
    private List<NormalInvader> invaders;
    private Game game;

    // Concrete subclass for testing
    private static class TestNormalInvaderController extends NormalInvaderController<NormalInvader> {
        private final Game game;

        public TestNormalInvaderController(List<NormalInvader> invaders, Game game) {
            super(invaders);
            this.game = game;
        }

        public boolean testCollides(NormalInvader invader, Position position) {
            return super.collides(invader, position);
        }

        public Game getTestGame() {
            return this.game;
        }
    }

    @BeforeEach
    public void setUp() {
        invaders = new ArrayList<>();
        game = mock(Game.class);
        controller = new TestNormalInvaderController(invaders, game);
    }

    @Test
    public void testConstructor() {
        assertNotNull(controller);
    }

//    @Test
//    public void testMoveInvaders_NoCollision() {
//        NormalInvader invader = mock(NormalInvader.class);
//        when(invader.getPosition()).thenReturn(new Position(100, 50));
//        when(invader.getSpeed()).thenReturn(2.0);
//        invaders.add(invader);
//
//        // Mock the behavior of game collision methods to avoid triggering collision
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
//        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(false);
//
//        controller.moveInvaders();
//
//        // Verify the invader moves to the new position (speed 2.0)
//        verify(invader, times(1)).setPosition(new Position(102.0, 50.0));
//    }
//
//    @Test
//    public void testMoveInvaders_CollisionReversesDirection() {
//        NormalInvader invader = mock(NormalInvader.class);
//        when(invader.getPosition()).thenReturn(new Position(10, 50));
//        when(invader.getSpeed()).thenReturn(2.0);
//        invaders.add(invader);
//
//        // Mock collision
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);
//
//        controller.moveInvaders();
//
//        // Verify direction reversal and no movement
//        assertEquals(0.5, controller.direction, "Direction should reverse to right (0.5)");
//        verify(invader, never()).setPosition(any());
//    }
//
//    @Test
//    public void testMoveInvaders_MovementAfterCollisionResolution() {
//        NormalInvader invader = mock(NormalInvader.class);
//        when(invader.getPosition()).thenReturn(new Position(10, 50));
//        when(invader.getSpeed()).thenReturn(2.0);
//        invaders.add(invader);
//
//        // First move simulates collision
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);
//        controller.moveInvaders();
//        assertEquals(0.5, controller.direction); // Direction reversed after collision
//
//        // Second move with no collision
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
//        controller.moveInvaders();
//        verify(invader, times(1)).setPosition(new Position(12.0, 50.0)); // Moves right with direction 0.5
//    }

    @Test
    public void testCalculateNewPosition() {
        NormalInvader invader = mock(NormalInvader.class);

        // Create a real Position object
        Position position = new Position(10.0, 50.0);

        when(invader.getPosition()).thenReturn(position);
        when(invader.getSpeed()).thenReturn(2.0);

        // Set the controller's direction to positive (right movement)
        controller.direction = 0.5;

        invaders.add(invader);

        Position newPosition = controller.calculateNewPosition(invader);

        assertNotNull(newPosition);
        assertEquals(11.0, newPosition.x());  // Adjusted expected result
        assertEquals(50.0, newPosition.y());  // Y remains unchanged
    }

//    @Test
//    public void testCollides() {
//        Game game = mock(Game.class);
//        NormalInvader invader = mock(NormalInvader.class);
//
//        // Mock methods related to the invader
//        when(invader.getPosition()).thenReturn(new Position(10, 50));
//        when(invader.getGame()).thenReturn(game); // Ensure the invader returns a non-null game
//
//        // Mock the behavior of collision detection
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);
//
//        // Add the invader to the controller's list
//        invaders.add(invader);
//
//        boolean collisionDetected = controller.collides(invader, new Position(10, 50));
//
//        assertTrue(collisionDetected, "Collision should be detected.");
//
//        // Change the mock behavior to simulate no collision
//        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
//        collisionDetected = controller.collides(invader, new Position(10, 50));
//
//        assertFalse(collisionDetected, "Collision should not be detected.");
//    }

    @Test
    public void testCollidesLeft() {
        Game game = mock(Game.class);
        NormalInvader invader = mock(NormalInvader.class);

        when(invader.getPosition()).thenReturn(new Position(10, 50));
        when(invader.getGame()).thenReturn(game);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);

        invaders.add(invader);

        boolean collisionDetected = controller.collides(invader, new Position(10, 50));
        assertTrue(collisionDetected, "Collision on the left should be detected.");

        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
        collisionDetected = controller.collides(invader, new Position(10, 50));
        assertFalse(collisionDetected, "Collision on the left should not be detected.");
    }

    @Test
    public void testNoCollision() {
        Game game = mock(Game.class);
        NormalInvader invader = mock(NormalInvader.class);

        when(invader.getPosition()).thenReturn(new Position(10, 50));
        when(invader.getGame()).thenReturn(game);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(false);

        invaders.add(invader);

        boolean collisionDetected = controller.collides(invader, new Position(10, 50));
        assertFalse(collisionDetected, "No collision should be detected.");
    }

    @Test
    public void testCollidesEdgeCases() {
        Game game = mock(Game.class);
        NormalInvader invader = mock(NormalInvader.class);

        // Test with a position at the boundary
        when(invader.getPosition()).thenReturn(new Position(0, 0));
        when(invader.getGame()).thenReturn(game);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);

        invaders.add(invader);

        boolean collisionDetected = controller.collides(invader, new Position(0, 0));
        assertTrue(collisionDetected, "Collision at boundary should be detected.");
    }


    @Test
    public void testOnRespawn_IncreasesSpeed() {
        NormalInvader invader1 = mock(NormalInvader.class);
        NormalInvader invader2 = mock(NormalInvader.class);

        when(invader1.getSpeed()).thenReturn(1.0);
        when(invader2.getSpeed()).thenReturn(1.5);
        invaders.add(invader1);
        invaders.add(invader2);

        controller.onRespawn();

        // Verify speed increase
        verify(invader1, times(1)).setSpeed(2.0);
        verify(invader2, times(1)).setSpeed(2.5);
    }

    @Test
    public void testOnRespawn_ResetsDirection() {
        controller.direction = 1.0; // Simulate moving right

        controller.onRespawn();

        assertEquals(-0.5, controller.direction, "Direction should reset to left (-0.5)");
    }
}
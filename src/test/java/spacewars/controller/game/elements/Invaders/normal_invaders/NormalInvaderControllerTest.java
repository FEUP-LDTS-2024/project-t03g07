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

    /*@Test
    public void testMoveInvaders_NoCollision() {
        NormalInvader invader = mock(NormalInvader.class);
        when(invader.getPosition()).thenReturn(new Position(100, 50));
        when(invader.getSpeed()).thenReturn(2.0);
        invaders.add(invader);

        // Mock the behavior of game collision methods to avoid triggering collision
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
        when(game.collidesRight(any(Position.class), anyDouble())).thenReturn(false);

        controller.moveInvaders();

        verify(invader, times(1)).setPosition(new Position(99.0, 50.0)); // Moves left with direction -0.5
    }

    @Test
    public void testMoveInvaders_CollisionReversesDirection() {
        NormalInvader invader1 = mock(NormalInvader.class);
        NormalInvader invader2 = mock(NormalInvader.class);

        when(invader1.getPosition()).thenReturn(new Position(10, 50));
        when(invader2.getPosition()).thenReturn(new Position(20, 50));
        when(invader1.getSpeed()).thenReturn(2.0);
        when(invader2.getSpeed()).thenReturn(2.0);
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true); // Simulate collision

        invaders.add(invader1);
        invaders.add(invader2);

        controller.moveInvaders();

        // Verify direction reversal and subsequent movement
        verify(invader1, never()).setPosition(any()); // No movement due to collision
        verify(invader2, never()).setPosition(any());
        assertEquals(0.5, controller.direction, "Direction should reverse to right (0.5)");
    }

    @Test
    public void testMoveInvaders_MovementAfterCollisionResolution() {
        NormalInvader invader = mock(NormalInvader.class);

        when(invader.getPosition()).thenReturn(new Position(10, 50));
        when(invader.getSpeed()).thenReturn(2.0);
        invaders.add(invader);

        // First move simulates collision
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);

        controller.moveInvaders();
        assertEquals(0.5, controller.direction); // Direction reversed after collision

        // Second move with no collision
        when(game.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);

        controller.moveInvaders();
        verify(invader, times(1)).setPosition(new Position(11.0, 50.0)); // Moves right with direction 0.5
    }*/

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

    /*@Test
    public void testCalculateNewPosition() {
        NormalInvader invader = mock(NormalInvader.class);
        Position position = mock(Position.class);
        when(invader.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(10.0);
        when(position.getY()).thenReturn(50.0);
        when(invader.getSpeed()).thenReturn(2.0);
        invaders.add(invader);

        Position newPosition = controller.calculateNewPosition(invader);
        assertNotNull(newPosition);
        assertEquals(9.0, newPosition.getX());
        assertEquals(50.0, newPosition.getY());
    }*/

    /*@Test
    public void testCollides() {
        NormalInvader invader = mock(NormalInvader.class);
        when(invader.getPosition()).thenReturn(new Position(10, 50));
        invaders.add(invader);

        Game testGame = ((TestNormalInvaderController) controller).getTestGame();

        when(testGame.collidesLeft(any(Position.class), anyDouble())).thenReturn(true);
        assertTrue(((TestNormalInvaderController) controller).testCollides(invader, new Position(10, 50)));

        when(testGame.collidesLeft(any(Position.class), anyDouble())).thenReturn(false);
        assertFalse(((TestNormalInvaderController) controller).testCollides(invader, new Position(10, 50)));
    }*/
}
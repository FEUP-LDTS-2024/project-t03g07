package spacewars.controller.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.game.elements.CollisionDetector;
import spacewars.model.Position;
import spacewars.model.game.Game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollisionDetectorTest {
    private Game game;
    private Position position;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        position = new Position(0, 0);
    }

    @Test
    public void testCollisionDetectorInstantiation() {
        CollisionDetector detector = new CollisionDetector();
        assertNotNull(detector);
    }

    @Test
    public void testCollidesLeft() {
        when(game.collidesLeft(position, 10)).thenReturn(true);
        assertTrue(CollisionDetector.collidesLeft(game, position, 10));
        verify(game, times(1)).collidesLeft(position, 10);
    }

    @Test
    public void testDoesNotCollideLeft() {
        when(game.collidesLeft(position, 10)).thenReturn(false);
        assertFalse(CollisionDetector.collidesLeft(game, position, 10));
        verify(game, times(1)).collidesLeft(position, 10);
    }

    @Test
    public void testCollidesRight() {
        when(game.collidesRight(position, 10)).thenReturn(true);
        assertTrue(CollisionDetector.collidesRight(game, position, 10));
        verify(game, times(1)).collidesRight(position, 10);
    }

    @Test
    public void testDoesNotCollideRight() {
        when(game.collidesRight(position, 10)).thenReturn(false);
        assertFalse(CollisionDetector.collidesRight(game, position, 10));
        verify(game, times(1)).collidesRight(position, 10);
    }
}

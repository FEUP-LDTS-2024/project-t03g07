package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.game.elements.bullets.Bullet1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Bullet1Test
{
    @Test
    public void getPosition()
    {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(0);
        when(mockPosition.getY()).thenReturn(0);
        Bullet1 bullet1 = new Bullet1(0, 0);
        bullet1.setPosition(mockPosition);
        assertEquals(0, bullet1.getPosition().getX());
        assertEquals(0, bullet1.getPosition().getY());
    }

    @Test
    public void setPosition()
    {
        Bullet1 bullet1 = new Bullet1(0, 0);
        bullet1.setPosition(new Position(10, 10));
        assertEquals(new Position (10,10), bullet1.getPosition());
    }

    @Test
    public void getSpeed()
    {
        Bullet1 bullet1 = new Bullet1(0, 0);
        assertEquals(10, bullet1.getSpeed());
    }

    @Test
    public void setSpeed()
    {
        Bullet1 bullet1 = new Bullet1(0, 0);
        bullet1.setSpeed(20);
        assertEquals(20, bullet1.getSpeed());
    }
}

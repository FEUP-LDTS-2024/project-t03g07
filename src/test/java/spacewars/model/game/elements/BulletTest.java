package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.game.elements.bullets.BulletNormalInvader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BulletTest
{
    // @Test
    // public void getPosition()
    // {
    //     Position mockPosition = mock(Position.class);
    //     when(mockPosition.getX()).thenReturn(0);
    //     when(mockPosition.getY()).thenReturn(0);
    //     BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(0, 0);
    //     bulletNormalInvader.setPosition(mockPosition);
    //     assertEquals(0, bulletNormalInvader.getPosition().getX());
    //     assertEquals(0, bulletNormalInvader.getPosition().getY());
    // }

    @Test
    public void setPosition()
    {
        BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(0, 0);
        bulletNormalInvader.setPosition(new Position(10, 10));
        assertEquals(new Position (10,10), bulletNormalInvader.getPosition());
    }

    @Test
    public void getSpeed()
    {
        BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(0, 0);
        assertEquals(10, bulletNormalInvader.getSpeed());
    }

    @Test
    public void setSpeed()
    {
        BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(0, 0);
        bulletNormalInvader.setSpeed(20);
        assertEquals(20, bulletNormalInvader.getSpeed());
    }
}

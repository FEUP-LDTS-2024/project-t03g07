package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.NormalInvader1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvaderTest
{
    @Test
    void InvaderPositionTest()
    {
        NormalInvader1 invader = new NormalInvader1(0, 0);
        invader.setPosition(new Position(10, 10));
        assertEquals(new Position (10,10), invader.getPosition());
    }
}

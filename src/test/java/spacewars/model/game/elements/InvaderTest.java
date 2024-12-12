package spacewars.model.game.elements;

import org.junit.jupiter.api.Test;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvaderTest
{
    @Test
    void InvaderPositionTest()
    {
        Invader1 invader = new Invader1(0, 0);
        invader.setPosition(new Position(10, 10));
        assertEquals(new Position (10,10), invader.getPosition());
    }
}

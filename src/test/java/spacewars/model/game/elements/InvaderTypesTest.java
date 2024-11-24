package spacewars.model.game.elements;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.model.game.elements.invaders.NormalInvader1;
import spacewars.model.game.elements.invaders.NormalInvader2;
import spacewars.model.game.elements.invaders.NormalInvader3;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvaderTypesTest
{
    @Property
    void NormalInvader1PositionTest(@ForAll int x, @ForAll int y)
    {
        NormalInvader1 invader1 = new NormalInvader1(x, y);
        assertEquals(x, invader1.getPosition().getX());
        assertEquals(y, invader1.getPosition().getY());
    }

    @Property
    void NormalInvader2PositionTest(@ForAll int x, @ForAll int y)
    {
        NormalInvader2 invader2 = new NormalInvader2(x, y);
        assertEquals(x, invader2.getPosition().getX());
        assertEquals(y, invader2.getPosition().getY());
    }

    @Property
    void NormalInvader3PositionTest(@ForAll int x, @ForAll int y)
    {
        NormalInvader3 invader3 = new NormalInvader3(x, y);
        assertEquals(x, invader3.getPosition().getX());
        assertEquals(y, invader3.getPosition().getY());
    }

    @Property
    void BossInvaderPositionTest(@ForAll int x, @ForAll int y)
    {
        BossInvader bossInvader = new BossInvader(x, y);
        assertEquals(x, bossInvader.getPosition().getX());
        assertEquals(y, bossInvader.getPosition().getY());
    }

}

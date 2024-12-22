package spacewars.model.game.elements.invaders;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BossInvaderTest
{
    @Property
    void BossInvaderPositionTest(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        assertEquals(x, bossInvader.getPosition().x());
        assertEquals(y, bossInvader.getPosition().y());
    }

    @Property
    void testGetPoints(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x,y);
        int points = bossInvader.getPoints();
        assertEquals(points, bossInvader.getPoints());
    }

    @Property
    void testGetSize(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x,y);
        assertEquals(16, bossInvader.getSize());
    }

    @Property
    void testIsAlive(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x,y);
        assertTrue(bossInvader.isAlive());
    }

    @Property
    void testSetAlive(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x,y);
        bossInvader.setAlive(false);
        assertFalse(bossInvader.isAlive());
    }

    @Property
    void testGetRandomPoints(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x,y);
        int points = bossInvader.getRandomPoints();
        assertTrue(points == 75 || points == 100 || points == 250 || points == 500 || points == 999);
    }

}

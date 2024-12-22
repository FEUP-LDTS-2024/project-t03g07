package spacewars.model.game.elements.bullets;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletInvader1Test {

    @Property
    public void testBulletInvader1Initialization(@ForAll double x, @ForAll double y) {
        BulletInvader1 bullet = new BulletInvader1(x, y);
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y, bullet.getPosition().y());
        assertEquals(1, bullet.getSpeed());
    }

    @Property
    public void testBulletPlayerUpdate(@ForAll double x, @ForAll double y) {
        BulletInvader1 bullet = new BulletInvader1(x, y);
        bullet.update();
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y + bullet.getSpeed(), bullet.getPosition().y());
    }
}

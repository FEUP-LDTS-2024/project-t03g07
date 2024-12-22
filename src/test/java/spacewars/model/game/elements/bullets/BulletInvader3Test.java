package spacewars.model.game.elements.bullets;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletInvader3Test {

    @Property
    public void testBulletInvader3Initialization(@ForAll double x, @ForAll double y) {
        BulletInvader3 bullet = new BulletInvader3(x, y);
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y, bullet.getPosition().y());
        assertEquals(1, bullet.getSpeed());
    }

    @Property
    public void testBulletInvader3Update(@ForAll double x, @ForAll double y) {
        BulletInvader3 bullet = new BulletInvader3(x, y);
        bullet.update();
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y + bullet.getSpeed(), bullet.getPosition().y());
    }

}

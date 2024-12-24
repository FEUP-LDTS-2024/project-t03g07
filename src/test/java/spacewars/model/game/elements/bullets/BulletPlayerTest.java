package spacewars.model.game.elements.bullets;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletPlayerTest {

    @Property
    public void testBulletPlayerInitialization(@ForAll double x, @ForAll double y) {
        BulletPlayer bullet = new BulletPlayer(x, y);
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y, bullet.getPosition().y());
        assertEquals(5, bullet.getSpeed());
    }

    @Property
    public void testBulletPlayerUpdate(@ForAll double x, @ForAll double y) {
        BulletPlayer bullet = new BulletPlayer(x, y);
        bullet.update();
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y - bullet.getSpeed(), bullet.getPosition().y());
    }

}

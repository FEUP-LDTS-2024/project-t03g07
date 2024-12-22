package spacewars.model.game.elements.bullets;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletBossInvaderTest {

    @Property
    public void testBulletBossInvaderInitialization(@ForAll double x, @ForAll double y) {
        BulletBossInvader bullet = new BulletBossInvader(x, y);
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y, bullet.getPosition().y());
        assertEquals(2, bullet.getSpeed());
    }

    @Property
    public void testBulletBossInvaderUpdate(@ForAll double x, @ForAll double y) {
        BulletBossInvader bullet = new BulletBossInvader(x, y);
        bullet.update();
        assertEquals(x, bullet.getPosition().x());
        assertEquals(y + bullet.getSpeed(), bullet.getPosition().y());
    }

}

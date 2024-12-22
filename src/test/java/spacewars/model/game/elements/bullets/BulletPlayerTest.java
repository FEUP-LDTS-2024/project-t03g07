package spacewars.model.game.elements.bullets;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletPlayerTest {

    @Test
    public void testBulletPlayerInitialization() {
        BulletPlayer bullet = new BulletPlayer(10, 20);
        assertEquals(10, bullet.getPosition().x());
        assertEquals(20, bullet.getPosition().y());
        assertEquals(5, bullet.getSpeed());
    }

    @Test
    public void testBulletPlayerUpdate() {
        BulletPlayer bullet = new BulletPlayer(10, 20);
        bullet.update();
        assertEquals(10, bullet.getPosition().x());
        assertEquals(15, bullet.getPosition().y());
    }

    @Test
    public void getSpeedTest() {
        BulletPlayer bullet = new BulletPlayer(10, 20);
        assertEquals(5, bullet.getSpeed());
    }

}

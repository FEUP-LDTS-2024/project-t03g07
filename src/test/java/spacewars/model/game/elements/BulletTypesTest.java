package spacewars.model.game.elements;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.game.elements.bullets.Bullet1;
import spacewars.model.game.elements.bullets.Bullet2;
import spacewars.model.game.elements.bullets.Bullet3;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.bullets.BulletBoss;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletTypesTest
{
    @Property
    void Bullet1PositionTest(@ForAll int x, @ForAll int y)
    {
        Bullet1 bullet1 = new Bullet1(x, y);
        assertEquals(x, bullet1.getPosition().getX());
        assertEquals(y, bullet1.getPosition().getY());
    }

    @Property
    void Bullet1SpeedTest(@ForAll int x, @ForAll int y)
    {
        Bullet1 bullet1 = new Bullet1(x, y);
        assertEquals(10, bullet1.getSpeed());
    }

    @Property
    void Bullet2PositionTest(@ForAll int x, @ForAll int y)
    {
        Bullet2 bullet2 = new Bullet2(x, y);
        assertEquals(x, bullet2.getPosition().getX());
        assertEquals(y, bullet2.getPosition().getY());
    }

    @Property
    void Bullet2SpeedTest(@ForAll int x, @ForAll int y)
    {
        Bullet2 bullet2 = new Bullet2(x, y);
        assertEquals(20, bullet2.getSpeed());
    }

    @Property
    void Bullet3PositionTest(@ForAll int x, @ForAll int y)
    {
        Bullet3 bullet3 = new Bullet3(x, y);
        assertEquals(x, bullet3.getPosition().getX());
        assertEquals(y, bullet3.getPosition().getY());
    }

    @Property
    void Bullet3SpeedTest(@ForAll int x, @ForAll int y)
    {
        Bullet3 bullet3 = new Bullet3(x, y);
        assertEquals(30, bullet3.getSpeed());
    }

    @Property
    void BulletPlayerPositionTest(@ForAll int x, @ForAll int y)
    {
        BulletPlayer bulletPlayer = new BulletPlayer(x, y);
        assertEquals(x, bulletPlayer.getPosition().getX());
        assertEquals(y, bulletPlayer.getPosition().getY());
    }

    @Property
    void BulletPlayerSpeedTest(@ForAll int x, @ForAll int y)
    {
        BulletPlayer bulletPlayer = new BulletPlayer(x, y);
        assertEquals(30, bulletPlayer.getSpeed());
    }

    @Property
    void BulletBossPositionTest(@ForAll int x, @ForAll int y)
    {
        BulletBoss bulletBoss = new BulletBoss(x, y);
        assertEquals(x, bulletBoss.getPosition().getX());
        assertEquals(y, bulletBoss.getPosition().getY());
    }

    @Property
    void BulletBossSpeedTest(@ForAll int x, @ForAll int y)
    {
        BulletBoss bulletBoss = new BulletBoss(x, y);
        assertEquals(40, bulletBoss.getSpeed());
    }
}

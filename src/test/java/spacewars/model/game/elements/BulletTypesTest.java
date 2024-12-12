package spacewars.model.game.elements;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.game.elements.bullets.BulletNormalInvader;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.bullets.BulletBossInvader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletTypesTest
{
    @Property
    void Bullet1PositionTest(@ForAll int x, @ForAll int y)
    {
        BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(x, y);
        assertEquals(x, bulletNormalInvader.getPosition().getX());
        assertEquals(y, bulletNormalInvader.getPosition().getY());
    }

    @Property
    void Bullet1SpeedTest(@ForAll int x, @ForAll int y)
    {
        BulletNormalInvader bulletNormalInvader = new BulletNormalInvader(x, y);
        assertEquals(10, bulletNormalInvader.getSpeed());
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
        BulletBossInvader bulletBossInvader = new BulletBossInvader(x, y);
        assertEquals(x, bulletBossInvader.getPosition().getX());
        assertEquals(y, bulletBossInvader.getPosition().getY());
    }

    @Property
    void BulletBossSpeedTest(@ForAll int x, @ForAll int y)
    {
        BulletBossInvader bulletBossInvader = new BulletBossInvader(x, y);
        assertEquals(40, bulletBossInvader.getSpeed());
    }
}

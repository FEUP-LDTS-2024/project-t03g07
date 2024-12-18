package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletNormalInvader;

import java.util.Map.Entry;

import static java.util.Map.entry;

public class Invader1 extends Invader {
    private int speed;
    private Entry<BulletNormalInvader, Boolean> invader1Bullet;
    private int invader1Size;
    private Game game;
    private long lastShootTime;

    public Invader1(int x, int y, Game game)
    {
        super(x, y);
        this.invader1Size = 16;
        this.game = game;
        this.invader1Bullet = null;
        this.lastShootTime = 0;
    }

    @Override
    public int getPoints()
    {
        return 10;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInvader1Size() {
        return invader1Size;
    }

    public Game getGame() {
        return game;
    }

    public void shoot() {
        BulletNormalInvader bullet = new BulletNormalInvader(this.getPosition().getX(), this.getPosition().getY() + 1);
        invader1Bullet = entry(bullet, true);
        lastShootTime = System.currentTimeMillis();
    }

    public long getLastShootTime() {
        return lastShootTime;
    }

    public Entry<BulletNormalInvader, Boolean> getInvader1Bullet() {
        return invader1Bullet;
    }
}

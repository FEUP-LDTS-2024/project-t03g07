package spacewars.model.game.elements;

import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;

import java.util.Map.Entry;

import static java.util.Map.entry;

public class Player extends Element {
    private double speed;
    private final int playerSize;
    private final Game game;
    private Entry<BulletPlayer, Boolean> playerBullet;
    private long lastShootTime;

    public Player(double x, double y, Game game) {
        super(x, y);
        this.speed = 2;
        this.playerSize = 10;
        this.game = game;
        this.playerBullet = null;
        this.lastShootTime = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void shoot() {
        BulletPlayer bullet = new BulletPlayer(this.getPosition().x(), this.getPosition().y() + 1);
        playerBullet = entry(bullet, true);
        lastShootTime = System.currentTimeMillis();
    }

    public int getPlayerSize() {
        return playerSize;
    }

    public Game getGame() {
        return game;
    }

    public Entry<BulletPlayer, Boolean> getBulletPlayer() {
        return playerBullet;
    }

    public void setBulletPlayer(Entry<BulletPlayer, Boolean> playerBullet) {
        this.playerBullet = playerBullet;
    }

    public long getLastShootTime() {
        return lastShootTime;
    }
}

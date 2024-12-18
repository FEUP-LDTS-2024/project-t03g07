package spacewars.model.game.elements;

import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;

import java.util.Map.Entry;

import static java.util.Map.entry;

public class Player extends Element {
    private int speed;
    private final int playerSize;
    private final Game game;
    private Entry<BulletPlayer, Boolean> playerBullet;
    private long lastShootTime;

    public Player(int x, int y, Game game) {
        super(x, y);
        this.speed = 2;
        this.playerSize = 10;
        this.game = game;
        this.playerBullet = null;
        this.lastShootTime = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void decreaseLives() {
    }

    public void shoot() {
        BulletPlayer bullet = new BulletPlayer(this.getPosition().getX(), this.getPosition().getY() + 1);
        playerBullet = entry(bullet, true);
        lastShootTime = System.currentTimeMillis();
    }

    @Override
    public void update() {
    }

    public int getPlayerSize() {
        return playerSize;
    }

    public Game getGame() {
        return game;
    }

    public Entry<BulletPlayer, Boolean> getBulletsPlayer() {
        return playerBullet;
    }

    public void setBulletsPlayer(Entry<BulletPlayer, Boolean> playerBullet) {
        this.playerBullet = playerBullet;
    }

    public long getLastShootTime() {
        return lastShootTime;
    }
}

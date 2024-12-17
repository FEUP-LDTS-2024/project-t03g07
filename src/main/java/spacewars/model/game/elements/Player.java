package spacewars.model.game.elements;

import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;

import java.util.ArrayList;
import java.util.List;

public class Player extends Element {
    private int speed;
    private final int playerSize;
    private Game game;
    private List<BulletPlayer> bulletsPlayer;
    private int bulletCount;
    private long lastShootTime;

    public Player(int x, int y, Game game) {
        super(x, y);
        this.speed = 2;
        this.playerSize = 10;
        this.game = game;
        this.bulletsPlayer = new ArrayList<>();
        this.bulletCount = 0;
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

    public BulletPlayer shoot() {
        BulletPlayer bullet = new BulletPlayer(this.getPosition().getX(), this.getPosition().getY() + 1);
        bulletsPlayer.add(bullet); // Add bullet to the list
        bulletCount++;
        lastShootTime = System.currentTimeMillis();
        return bullet;
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

    public List<BulletPlayer> getBulletsPlayer() {
        return bulletsPlayer;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public void resetBulletCount() {
        this.bulletCount = 0;
    }

    public long getLastShootTime() {
        return lastShootTime;
    }
}

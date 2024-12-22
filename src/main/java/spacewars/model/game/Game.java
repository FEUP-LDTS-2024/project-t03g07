package spacewars.model.game;

import spacewars.controller.game.elements.invaders.normal_invaders.RespawnObserver;
import spacewars.model.Position;
import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.*;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;
import spacewars.model.game.elements.invaders.BossInvader;

import java.util.*;

public class Game {
    private final GameBuilder builder;

    private final Player player;
    private final List<NormalInvader1> invaders1;
    private final List<NormalInvader2> invaders2;
    private final List<NormalInvader3> invaders3;
    private final BossInvader bossInvader;
    private BulletInvader1 bulletInvader1;
    private BulletInvader2 bulletInvader2;
    private BulletInvader3 bulletInvader3;
    private BulletBossInvader bossBullet;
    private long lastInvader1ShootTime = 0;
    private long lastInvader2ShootTime = 0;
    private long lastInvader3ShootTime = 0;
    private long lastBossShootTime = 0;
    private final int highScore;

    private final List<RespawnObserver> observers = new ArrayList<>();

    private final Score score;

    private final List<Live> lives;

    private static final double COLLISION_THRESHOLD = 8.0;

    public Game(GameBuilder builder) {
        this.builder = builder;
        this.player = builder.createPlayer(this);
        this.invaders1 = builder.createInvaders1(this);
        this.invaders2 = builder.createInvaders2(this);
        this.invaders3 = builder.createInvaders3(this);
        this.bossInvader = builder.createBossInvader();
        this.lives = builder.createLives();

        this.score = new Score();
        this.highScore = HighScore.loadHighScore();
    }

    public Player getPlayer() {
        return player;
    }

    public List<NormalInvader1> getInvaders1() {
        return invaders1;
    }

    public List<NormalInvader2> getInvaders2() {
        return invaders2;
    }

    public List<NormalInvader3> getInvaders3() {
        return invaders3;
    }

    public BossInvader getBossInvader() {
        return bossInvader;
    }

    public BulletInvader1 getBulletInvader1() {
        return bulletInvader1;
    }

    public BulletInvader2 getBulletInvader2() {
        return bulletInvader2;
    }

    public BulletInvader3 getBulletInvader3() {
        return bulletInvader3;
    }

    public BulletBossInvader getBulletBossInvader() {
        return bossBullet;
    }

    public String getScore() {
        return score.getScore();
    }

    public int getRawScore() {
        return score.getRawScore();
    }

    public String getScoreText() {
        return "Score: " + score.getScore();
    }

    public String getHighScoreText() {
        return "High Score: " + highScore;
    }

    public List<Live> getLives() {
        return lives;
    }


    public void updatePlayerBullet() {
        if (player.getBulletPlayer() != null) {
            player.getBulletPlayer().getKey().update();
            checkBulletCollisions(player.getBulletPlayer().getKey());
        }
    }

    public boolean checkSideBoundaries(double x1, double x2) {
        return x1 < 20 || x2 > 300;
    }

    public boolean checkTopBoundary(double y) {
        return y < 20;
    }

    public boolean checkCollision(Position topLeft, Position bottomRight) {
        return checkSideBoundaries(topLeft.x(), bottomRight.x());
    }

    public boolean collidesLeft(Position position, double size) {
        return checkCollision(position, new Position(position.x() + 1, position.y() + size - 1));
    }

    public boolean collidesRight(Position position, double size) {
        return checkCollision(new Position(position.x() + size - 1, position.y()), new Position(position.x() + size - 1, position.y() + size - 1));
    }

    public boolean isCollision(Position pos1, Position pos2) {
        double distance = Math.sqrt(Math.pow(pos1.x() - pos2.x(), 2) + Math.pow(pos1.y() - pos2.y(), 2));
        return distance < COLLISION_THRESHOLD;
    }

    public void checkBulletCollisions(BulletPlayer bullet) {
        List<NormalInvader1> invaders1ToRemove = new ArrayList<>();
        List<NormalInvader2> invaders2ToRemove = new ArrayList<>();
        List<NormalInvader3> invaders3ToRemove = new ArrayList<>();

        for (NormalInvader1 invader : invaders1) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletPlayer(null);
                invaders1ToRemove.add(invader);
                score.increaseScore(invader.getPoints());
                break;
            }
        }
        for (NormalInvader2 invader : invaders2) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletPlayer(null);
                invaders2ToRemove.add(invader);
                score.increaseScore(invader.getPoints());
                break;
            }
        }
        for (NormalInvader3 invader : invaders3) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletPlayer(null);
                invaders3ToRemove.add(invader);
                score.increaseScore(invader.getPoints());
                break;
            }
        }

        if (bossInvader != null) {
            if (isCollision(bossInvader.getPosition(), bullet.getPosition())) {
                player.setBulletPlayer(null);
                score.increaseScore(bossInvader.getRandomPoints());
                bossInvader.setAlive(false);
            }
        }

        if (checkTopBoundary(bullet.getPosition().y())) {
            player.setBulletPlayer(null);
        }

        invaders1.removeAll(invaders1ToRemove);
        invaders2.removeAll(invaders2ToRemove);
        invaders3.removeAll(invaders3ToRemove);
    }

    public void checkBulletInvader1Collisions(BulletInvader1 bullet) {
        if (bullet == null) {
            return;
        }

        if (isCollision(player.getPosition(), bullet.getPosition())) {
            decreaseLives();
            bulletInvader1 = null;
        }
    }

    public void checkBulletInvader2Collisions(BulletInvader2 bullet) {
        if (bullet == null) {
            return;
        }
        if (isCollision(player.getPosition(), bullet.getPosition())) {
            decreaseLives();
            bulletInvader2 = null;
        }
    }

    public void checkBulletInvader3Collisions(BulletInvader3 bullet) {
        if (bullet == null) {
            return;
        }

        if (isCollision(player.getPosition(), bullet.getPosition())) {
            decreaseLives();
            bulletInvader3 = null;
        }
    }

    public void checkBulletBossInvaderCollisions(BulletBossInvader bullet) {
        if (bullet == null) {
            return;
        }

        if (isCollision(player.getPosition(), bullet.getPosition())) {
            decreaseLives();
            bossBullet = null;
        }
    }

    public void invader1Shoot() {
        if (bulletInvader1 == null && System.currentTimeMillis() - lastInvader1ShootTime > 2000) { // Shoot every 2 seconds
            List<NormalInvader1> activeInvaders = new ArrayList<>();

            // Collect all active invaders
            for (NormalInvader1 invader : invaders1) {
                if (invader != null) {
                    activeInvaders.add(invader);
                }
            }

            // Choose a random invader to shoot
            if (!activeInvaders.isEmpty()) {
                NormalInvader1 randomInvader = activeInvaders.get(new Random().nextInt(activeInvaders.size()));
                bulletInvader1 = new BulletInvader1(randomInvader.getPosition().x(), randomInvader.getPosition().y() + 1);
                lastInvader1ShootTime = System.currentTimeMillis();
            }
        }
    }

    public void updateInvader1Bullet() {
        if (bulletInvader1 != null) {
            bulletInvader1.update();

            // Remove the bullet if it moves off the screen
            if (bulletInvader1.getPosition().y() > 192) {
                bulletInvader1 = null;
            }
            checkBulletInvader1Collisions(bulletInvader1);
        }
    }

    public void invader2Shoot() {
        if (bulletInvader2 == null && System.currentTimeMillis() - lastInvader2ShootTime > 2000) { // Shoot every 2 seconds
            List<NormalInvader2> activeInvaders = new ArrayList<>();

            // Collect all active invaders
            for (NormalInvader2 invader : invaders2) {
                if (invader != null) {
                    activeInvaders.add(invader);
                }
            }

            // Choose a random invader to shoot
            if (!activeInvaders.isEmpty()) {
                NormalInvader2 randomInvader = activeInvaders.get(new Random().nextInt(activeInvaders.size()));
                bulletInvader2 = new BulletInvader2(randomInvader.getPosition().x(), randomInvader.getPosition().y() + 1);
                lastInvader2ShootTime = System.currentTimeMillis();
            }
        }
    }

    public void updateInvader2Bullet() {
        if (bulletInvader2 != null) {
            bulletInvader2.update();

            // Remove the bullet if it moves off the screen
            if (bulletInvader2.getPosition().y() > 192) {
                bulletInvader2 = null;
            }
            checkBulletInvader2Collisions(bulletInvader2);
        }
    }

    public void invader3Shoot() {
        if (bulletInvader3 == null && System.currentTimeMillis() - lastInvader3ShootTime > 2000) { // Shoot every 2 seconds
            List<NormalInvader3> activeInvaders = new ArrayList<>();

            // Collect all active invaders
            for (NormalInvader3 invader : invaders3) {
                if (invader != null) {
                    activeInvaders.add(invader);
                }
            }

            // Choose a random invader to shoot
            if (!activeInvaders.isEmpty()) {
                NormalInvader3 randomInvader = activeInvaders.get(new Random().nextInt(activeInvaders.size()));
                bulletInvader3 = new BulletInvader3(randomInvader.getPosition().x(), randomInvader.getPosition().y() + 1);
                lastInvader3ShootTime = System.currentTimeMillis();
            }
        }
    }

    public void updateInvader3Bullet() {
        if (bulletInvader3 != null) {
            bulletInvader3.update();

            // Remove the bullet if it moves off the screen
            if (bulletInvader3.getPosition().y() > 192) {
                bulletInvader3 = null;
            }
            checkBulletInvader3Collisions(bulletInvader3);
        }
    }

    public void bossInvaderShoot(BossInvader bossInvader) {
        // Ensure boss is not hidden and enough time has passed since the last shot
        if (bossInvader.isAlive() && bossBullet == null && System.currentTimeMillis() - lastBossShootTime > 5000) { // Boss shoots every 3 seconds
            bossBullet = new BulletBossInvader(bossInvader.getPosition().x(), bossInvader.getPosition().y() + 1); // Bullet starts below the boss
            lastBossShootTime = System.currentTimeMillis();
        }
    }

    public void updateBossInvaderBullet() {
        if (bossBullet != null) {
            bossBullet.update(); // Move the bullet

            // Remove the bullet if it moves off the screen
            if (bossBullet.getPosition().y() > 192) {
                bossBullet = null;
            }
            checkBulletBossInvaderCollisions(bossBullet);
        }
    }

    public void updateInvaderBullets() {
        invader1Shoot();
        updateInvader1Bullet();
        invader2Shoot();
        updateInvader2Bullet();
        invader3Shoot();
        updateInvader3Bullet();

        if (bossInvader.isAlive()) {
            bossInvaderShoot(bossInvader);
            updateBossInvaderBullet();
        }
    }

    public void decreaseLives() {
        if (!lives.isEmpty()) {
            // Find the Live object with the lowest x-coordinate
            Live leftmostLive = lives.stream()
                    .min(Comparator.comparingDouble(live -> live.getPosition().x()))
                    .orElse(null);

            // Remove the leftmost Live
            lives.remove(leftmostLive);
        }
    }

    public void respawnInvaders() {
        if (getInvaders1().isEmpty() && getInvaders2().isEmpty() && getInvaders3().isEmpty()) {
            getInvaders1().addAll(builder.createInvaders1(this));
            getInvaders2().addAll(builder.createInvaders2(this));
            getInvaders3().addAll(builder.createInvaders3(this));
            notifyObservers();
        }
    }

    public void addObserver(RespawnObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (RespawnObserver observer : observers) {
            observer.onRespawn();
        }
    }

    public List<RespawnObserver> getObservers() {
        return observers;
    }
}

package spacewars.model.game;

import spacewars.model.Position;
import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.BulletBossInvader;
import spacewars.model.game.elements.bullets.BulletNormalInvader;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.invaders.Invader1;
import spacewars.model.game.elements.invaders.Invader2;
import spacewars.model.game.elements.invaders.Invader3;
import spacewars.model.game.elements.invaders.BossInvader;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private final Player player;
    private final List<Invader1> invaders1;
    private final List<Invader2> invaders2;
    private final List<Invader3> invaders3;
    private BossInvader bossInvader;
    private BulletNormalInvader bulletNormalInvader;
    private BulletBossInvader bulletBossInvader;
    private Score score;
    private Timer bossRespawnTimer;

    private final List<Live> lives;

    private static final double COLLISION_THRESHOLD = 8.0;

    public Game() {
        this.player = createPlayer();
        this.invaders1 = createInvaders1();
        this.invaders2 = createInvaders2();
        this.invaders3 = createInvaders3();
        this.bossInvader = createBossInvader();
        this.lives = createLives();
        this.score = new Score();
        this.bossRespawnTimer = new Timer();
    }

    private Player createPlayer() {
        return new Player(155, 170, this);
    }

    public List<Invader1> createInvaders1() {
        List<Invader1> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader1(64 + i * 20, 110, this));
        }
        return list;
    }

    public List<Invader2> createInvaders2() {
        List<Invader2> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader2(64 + i * 20, 90,this));
        }
        return list;
    }

    public List<Invader3> createInvaders3() {
        List<Invader3> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader3(64 + i * 20, 70,this));
        }
        return list;
    }

    public BossInvader createBossInvader() {
        return new BossInvader(0,30,this);
    }

    public List<Live> createLives() {
        List<Live> list = new ArrayList<>(List.of());
        for (int i = 0; i < 3; i++) {
            list.add(new Live(273 + i * 15, 5, i));
        }
        return list;
    }

    public void updatePlayerBullet() {
        if (player.getBulletsPlayer() != null) {
            player.getBulletsPlayer().getKey().update();
            checkBulletCollisions(player.getBulletsPlayer().getKey());
        }
    }

    public void setBulletNormalInvader(BulletNormalInvader bulletNormalInvader) {
        this.bulletNormalInvader = bulletNormalInvader;
    }

    public void setBulletBossInvader(BulletBossInvader bulletBossInvader) {
        this.bulletBossInvader = bulletBossInvader;
    }


    public Player getPlayer() {
        return player;
    }

    public List<Invader1> getInvaders1() {
        return invaders1;
    }

    public List<Invader2> getInvaders2() {
        return invaders2;
    }

    public List<Invader3> getInvaders3() {
        return invaders3;
    }

    public BossInvader getBossInvader() {
        return bossInvader;
    }

    public BulletNormalInvader getBulletNormalInvader() {
        return bulletNormalInvader;
    }

    public BulletBossInvader getBulletBossInvader() {
        return bulletBossInvader;
    }

    public String getScoreText() {
        return "Score: " + score.getScore();
    }

    public List<Live> getLives() {
        return lives;
    }

    public boolean checkSideBoundaries(double x1, double x2) {
        return x1 < 20 || x2 > 300;
    }

    public boolean checkTopBoundary(double y) {
        return y < 20;
    }

    private boolean checkCollision(Position topLeft, Position bottomRight) {
        return checkSideBoundaries(topLeft.getX(), bottomRight.getX());
    }

    public boolean collidesLeft(Position position, double size) {
        return checkCollision(position, new Position(position.getX() + 1, position.getY() + size - 1));
    }

    public boolean collidesRight(Position position, double size) {
        return checkCollision(new Position(position.getX() + size - 1, position.getY()), new Position(position.getX() + size - 1, position.getY() + size - 1));
    }

    private boolean isCollision(Position pos1, Position pos2) {
        double distance = Math.sqrt(Math.pow(pos1.getX() - pos2.getX(), 2) + Math.pow(pos1.getY() - pos2.getY(), 2));
        return distance < COLLISION_THRESHOLD;
    }

    public void checkBulletCollisions(BulletPlayer bullet) {
        List<Invader1> invaders1ToRemove = new ArrayList<>();
        List<Invader2> invaders2ToRemove = new ArrayList<>();
        List<Invader3> invaders3ToRemove = new ArrayList<>();

        for (Invader1 invader : invaders1) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletsPlayer(null);
                invaders1ToRemove.add(invader);
                score.increaseScore(10);
                break;
            }
        }
        for (Invader2 invader : invaders2) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletsPlayer(null);
                invaders2ToRemove.add(invader);
                score.increaseScore(20);
                break;
            }
        }
        for (Invader3 invader : invaders3) {
            if (isCollision(invader.getPosition(), bullet.getPosition())) {
                player.setBulletsPlayer(null);
                invaders3ToRemove.add(invader);
                score.increaseScore(40);
                break;
            }
        }

        if (isCollision(bossInvader.getPosition(), bullet.getPosition())) {
            player.setBulletsPlayer(null);
            bossInvader = new BossInvader(0,30,this);
            score.increaseScore(bossInvader.getRandomPoints());
            bossInvader.setHidden(true);
        }

        if (checkTopBoundary(bullet.getPosition().getY())) {
            player.setBulletsPlayer(null);
        }

        invaders1.removeAll(invaders1ToRemove);
        invaders2.removeAll(invaders2ToRemove);
        invaders3.removeAll(invaders3ToRemove);
    }

    public boolean isBullet(Position position) {
        return bulletNormalInvader.getPosition().equals(position);
    }


}

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

public class Game {
    private final Player player;
    private final List<Invader1> invaders1;
    private final List<Invader2> invaders2;
    private final List<Invader3> invaders3;
    private BossInvader bossInvader;

    private List<BulletPlayer> bulletsPlayer;
    private BulletNormalInvader bulletNormalInvader;
    private BulletBossInvader bulletBossInvader;

    private final String ScoreText = "Score: ";

    private final List<Live> lives;

    public Game() {
        this.player = createPlayer();
        this.invaders1 = createInvaders1();
        this.invaders2 = createInvaders2();
        this.invaders3 = createInvaders3();
        this.lives = createLives();
    }
    
    private Player createPlayer() {
        return new Player(155, 170, this);
    }

    public List<Invader1> createInvaders1() {
        List<Invader1> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader1(64 + i * 20, 110));
        }
        return list;
    }

    public List<Invader2> createInvaders2() {
        List<Invader2> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader2(64 + i * 20, 90));
        }
        return list;
    }
    
    public List<Invader3> createInvaders3() {
        List<Invader3> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader3(64 + i * 20, 70));
        }
        return list;
    }

    public List<Live> createLives() {
        List<Live> list = new ArrayList<>(List.of());
        for (int i = 0; i < 3; i++) {
            list.add(new Live(273 + i * 15, 0, i));
        }
        return list;
    }

    public void setBossInvader(BossInvader bossInvader) {
        this.bossInvader = bossInvader;
    }

    public void addPlayerBullet(BulletPlayer bullet) {
        bulletsPlayer.add(bullet);
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

    public List<BulletPlayer> getBulletPlayer() {
        return bulletsPlayer;
    }

    public BulletNormalInvader getBulletNormalInvader() {
        return bulletNormalInvader;
    }

    public BulletBossInvader getBulletBossInvader() {
        return bulletBossInvader;
    }

    public String getScoreText() {
        return ScoreText;
    }

    public List<Live> getLives() {
        return lives;
    }

    public boolean checkOutsideBoundaries(int x1, int x2) {
        return x1 < 0 || x2 > 320;
    }

    private boolean checkCollision(Position topLeft, Position bottomRight) {
        return checkOutsideBoundaries(topLeft.getX(), bottomRight.getX());
    }

    public boolean collidesLeft(Position position, int size) {
        return checkCollision(position, new Position(position.getX() + 1, position.getY() + size - 1));
    }

    public boolean collidesRight(Position position, int size) {
        return checkCollision(new Position(position.getX() + size - 1, position.getY()), new Position(position.getX() + size - 1, position.getY() + size - 1));
    }

    public boolean isBullet(Position position) {
        return bulletNormalInvader.getPosition().equals(position);
    }
}

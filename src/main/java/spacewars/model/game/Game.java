package spacewars.model.game;

import spacewars.model.Position;
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
    // private final List<Invader1> invaders1;
    private List<Invader2> invaders2;
    private List<Invader3> invaders3;
    private BossInvader bossInvader;

    private List<BulletPlayer> bulletsPlayer;
    private BulletNormalInvader bulletNormalInvader;
    private BulletBossInvader bulletBossInvader;

    public Game() {
        this.player = createPlayer();
        // this.invaders1 = createInvaders1();
    }
    
    private Player createPlayer() {
        return new Player(155, 170);
    }

    /*public List<Invader1> createInvaders1() {
        List<Invader1> list = new ArrayList<>(List.of());
        for (int i = 0; i < 10; i++) {
            assert invaders1 != null;
            list.add(new Invader1(10 + i * 20, 10));
        }
        return list;
    }*/

    public void setInvaders2(List<Invader2> invaders2) {
        this.invaders2 = invaders2;
    }
    
    public void setInvaders3(List<Invader3> invaders3) {
        this.invaders3 = invaders3;
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



    public boolean isBullet(Position position) {
        if (bulletNormalInvader.getPosition().equals(position))
            return true;
        return false;
    }
}

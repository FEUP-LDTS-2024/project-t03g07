package spacewars.model.game;

import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.bullets.BulletBossInvader;
import spacewars.model.game.elements.bullets.BulletNormalInvader;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.invaders.Invader1;
import spacewars.model.game.elements.invaders.Invader2;
import spacewars.model.game.elements.invaders.Invader3;
import spacewars.model.game.elements.invaders.BossInvader;

import java.util.List;

public class Game {

    private Player player;
    private List<Invader1> invaders1;
    private List<Invader2> invaders2;
    private List<Invader3> invaders3;
    private  BossInvader bossInvader;

    private BulletPlayer bulletPlayer;
    private BulletNormalInvader bulletNormalInvader;
    private BulletBossInvader bulletBossInvader;

    public Game() {}
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setInvaders1(List<Invader1> invaders1) {
        this.invaders1 = invaders1;
    }

    public void setInvaders2(List<Invader2> invaders2) {
        this.invaders2 = invaders2;
    }
    
    public void setInvaders3(List<Invader3> invaders3) {
        this.invaders3 = invaders3;
    }

    public void setBossInvader(BossInvader bossInvader) {
        this.bossInvader = bossInvader;
    }

    public void setBulletPlayer(BulletPlayer bulletPlayer) {
        this.bulletPlayer = bulletPlayer;
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

    public BulletPlayer getBulletPlayer() {
        return bulletPlayer;
    }

    public BulletNormalInvader getBulletNormalInvader() {
        return bulletNormalInvader;
    }

    public BulletBossInvader getBulletBossInvader() {
        return bulletBossInvader;
    }
}

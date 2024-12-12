package spacewars.view.game;

import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.BulletBossInvaderViewer;
import spacewars.view.game.elements.bullets.BulletNormalInvaderViewer;
import spacewars.view.game.elements.bullets.BulletPlayerViewer;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.game.elements.invaders.Invader1Viewer;
import spacewars.view.game.elements.invaders.Invader2Viewer;
import spacewars.view.game.elements.invaders.Invader3Viewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class ViewerProvider {
    private final PlayerViewer playerViewer;

    private final Invader1Viewer invader1Viewer;
    private final Invader2Viewer invader2Viewer;
    private final Invader3Viewer invader3Viewer;
    private final BossInvaderViewer bossInvaderViewer;

    private final BulletPlayerViewer bulletPlayerViewer;
    private final BulletNormalInvaderViewer bulletNormalInvaderViewer;
    private final BulletBossInvaderViewer bulletBossInvaderViewer;


    public ViewerProvider(ImageLoader imageLoader) throws IOException {
        this.playerViewer = new PlayerViewer(imageLoader);

        this.invader1Viewer = new Invader1Viewer(imageLoader);
        this.invader2Viewer = new Invader2Viewer(imageLoader);
        this.invader3Viewer = new Invader3Viewer(imageLoader);
        this.bossInvaderViewer = new BossInvaderViewer(imageLoader);

        this.bulletPlayerViewer = new BulletPlayerViewer(imageLoader);
        this.bulletNormalInvaderViewer = new BulletNormalInvaderViewer(imageLoader);
        this.bulletBossInvaderViewer = new BulletBossInvaderViewer(imageLoader);
    }



    public PlayerViewer getPlayerViewer() {
        return playerViewer;
    }

    public Invader1Viewer getInvader1Viewer() {
        return invader1Viewer;
    }

    public Invader2Viewer getInvader2Viewer() {
        return invader2Viewer;
    }

    public Invader3Viewer getInvader3Viewer() {
        return invader3Viewer;
    }

    public BossInvaderViewer getBossInvaderViewer() {
        return bossInvaderViewer;
    }

    public BulletPlayerViewer getBulletPlayerViewer() {
        return bulletPlayerViewer;
    }

    public BulletNormalInvaderViewer getBulletNormalInvaderViewer() {
        return bulletNormalInvaderViewer;
    }

    public BulletBossInvaderViewer getBulletBossInvaderViewer() {
        return bulletBossInvaderViewer;
    }
}

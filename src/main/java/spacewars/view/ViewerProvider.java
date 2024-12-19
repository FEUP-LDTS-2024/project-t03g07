package spacewars.view;

import spacewars.view.game.elements.LiveViewer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.BulletBossInvaderViewer;
import spacewars.view.game.elements.bullets.BulletInvader1Viewer;
import spacewars.view.game.elements.bullets.BulletPlayerViewer;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.game.elements.invaders.Invader1Viewer;
import spacewars.view.game.elements.invaders.Invader2Viewer;
import spacewars.view.game.elements.invaders.Invader3Viewer;
import spacewars.view.images.ImageLoader;
import spacewars.view.menus.EntryViewer;
import spacewars.view.menus.how_to_play.*;
import spacewars.view.menus.main_menu.LogoViewer;
import spacewars.view.texts.AppTextViewer;
import spacewars.view.texts.TextViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ViewerProvider {
    private final PlayerViewer playerViewer;

    private final Invader1Viewer invader1Viewer;
    private final Invader2Viewer invader2Viewer;
    private final Invader3Viewer invader3Viewer;
    private final BossInvaderViewer bossInvaderViewer;

    private final BulletPlayerViewer bulletPlayerViewer;
    private final BulletInvader1Viewer bulletNormalInvaderViewer;
    private final BulletBossInvaderViewer bulletBossInvaderViewer;

    private final TextViewer textViewer;
    private final EntryViewer entryViewer;
    private final LogoViewer logoViewer;

    private final ArrowsViewer arrowsViewer;
    private final SpacebarViewer spacebarViewer;

    private final EmpireFighterViewer empireFighterViewer;
    private final TIEExecutorViewer tieExecutorViewer;
    private final StarDestroyerViewer starDestroyerViewer;
    private final DeathStarViewer deathStarViewer;
    private final LiveViewer liveViewer;


    public ViewerProvider(ImageLoader imageLoader) throws IOException, FontFormatException, URISyntaxException {
        this.playerViewer = new PlayerViewer(imageLoader);

        this.invader1Viewer = new Invader1Viewer(imageLoader);
        this.invader2Viewer = new Invader2Viewer(imageLoader);
        this.invader3Viewer = new Invader3Viewer(imageLoader);
        this.bossInvaderViewer = new BossInvaderViewer(imageLoader);

        this.bulletPlayerViewer = new BulletPlayerViewer(imageLoader);
        this.bulletNormalInvaderViewer = new BulletInvader1Viewer(imageLoader);
        this.bulletBossInvaderViewer = new BulletBossInvaderViewer(imageLoader);

        this.textViewer = new AppTextViewer();
        this.entryViewer = new EntryViewer(textViewer);
        this.logoViewer = new LogoViewer(imageLoader);

        this.arrowsViewer = new ArrowsViewer(imageLoader);
        this.spacebarViewer = new SpacebarViewer(imageLoader);

        this.empireFighterViewer = new EmpireFighterViewer(imageLoader);
        this.tieExecutorViewer = new TIEExecutorViewer(imageLoader);
        this.starDestroyerViewer = new StarDestroyerViewer(imageLoader);
        this.deathStarViewer = new DeathStarViewer(imageLoader);
        this.liveViewer = new LiveViewer(imageLoader);
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

    public BulletInvader1Viewer getBulletNormalInvaderViewer() {
        return bulletNormalInvaderViewer;
    }

    public BulletBossInvaderViewer getBulletBossInvaderViewer() {
        return bulletBossInvaderViewer;
    }

    public EntryViewer getEntryViewer() {
        return entryViewer;
    }

    public LogoViewer getLogoViewer() {
        return logoViewer;
    }

    public TextViewer getTextViewer() {
        return textViewer;
    }

    public EmpireFighterViewer getEmpireFighterViewer() {
        return empireFighterViewer;
    }

    public ArrowsViewer getArrowsViewer() {
        return arrowsViewer;
    }

    public SpacebarViewer getSpacebarViewer() {
        return spacebarViewer;
    }

    public TIEExecutorViewer getTIEExecutorViewer() {
        return tieExecutorViewer;
    }

    public StarDestroyerViewer getStarDestroyerViewer() {
        return starDestroyerViewer;
    }

    public DeathStarViewer getDeathStarViewer() {
        return deathStarViewer;
    }

    public LiveViewer getLiveViewer() {
        return liveViewer;
    }
}

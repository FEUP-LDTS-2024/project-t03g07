package spacewars.view;

import spacewars.view.game.elements.LiveViewer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.*;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader1Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader2Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader3Viewer;
import spacewars.view.images.ImageLoader;
import spacewars.view.menus.EntryViewer;
import spacewars.view.menus.GameOverImageViewer;
import spacewars.view.menus.how_to_play.*;
import spacewars.view.menus.how_to_play.spaceships.DeathStarViewer;
import spacewars.view.menus.how_to_play.spaceships.EmpireFighterViewer;
import spacewars.view.menus.how_to_play.spaceships.StarDestroyerViewer;
import spacewars.view.menus.how_to_play.spaceships.TIEExecutorViewer;
import spacewars.view.menus.main_menu.LogoViewer;
import spacewars.view.texts.AppTextViewer;
import spacewars.view.texts.TextViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ViewerProvider {
    private final PlayerViewer playerViewer;

    private final NormalInvader1Viewer normalInvader1Viewer;
    private final NormalInvader2Viewer normalInvader2Viewer;
    private final NormalInvader3Viewer normalInvader3Viewer;
    private final BossInvaderViewer bossInvaderViewer;

    private final BulletPlayerViewer bulletPlayerViewer;
    private final BulletInvader1Viewer bulletInvader1Viewer;
    private final BulletInvader2Viewer bulletInvader2Viewer;
    private final BulletInvader3Viewer bulletInvader3Viewer;
    private final BulletBossInvaderViewer bulletBossInvaderViewer;

    private final LiveViewer liveViewer;

    private final TextViewer textViewer;
    private final EntryViewer entryViewer;

    private final LogoViewer logoViewer;
    private final GameOverImageViewer gameOverImageViewer;

    private final ArrowsViewer arrowsViewer;
    private final SpacebarViewer spacebarViewer;

    private final EmpireFighterViewer empireFighterViewer;
    private final TIEExecutorViewer tieExecutorViewer;
    private final StarDestroyerViewer starDestroyerViewer;
    private final DeathStarViewer deathStarViewer;


    public ViewerProvider(ImageLoader imageLoader) throws IOException, FontFormatException, URISyntaxException {
        this.playerViewer = new PlayerViewer(imageLoader);

        this.normalInvader1Viewer = new NormalInvader1Viewer(imageLoader);
        this.normalInvader2Viewer = new NormalInvader2Viewer(imageLoader);
        this.normalInvader3Viewer = new NormalInvader3Viewer(imageLoader);
        this.bossInvaderViewer = new BossInvaderViewer(imageLoader);

        this.bulletPlayerViewer = new BulletPlayerViewer(imageLoader);
        this.bulletInvader1Viewer = new BulletInvader1Viewer(imageLoader);
        this.bulletInvader2Viewer = new BulletInvader2Viewer(imageLoader);
        this.bulletInvader3Viewer = new BulletInvader3Viewer(imageLoader);
        this.bulletBossInvaderViewer = new BulletBossInvaderViewer(imageLoader);

        this.liveViewer = new LiveViewer(imageLoader);

        this.textViewer = new AppTextViewer();
        this.entryViewer = new EntryViewer(textViewer);

        this.logoViewer = new LogoViewer(imageLoader);
        this.gameOverImageViewer = new GameOverImageViewer(imageLoader);

        this.arrowsViewer = new ArrowsViewer(imageLoader);
        this.spacebarViewer = new SpacebarViewer(imageLoader);

        this.empireFighterViewer = new EmpireFighterViewer(imageLoader);
        this.tieExecutorViewer = new TIEExecutorViewer(imageLoader);
        this.starDestroyerViewer = new StarDestroyerViewer(imageLoader);
        this.deathStarViewer = new DeathStarViewer(imageLoader);
    }

    public PlayerViewer getPlayerViewer() {
        return playerViewer;
    }


    public NormalInvader1Viewer getInvader1Viewer() {
        return normalInvader1Viewer;
    }

    public NormalInvader2Viewer getInvader2Viewer() {
        return normalInvader2Viewer;
    }

    public NormalInvader3Viewer getInvader3Viewer() {
        return normalInvader3Viewer;
    }

    public BossInvaderViewer getBossInvaderViewer() {
        return bossInvaderViewer;
    }


    public BulletPlayerViewer getBulletPlayerViewer() {
        return bulletPlayerViewer;
    }

    public BulletInvader1Viewer getBulletInvader1Viewer() {
        return bulletInvader1Viewer;
    }

    public BulletInvader2Viewer getBulletInvader2Viewer() {
        return bulletInvader2Viewer;
    }

    public BulletInvader3Viewer getBulletInvader3Viewer() {
        return bulletInvader3Viewer;
    }

    public BulletBossInvaderViewer getBulletBossInvaderViewer() {
        return bulletBossInvaderViewer;
    }


    public LiveViewer getLiveViewer() {
        return liveViewer;
    }


    public TextViewer getTextViewer() {
        return textViewer;
    }

    public EntryViewer getEntryViewer() {
        return entryViewer;
    }


    public LogoViewer getLogoViewer() {
        return logoViewer;
    }

    public GameOverImageViewer getGameOverImageViewer() {
        return gameOverImageViewer;
    }


    public ArrowsViewer getArrowsViewer() {
        return arrowsViewer;
    }

    public SpacebarViewer getSpacebarViewer() {
        return spacebarViewer;
    }


    public EmpireFighterViewer getEmpireFighterViewer() {
        return empireFighterViewer;
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

}

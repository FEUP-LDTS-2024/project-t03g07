package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Element;
import spacewars.view.ViewerProvider;
import spacewars.view.game.elements.ElementViewer;
import spacewars.view.game.elements.LiveViewer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.BulletBossInvaderViewer;
import spacewars.view.game.elements.bullets.BulletNormalInvaderViewer;
import spacewars.view.game.elements.bullets.BulletPlayerViewer;
import spacewars.view.game.elements.invaders.Invader1Viewer;
import spacewars.view.game.elements.invaders.Invader2Viewer;
import spacewars.view.game.elements.invaders.Invader3Viewer;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends ScreenViewer<Game> {
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);

    private final PlayerViewer playerViewer;
    private final Invader1Viewer invader1Viewer;
    private final Invader2Viewer invader2Viewer;
    private final Invader3Viewer invader3Viewer;
    /*private final BossInvaderViewer bossInvaderViewer;
    private final BulletPlayerViewer bulletPlayerViewer;
    private final BulletNormalInvaderViewer bulletNormalInvaderViewer;
    private final BulletBossInvaderViewer bulletBossInvaderViewer;*/

    private final TextViewer textViewer;
    private final LiveViewer liveViewer;

    public GameViewer(Game model, ViewerProvider viewerProvider) {
        super(model);

        this.playerViewer = viewerProvider.getPlayerViewer();
        this.invader1Viewer = viewerProvider.getInvader1Viewer();
        this.invader2Viewer = viewerProvider.getInvader2Viewer();
        this.invader3Viewer = viewerProvider.getInvader3Viewer();
        /*this.bossInvaderViewer = viewerProvider.getBossInvaderViewer();
        this.bulletPlayerViewer = viewerProvider.getBulletPlayerViewer();
        this.bulletNormalInvaderViewer = viewerProvider.getBulletNormalInvaderViewer();
        this.bulletBossInvaderViewer = viewerProvider.getBulletBossInvaderViewer();*/
        this.textViewer = viewerProvider.getTextViewer();
        this.liveViewer = viewerProvider.getLiveViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui,backgroundColor);

        drawElement(gui,getModel().getPlayer(),playerViewer);

        drawElements(gui,getModel().getInvaders1(),invader1Viewer);
        drawElements(gui,getModel().getInvaders2(),invader2Viewer);
        drawElements(gui,getModel().getInvaders3(),invader3Viewer);

        drawText(gui, getModel().getScoreText(), 5, 5, TextColor.ANSI.WHITE);

        drawElements(gui, getModel().getLives(), liveViewer);

        /*drawElement(gui,getModel().getBossInvader(),bossInvaderViewer);

        drawElements(gui, getModel().getBulletPlayer(), bulletPlayerViewer);
        drawElement(gui,getModel().getBulletNormalInvader(), bulletNormalInvaderViewer);
        drawElement(gui, getModel().getBulletBossInvader(), bulletBossInvaderViewer);*/

        gui.refresh();
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private void drawText(GUI gui, String text, int x, int y, TextColor color) {
        textViewer.draw(text, x, y, color, gui);
    }
}

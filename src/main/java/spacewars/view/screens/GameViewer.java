package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Element;
import spacewars.view.ViewerProvider;
import spacewars.view.game.elements.ElementViewer;
import spacewars.view.game.elements.LiveViewer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.*;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader1Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader2Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader3Viewer;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends ScreenViewer<Game> {

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

    private final TextViewer textViewer;
    private final LiveViewer liveViewer;

    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue


    public GameViewer(Game model, ViewerProvider viewerProvider) {
        super(model);

        this.playerViewer = viewerProvider.getPlayerViewer();

        this.normalInvader1Viewer = viewerProvider.getInvader1Viewer();
        this.normalInvader2Viewer = viewerProvider.getInvader2Viewer();
        this.normalInvader3Viewer = viewerProvider.getInvader3Viewer();
        this.bossInvaderViewer = viewerProvider.getBossInvaderViewer();

        this.bulletPlayerViewer = viewerProvider.getBulletPlayerViewer();
        this.bulletInvader1Viewer = viewerProvider.getBulletInvader1Viewer();
        this.bulletInvader2Viewer = viewerProvider.getBulletInvader2Viewer();
        this.bulletInvader3Viewer = viewerProvider.getBulletInvader3Viewer();
        this.bulletBossInvaderViewer = viewerProvider.getBulletBossInvaderViewer();

        this.textViewer = viewerProvider.getTextViewer();
        this.liveViewer = viewerProvider.getLiveViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui, backgroundColor);

        drawElement(gui, getModel().getPlayer(), playerViewer);

        drawElements(gui, getModel().getInvaders1(), normalInvader1Viewer);
        drawElements(gui, getModel().getInvaders2(), normalInvader2Viewer);
        drawElements(gui, getModel().getInvaders3(), normalInvader3Viewer);
        drawElement(gui, getModel().getBossInvader(), bossInvaderViewer);

        drawText(gui, getModel().getScoreText(), 5);
        drawText(gui, getModel().getHighScoreText(), 15);

        drawElements(gui, getModel().getLives(), liveViewer);

        if (getModel().getPlayer().getBulletPlayer() != null)
            drawElement(gui, getModel().getPlayer().getBulletPlayer().getKey(), bulletPlayerViewer);

        if (getModel().getBulletInvader1() != null)
            drawElement(gui, getModel().getBulletInvader1(), bulletInvader1Viewer);

        if (getModel().getBulletInvader2() != null)
            drawElement(gui, getModel().getBulletInvader2(), bulletInvader2Viewer);

        if (getModel().getBulletInvader3() != null)
            drawElement(gui, getModel().getBulletInvader3(), bulletInvader3Viewer);

        if (getModel().getBulletBossInvader() != null)
            drawElement(gui, getModel().getBulletBossInvader(), bulletBossInvaderViewer);

        gui.refresh();
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private void drawText(GUI gui, String text, int y) {
        textViewer.draw(text, 5, y, TextColor.ANSI.WHITE, gui);
    }
}

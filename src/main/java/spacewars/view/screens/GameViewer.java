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
import spacewars.view.game.elements.invaders.Invader1Viewer;
import spacewars.view.game.elements.invaders.Invader2Viewer;
import spacewars.view.game.elements.invaders.Invader3Viewer;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends ScreenViewer<Game> {

    private final PlayerViewer playerViewer;

    private final Invader1Viewer invader1Viewer;
    private final Invader2Viewer invader2Viewer;
    private final Invader3Viewer invader3Viewer;
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

        this.invader1Viewer = viewerProvider.getInvader1Viewer();
        this.invader2Viewer = viewerProvider.getInvader2Viewer();
        this.invader3Viewer = viewerProvider.getInvader3Viewer();
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

        drawElements(gui, getModel().getInvaders1(), invader1Viewer);
        drawElements(gui, getModel().getInvaders2(), invader2Viewer);
        drawElements(gui, getModel().getInvaders3(), invader3Viewer);
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

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
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

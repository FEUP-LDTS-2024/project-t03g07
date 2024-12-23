package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Element;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.view.ViewerProvider;
import spacewars.view.game.elements.ElementViewer;
import spacewars.view.game.elements.LiveViewer;
import spacewars.view.game.elements.PlayerViewer;
import spacewars.view.game.elements.bullets.*;
import spacewars.view.game.elements.invaders.BossInvaderViewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader1Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader2Viewer;
import spacewars.view.game.elements.invaders.normal_invaders.NormalInvader3Viewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private GUI gui;
    private Game game;
    private GameViewer gameViewer;
    private TextViewer textViewer;
    private Element element;
    private ElementViewer<Element> elementViewer;
    PlayerViewer playerViewer;
    NormalInvader1Viewer normalInvader1Viewer;
    NormalInvader2Viewer normalInvader2Viewer;
    NormalInvader3Viewer normalInvader3Viewer;
    BossInvaderViewer bossInvaderViewer;
    LiveViewer liveViewer;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
        game = mock(Game.class);
        ViewerProvider viewerProvider = mock(ViewerProvider.class);
        playerViewer = mock(PlayerViewer.class);
        normalInvader1Viewer = mock(NormalInvader1Viewer.class);
        normalInvader2Viewer = mock(NormalInvader2Viewer.class);
        normalInvader3Viewer = mock(NormalInvader3Viewer.class);
        bossInvaderViewer = mock(BossInvaderViewer.class);
        BulletPlayerViewer bulletPlayerViewer = mock(BulletPlayerViewer.class);
        BulletInvader1Viewer bulletInvader1Viewer = mock(BulletInvader1Viewer.class);
        BulletInvader2Viewer bulletInvader2Viewer = mock(BulletInvader2Viewer.class);
        BulletInvader3Viewer bulletInvader3Viewer = mock(BulletInvader3Viewer.class);
        BulletBossInvaderViewer bulletBossInvaderViewer = mock(BulletBossInvaderViewer.class);
        liveViewer = mock(LiveViewer.class);
        textViewer = mock(TextViewer.class);
        element = mock(Element.class);
        elementViewer = mock(ElementViewer.class);

        when(gui.getScreen()).thenReturn(mock(com.googlecode.lanterna.screen.Screen.class));
        com.googlecode.lanterna.graphics.TextGraphics textGraphics = mock(com.googlecode.lanterna.graphics.TextGraphics.class);
        when(gui.getScreen().newTextGraphics()).thenReturn(textGraphics);
        when(viewerProvider.getPlayerViewer()).thenReturn(playerViewer);
        when(viewerProvider.getInvader1Viewer()).thenReturn(normalInvader1Viewer);
        when(viewerProvider.getInvader2Viewer()).thenReturn(normalInvader2Viewer);
        when(viewerProvider.getInvader3Viewer()).thenReturn(normalInvader3Viewer);
        when(viewerProvider.getBossInvaderViewer()).thenReturn(bossInvaderViewer);
        when(viewerProvider.getBulletPlayerViewer()).thenReturn(bulletPlayerViewer);
        when(viewerProvider.getBulletInvader1Viewer()).thenReturn(bulletInvader1Viewer);
        when(viewerProvider.getBulletInvader2Viewer()).thenReturn(bulletInvader2Viewer);
        when(viewerProvider.getBulletInvader3Viewer()).thenReturn(bulletInvader3Viewer);
        when(viewerProvider.getBulletBossInvaderViewer()).thenReturn(bulletBossInvaderViewer);
        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
        when(viewerProvider.getLiveViewer()).thenReturn(liveViewer);

        gameViewer = new GameViewer(game, viewerProvider);
    }

    @Test
    public void testDraw() throws IOException {
        when(game.getPlayer()).thenReturn(mock(Player.class));
        when(game.getInvaders1()).thenReturn(Collections.emptyList());
        when(game.getInvaders2()).thenReturn(Collections.emptyList());
        when(game.getInvaders3()).thenReturn(Collections.emptyList());
        when(game.getBossInvader()).thenReturn(mock(BossInvader.class));
        when(game.getScoreText()).thenReturn("Score: 0");
        when(game.getHighScoreText()).thenReturn("High Score: 0");
        when(game.getLives()).thenReturn(Collections.emptyList());

        GameViewer spyGameViewer = spy(gameViewer);
        spyGameViewer.draw(gui);

        verify(gui).clear();
        verify(gui).refresh();
        verify(textViewer).draw(eq("Score: 0"), eq(5.0d), eq(5.0d), eq(TextColor.ANSI.WHITE), eq(gui));
        verify(textViewer).draw(eq("High Score: 0"), eq(5.0d), eq(15.0d), eq(TextColor.ANSI.WHITE), eq(gui));
        verify(spyGameViewer).drawBackground(eq(gui), eq(GameViewer.backgroundColor));
        verify(spyGameViewer).drawElement(eq(gui), any(Player.class), eq(playerViewer));
        verify(spyGameViewer).drawElements(eq(gui), anyList(), eq(normalInvader1Viewer));
        verify(spyGameViewer).drawElements(eq(gui), anyList(), eq(normalInvader2Viewer));
        verify(spyGameViewer).drawElements(eq(gui), anyList(), eq(normalInvader3Viewer));
        verify(spyGameViewer).drawElement(eq(gui), any(BossInvader.class), eq(bossInvaderViewer));
        verify(spyGameViewer).drawElements(eq(gui), anyList(), eq(liveViewer));
    }

    @Test
    public void testDrawElement() {
        gameViewer.drawElement(gui, element, elementViewer);

        verify(elementViewer).draw(eq(element), eq(gui));
    }

    @Test
    public void testDrawElements() {
        List<Element> elements = List.of(mock(Element.class), mock(Element.class));
        gameViewer.drawElements(gui, elements, elementViewer);

        for (Element element : elements) {
            verify(elementViewer).draw(eq(element), eq(gui));
        }
    }

    @Test
    public void testDrawText() {
        String text = "Test Text";
        int y = 10;

        gameViewer.drawText(gui, text, y);

        verify(textViewer).draw(eq(text), eq(5.0d), eq((double) y), eq(TextColor.ANSI.WHITE), eq(gui));
    }
}
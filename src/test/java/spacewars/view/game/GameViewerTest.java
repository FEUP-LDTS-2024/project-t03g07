package spacewars.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import spacewars.gui.LanternaGUI;
import spacewars.view.screens.GameViewer;

public class GameViewerTest {
    private LanternaGUI frame;
    private TextGraphics textGraphics;
    private GameViewer gameViewer;
    private TerminalSize terminalSize;
    private TerminalScreen screen;

    /*@BeforeEach
    public void setup() {
        frame = mock(LanternaGUI.class);
        screen = mock(TerminalScreen.class);
        textGraphics = mock(TextGraphics.class);
        terminalSize = mock(TerminalSize.class);

        when(frame.getScreen()).thenReturn(screen);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        when(screen.getTerminalSize()).thenReturn(terminalSize);
        when(terminalSize.getColumns()).thenReturn(80);
        when(terminalSize.getRows()).thenReturn(24);

        gameViewer = new GameViewer(frame);
    }

    @Test
    public void testDraw() {
        //gameViewer.draw();

        verify(textGraphics).setBackgroundColor(new TextColor.RGB(0, 10, 32));
        verify(textGraphics, times(1)).fill(' ');

        int numberOfStars = (80 * 24) / 300;
        verify(textGraphics, times(numberOfStars)).setForegroundColor(TextColor.ANSI.WHITE);
        for (int i = 0; i < numberOfStars; i++) {
            int x = (i * 7) % 80;
            int y = (i * 5) % 24;
            verify(textGraphics).setCharacter(x, y, '·');
        }
    }*/
}
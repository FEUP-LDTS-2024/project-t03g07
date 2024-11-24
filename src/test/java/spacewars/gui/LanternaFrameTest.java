package spacewars.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeTry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LanternaFrameTest {
    private TextGraphics graphics;
    private TerminalScreen screen;
    private AWTTerminalFrame terminal;

    @BeforeTry
    @BeforeEach
    public void setup() {
        this.graphics = mock(TextGraphics.class);
        this.screen = mock(TerminalScreen.class);
        this.terminal = mock(AWTTerminalFrame.class);
    }

    @Test
    public void getScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getScreen Test", graphics, screen, terminal);

        lanternaFrame.getScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getTerminal() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getTerminal Test", graphics, screen, terminal);

        lanternaFrame.getTerminal();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void startScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("startScreen Test", graphics, screen, terminal);

        lanternaFrame.startScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void stopScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("stopScreen Test", graphics, screen, terminal);

        lanternaFrame.stopScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getWIDTH() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getWIDTH Test", graphics, screen, terminal);

        lanternaFrame.getWIDTH();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getHEIGHT() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getHEIGHT Test", graphics, screen, terminal);

        lanternaFrame.getHEIGHT();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void refresh() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("refresh Test", graphics, screen, terminal);

        lanternaFrame.refresh();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Property
    public void drawPixel(@ForAll int x, @ForAll int y, @ForAll("color") TextColor.RGB color) {
        LanternaFrame lanternaFrame = new LanternaFrame("drawPixel Test", graphics, screen, terminal);

        lanternaFrame.drawPixel(x, y, color);

        verify(graphics, times(1)).setBackgroundColor(color);
        verify(graphics, times(1)).putString(x, y, " ");
        verifyNoMoreInteractions(graphics);
    }

    @Provide
    public Arbitrary<TextColor.RGB> color() {
        return Combinators.combine(
                Arbitraries.integers().between(0, 255),
                Arbitraries.integers().between(0, 255),
                Arbitraries.integers().between(0, 255)
        ).as(TextColor.RGB::new);
    }
}
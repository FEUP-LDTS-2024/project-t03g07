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

public class LanternaGUITest {
    private TextGraphics graphics;
    private TerminalScreen screen;
    private AWTTerminalFrame terminal;

    /*@BeforeTry
    @BeforeEach
    public void setup() {
        this.graphics = mock(TextGraphics.class);
        this.screen = mock(TerminalScreen.class);
        this.terminal = mock(AWTTerminalFrame.class);
    }

    @Test
    public void getScreen() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("getScreen Test", graphics, screen, terminal);

        lanternaGUI.getScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getTerminal() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("getTerminal Test", graphics, screen, terminal);

        lanternaGUI.getTerminal();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void startScreen() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("startScreen Test", graphics, screen, terminal);

        lanternaGUI.startScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void stopScreen() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("stopScreen Test", graphics, screen, terminal);

        lanternaGUI.stopScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getWIDTH() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("getWIDTH Test", graphics, screen, terminal);

        lanternaGUI.getWIDTH();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getHEIGHT() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("getHEIGHT Test", graphics, screen, terminal);

        lanternaGUI.getHEIGHT();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void refresh() throws IOException {
        LanternaGUI lanternaGUI = new LanternaGUI("refresh Test", graphics, screen, terminal);

        lanternaGUI.refresh();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Property
    public void drawPixel(@ForAll int x, @ForAll int y, @ForAll("color") TextColor.RGB color) {
        LanternaGUI lanternaGUI = new LanternaGUI("drawPixel Test", graphics, screen, terminal);

        lanternaGUI.drawPixel(x, y, color);

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
    }*/
}
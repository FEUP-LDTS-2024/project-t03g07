import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeTry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.LanternaFrame;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class LanternaFrameTest {
    private TextGraphics graphics;

    @BeforeTry
    @BeforeEach
    public void setup() {
        this.graphics = mock(TextGraphics.class);
    }

    @Test
    public void getScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getScreen Test");

        lanternaFrame.getScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getTerminal() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getTerminal Test");

        lanternaFrame.getTerminal();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void startScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("startScreen Test");

        lanternaFrame.startScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void stopScreen() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("stopScreen Test");

        lanternaFrame.stopScreen();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getWIDTH() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getWIDTH Test");

        lanternaFrame.getWIDTH();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }

    @Test
    public void getHEIGHT() throws IOException {
        LanternaFrame lanternaFrame = new LanternaFrame("getHEIGHT Test");

        lanternaFrame.getHEIGHT();

        verify(graphics, times(0)).setBackgroundColor(any());
        verify(graphics, times(0)).putString(anyInt(), anyInt(), anyString());
        verifyNoMoreInteractions(graphics);
    }


    @Property
    public void drawPixel(@ForAll int x, @ForAll int y, @ForAll("color") TextColor.RGB color) {
        LanternaFrame lanternaFrame = new LanternaFrame(graphics);

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
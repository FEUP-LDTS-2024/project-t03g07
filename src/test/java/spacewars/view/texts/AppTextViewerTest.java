package spacewars.view.texts;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.GUI;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AppTextViewerTest {
    private AppTextViewer appTextViewer;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException {
        appTextViewer = new AppTextViewer();
    }

    @Test
    public void testAppTextViewer() {
        assertNotNull(appTextViewer);
    }

    @Test
    public void testDrawKnownChar() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw('A', 0, 0, color, mockGui);
        verify(mockGui, atLeastOnce()).drawPixel(anyDouble(), anyDouble(), any(TextColor.RGB.class));
    }

    @Test
    public void testDrawString() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw("Hello", 0, 0, color, mockGui);
        verify(mockGui, atLeast(5)).drawPixel(anyDouble(), anyDouble(), any(TextColor.RGB.class));
    }

    @Test
    public void testGetCharHeight() {
        assertEquals(5, appTextViewer.getCharHeight());
    }

    @Test
    public void testDrawUnknownChar() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw('«', 0, 0, color, mockGui);
        verify(mockGui, atLeastOnce()).drawRectangle(anyDouble(), anyDouble(), eq(3), eq(5), any(TextColor.RGB.class));
    }

    @Test
    public void testDrawKnownCharBoundary() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw('A', 0, 0, color, mockGui);
        verify(mockGui, atLeastOnce()).drawPixel(anyDouble(), anyDouble(), any(TextColor.RGB.class));
    }

    @Test
    public void testDrawUnknownCharBoundary() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw('«', 0, 0, color, mockGui);
        verify(mockGui, atLeastOnce()).drawRectangle(anyDouble(), anyDouble(), eq(3), eq(5), any(TextColor.RGB.class));
    }

    @Test
    public void testDrawKnownCharPixelDrawing() {
        GUI mockGui = mock(GUI.class);
        TextColor color = new TextColor.RGB(255, 255, 255);
        appTextViewer.draw('A', 0, 0, color, mockGui);
        verify(mockGui, atLeast(12)).drawPixel(anyDouble(), anyDouble(), any(TextColor.RGB.class));
    }
}
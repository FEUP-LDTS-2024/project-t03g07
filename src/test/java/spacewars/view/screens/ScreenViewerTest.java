package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.GUI;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ScreenViewerTest {
    private GUI gui;
    private TextGraphics textGraphics;
    private ScreenViewer<Object> screenViewer;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
        Screen screen = mock(Screen.class);
        textGraphics = mock(TextGraphics.class);

        when(gui.getScreen()).thenReturn(screen);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        screenViewer = new ScreenViewer<Object>(new Object()) {
            @Override
            public void draw(GUI gui) {
                // No implementation needed for this test
            }
        };
    }

    @Test
    public void testGetModel() {
        Object model = screenViewer.getModel();

        assertNotNull(model);
    }

    @Test
    public void testDrawBackground() {
        TextColor backgroundColor = new TextColor.RGB(255, 0, 0); // Red color

        screenViewer.drawBackground(gui, backgroundColor);

        verify(textGraphics).setBackgroundColor(backgroundColor);
        verify(textGraphics).fill(' ');
    }
}
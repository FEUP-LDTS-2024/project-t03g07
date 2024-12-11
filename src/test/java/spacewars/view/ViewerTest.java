package spacewars.view;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.LanternaGUI;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ViewerTest {
    private LanternaGUI frame;
    private Viewer viewer;
    private BufferedImage image;

    @BeforeEach
    public void setup() throws IOException {
        frame = mock(LanternaGUI.class);
        viewer = new Viewer("bullet_1.png") {
            @Override
            public void drawEntity(LanternaGUI frame, Object entity) {
                // Implementation not needed for this test
            }
        };
        image = mock(BufferedImage.class);
        viewer.image = image;
    }

    @Test
    public void testLoadImage() throws IOException {
        viewer.loadImage("bullet_1.png");
        assertNotNull(viewer.image);
    }

    @Test
    public void testDraw() {
        when(image.getWidth()).thenReturn(2);
        when(image.getHeight()).thenReturn(2);
        when(image.getRGB(0, 0)).thenReturn(0xFF0000); // Red
        when(image.getRGB(1, 0)).thenReturn(0x00FF00); // Green
        when(image.getRGB(0, 1)).thenReturn(0x0000FF); // Blue
        when(image.getRGB(1, 1)).thenReturn(0xFFFFFF); // White

        viewer.draw(frame, 10, 20);

        verify(frame).drawPixel(10, 20, new TextColor.RGB(255, 0, 0));
        verify(frame).drawPixel(11, 20, new TextColor.RGB(0, 255, 0));
        verify(frame).drawPixel(10, 21, new TextColor.RGB(0, 0, 255));
        verify(frame).drawPixel(11, 21, new TextColor.RGB(255, 255, 255));
    }
}
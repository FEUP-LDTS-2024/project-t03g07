package spacewars.view;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.LanternaFrame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ViewerTest {
    private LanternaFrame frame;
    private Viewer viewer;

    @BeforeEach
    public void setup() throws IOException {
        frame = mock(LanternaFrame.class);
        viewer = new Viewer("bullet_1.png") {
            @Override
            public void drawEntity(LanternaFrame frame, Object entity) {
                // Implementation not needed for this test
            }
        };
    }

    @Test
    public void testLoadImage() throws IOException {
        viewer.loadImage("bullet_1.png");
        assertNotNull(viewer.image);
    }

    @Test
    public void testDraw() {
        viewer.image = mock(BufferedImage.class);
        when(viewer.image.getHeight()).thenReturn(10);
        when(viewer.image.getWidth()).thenReturn(10);
        when(viewer.image.getRGB(0, 0)).thenReturn(0);
        when(viewer.image.getRGB(1, 1)).thenReturn(1);
        when(viewer.image.getRGB(2, 2)).thenReturn(2);
        when(viewer.image.getRGB(3, 3)).thenReturn(3);
        when(viewer.image.getRGB(4, 4)).thenReturn(4);
        when(viewer.image.getRGB(5, 5)).thenReturn(5);
        when(viewer.image.getRGB(6, 6)).thenReturn(6);
        when(viewer.image.getRGB(7, 7)).thenReturn(7);
        when(viewer.image.getRGB(8, 8)).thenReturn(8);
        when(viewer.image.getRGB(9, 9)).thenReturn(9);

        viewer.draw(frame, 5, 15);

        verify(frame, times(100)).drawPixel(anyInt(), anyInt(), any(TextColor.RGB.class));

    }
}
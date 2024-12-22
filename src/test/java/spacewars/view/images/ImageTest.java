package spacewars.view.images;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.GUI;

import java.io.IOException;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ImageTest {
    private Image image;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
    }

    @Test
    public void testLoadImageSuccessfully() throws IOException {
        String validPath = "images/test.png";
        image = new Image(validPath);
        assertNotNull(image);
    }

    @Test
    public void testLoadImageThrowsIOExceptionForInvalidPath() {
        String invalidPath = "invalid/path.png";
        assertThrows(IOException.class, () -> new Image(invalidPath));
    }

    @Test
    public void testDrawImage() throws IOException {
        String validPath = "bullet_1.png";
        image = new Image(validPath);
        image.draw(gui, 0, 0);
        verify(gui, atLeastOnce()).drawPixel(anyDouble(), anyDouble(), any());
    }

    @Test
    public void testGetLanternaColor() throws IOException {
        String validPath = "bullet_1.png";
        image = new Image(validPath);
        BufferedImage bufferedImage = image.loadImage(validPath);
        int rgb = bufferedImage.getRGB(0, 0);
        TextColor.RGB color = image.getLanternaColor(rgb);
        assertNotNull(color);
        assertEquals(new TextColor.RGB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF), color);
    }

    @Test
    public void testGetTransparency() throws IOException {
        String validPath = "bullet_1.png";
        image = new Image(validPath);
        BufferedImage bufferedImage = image.loadImage(validPath);
        int rgb = bufferedImage.getRGB(0, 0);
        int transparency = image.getTransparency(rgb);
        assertEquals(rgb >> 24, transparency);
    }

    @Test
    public void testDrawImageWithTransparency() throws IOException, NoSuchFieldException, IllegalAccessException {
        String validPath = "bullet_1.png";
        image = new Image(validPath);
        BufferedImage bufferedImage = mock(BufferedImage.class);
        when(bufferedImage.getHeight()).thenReturn(1);
        when(bufferedImage.getWidth()).thenReturn(1);
        when(bufferedImage.getRGB(0, 0)).thenReturn(0x00FFFFFF); // Fully transparent pixel

        // Use reflection to set the private image field
        java.lang.reflect.Field imageField = Image.class.getDeclaredField("image");
        imageField.setAccessible(true);
        imageField.set(image, bufferedImage);

        image.draw(gui, 0, 0);
        verify(gui, never()).drawPixel(anyDouble(), anyDouble(), any());
    }
}
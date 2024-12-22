package spacewars.view.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AppImageLoaderTest {
    private AppImageLoader appImageLoader;

    @BeforeEach
    public void setUp() {
        appImageLoader = new AppImageLoader();
    }

    @Test
    public void testGetImageLoadsImage() throws IOException {
        String imagePath = "images/test.png";
        Image image = appImageLoader.get(imagePath);
        assertNotNull(image);
    }

    @Test
    public void testGetImageCachesImage() throws IOException {
        String imagePath = "images/test.png";
        Image firstLoad = appImageLoader.get(imagePath);
        Image secondLoad = appImageLoader.get(imagePath);
        assertSame(firstLoad, secondLoad);
    }

    @Test
    public void testGetImageThrowsIOExceptionForInvalidPath() {
        String invalidPath = "invalid/path.png";
        assertThrows(IOException.class, () -> appImageLoader.get(invalidPath));
    }
}
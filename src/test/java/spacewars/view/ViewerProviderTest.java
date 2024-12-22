package spacewars.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.view.images.ImageLoader;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class ViewerProviderTest {
    private ViewerProvider viewerProvider;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException {
        ImageLoader imageLoader = mock(ImageLoader.class);
        viewerProvider = new ViewerProvider(imageLoader);
    }

    @Test
    public void testViewerProvider() {
        assertNotNull(viewerProvider);
    }

    @Test
    public void testPlayerViewer() {
        assertNotNull(viewerProvider.getPlayerViewer());
    }

    @Test
    public void testNormalInvader1Viewer() {
        assertNotNull(viewerProvider.getInvader1Viewer());
    }

    @Test
    public void testNormalInvader2Viewer() {
        assertNotNull(viewerProvider.getInvader2Viewer());
    }

    @Test
    public void testNormalInvader3Viewer() {
        assertNotNull(viewerProvider.getInvader3Viewer());
    }

    @Test
    public void testBossInvaderViewer() {
        assertNotNull(viewerProvider.getBossInvaderViewer());
    }

    @Test
    public void testBulletPlayerViewer() {
        assertNotNull(viewerProvider.getBulletPlayerViewer());
    }

    @Test
    public void testBulletInvader1Viewer() {
        assertNotNull(viewerProvider.getBulletInvader1Viewer());
    }

    @Test
    public void testBulletInvader2Viewer() {
        assertNotNull(viewerProvider.getBulletInvader2Viewer());
    }

    @Test
    public void testBulletInvader3Viewer() {
        assertNotNull(viewerProvider.getBulletInvader3Viewer());
    }

    @Test
    public void testBulletBossInvaderViewer() {
        assertNotNull(viewerProvider.getBulletBossInvaderViewer());
    }

    @Test
    public void testLiveViewer() {
        assertNotNull(viewerProvider.getLiveViewer());
    }

    @Test
    public void testTextViewer() {
        assertNotNull(viewerProvider.getTextViewer());
    }

    @Test
    public void testEntryViewer() {
        assertNotNull(viewerProvider.getEntryViewer());
    }

    @Test
    public void testLogoViewer() {
        assertNotNull(viewerProvider.getLogoViewer());
    }

    @Test
    public void testGameOverViewer() {
        assertNotNull(viewerProvider.getGameOverImageViewer());
    }

    @Test
    public void testArrowsViewer() {
        assertNotNull(viewerProvider.getArrowsViewer());
    }

    @Test
    public void testSpacebarViewer() {
        assertNotNull(viewerProvider.getSpacebarViewer());
    }

    @Test
    public void testEmpireFighterViewer() {
        assertNotNull(viewerProvider.getEmpireFighterViewer());
    }

    @Test
    public void testTIEExecutorViewer() {
        assertNotNull(viewerProvider.getTIEExecutorViewer());
    }

    @Test
    public void testStarDestroyerViewer() {
        assertNotNull(viewerProvider.getStarDestroyerViewer());
    }

    @Test
    public void testDeathStarViewer() {
        assertNotNull(viewerProvider.getDeathStarViewer());
    }
}

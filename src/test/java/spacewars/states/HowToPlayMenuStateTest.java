package spacewars.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.Controller;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.screens.menus.HowToPlayMenuViewer;
import spacewars.controller.menu.HowToPlayMenuController;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;

public class HowToPlayMenuStateTest {
    private HowToPlayMenuState howToPlayMenuState;
    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        HowToPlayMenu howToPlayMenu = mock(HowToPlayMenu.class);
        ImageLoader imageLoader = mock(ImageLoader.class);
        viewerProvider = mock(ViewerProvider.class);

        howToPlayMenuState = new HowToPlayMenuState(howToPlayMenu, imageLoader);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<HowToPlayMenu> screenViewer = howToPlayMenuState.getScreenViewer(viewerProvider);
        assertInstanceOf(HowToPlayMenuViewer.class, screenViewer);
    }

    @Test
    void testGetController() {
        Controller<HowToPlayMenu> controller = howToPlayMenuState.getController();
        assertInstanceOf(HowToPlayMenuController.class, controller);
    }
}

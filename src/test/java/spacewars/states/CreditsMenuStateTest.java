package spacewars.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.Controller;
import spacewars.controller.menu.CreditsMenuController;
import spacewars.model.menu.CreditsMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.screens.menus.CreditsMenuViewer;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;

public class CreditsMenuStateTest {
    private CreditsMenuState mainMenuState;
    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        CreditsMenu creditsMenu = mock(CreditsMenu.class);
        ImageLoader imageLoader = mock(ImageLoader.class);
        viewerProvider = mock(ViewerProvider.class);

        mainMenuState = new CreditsMenuState(creditsMenu, imageLoader);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<CreditsMenu> screenViewer = mainMenuState.getScreenViewer(viewerProvider);
        assertInstanceOf(CreditsMenuViewer.class, screenViewer);
    }

    @Test
    void testGetController() {
        Controller<CreditsMenu> controller = mainMenuState.getController();
        assertInstanceOf(CreditsMenuController.class, controller);
    }
}

package spacewars.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.Controller;
import spacewars.controller.menu.MainMenuController;
import spacewars.model.menu.MainMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.menus.MainMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.*;

class MainMenuStateTest {
    private MainMenuState mainMenuState;
    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        MainMenu mainMenu = mock(MainMenu.class);
        ImageLoader imageLoader = mock(ImageLoader.class);
        viewerProvider = mock(ViewerProvider.class);

        mainMenuState = new MainMenuState(mainMenu, imageLoader);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<MainMenu> screenViewer = mainMenuState.getScreenViewer(viewerProvider);
        assertInstanceOf(MainMenuViewer.class, screenViewer);
    }

    @Test
    void testGetController() {
        Controller<MainMenu> controller = mainMenuState.getController();
        assertInstanceOf(MainMenuController.class, controller);
    }
}
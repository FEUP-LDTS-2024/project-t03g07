package spacewars.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.model.menu.CreditsMenu;
import spacewars.states.MainMenuState;
import spacewars.view.images.ImageLoader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class CreditsMenuControllerTest {
    private CreditsMenuController controller;
    private CreditsMenu creditsMenu;
    private Application application;
    private EntryController entryController;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setUp() {
        creditsMenu = mock(CreditsMenu.class);
        application = mock(Application.class);
        entryController = mock(EntryController.class);
        imageLoader = mock(ImageLoader.class);
        controller = new CreditsMenuController(creditsMenu, entryController);

        when(application.getImageLoader()).thenReturn(imageLoader);
    }

    @Test
    public void testOnQuit() throws IOException, FontFormatException, URISyntaxException {
        controller.onQuit(application);

        // Verify that the application state is set to MainMenuState
        verify(application, times(1)).setState(isA(MainMenuState.class));
    }
}
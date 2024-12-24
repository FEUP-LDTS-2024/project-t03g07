package spacewars.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.states.MainMenuState;
import spacewars.view.images.ImageLoader;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class HowtoPlayMenuControllerTest {
    private HowToPlayMenuController controller;
    private Application application;

    @BeforeEach
    public void setUp() {
        HowToPlayMenu howToPlayMenu = mock(HowToPlayMenu.class);
        application = mock(Application.class);
        EntryController entryController = mock(EntryController.class);
        controller = new HowToPlayMenuController(howToPlayMenu, entryController);
        ImageLoader imageLoader = mock(ImageLoader.class);

        when(application.getImageLoader()).thenReturn(imageLoader);
    }

    @Test
    public void testOnQuit() throws IOException, URISyntaxException {
        controller.onQuit(application);

        verify(application, times(1)).setState(isA(MainMenuState.class));
    }
}
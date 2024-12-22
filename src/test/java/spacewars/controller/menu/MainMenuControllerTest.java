package spacewars.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.model.menu.MainMenu;
import spacewars.view.images.ImageLoader;

import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController controller;
    private Application application;

    @BeforeEach
    public void setUp() {
        MainMenu mainMenu = mock(MainMenu.class);
        application = mock(Application.class);
        EntryController entryController = mock(EntryController.class);
        controller = new MainMenuController(mainMenu, entryController);
        ImageLoader imageLoader = mock(ImageLoader.class);

        when(application.getImageLoader()).thenReturn(imageLoader);
    }

    @Test
    public void testOnQuit() {
        controller.onQuit(application);

        verify(application, times(1)).setState(null);
    }
}

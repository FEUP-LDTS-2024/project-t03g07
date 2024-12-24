package spacewars.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.menu.Menu;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {
    private MenuController<Menu> controller;
    private Application application;
    private Menu menu;
    private EntryController entryController;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        application = mock(Application.class);
        entryController = mock(EntryController.class);
        controller = new MenuController<Menu>(menu, entryController) {
            @Override
            protected void onQuit(Application app) {
                app.setState(null);
            }
        };
    }

    @Test
    public void testStepUp() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.UP, 0);

        verify(menu, times(1)).previousEntry();
    }

    @Test
    public void testStepDown() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.DOWN, 0);

        verify(menu, times(1)).nextEntry();
    }

    @Test
    public void testStepQuit() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.QUIT, 0);

        verify(application, times(1)).setState(null);
    }

    @Test
    public void testStepDefault() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.LEFT, 0);

        verify(entryController, times(1)).step(application, GUI.ACTION.LEFT, 0);
    }
}
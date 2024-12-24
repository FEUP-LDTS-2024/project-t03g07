package spacewars.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.*;
import spacewars.states.CreditsMenuState;
import spacewars.states.GameState;
import spacewars.states.HowToPlayMenuState;
import spacewars.states.MainMenuState;
import spacewars.view.images.ImageLoader;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class EntryControllerTest {
    private EntryController controller;
    private Menu menu;
    private Application application;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        application = mock(Application.class);
        controller = new EntryController(menu);
        ImageLoader imageLoader = mock(ImageLoader.class);

        when(application.getImageLoader()).thenReturn(imageLoader);
    }

    @Test
    public void testStepPlay() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.PLAY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isA(GameState.class));
    }

    @Test
    public void testStepHowToPlay() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.HOW_TO_PLAY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isA(HowToPlayMenuState.class));
    }

    @Test
    public void testStepCredits() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.CREDITS);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isA(CreditsMenuState.class));
    }

    @Test
    public void testStepQuit() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.QUIT);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isNull());
    }

    @Test
    public void testStepReturnToMenu() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.RETURN_TO_MENU);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isA(MainMenuState.class));
    }

    @Test
    public void testStepPlayAgain() throws IOException, URISyntaxException {
        Entry entry = new Entry(new Position(0, 0), Entry.TYPE.PLAY_AGAIN);
        when(menu.getCurrentEntry()).thenReturn(entry);

        controller.step(application, GUI.ACTION.SELECT, System.currentTimeMillis());

        verify(application, times(1)).setState(isA(GameState.class));
    }
}
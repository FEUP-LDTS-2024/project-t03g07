package spacewars.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class ControllerTest {
    private Controller<Game> controller;
    private Game game;
    private Application application;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        application = mock(Application.class);
        gui = mock(GUI.class);
        controller = new Controller<>(game) {
            @Override
            public void step(Application application, GUI.ACTION action, long time){
            }
        };
    }

    @Test
    public void testGetModel() {
        assertSame(game, controller.getModel());
    }

    @Test
    public void testStep() throws IOException, FontFormatException, URISyntaxException {
        GUI.ACTION action = GUI.ACTION.NONE;
        long time = System.currentTimeMillis();

        controller.step(application, action, time);

        // Verify interactions with mocks if any
        verifyNoInteractions(game, application, gui);
    }
}
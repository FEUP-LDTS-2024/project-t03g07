package spacewars.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StateTest {
    private State<Object> state;
    private Object model;
    private Controller<Object> controller;
    private ScreenViewer<Object> screenViewer;
    private ImageLoader imageLoader;
    private Application application;
    private GUI gui;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        model = new Object();
        controller = mock(Controller.class);
        screenViewer = mock(ScreenViewer.class);
        imageLoader = mock(ImageLoader.class);
        application = mock(Application.class);
        gui = mock(GUI.class);

        state = new State<>(model, imageLoader) {
            @Override
            protected ScreenViewer<Object> getScreenViewer(ViewerProvider viewerProvider) {
                return screenViewer;
            }

            @Override
            protected Controller<Object> getController() {
                return controller;
            }
        };
    }

    @Test
    void testGetModel() {
        assertEquals(model, state.getModel());
    }

    @Test
    void testStep() throws IOException, URISyntaxException {
        GUI.ACTION action = GUI.ACTION.NONE;
        long time = 1000L;

        when(gui.getNextAction()).thenReturn(action);

        state.step(application, gui, time);

        verify(controller, times(1)).step(application, action, time);
        verify(screenViewer, times(1)).draw(gui);
    }
}
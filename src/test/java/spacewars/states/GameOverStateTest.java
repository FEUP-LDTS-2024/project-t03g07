package spacewars.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.Controller;
import spacewars.controller.menu.GameOverController;
import spacewars.model.menu.GameOver;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.screens.menus.GameOverViewer;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;

public class GameOverStateTest {
    private GameOverState gameOverState;
    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        GameOver gameOver = mock(GameOver.class);
        ImageLoader imageLoader = mock(ImageLoader.class);
        viewerProvider = mock(ViewerProvider.class);

        gameOverState = new GameOverState(gameOver, imageLoader);
    }

    @Test
    void testGetScreenViewer() {
        ScreenViewer<GameOver> screenViewer = gameOverState.getScreenViewer(viewerProvider);
        assertInstanceOf(GameOverViewer.class, screenViewer);
    }

    @Test
    void testGetController() {
        Controller<GameOver> controller = gameOverState.getController();
        assertInstanceOf(GameOverController.class, controller);
    }
}

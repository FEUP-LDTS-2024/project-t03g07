package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.game.GameOverController;
import spacewars.model.game.GameOver;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.GameOverViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model, ImageLoader imageLoader) throws IOException, URISyntaxException, FontFormatException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<GameOver> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new GameOverViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
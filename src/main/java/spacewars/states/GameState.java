package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.game.GameController;
import spacewars.model.game.Game;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.GameViewer;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.ViewerProvider;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameState extends State<Game> {
    public GameState(Game model, ImageLoader imageLoader) throws IOException, FontFormatException, URISyntaxException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<Game> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new GameViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<Game> getController() {
        return new GameController(getModel());
    }
}

package spacewars.states;

import spacewars.controller.Controller;
import spacewars.model.game.Game;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.GameViewer;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.ViewerProvider;

import java.awt.*;
import java.io.IOException;

public class GameState extends State<Game> {
    public GameState(Game model, ImageLoader imageLoader) throws IOException, FontFormatException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<Game> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new GameViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<Game> getController() {
        return null;
    }
}

package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.EntryController;
import spacewars.controller.menu.GameOverController;
import spacewars.model.menu.GameOver;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.menus.GameOverViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model, ImageLoader imageLoader) throws IOException, URISyntaxException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<GameOver> getScreenViewer(ViewerProvider viewerProvider) {
        return new GameOverViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel(), new EntryController(getModel()));
    }
}
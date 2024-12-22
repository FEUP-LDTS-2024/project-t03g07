package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.GameOver;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends MenuController<GameOver> {
    public GameOverController(GameOver model, EntryController entryController) {
        super(model, entryController);
    }

    @Override
    protected void onQuit(Application app) throws IOException, URISyntaxException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }

}
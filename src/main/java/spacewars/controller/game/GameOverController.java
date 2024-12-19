package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.game.GameOver;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        switch (action) {
            case QUIT:
                onQuit(application);
                break;
        }
    }
    private void onQuit (Application application) throws IOException, URISyntaxException, FontFormatException {
        application.setState(new MainMenuState(new MainMenu(), application.getImageLoader()));
    }
}
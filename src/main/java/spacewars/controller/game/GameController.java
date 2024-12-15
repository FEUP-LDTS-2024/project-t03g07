package spacewars.controller.game;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class GameController extends Controller<Game> {
    private final PlayerController playerController;
    // private final InvaderController invaderController;


    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(getModel().getPlayer());
        // this.invaderController = new InvaderController(game);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        switch (action) {
            case QUIT:
                onQuit(application);
                break;
        }
    }

    private void onQuit(Application application) throws IOException, URISyntaxException, FontFormatException {
        application.setState(new MainMenuState(new MainMenu(), application.getImageLoader()));
    }
}

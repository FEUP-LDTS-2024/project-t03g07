package spacewars.controller.menu;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.game.Game;
import spacewars.model.game.GameBuilder;
import spacewars.model.game.elements.Player;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.model.menu.MainMenu;
import spacewars.model.menu.Menu;
import spacewars.states.CreditsMenuState;
import spacewars.states.GameState;
import spacewars.states.HowToPlayMenuState;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class EntryController extends Controller<Menu> {

    public EntryController(Menu model) {
        super(model);
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException, FontFormatException, URISyntaxException {
        switch (getModel().getCurrentEntry().getType()) { //"play", "how to play", "credits", "quit", "return to menu"
            case PLAY:
                if (action==GUI.ACTION.SELECT) {
                    app.setState(new GameState(new Game(), app.getImageLoader()));
                }
                break;

            case HOW_TO_PLAY:
                if (action==GUI.ACTION.SELECT) {
                    app.setState(new HowToPlayMenuState(new HowToPlayMenu(), app.getImageLoader()));
                }
                break;

            case CREDITS:
                if (action==GUI.ACTION.SELECT) {
                    app.setState(new CreditsMenuState(new CreditsMenu(), app.getImageLoader()));
                }
                break;

            case QUIT:
                if (action == GUI.ACTION.SELECT) {
                    app.setState(null);
                }
                break;

            case RETURN_TO_MENU:
                if (action == GUI.ACTION.SELECT) {
                    app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
                }
        }
    }
}

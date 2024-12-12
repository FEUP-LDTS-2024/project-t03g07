package spacewars.controller.menu;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
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

import java.io.IOException;

public class EntryController extends Controller<Menu> {

    public EntryController(Menu model) {
        super(model);
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        switch (getModel().getCurrentEntry().get) { //"play", "how to play", "credits", "quit", "return to menu"
            case PLAY:
                if (action==GUI.ACTION.SELECT) {
//                    app.setState(new GameState(
//                            new GameBuilder.createGame(new Player(10,10)),
//                            app.getImageLoader()
//                    ));
                }
                break;

            case "how to play":
                if (action==GUI.ACTION.SELECT) {
                    app.setState(new HowToPlayMenuState(new HowToPlayMenu(), app.getImageLoader()));
                }
                break;

            case "credits":
                if (action==GUI.ACTION.SELECT) {
                    app.setState(new CreditsMenuState(new CreditsMenu(), app.getImageLoader()));
                }
                break;

            case "quit":
                if (action == GUI.ACTION.SELECT) {
                    app.setState(null);
                }
                break;

            case "return to menu":
                if (action == GUI.ACTION.SELECT) {
                    app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
                }
        }
    }
}

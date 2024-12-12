package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.io.IOException;

public class CreditsMenuController extends MenuController<CreditsMenu> {

    public CreditsMenuController(CreditsMenu menu) {
        super(menu);
    }

    @Override
    protected void onQuit(Application app) throws IOException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

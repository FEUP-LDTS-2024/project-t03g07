package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreditsMenuController extends MenuController<CreditsMenu> {

    public CreditsMenuController(CreditsMenu menu, EntryController entryController) {
        super(menu, entryController);
    }

    @Override
    protected void onQuit(Application app) throws IOException, URISyntaxException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

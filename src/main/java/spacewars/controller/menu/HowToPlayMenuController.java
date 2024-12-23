package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class HowToPlayMenuController extends MenuController<HowToPlayMenu> {

    public HowToPlayMenuController(HowToPlayMenu menu, EntryController entryController) {
        super(menu, entryController);
    }

    @Override
    protected void onQuit(Application app) throws IOException, URISyntaxException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

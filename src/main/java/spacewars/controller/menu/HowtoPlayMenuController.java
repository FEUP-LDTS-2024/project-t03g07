package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HowtoPlayMenuController extends MenuController<HowToPlayMenu> {

    public HowtoPlayMenuController(HowToPlayMenu menu, EntryController entryController) {
        super(menu,entryController);
    }

    @Override
    protected void onQuit(Application app) throws IOException, FontFormatException, URISyntaxException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

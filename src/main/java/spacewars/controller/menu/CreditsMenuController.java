package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.CreditsMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.awt.*;
import java.io.IOException;

public class CreditsMenuController extends MenuController<CreditsMenu> {

    public CreditsMenuController(CreditsMenu menu, EntryController en) {
        super(menu,en);
    }

    @Override
    protected void onQuit(Application app) throws IOException, FontFormatException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

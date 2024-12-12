package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.model.menu.MainMenu;
import spacewars.states.MainMenuState;

import java.io.IOException;

public class HowtoPlayMenuController extends MenuController<HowToPlayMenu> {

    public HowtoPlayMenuController(HowToPlayMenu menu) {
        super(menu);
    }

    @Override
    protected void onQuit(Application app) throws IOException {
        app.setState(new MainMenuState(new MainMenu(), app.getImageLoader()));
    }
}

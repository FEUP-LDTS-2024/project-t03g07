package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.MainMenu;

import java.io.IOException;

public class MainMenuController extends MenuController<MainMenu> {

    public MainMenuController(MainMenu menu) {
        super(menu);
    }



    @Override
    protected void onQuit(Application app) throws IOException {
        app.setState(null);
    }
}

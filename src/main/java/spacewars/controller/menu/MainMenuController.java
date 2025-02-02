package spacewars.controller.menu;

import spacewars.Application;
import spacewars.model.menu.MainMenu;

public class MainMenuController extends MenuController<MainMenu> {

    public MainMenuController(MainMenu menu, EntryController entrycontroller) {
        super(menu, entrycontroller);
    }

    @Override
    protected void onQuit(Application app) {
        app.setState(null);
    }
}

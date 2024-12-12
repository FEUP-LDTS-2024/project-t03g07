package spacewars.controller.menu;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.menu.Menu;

import java.io.IOException;

public abstract class MenuController <T extends Menu> extends Controller<T> {
    private final EntryController entryController;

    public MenuController(T menu, EntryController entryController) {
        super(menu);
        this.entryController = entryController;
    }

    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                this.getModel().previousEntry();
                break;
            case DOWN:
                this.getModel().nextEntry();
                break;
            case QUIT:
                onQuit(app);
                break;
            default:
                entryController.step(app, action, time);
        }
    }

    protected abstract void onQuit(Application app) throws IOException;
}

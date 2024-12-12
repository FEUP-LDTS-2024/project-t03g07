package spacewars.controller.menu;

import spacewars.Application;
import spacewars.controller.Controller;
import spacewars.gui.GUI;
import spacewars.model.menu.Menu;

import java.io.IOException;

public abstract class MenuController <T extends Menu> extends Controller<T> {

    public MenuController(T menu) {
        super(menu);
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

        }
    }

    protected abstract void onQuit(Application app) throws IOException;
}

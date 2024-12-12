package spacewars.view.menu;

import spacewars.gui.GUI;
import spacewars.model.menu.Menu;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class MenuViewer<T extends Menu> extends ScreenViewer<T> {

    public MenuViewer(T model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        //to implement
    }
}

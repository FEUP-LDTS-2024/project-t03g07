package spacewars.view.menu;

import spacewars.gui.GUI;
import spacewars.model.menu.MainMenu;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class MainMenuViewer extends ScreenViewer<MainMenu> {
    public MainMenuViewer(MainMenu model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        //to implement
    }
}

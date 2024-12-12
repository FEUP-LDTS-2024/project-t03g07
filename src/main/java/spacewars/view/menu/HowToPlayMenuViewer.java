package spacewars.view.menu;

import spacewars.gui.GUI;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.states.HowToPlayMenuState;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class HowToPlayMenuViewer extends ScreenViewer<HowToPlayMenu> {

    public HowToPlayMenuViewer(HowToPlayMenu model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        //to implement
    }
}

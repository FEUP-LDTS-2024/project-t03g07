package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.MainMenuController;
import spacewars.model.menu.MainMenu;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.menu.MainMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class MainMenuState extends State<Menu> {
    public MainMenuState(Menu model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<MainMenu> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}

package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.EntryController;
import spacewars.controller.menu.MainMenuController;
import spacewars.model.menu.MainMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.menus.MainMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model, ImageLoader imageLoader) throws IOException, URISyntaxException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<MainMenu> getScreenViewer(ViewerProvider viewerProvider) {
        return new MainMenuViewer<>(getModel(), viewerProvider);
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel(), new EntryController(getModel()));
    }
}

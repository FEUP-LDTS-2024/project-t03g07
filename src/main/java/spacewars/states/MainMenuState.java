package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.EntryController;
import spacewars.controller.menu.MainMenuController;
import spacewars.model.menu.MainMenu;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.menu.MainMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model, ImageLoader imageLoader) throws IOException, FontFormatException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<MainMenu> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new MainMenuViewer<>(getModel(), viewerProvider);
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel(), new EntryController(getModel()));
    }
}

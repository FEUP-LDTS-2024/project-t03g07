package spacewars.states;

import spacewars.controller.Controller;
import spacewars.model.menu.Menu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class MainMenuState extends State<Menu> {
    public MainMenuState(Menu model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<Menu> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return null;
    }

    @Override
    protected Controller<Menu> getController() {
        return null;
    }
}

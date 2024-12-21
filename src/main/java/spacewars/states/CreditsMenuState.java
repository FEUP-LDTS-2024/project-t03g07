package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.CreditsMenuController;
import spacewars.controller.menu.EntryController;
import spacewars.model.menu.CreditsMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.screens.menus.CreditsMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class CreditsMenuState extends State<CreditsMenu>{
    public CreditsMenuState(CreditsMenu model, ImageLoader imageLoader) throws IOException, FontFormatException, URISyntaxException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<CreditsMenu> getScreenViewer(ViewerProvider viewerProvider) {
        return new CreditsMenuViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<CreditsMenu> getController() {
        return new CreditsMenuController(getModel(),new EntryController(getModel()));
    }
}

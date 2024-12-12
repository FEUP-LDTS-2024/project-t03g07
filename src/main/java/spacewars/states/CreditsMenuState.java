package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.CreditsMenuController;
import spacewars.model.menu.CreditsMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.menu.CreditsMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.io.IOException;

public class CreditsMenuState extends State<CreditsMenu>{
    public CreditsMenuState(CreditsMenu model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<CreditsMenu> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new CreditsMenuViewer(getModel());
    }

    @Override
    protected Controller<CreditsMenu> getController() {
        return new CreditsMenuController(getModel());
    }
}

package spacewars.states;

import spacewars.controller.Controller;
import spacewars.controller.menu.EntryController;
import spacewars.controller.menu.HowtoPlayMenuController;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.view.ViewerProvider;
import spacewars.view.images.ImageLoader;
import spacewars.view.menu.HowToPlayMenuViewer;
import spacewars.view.screens.ScreenViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HowToPlayMenuState extends State<HowToPlayMenu> {

    public HowToPlayMenuState(HowToPlayMenu model, ImageLoader imageLoader) throws IOException, FontFormatException, URISyntaxException {
        super(model, imageLoader);
    }

    @Override
    protected ScreenViewer<HowToPlayMenu> getScreenViewer(ViewerProvider viewerProvider) throws IOException {
        return new HowToPlayMenuViewer(getModel());
    }

    @Override
    protected Controller<HowToPlayMenu> getController() {
        return new HowtoPlayMenuController(getModel(),new EntryController(getModel()));
    }
}

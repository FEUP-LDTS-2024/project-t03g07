package spacewars.view.menus.main_menu;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class LogoViewer extends AbstractImageViewer {

    public LogoViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "images/logo.png");
    }

}

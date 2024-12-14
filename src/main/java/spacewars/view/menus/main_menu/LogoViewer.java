package spacewars.view.menus.main_menu;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class LogoViewer {
    private final Image image;

    public LogoViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("images/logo.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

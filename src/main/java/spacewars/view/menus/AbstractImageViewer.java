package spacewars.view.menus;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public abstract class AbstractImageViewer {
    protected final Image image;

    protected AbstractImageViewer(ImageLoader imageLoader, String imagePath) throws IOException {
        this.image = imageLoader.get(imagePath);
    }

    public void draw(GUI gui, double x, double y) {
        image.draw(gui, x, y);
    }
}

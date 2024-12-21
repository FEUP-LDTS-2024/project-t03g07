package spacewars.view.menus.how_to_play;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class SpacebarViewer {
    private final Image image;

    public SpacebarViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("images/spacebar_howtoplay.png");
    }

    public void draw(GUI gui, double x, double y) throws IOException {
        image.draw(gui, x, y);
    }
}

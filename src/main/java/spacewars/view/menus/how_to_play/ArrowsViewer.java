package spacewars.view.menus.how_to_play;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class ArrowsViewer {
    private final Image image;

    public ArrowsViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("arrows_how_to_play.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

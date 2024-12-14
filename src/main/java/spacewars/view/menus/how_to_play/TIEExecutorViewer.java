package spacewars.view.menus.how_to_play;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class TIEExecutorViewer {
    private final Image image;

    public TIEExecutorViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("tie_executor16x16.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

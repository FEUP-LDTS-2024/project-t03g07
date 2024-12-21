package spacewars.view.menus.how_to_play.spaceships;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class TIEExecutorViewer {
    private final Image image;

    public TIEExecutorViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/tie_executor.png");
    }

    public void draw(GUI gui, double x, double y) throws IOException {
        image.draw(gui, x, y);
    }
}

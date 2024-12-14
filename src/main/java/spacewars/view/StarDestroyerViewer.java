package spacewars.view;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class StarDestroyerViewer {
    private final Image image;

    public StarDestroyerViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("star_destroyer16x16.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

package spacewars.view;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class EmpireFighterViewer {
    private final Image image;

    public EmpireFighterViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("empire_fighter16x16.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

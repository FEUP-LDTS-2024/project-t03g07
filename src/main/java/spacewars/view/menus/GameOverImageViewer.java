package spacewars.view.menus;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class GameOverImageViewer {
    private final Image image;

    public GameOverImageViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("images/game_over_image.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

package spacewars.view.menus.how_to_play.spaceships;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class DeathStarViewer {
    private final Image image;

    public DeathStarViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/death_star.png");
    }

    public void draw(GUI gui, int x, int y) throws IOException {
        image.draw(gui, x, y);
    }
}

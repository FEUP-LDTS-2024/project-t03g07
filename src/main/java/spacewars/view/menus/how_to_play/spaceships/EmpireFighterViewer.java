package spacewars.view.menus.how_to_play.spaceships;

import spacewars.gui.GUI;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class EmpireFighterViewer {
    private final Image image;

    public EmpireFighterViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/empire_fighter.png");
    }

    public void draw(GUI gui, double x, double y) throws IOException {
        image.draw(gui, x, y);
    }
}

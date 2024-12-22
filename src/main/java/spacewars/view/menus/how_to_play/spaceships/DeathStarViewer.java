package spacewars.view.menus.how_to_play.spaceships;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class DeathStarViewer extends AbstractImageViewer {

    public DeathStarViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/death_star.png");
    }

}

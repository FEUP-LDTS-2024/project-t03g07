package spacewars.view.menus.how_to_play.spaceships;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class StarDestroyerViewer extends AbstractImageViewer {

    public StarDestroyerViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/star_destroyer.png");
    }
}

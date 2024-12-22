package spacewars.view.menus.how_to_play.spaceships;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class EmpireFighterViewer extends AbstractImageViewer {

    public EmpireFighterViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/empire_fighter.png");
    }

}

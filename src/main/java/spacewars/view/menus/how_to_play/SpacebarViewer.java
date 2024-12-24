package spacewars.view.menus.how_to_play;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class SpacebarViewer extends AbstractImageViewer {

    public SpacebarViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "images/spacebar_howtoplay.png");
    }

}

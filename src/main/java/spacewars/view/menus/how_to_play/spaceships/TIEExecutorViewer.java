package spacewars.view.menus.how_to_play.spaceships;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class TIEExecutorViewer extends AbstractImageViewer {

    public TIEExecutorViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/tie_executor.png");
    }

}

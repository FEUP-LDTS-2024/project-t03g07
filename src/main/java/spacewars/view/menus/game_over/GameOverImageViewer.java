package spacewars.view.menus.game_over;

import spacewars.view.images.ImageLoader;
import spacewars.view.menus.AbstractImageViewer;

import java.io.IOException;

public class GameOverImageViewer extends AbstractImageViewer {

    public GameOverImageViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "images/game_over_image.png");
    }
}

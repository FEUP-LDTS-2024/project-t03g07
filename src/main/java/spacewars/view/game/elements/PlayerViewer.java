package spacewars.view.game.elements;

import spacewars.model.game.elements.Player;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class PlayerViewer extends AbstractElementViewer<Player> {

    public PlayerViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/player/millennium_falcon.png");
    }

}
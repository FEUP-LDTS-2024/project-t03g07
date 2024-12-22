package spacewars.view.game.elements.bullets;

import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BulletPlayerViewer extends AbstractElementViewer<BulletPlayer> {

    public BulletPlayerViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/bullets/bullet_1.png");
    }

}

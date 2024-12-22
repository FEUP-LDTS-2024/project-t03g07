package spacewars.view.game.elements.bullets;

import spacewars.model.game.elements.bullets.BulletInvader2;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BulletInvader2Viewer extends AbstractElementViewer<BulletInvader2> {

    public BulletInvader2Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/bullets/bullet_3.png");
    }

}

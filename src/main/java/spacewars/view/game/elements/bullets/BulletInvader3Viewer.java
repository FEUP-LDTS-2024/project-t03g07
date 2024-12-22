package spacewars.view.game.elements.bullets;

import spacewars.model.game.elements.bullets.BulletInvader3;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BulletInvader3Viewer extends AbstractElementViewer<BulletInvader3> {

    public BulletInvader3Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/bullets/bullet_5.png");
    }

}

package spacewars.view.game.elements.bullets;

import spacewars.model.game.elements.bullets.BulletInvader1;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BulletInvader1Viewer extends AbstractElementViewer<BulletInvader1> {

    public BulletInvader1Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/bullets/bullet_2.png");
    }

}

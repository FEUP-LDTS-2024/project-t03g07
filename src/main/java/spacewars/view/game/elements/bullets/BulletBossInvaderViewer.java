package spacewars.view.game.elements.bullets;

import spacewars.model.game.elements.bullets.BulletBossInvader;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BulletBossInvaderViewer extends AbstractElementViewer<BulletBossInvader> {

    public BulletBossInvaderViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/bullets/bullet_4.png");
    }

}

package spacewars.view.game.elements.bullets;

import spacewars.gui.GUI;
import spacewars.model.game.elements.bullets.BulletInvader1;
import spacewars.model.game.elements.bullets.BulletInvader2;
import spacewars.model.game.elements.bullets.BulletInvader3;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class BulletInvader3Viewer implements ElementViewer<BulletInvader3> {
    private final Image image;

    public BulletInvader3Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/bullets/bullet_4.png");
    }

    @Override
    public void draw(BulletInvader3 element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

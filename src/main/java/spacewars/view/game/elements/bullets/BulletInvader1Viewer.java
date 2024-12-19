package spacewars.view.game.elements.bullets;

import spacewars.gui.GUI;
import spacewars.model.game.elements.bullets.BulletInvader1;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class BulletInvader1Viewer implements ElementViewer<BulletInvader1> {
    private final Image image;

    public BulletInvader1Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/bullets/bullet_2.png");
    }

    @Override
    public void draw(BulletInvader1 element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

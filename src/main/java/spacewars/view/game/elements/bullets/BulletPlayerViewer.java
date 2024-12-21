package spacewars.view.game.elements.bullets;

import spacewars.gui.GUI;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class BulletPlayerViewer implements ElementViewer<BulletPlayer> {
    private final Image image;

    public BulletPlayerViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/bullets/bullet_1.png");
    }

    @Override
    public void draw(BulletPlayer element, GUI gui) throws IOException {
        image.draw(gui, element.getPosition().x(), element.getPosition().y());
    }
}

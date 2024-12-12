package spacewars.view.game.elements.bullets;

import spacewars.gui.GUI;
import spacewars.model.game.elements.bullets.BulletBossInvader;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class BulletBossInvaderViewer implements ElementViewer<BulletBossInvader> {
    private final Image image;

    public BulletBossInvaderViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/bullets/bullet_3.png");
    }

    @Override
    public void draw(BulletBossInvader element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

package spacewars.view.game.elements.invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.view.game.elements.ElementViewer;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BossInvaderViewer implements ElementViewer<BossInvader> {
    private final Image image;

    public BossInvaderViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/death_star.png");
    }

    @Override
    public void draw(BossInvader element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

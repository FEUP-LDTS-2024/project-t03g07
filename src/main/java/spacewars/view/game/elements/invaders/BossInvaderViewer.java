package spacewars.view.game.elements.invaders;

import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class BossInvaderViewer extends AbstractElementViewer<BossInvader> {
    public BossInvaderViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/death_star.png");
    }

    @Override
    protected int getX(BossInvader element) {
        return (int)element.getPosition().x();
    }

    @Override
    protected int getY(BossInvader element) {
        return (int)element.getPosition().y();
    }
}
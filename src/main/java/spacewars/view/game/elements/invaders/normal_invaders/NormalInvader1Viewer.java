package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class NormalInvader1Viewer extends AbstractElementViewer<NormalInvader1> {
    public NormalInvader1Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/empire_fighter.png");
    }

    @Override
    protected int getX(NormalInvader1 element) {
        return (int)element.getPosition().x();
    }

    @Override
    protected int getY(NormalInvader1 element) {
        return (int)element.getPosition().y();
    }
}

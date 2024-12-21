package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class NormalInvader3Viewer extends AbstractElementViewer<NormalInvader3> {
    public NormalInvader3Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/star_destroyer.png");
    }

    @Override
    protected int getX(NormalInvader3 element) {
        return (int)element.getPosition().x();
    }

    @Override
    protected int getY(NormalInvader3 element) {
        return (int)element.getPosition().y();
    }
}
package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.view.game.elements.AbstractElementViewer;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class NormalInvader2Viewer extends AbstractElementViewer<NormalInvader2> {
    public NormalInvader2Viewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/invaders/tie_executor.png");
    }

    @Override
    protected int getX(NormalInvader2 element) {
        return (int)element.getPosition().x();
    }

    @Override
    protected int getY(NormalInvader2 element) {
        return (int)element.getPosition().y();
    }
}

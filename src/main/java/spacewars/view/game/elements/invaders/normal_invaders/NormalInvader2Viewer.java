package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class NormalInvader2Viewer implements ElementViewer<NormalInvader2> {
    private final Image image;

    public NormalInvader2Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/tie_executor.png");
    }

    @Override
    public void draw(NormalInvader2 element, GUI gui) throws IOException {
        image.draw(gui, element.getPosition().x(), element.getPosition().y());
    }
}

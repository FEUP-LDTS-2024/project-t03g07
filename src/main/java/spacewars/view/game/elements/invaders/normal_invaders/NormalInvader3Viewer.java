package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class NormalInvader3Viewer implements ElementViewer<NormalInvader3> {
    private final Image image;

    public NormalInvader3Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/star_destroyer.png");
    }

    @Override
    public void draw(NormalInvader3 element, GUI gui) throws IOException {
        image.draw(gui, element.getPosition().x(), element.getPosition().y());
    }
}

package spacewars.view.game.elements.invaders.normal_invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class NormalInvader1Viewer implements ElementViewer<NormalInvader1> {
    private final Image image;

    public NormalInvader1Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/empire_fighter.png");
    }

    @Override
    public void draw(NormalInvader1 element, GUI gui) throws IOException {
        image.draw(gui, element.getPosition().x(), element.getPosition().y());
    }
}

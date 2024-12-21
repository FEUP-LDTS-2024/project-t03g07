package spacewars.view.game.elements.invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.Invader1;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class Invader1Viewer implements ElementViewer<Invader1> {
    private final Image image;

    public Invader1Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/empire_fighter.png");
    }

    @Override
    public void draw(Invader1 element, GUI gui) throws IOException {
       image.draw(gui,element.getPosition().x(), element.getPosition().y());
    }
}

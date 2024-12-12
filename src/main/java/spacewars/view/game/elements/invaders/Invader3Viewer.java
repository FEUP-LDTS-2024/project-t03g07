package spacewars.view.game.elements.invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.Invader3;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class Invader3Viewer implements ElementViewer<Invader3> {
    private final Image image;

    public Invader3Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/star_destroyer.png");
    }

    @Override
    public void draw(Invader3 element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

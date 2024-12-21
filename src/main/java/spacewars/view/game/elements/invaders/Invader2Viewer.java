package spacewars.view.game.elements.invaders;

import spacewars.gui.GUI;
import spacewars.model.game.elements.invaders.Invader2;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;
import spacewars.view.game.elements.ElementViewer;

import java.io.IOException;

public class Invader2Viewer implements ElementViewer<Invader2> {
    private final Image image;

    public Invader2Viewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/invaders/tie_executor.png");
    }

    @Override
    public void draw(Invader2 element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().x(), element.getPosition().y());
    }
}

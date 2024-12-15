package spacewars.view.game.elements;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Live;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class LiveViewer implements ElementViewer<Live> {
    private final Image image;

    public LiveViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("elements/lives/heart_lives.png");
    }

    @Override
    public void draw(Live element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

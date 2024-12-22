package spacewars.view.game.elements;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Element;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public abstract class AbstractElementViewer<T extends Element> implements ElementViewer<T> {
    protected final Image image;

    protected AbstractElementViewer(ImageLoader imageLoader, String imagePath) throws IOException {
        this.image = imageLoader.get(imagePath);
    }

    @Override
    public void draw(T element, GUI gui) throws IOException {
        image.draw(gui, getX(element), getY(element));
    }

    protected int getX(T element) {
        return (int)element.getPosition().x();
    }
    protected int getY(T element) {
        return (int)element.getPosition().y();
    }
}
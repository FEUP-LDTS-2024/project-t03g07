package spacewars.view.game.elements;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Player;
import spacewars.view.images.Image;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class PlayerViewer implements ElementViewer<Player> {
    private final Image image;

    public PlayerViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("millennium_falcon16x16.png");
    }

    @Override
    public void draw(Player element, GUI gui) throws IOException {
        image.draw(gui,element.getPosition().getX(), element.getPosition().getY());
    }
}

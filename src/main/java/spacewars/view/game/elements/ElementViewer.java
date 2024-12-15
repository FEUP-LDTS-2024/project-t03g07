package spacewars.view.game.elements;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Element;
import spacewars.model.game.elements.Player;

import java.io.IOException;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui) throws IOException;
}

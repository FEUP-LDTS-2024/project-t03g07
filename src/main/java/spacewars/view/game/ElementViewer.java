package spacewars.view.game;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Element;

import java.io.IOException;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui) throws IOException;
}

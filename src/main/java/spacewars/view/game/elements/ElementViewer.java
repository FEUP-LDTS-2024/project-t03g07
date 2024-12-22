package spacewars.view.game.elements;

import spacewars.gui.GUI;
import spacewars.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

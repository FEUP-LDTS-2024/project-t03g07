package spacewars.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spacewars.gui.GUI;
import spacewars.gui.LanternaGUI;
import spacewars.model.game.Game;
import spacewars.model.game.elements.Element;
import spacewars.view.Viewer;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GameViewer extends Viewer<Game> {
    public GameViewer(Game game) {
        super(game);
    }

    @Override
    protected void drawElements(GUI gui) {

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element,gui);
    }
}

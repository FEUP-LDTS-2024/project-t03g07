package spacewars.view.menus;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.menu.Entry;
import spacewars.view.texts.TextViewer;


public class EntryViewer {
    private final TextViewer textViewer;

    public EntryViewer(TextViewer textViewer) {
        this.textViewer = textViewer;
    }

    public void draw(Entry model, GUI gui, TextColor color) {
        String entryText = switch (model.getType()) {
            case PLAY-> "Play";
            case HOW_TO_PLAY -> "How to Play";
            case CREDITS -> "Credits";
            case QUIT -> "Quit";
            case RETURN_TO_MENU -> "Return to menu";
        };
        textViewer.draw(entryText, (int) model.getPosition().getX(), (int) model.getPosition().getY(), color, gui);
    }
}

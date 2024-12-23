package spacewars.view.texts;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;

public interface TextViewer {
    void draw(char character, double x, double y, TextColor foregroundColor, GUI gui);

    void draw(String string, double x, double y, TextColor foregroundColor, GUI gui);

    int getCharHeight();
}

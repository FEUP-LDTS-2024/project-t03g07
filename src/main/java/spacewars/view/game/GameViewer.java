package spacewars.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spacewars.gui.LanternaFrame;

import java.util.Random;

public class GameViewer {
    private final LanternaFrame frame;

    public GameViewer(LanternaFrame frame) {
        this.frame = frame;
    }

    public void draw() {
        int width = frame.getScreen().getTerminalSize().getColumns();
        int height = frame.getScreen().getTerminalSize().getRows();

        TextGraphics textGraphics = frame.getScreen().newTextGraphics();

        TextColor.RGB customBackgroundColor = new TextColor.RGB(0, 10, 32);
        textGraphics.setBackgroundColor(customBackgroundColor);
        textGraphics.fill(' ');

        int numberOfStars = (width * height) / 300;

        for (int i = 0; i < numberOfStars; i++) {
            int x = (i * 7) % width; // Example pattern for x
            int y = (i * 5) % height; // Example pattern for y
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setCharacter(x, y, '·');
        }
    }
}

package spacewars.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spacewars.gui.LanternaFrame;
import spacewars.model.game.Game;

import java.util.Random;

public class GameViewer
{
    public GameViewer(Game game, LanternaFrame frame)
    {
        int width = frame.getScreen().getTerminalSize().getColumns();
        int height = frame.getScreen().getTerminalSize().getRows();

        TextGraphics textGraphics = frame.getScreen().newTextGraphics();

        //set background color to #000A20
        TextColor.RGB customBackgroundColor = new TextColor.RGB(0, 10, 32);
        textGraphics.setBackgroundColor(customBackgroundColor);
        textGraphics.fill(' '); //fills the screen with the background color

        //add stars at random positions
        Random random = new Random();
        int numberOfStars = (width * height) / 200; // Approximate number of stars (density)

        for (int i = 0; i < numberOfStars; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setCharacter(x, y, '·');
        }
    }
}

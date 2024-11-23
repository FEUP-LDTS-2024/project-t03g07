package spacewars.model.game;

import spacewars.gui.LanternaFrame;

public class Game
{
    private final int width;
    private final int height;


    public Game(int width, int height)
    {
        this.width = LanternaFrame.getWIDTH();
        this.height = LanternaFrame.getHEIGHT();
    }

    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}

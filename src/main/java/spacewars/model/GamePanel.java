package spacewars.model;

import spacewars.gui.LanternaFrame;

public class GamePanel
{
    private final int width;
    private final int height;


    public GamePanel(int width, int height)
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

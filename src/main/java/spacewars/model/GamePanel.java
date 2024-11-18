package spacewars.model;

public class GamePanel
{
    //will be used in the GamePanel controller class - to be done
    private final int width;
    private final int height;

    public GamePanel(int width, int height)
    {
        this.width = width;
        this.height = height;
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

package spacewars.model;

public class Position
{
    private final int x;
    private final int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getLeft() { return x - 1; }
    public int getRight() { return x + 1; }
    public int getUp() { return y - 1; }
    public int getDown() { return y + 1; }

    public int getX()
    {
        return x;
    }
    public int getY() {
        return y;
    }
}

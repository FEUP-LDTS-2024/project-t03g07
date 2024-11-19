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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    public int getX()
    {
        return x;
    }
    public int getY() {
        return y;
    }
}

package spacewars.model;

import java.util.Objects;

public class Position
{
    private final int x;
    private final int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Position getLeft(int speed) { return new Position(x - speed,y); }
    public Position getRight(int speed) { return new Position(x + speed,y); }
    public Position getUp() { return new Position(x, y - 1); }
    public Position getDown() { return new Position( x,y+ 1); }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {         //necessary for proper equality semantics
        return Objects.hash(x, y);
    }

    public int getX()
    {
        return x;
    }
    public int getY() {
        return y;
    }
}

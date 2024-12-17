package spacewars.model;

import java.util.Objects;

public class Position
{
    private final double x;
    private final double y;

    public Position(double x, double y)
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

        if (Double.compare(position.x, x) != 0) return false;
        return Double.compare(position.y, y) == 0;
    }

    @Override
    public int hashCode() {         //necessary for proper equality semantics
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;
    }

    public double getX()
    {
        return x;
    }
    public double getY() {
        return y;
    }
}

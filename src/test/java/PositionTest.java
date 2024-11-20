import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;
import spacewars.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest
{
    @Property
    public void testGetX(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        assertEquals(x, position.getX());
    }

    @Property
    public void testGetY(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        assertEquals(y, position.getY());
    }


    @Test
    public void testEquals() {
        Position position1 = new Position(5, 5);
        Position position2 = new Position(5, 5);
        Position position3 = new Position(6, 5);
        Position position4 = new Position(5, 6);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
        assertNotEquals(position1, position4);
        assertNotEquals(null, position1);
        assertNotEquals(new Object(), position1);
    }


    @Property
    public void testGetLeft(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        Position left = position.getLeft();
        assertEquals(x - 1, left.getX());
        assertEquals(y, left.getY());
    }

    @Property
    public void testGetRight(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        Position right = position.getRight();
        assertEquals(x + 1, right.getX());
        assertEquals(y, right.getY());
    }

    @Property
    public void testGetUp(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        Position up = position.getUp();
        assertEquals(x, up.getX());
        assertEquals(y - 1, up.getY());
    }

    @Property
    public void testGetDown(@ForAll int x, @ForAll int y)
    {
        Position position = new Position(x, y);
        Position down = position.getDown();
        assertEquals(x, down.getX());
        assertEquals(y + 1, down.getY());
    }
}

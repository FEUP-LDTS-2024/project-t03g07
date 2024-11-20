import org.junit.jupiter.api.Test;
import spacewars.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest
{
    @Test
    public void testGetX()
    {
        Position position = new Position(5, 5);
        assertEquals(5, position.getX());
    }

    @Test
    public void testGetY()
    {
        Position position = new Position(5, 5);
        assertEquals(5, position.getY());
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

    @Test
    public void testGetLeft()
    {
        Position position = new Position(5, 5);
        Position left = position.getLeft();
        assertEquals(4, left.getX());
        assertEquals(5, left.getY());
    }

    @Test
    public void testGetRight()
    {
        Position position = new Position(5, 5);
        Position right = position.getRight();
        assertEquals(6, right.getX());
        assertEquals(5, right.getY());
    }

    @Test
    public void testGetUp()
    {
        Position position = new Position(5, 5);
        Position up = position.getUp();
        assertEquals(5, up.getX());
        assertEquals(4, up.getY());
    }

    @Test
    public void testGetDown()
    {
        Position position = new Position(5, 5);
        Position down = position.getDown();
        assertEquals(5, down.getX());
        assertEquals(6, down.getY());
    }

    @Test
    public void testGetLeftEdgeCase() {
        Position position = new Position(Integer.MIN_VALUE, 5);
        Position left = position.getLeft();
        assertEquals(Integer.MIN_VALUE - 1, left.getX());
        assertEquals(5, left.getY());
    }

    @Test
    public void testGetRightEdgeCase() {
        Position position = new Position(Integer.MAX_VALUE, 5);
        Position right = position.getRight();
        assertEquals(Integer.MAX_VALUE + 1, right.getX());
        assertEquals(5, right.getY());
    }

    @Test
    public void testGetUpEdgeCase() {
        Position position = new Position(5, Integer.MIN_VALUE);
        Position up = position.getUp();
        assertEquals(5, up.getX());
        assertEquals(Integer.MIN_VALUE - 1, up.getY());
    }

    @Test
    public void testGetDownEdgeCase() {
        Position position = new Position(5, Integer.MAX_VALUE);
        Position down = position.getDown();
        assertEquals(5, down.getX());
        assertEquals(Integer.MAX_VALUE + 1, down.getY());
    }
}

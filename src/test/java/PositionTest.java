import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Property
    void equalsAndHash(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x, y);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Property
    void equalsDifferentX(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x + 1, y);
        assertFalse(p1.equals(p2));
    }

    @Property
    void equalsDifferentY(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x, y + 1);
        assertFalse(p1.equals(p2));
    }

    @Property
    void equalsSameObject(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        assertTrue(p1.equals(p1));
    }

    @Property
    void equalsNullObject(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        assertFalse(p1.equals(null));
    }

    @Property
    void equalsDifferentClass(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        String notAPosition = "Not a Position";
        assertFalse(p1.equals(notAPosition));
    }

    @Property
    void equalsDifferentValues(@ForAll int x, @ForAll int y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x + 1, y + 1);
        assertFalse(p1.equals(p2));
    }


}
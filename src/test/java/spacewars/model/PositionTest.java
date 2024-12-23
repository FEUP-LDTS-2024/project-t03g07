package spacewars.model;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {

    @Provide
    Arbitrary<Position> differentPositions() {
        return Arbitraries.doubles()
                .between(-1e6, 1e6) // Ensure large range to minimize collisions
                .filter(x -> !Double.isNaN(x)) // Exclude NaN values
                .tuple2()
                .filter(tuple -> !tuple.get1().equals(tuple.get2())) // Ensure distinct x and y
                .map(tuple -> new Position(tuple.get1(), tuple.get2()));
    }

    @Property
    void testEqualsAndHashCode(@ForAll double x, @ForAll double y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x, y);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Property
    void testNotEquals(@ForAll("differentPositions") Position p1, @ForAll("differentPositions") Position p2) {
        if (p1.x() != p2.x() || p1.y() != p2.y()) {
            assertNotEquals(p1, p2);
        }

        // Ensure positions with one coordinate different are not equal
        Position sameXDifferentY = new Position(p1.x(), p1.y() + 1.0);
        Position sameYDifferentX = new Position(p1.x() + 1.0, p1.y());

        assertNotEquals(p1, sameXDifferentY);
        assertNotEquals(p1, sameYDifferentX);
    }

    @Property
    void testSpecialFloatingPointNotEquals() {
        Position nanPosition = new Position(Double.NaN, Double.NaN);
        Position posInfPosition = new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Position negInfPosition = new Position(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

        assertNotEquals(nanPosition, posInfPosition);
        assertNotEquals(nanPosition, negInfPosition);
        assertNotEquals(posInfPosition, negInfPosition);
    }

    @Test
    void testSpecialFloatingPointValues() {
        Position nanPosition = new Position(Double.NaN, Double.NaN);
        Position posInfPosition = new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Position negInfPosition = new Position(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

        assertNotEquals(nanPosition, posInfPosition);
        assertNotEquals(nanPosition, negInfPosition);
        assertNotEquals(posInfPosition, negInfPosition);
    }

    @Test
    void testEqualsSameObject() {
        Position p = new Position(1.0, 2.0);
        assertEquals(p, p);
    }

    @Test
    void testEqualsNull() {
        Position p = new Position(1.0, 2.0);
        assertNotEquals(null, p);
    }

    @Test
    void testEqualsDifferentClass() {
        Position p = new Position(1.0, 2.0);
        String other = "not a Position";
        assertNotEquals(other, p);
    }

    @Property
    void testHashCodeConsistency(@ForAll double x, @ForAll double y) {
        Position p1 = new Position(x, y);
        Position p2 = new Position(x, y);

        // Assert that equal positions have the same hash code
        assertEquals(p1.hashCode(), p2.hashCode());

        // Test that unequal positions have different hash codes (where possible)
        Position differentX = new Position(x + 1.0, y);
        Position differentY = new Position(x, y + 1.0);

        if (!p1.equals(differentX)) {
            assertNotEquals(p1.hashCode(), differentX.hashCode());
        }
        if (!p1.equals(differentY)) {
            assertNotEquals(p1.hashCode(), differentY.hashCode());
        }
    }

    @Test
    void testSpecialFloatingPointHashCode() {
        // NaN cases
        Position nanPosition1 = new Position(Double.NaN, Double.NaN);
        Position nanPosition2 = new Position(Double.NaN, Double.NaN);
        assertEquals(nanPosition1.hashCode(), nanPosition2.hashCode(), "NaN hashCodes do not match");

        // Infinity cases
        Position infPosition = new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Position negInfPosition = new Position(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        assertNotEquals(infPosition.hashCode(), negInfPosition.hashCode(), "Infinity hashCodes should not match");

        // Mixed infinity cases
        Position mixedInfinity1 = new Position(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Position mixedInfinity2 = new Position(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertNotEquals(mixedInfinity1.hashCode(), mixedInfinity2.hashCode(), "Mixed infinity hashCodes should not match");
    }

}

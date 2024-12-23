package spacewars.model.game.elements.invaders;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BossInvaderTest {
    @Property
    void BossInvaderPositionTest(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        assertEquals(x, bossInvader.getPosition().x());
        assertEquals(y, bossInvader.getPosition().y());
    }

    @Property
    void testGetPointsConsistency(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        int initialPoints = bossInvader.getPoints();
        assertEquals(initialPoints, bossInvader.getPoints(), "getPoints should consistently return the same value");
    }

    @Property
    void testGetPointsNeverReturnsZero(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        assertNotEquals(0, bossInvader.getPoints(), "getPoints should never return 0");
    }

    @Property
    void testGetSizeConsistency(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        assertEquals(16, bossInvader.getSize(), "BossInvader size should always be 16");
    }

    @Property
    void testIsAlive(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        assertTrue(bossInvader.isAlive());
    }

    @Property
    void testToggleAliveState(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);

        bossInvader.setAlive(false);
        assertFalse(bossInvader.isAlive(), "Boss should be dead after setAlive(false)");

        bossInvader.setAlive(true);
        assertTrue(bossInvader.isAlive(), "Boss should be alive after setAlive(true)");
    }


    @Property
    void testGetRandomPointsDistribution(@ForAll int x, @ForAll int y) {
        BossInvader bossInvader = new BossInvader(x, y);
        int[] counts = new int[5];
        int iterations = 10000;

        // Collect results over many iterations
        for (int i = 0; i < iterations; i++) {
            int points = bossInvader.getRandomPoints();
            switch (points) {
                case 75 -> counts[0]++;
                case 100 -> counts[1]++;
                case 250 -> counts[2]++;
                case 500 -> counts[3]++;
                case 999 -> counts[4]++;
                default -> fail("Unexpected points value: " + points);
            }
        }

        // Validate approximate probabilities
        assertTrue(counts[0] > counts[1]); // 0.5 > 0.2
        assertTrue(counts[1] > counts[2]); // 0.2 > 0.15
        assertTrue(counts[2] > counts[3]); // 0.15 > 0.1
        assertTrue(counts[3] > counts[4]); // 0.1 > 0.05
    }

    //the fallback behavior is nearly impossible to test due to the nature of randomness and rounding errors.
    //the mutation in PIT is "unavoidable" due to limitations in the testability of the code.

}

package spacewars.controller.game.elements.Invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spacewars.controller.game.elements.invaders.BossInvaderController;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.BossInvader;

import static org.mockito.Mockito.*;

class BossInvaderControllerTest {

    private BossInvader bossInvader;
    private BossInvaderController controller;

    @BeforeEach
    public void setUp() {
        bossInvader = mock(BossInvader.class);
        when(bossInvader.getSize()).thenReturn(50);
        when(bossInvader.getPosition()).thenReturn(new Position(0, 0));
        controller = new BossInvaderController(bossInvader, 320);
    }

    @Test
    public void testInitialPosition() {
        verify(bossInvader, times(1)).setPosition(new Position(-bossInvader.getSize(), 0));
    }

    @Test
    public void testMoveRight() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(0, 0));

        controller.moveBoss(6000); // Beyond wait duration

        verify(bossInvader, times(1)).setPosition(new Position(2, 0)); // Moves right by 2
    }

    /*@Test
    public void testMoveLeft() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(320, 0));

        controller.moveBoss(6000); // Beyond wait duration
        when(bossInvader.getPosition()).thenReturn(new Position(320, 0)); // Update position after move
        controller.moveBoss(8000); // Continue moving left

        verify(bossInvader, times(1)).setPosition(new Position(318, 0)); // Moves left by 2
    }

    @Test
    public void testRespawnAfterDeath() {
        when(bossInvader.isAlive()).thenReturn(false);

        controller.moveBoss(4000); // Before respawn time
        verify(bossInvader, never()).setAlive(true);

        controller.moveBoss(7000); // After respawn time
        verify(bossInvader, times(1)).setAlive(true);
        verify(bossInvader, times(1)).setPosition(new Position(-bossInvader.getSize(), 0));
    }

    @Test
    public void testWaitBeforeMoving() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(320, 0));

        controller.moveBoss(0); // Start waiting
        controller.moveBoss(4000); // Still waiting
        verify(bossInvader, never()).setPosition(any()); // No movement during wait period

        controller.moveBoss(6000); // Beyond wait duration
        verify(bossInvader, times(1)).setPosition(new Position(318, 0)); // Starts moving left
    }

    @Test
    public void testOffScreenDeath() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(-60, 0));
        when(bossInvader.getSize()).thenReturn(50);

        controller.moveBoss(0);
        verify(bossInvader, times(1)).setAlive(false); // Goes off-screen and dies

        controller.moveBoss(3000); // Trigger respawn logic
        verify(bossInvader, never()).setAlive(true);
    }

    @Test
    public void testChangeDirectionAtRightEdge() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(320, 0));

        controller.moveBoss(6000); // Beyond wait duration
        verify(bossInvader, times(1)).setPosition(new Position(318, 0)); // Starts moving left
    }*/
}
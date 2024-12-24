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

    @Test
    public void testSwitchDirectionAtScreenEdge() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(320, 0)); // At screen edge

        controller.moveBoss(6000); // Beyond wait duration

        // Check that setPosition was not called to move the boss, only to reset position if applicable
        verify(bossInvader, times(0)).setPosition(new Position(322, 0)); // No rightward move
    }

    @Test
    public void testSequenceOfMovements() {
        when(bossInvader.isAlive()).thenReturn(true);
        when(bossInvader.getPosition()).thenReturn(new Position(0, 0));

        controller.moveBoss(6000); // Beyond wait duration
        verify(bossInvader, times(1)).setPosition(new Position(2, 0));

        when(bossInvader.getPosition()).thenReturn(new Position(2, 0));
        controller.moveBoss(7000); // Next move
        verify(bossInvader, times(1)).setPosition(new Position(4, 0));
    }
}
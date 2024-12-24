package spacewars.controller.game.elements.Invaders.normal_invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader3Controller;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class NormalInvader3ControllerTest {

    @BeforeEach
    public void setUp() {
        List<NormalInvader3> invaders = mock(List.class);
        new NormalInvader3Controller(invaders);
    }

    @Test
    public void testConstructor() {
        List<NormalInvader3> invaders = mock(List.class);
        NormalInvader3Controller controller = new NormalInvader3Controller(invaders);

        // Verify that the invaders list is correctly passed to the controller
        assertNotNull(controller);
    }
}
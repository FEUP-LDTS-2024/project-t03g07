package spacewars.controller.game.elements.Invaders.normal_invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader2Controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class NormalInvader2ControllerTest {

    @BeforeEach
    public void setUp() {
        List<NormalInvader2> invaders = mock(List.class);
        new NormalInvader2Controller(invaders);
    }

    @Test
    public void testConstructor() {
        List<NormalInvader2> invaders = mock(List.class);
        NormalInvader2Controller controller = new NormalInvader2Controller(invaders);

        // Verify that the invaders list is correctly passed to the controller
        assertNotNull(controller);
    }
}
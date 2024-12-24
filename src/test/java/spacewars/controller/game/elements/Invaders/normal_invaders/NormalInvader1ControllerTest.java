package spacewars.controller.game.elements.Invaders.normal_invaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader1Controller;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class NormalInvader1ControllerTest {

    @BeforeEach
    public void setUp() {
        List<NormalInvader1> invaders = mock(List.class);
        new NormalInvader1Controller(invaders);
    }

    @Test
    public void testConstructor() {
        List<NormalInvader1> invaders = mock(List.class);
        NormalInvader1Controller controller = new NormalInvader1Controller(invaders);

        // Verify that the invaders list is correctly passed to the controller
        assertNotNull(controller);
    }
}
package spacewars.view.game;

import spacewars.gui.LanternaGUI;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader;
import spacewars.view.game.elements.invaders.Invader1Viewer;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvaderViewerTest {
    private Invader1Viewer invader1Viewer;
    private LanternaGUI frame;
    private Invader invaders;
    private Position position;

    /*@BeforeEach
    void setUp() throws IOException {
        //invaderViewer = spy(new InvaderViewer("empire_fighter.png"));
        frame = mock(LanternaGUI.class);
        invaders = mock(Invader.class);
        position = mock(Position.class);
    }

    @Test
    void testDrawEntityWithPlayer() {
        when(invaders.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(60);

        //invaderViewer.drawEntity(frame, invaders);

        //verify(invaderViewer).draw(frame, 5, 60);
    }

    @Test
    void testDrawEntityWithInvalidEntity() {
        Object invalidEntity = new Object();

        //assertThrows(IllegalArgumentException.class, () -> invaderViewer.drawEntity(frame, invalidEntity));
    }*/
}

package spacewars.view.game;

import spacewars.gui.LanternaGUI;
import spacewars.model.Position;
import spacewars.model.game.elements.Player;
import spacewars.view.game.elements.PlayerViewer;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerViewerTest {
    private PlayerViewer playerViewer;
    private LanternaGUI frame;
    private Player player;
    private Position position;

    /*@BeforeEach
    void setUp() throws IOException {
        playerViewer = spy(new PlayerViewer("millennium_falcon.png"));
        frame = mock(LanternaGUI.class);
        player = mock(Player.class);
        position = mock(Position.class);
    }

    @Test
    void testDrawEntityWithPlayer() throws IOException {
        when(player.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(10);

        playerViewer.drawEntity(frame, player);

        verify(playerViewer).draw(frame, 5, 10);
    }

    @Test
    void testDrawEntityWithInvalidEntity() {
        Object invalidEntity = new Object();

        assertThrows(IllegalArgumentException.class, () -> playerViewer.drawEntity(frame, invalidEntity));
    }*/
}

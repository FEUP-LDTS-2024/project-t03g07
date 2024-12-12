package spacewars.view.game;

import spacewars.gui.LanternaGUI;
import spacewars.model.Position;
import spacewars.model.game.elements.bullets.Bullet;
import spacewars.view.game.elements.bullets.BulletPlayerViewer;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BulletViewerTest {
    private LanternaGUI frame;
    private BulletPlayerViewer bulletPlayerViewer;
    private Position position;
    private Bullet bullet;


    /*@BeforeEach
    public void setup() throws IOException {
        frame = mock(LanternaGUI.class);
        bulletViewer = spy(new BulletViewer("bullet_1.png"));
        position = mock(Position.class);
        bullet = mock(Bullet.class);
    }*/

    /*@Test
    public void testDrawEntityWithBullet() {
        when(bullet.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(15);

        bulletViewer.drawEntity(frame, bullet);

        verify(bulletViewer).draw(frame, 5, 15);
    }*/

    /*@Test
    void testDrawEntityWithInvalidEntity() {
        Object invalidEntity = new Object();

        assertThrows(IllegalArgumentException.class, () -> bulletViewer.drawEntity(frame, invalidEntity));
    }*/
}

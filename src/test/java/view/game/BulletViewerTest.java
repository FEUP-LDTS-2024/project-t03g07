package view.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.LanternaFrame;
import spacewars.model.Position;
import spacewars.view.game.BulletViewer;
import spacewars.model.game.elements.bullets.Bullet;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BulletViewerTest {
    private LanternaFrame frame;
    private BulletViewer bulletViewer;
    private Position position;
    private Bullet bullet;


    @BeforeEach
    public void setup() throws IOException {
        frame = mock(LanternaFrame.class);
        bulletViewer = spy(new BulletViewer("bullet_1.png"));
        position = mock(Position.class);
        bullet = mock(Bullet.class);
    }

    @Test
    public void testDrawEntityWithBullet() {
        when(bullet.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(5);
        when(position.getY()).thenReturn(10);

        bulletViewer.drawEntity(frame, bullet);

        verify(bulletViewer).draw(frame, 5, 10);
    }

    @Test
    void testDrawEntityWithInvalidEntity() {
        Object invalidEntity = new Object();

        assertThrows(IllegalArgumentException.class, () -> bulletViewer.drawEntity(frame, invalidEntity));
    }
}

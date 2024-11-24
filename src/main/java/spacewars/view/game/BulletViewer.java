package spacewars.view.game;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.elements.bullets.Bullet;
import spacewars.view.Viewer;

import java.io.IOException;

public class BulletViewer extends Viewer {
    public BulletViewer(String filepath) throws IOException {
        super(filepath);
    }

    @Override
    public void drawEntity(LanternaFrame frame, Object entity) {
        if (entity instanceof Bullet bullet) {
            draw(frame, bullet.getPosition().getX(), bullet.getPosition().getY());
        } else {
            throw new IllegalArgumentException("Invalid entity type");
        }
    }
}

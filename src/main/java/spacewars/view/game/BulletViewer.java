package spacewars.view.game;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.elements.bullets.Bullet;
import spacewars.view.Viewer;

import java.io.IOException;

public class BulletViewer extends Viewer
{
    public BulletViewer(String filepath) throws IOException {
        super(filepath);
    }

    public void drawBullet(LanternaFrame frame, Bullet bullet) throws IOException
    {
        draw(frame, bullet.getPosition().getX(), bullet.getPosition().getY());
    }
}

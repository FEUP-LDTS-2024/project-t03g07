package spacewars.view;

import spacewars.gui.LanternaFrame;
import spacewars.model.bullets.Bullet;

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

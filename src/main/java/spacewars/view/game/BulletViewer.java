package spacewars.view.game;

import spacewars.gui.GUI;
import spacewars.gui.LanternaGUI;
import spacewars.model.game.elements.bullets.Bullet;

import java.io.IOException;

public class BulletViewer implements ElementViewer<Bullet> {
    @Override
    public void draw(Bullet bullet, GUI gui) throws IOException
    {
        gui.drawBullet(bullet.getPosition());
    }
}

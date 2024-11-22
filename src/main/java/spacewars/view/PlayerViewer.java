package spacewars.view;

import spacewars.gui.LanternaFrame;
import spacewars.model.elements.Player;

import java.io.IOException;

public class PlayerViewer extends Viewer
{
    public PlayerViewer(String filepath) throws IOException {
        super(filepath);
    }

    public void drawPlayer(LanternaFrame frame, Player player) throws IOException
    {
        draw(frame, player.getPosition().getX(), player.getPosition().getY());
    }
}

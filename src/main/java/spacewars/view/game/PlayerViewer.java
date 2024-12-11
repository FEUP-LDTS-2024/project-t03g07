package spacewars.view.game;

import spacewars.gui.GUI;
import spacewars.gui.LanternaGUI;
import spacewars.model.game.elements.Player;

import java.io.IOException;

public class PlayerViewer implements ElementViewer<Player> {
   public void drawEntity(LanternaGUI frame, Object entity) throws IOException {
        if (entity instanceof Player player) {
            //draw(frame, player.getPosition().getX(), player.getPosition().getY());
            frame.refresh();
        } else {
            throw new IllegalArgumentException("Invalid entity type");
        }
    }
    @Override
    public void draw(Player player, GUI gui) throws IOException
    {
        gui.drawPlayer(player.getPosition());
    }
}

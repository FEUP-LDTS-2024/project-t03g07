package spacewars.view.game;

import spacewars.gui.LanternaFrame;
import spacewars.model.game.elements.Player;
import spacewars.view.Viewer;

import java.io.IOException;

public class PlayerViewer extends Viewer {
    public PlayerViewer(String filepath) throws IOException {
        super(filepath);
    }

    @Override
    public void drawEntity(LanternaFrame frame, Object entity) {
        if (entity instanceof Player player) {
            draw(frame, player.getPosition().getX(), player.getPosition().getY());
        } else {
            throw new IllegalArgumentException("Invalid entity type");
        }
    }
}

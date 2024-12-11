package spacewars.view.game;

import spacewars.gui.LanternaGUI;
import spacewars.model.game.elements.invaders.Invader;
import spacewars.view.Viewer;

import java.io.IOException;

public class InvaderViewer extends Viewer {
    public InvaderViewer(String filepath) throws IOException {
        super(filepath);
    }

    @Override
    public void drawEntity(LanternaGUI frame, Object entity) {
        if (entity instanceof Invader invader) {
            draw(frame, invader.getPosition().getX(), invader.getPosition().getY());
        } else {
            throw new IllegalArgumentException("Invalid entity type");
        }
    }
}

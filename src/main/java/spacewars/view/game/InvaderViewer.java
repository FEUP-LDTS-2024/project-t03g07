package spacewars.view.game;

import spacewars.gui.GUI;
import spacewars.gui.LanternaGUI;
import spacewars.model.game.elements.invaders.Invader;
import spacewars.view.Viewer;

import java.io.IOException;

public class InvaderViewer implements ElementViewer<Invader> {
    @Override
    public void draw(Invader invader, GUI gui) throws IOException {
        gui.drawInvader(invader.getPosition());
    }
}

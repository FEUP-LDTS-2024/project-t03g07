package spacewars.view;

import spacewars.gui.LanternaFrame;
import spacewars.model.elements.invaders.Invader;

import java.io.IOException;

public class InvaderViewer extends Viewer
{
    public InvaderViewer(String filepath) throws IOException {
        super(filepath);
    }

    public void drawInvader(LanternaFrame frame, Invader invader) throws IOException
    {
        draw(frame, invader.getPosition().getX(), invader.getPosition().getY());
    }
}

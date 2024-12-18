package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.invaders.Invader;
import spacewars.model.game.elements.invaders.Invader1;

import java.io.IOException;

public class InvaderController extends GameController {

    public InvaderController(Game game) {
        super(game);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
    }

}



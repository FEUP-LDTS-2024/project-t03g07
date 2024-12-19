package spacewars.controller.game.elements.invaders;

import spacewars.Application;
import spacewars.controller.game.GameController;
import spacewars.gui.GUI;
import spacewars.model.game.Game;

import java.io.IOException;

public class InvaderController extends GameController {

    public InvaderController(Game game) {
        super(game);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
    }

}



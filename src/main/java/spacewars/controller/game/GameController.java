package spacewars.controller.game;

import spacewars.controller.Controller;
import spacewars.model.game.Game;

public abstract class GameController extends Controller<Game> {
    public GameController(Game game) {
        super(game);
    }
}

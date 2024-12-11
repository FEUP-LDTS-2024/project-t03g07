package spacewars.controller.game;

import spacewars.controller.Controller;
import spacewars.model.game.Game;


public abstract class GameController extends Controller<Game> {
    private final PlayerController playerController;
    private final InvaderController invaderController;


    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
        this.invaderController = new InvaderController(game);
    }
}

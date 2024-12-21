package spacewars.controller.game.elements;

import spacewars.model.Position;
import spacewars.model.game.Game;

public class CollisionDetector {

    public static boolean collidesLeft(Game game, Position position, int size) {
        return game.collidesLeft(position, size);
    }

    public static boolean collidesRight(Game game, Position position, int size) {
        return game.collidesRight(position, size);
    }
}
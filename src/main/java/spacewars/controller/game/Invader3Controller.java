package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader2;
import spacewars.model.game.elements.invaders.Invader3;

import java.util.List;

public class Invader3Controller {
    private final List<Invader3> invaders3;
    private int direction = -1; // Start moving left (-1)

    public Invader3Controller(List<Invader3> invaders3) {
        this.invaders3 = invaders3;
    }

    public void moveInvaders3() {
        boolean collisionDetected = false;

        for (Invader3 invader3 : invaders3) {
            Position newPosition = calculateNewPosition(invader3);

            // Check for collisions
            if (collides(invader3, newPosition)) {
                collisionDetected = true;
                break;
            }
        }

        // Reverse direction if any invader collides
        if (collisionDetected) {
            direction = -direction;
        } else {
            // Move all invaders to their new positions
            for (Invader3 invader3 : invaders3) {
                Position newPosition = calculateNewPosition(invader3);
                invader3.setPosition(newPosition);
            }
        }
    }

    private Position calculateNewPosition(Invader3 invader3) {
        double x = invader3.getPosition().getX();
        double y = invader3.getPosition().getY();
        return new Position(x + direction, y);
    }

    private boolean collides(Invader3 invader3, Position newPosition) {
        return (direction < 0 && invader3.getGame().collidesLeft(newPosition, invader3.getInvader3Size())) ||
                (direction > 0 && invader3.getGame().collidesRight(newPosition, invader3.getInvader3Size()));
    }
}

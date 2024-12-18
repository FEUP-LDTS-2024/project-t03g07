package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader2;

import java.util.List;

public class Invader2Controller {
    private final List<Invader2> invaders2;
    private double direction = -0.5; // Start moving left (-0.5)

    public Invader2Controller(List<Invader2> invaders2) {
        this.invaders2 = invaders2;
    }

    public void moveInvaders2() {
        boolean collisionDetected = false;

        for (Invader2 invader2 : invaders2) {
            Position newPosition = calculateNewPosition(invader2);

            // Check for collisions
            if (collides(invader2, newPosition)) {
                collisionDetected = true;
                break;
            }
        }

        // Reverse direction if any invader collides
        if (collisionDetected) {
            direction = -direction;
        } else {
            // Move all invaders to their new positions
            for (Invader2 invader2 : invaders2) {
                Position newPosition = calculateNewPosition(invader2);
                invader2.setPosition(newPosition);
            }
        }
    }

    private Position calculateNewPosition(Invader2 invader2) {
        double x = invader2.getPosition().getX();
        double y = invader2.getPosition().getY();
        return new Position(x + direction, y);
    }

    private boolean collides(Invader2 invader2, Position newPosition) {
        return (direction < 0 && invader2.getGame().collidesLeft(newPosition, invader2.getInvader2Size())) ||
                (direction > 0 && invader2.getGame().collidesRight(newPosition, invader2.getInvader2Size()));
    }
}

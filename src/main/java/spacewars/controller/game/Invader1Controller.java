package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader1;

import java.util.List;

public class Invader1Controller {
    private final List<Invader1> invaders1;
    private double direction = -0.5; // Start moving left (-0.5)

    public Invader1Controller(List<Invader1> invaders1) {
        this.invaders1 = invaders1;
    }

    public void moveInvaders1() {
        boolean collisionDetected = false;

        for (Invader1 invader1 : invaders1) {
            Position newPosition = calculateNewPosition(invader1);

            // Check for collisions
            if (collides(invader1, newPosition)) {
                collisionDetected = true;
                break;
            }
        }

        // Reverse direction if any invader collides
        if (collisionDetected) {
            direction = -direction;
        } else {
            // Move all invaders to their new positions
            for (Invader1 invader1 : invaders1) {
                Position newPosition = calculateNewPosition(invader1);
                invader1.setPosition(newPosition);
            }
        }
    }

    private Position calculateNewPosition(Invader1 invader1) {
        double x = invader1.getPosition().getX();
        double y = invader1.getPosition().getY();
        return new Position(x + direction, y);
    }

    private boolean collides(Invader1 invader1, Position newPosition) {
        return (direction < 0 && invader1.getGame().collidesLeft(newPosition, invader1.getInvader1Size())) ||
                (direction > 0 && invader1.getGame().collidesRight(newPosition, invader1.getInvader1Size()));
    }
}

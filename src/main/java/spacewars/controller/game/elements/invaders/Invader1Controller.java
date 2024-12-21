package spacewars.controller.game.elements.invaders;

import spacewars.controller.game.elements.CollisionDetector;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader1;

import java.util.List;

public class Invader1Controller implements RespawnObserver {
    private final List<Invader1> invaders1;
    private double direction;

    public Invader1Controller(List<Invader1> invaders1) {
        this.invaders1 = invaders1;
        this.direction = -0.5; // Start moving left (-0.5)
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
        double x = invader1.getPosition().x();
        double y = invader1.getPosition().y();
        return new Position(x + direction * invader1.getSpeed(), y);
    }

    private boolean collides(Invader1 invader1, Position newPosition) {
        return (direction < 0 && CollisionDetector.collidesLeft(invader1.getGame(), newPosition, invader1.getInvader1Size()) ||
                (direction > 0 && CollisionDetector.collidesRight(invader1.getGame(), newPosition, invader1.getInvader1Size())));
    }

    @Override
    public void onRespawn() {
        for (Invader1 invader1 : invaders1) {  // Iterate and update individual speeds
            invader1.setSpeed(invader1.getSpeed() + 1.0); // Increase individual speed
        }
        direction = -0.5;
    }

}

package spacewars.controller.game.elements.invaders;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.Invader3;

import java.util.List;

public class Invader3Controller implements RespawnObserver {

    private final List<Invader3> invaders3;
    private double direction;

    public Invader3Controller(List<Invader3> invaders3) {
        this.invaders3 = invaders3;
        this.direction = -0.5; // Start moving left (-0.5)
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
        return new Position(x + direction * invader3.getSpeed(), y);
    }

    private boolean collides(Invader3 invader3, Position newPosition) {
        return (direction < 0 && invader3.getGame().collidesLeft(newPosition, invader3.getInvader3Size())) ||
                (direction > 0 && invader3.getGame().collidesRight(newPosition, invader3.getInvader3Size()));
    }

    @Override
    public void onRespawn() {
        for (Invader3 invader3 : invaders3) {  // Iterate and update individual speeds
            invader3.setSpeed(invader3.getSpeed() + 1.0); // Increase individual speed
        }
        direction = -0.5;
    }
}

package spacewars.controller.game.elements.invaders.normal_invaders;

import spacewars.controller.game.elements.CollisionDetector;
import spacewars.model.Position;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader;

import java.util.List;

public abstract class NormalInvaderController<T extends NormalInvader> implements RespawnObserver {
    protected final List<T> invaders;
    public double direction;

    public NormalInvaderController(List<T> invaders) {
        this.invaders = invaders;
        this.direction = -0.5; // Start moving left (-0.5)
    }

    public void moveInvaders() {
        boolean collisionDetected = false;

        for (T invader : invaders) {
            Position newPosition = calculateNewPosition(invader);

            // Check for collisions
            if (collides(invader, newPosition)) {
                collisionDetected = true;
                break;
            }
        }

        // Reverse direction if any invader collides
        if (collisionDetected) {
            direction = -direction;
        } else {
            // Move all invaders to their new positions
            for (T invader : invaders) {
                Position newPosition = calculateNewPosition(invader);
                invader.setPosition(newPosition);
            }
        }
    }

    public Position calculateNewPosition(T invader) {
        double x = invader.getPosition().x();
        double y = invader.getPosition().y();
        return new Position(x + direction * invader.getSpeed(), y);
    }

    protected boolean collides(T invader, Position newPosition) {
        return (direction < 0 && CollisionDetector.collidesLeft(invader.getGame(), newPosition, invader.getSize()) ||
                (direction > 0 && CollisionDetector.collidesRight(invader.getGame(), newPosition, invader.getSize())));
    }

    @Override
    public void onRespawn() {
        for (T invader : invaders) {  // Iterate and update individual speeds
            invader.setSpeed(invader.getSpeed() + 1.0); // Increase individual speed
        }
        direction = -0.5;
    }
}
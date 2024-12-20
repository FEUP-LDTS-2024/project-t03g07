package spacewars.controller.game.elements.invaders;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.BossInvader;

public class BossInvaderController {
    private final BossInvader bossInvader;
    private final int screenWidth;
    private final int speed = 2;
    private boolean movingRight = true;
    private long waitStartTime = 0;
    private final long WAIT_DURATION = 5000; // 1 second wait
    private long respawnTime = 0;
    private final long RESPAWN_DURATION = 3000;  // 3 seconds respawn time


    public BossInvaderController(BossInvader bossInvader, int screenWidth) {
        this.bossInvader = bossInvader;
        this.screenWidth = screenWidth;
        resetBossPosition();
    }


    public void moveBoss(long currentTime) {

        if (!bossInvader.isAlive()) {
            if (currentTime - respawnTime >= RESPAWN_DURATION) {
                bossInvader.setAlive(true);
                resetBossPosition();
            }
            return; // Don't move if dead and respawning
        }


        double x = bossInvader.getPosition().getX();

        if (movingRight) {
            if (x >= screenWidth) {  // Goes completely off-screen
                movingRight = false;
                waitStartTime = currentTime;
            }
        } else {  // Moving left
            if (x + bossInvader.getSize() <= 0) { // Goes completely off-screen
                movingRight = true;
                waitStartTime = currentTime;
                respawnTime = currentTime; // Start respawn timer when off-screen left
                bossInvader.setAlive(false); // Set to dead to trigger respawn logic
            }
        }


        if (currentTime - waitStartTime >= WAIT_DURATION) {
            int dx = movingRight ? speed : -speed;
            Position newPosition = new Position(x + dx, bossInvader.getPosition().getY());
            bossInvader.setPosition(newPosition);
        }


    }

    private void resetBossPosition() {
        movingRight = true;
        bossInvader.setPosition(new Position(-bossInvader.getSize(), bossInvader.getPosition().getY()));
    }



    public BossInvader getBossInvader() {
        return bossInvader;
    }

}
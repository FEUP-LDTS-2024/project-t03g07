package spacewars.controller.game.elements.invaders;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.BossInvader;

public class BossInvaderController {
    private final BossInvader bossInvader;
    private boolean movingRight = true;
    private long waitStartTime = 0;
    private long respawnTime = 0;


    public BossInvaderController(BossInvader bossInvader, int screenWidth) {
        this.bossInvader = bossInvader;
        resetBossPosition();
    }

    public void moveBoss(long currentTime) {

        if (!bossInvader.isAlive()) {
            long RESPAWN_DURATION = 3000;
            if (currentTime - respawnTime >= RESPAWN_DURATION) {
                bossInvader.setAlive(true);
                resetBossPosition();
            }
            return; //Don't move if dead and respawning
        }

        double x = bossInvader.getPosition().x();

        if (movingRight) {
            if (x >= 320) {  //Goes completely off-screen
                movingRight = false;
                waitStartTime = currentTime;
            }
        } else {  //Moving left
            if (x + bossInvader.getSize() <= 0) { //Goes completely off-screen
                movingRight = true;
                waitStartTime = currentTime;
                respawnTime = currentTime;      //Start respawn timer
                bossInvader.setAlive(false);    //Set to dead to trigger respawn logic
            }
        }

        long WAIT_DURATION = 5000;
        if (currentTime - waitStartTime >= WAIT_DURATION) {
            double speed = 2;
            double dx = movingRight ? speed : -speed;
            Position newPosition = new Position(x + dx, bossInvader.getPosition().y());
            bossInvader.setPosition(newPosition);
        }

    }

    void resetBossPosition() {
        movingRight = true;
        bossInvader.setPosition(new Position(-bossInvader.getSize(), bossInvader.getPosition().y()));
    }

}
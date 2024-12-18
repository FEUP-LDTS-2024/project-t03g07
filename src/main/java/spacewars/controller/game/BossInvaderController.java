package spacewars.controller.game;

import spacewars.model.Position;
import spacewars.model.game.elements.invaders.BossInvader;

public class BossInvaderController {
    private final BossInvader bossInvader;
    private final int screenWidth;
    private final int speed = 2;
    private long lastAppearanceTime;
    private static final long REAPPEAR_INTERVAL = 5000; // Time in milliseconds (30 seconds)

    public BossInvaderController(BossInvader bossInvader, int screenWidth) {
        this.bossInvader = bossInvader;
        this.screenWidth = screenWidth;
        this.lastAppearanceTime = System.currentTimeMillis() - REAPPEAR_INTERVAL;
        resetBossPosition();
    }

    public void moveBoss(long currentTime) {
        if (bossInvader.getPosition().getX() > screenWidth || bossInvader.isHidden()) {
            if (currentTime - lastAppearanceTime >= REAPPEAR_INTERVAL) {
                resetBossPosition();
                lastAppearanceTime = currentTime;
            }
            return;
        }

        // Move the boss to the right if not hidden
        Position newPosition = new Position(
                bossInvader.getPosition().getX() + speed,
                bossInvader.getPosition().getY()
        );
        bossInvader.setPosition(newPosition);
    }

    private void resetBossPosition() {
        // Reset the boss's position to the left side of the screen and make it visible again
        bossInvader.setPosition(new Position(-bossInvader.getSize(), bossInvader.getPosition().getY()));
        bossInvader.setHidden(false);
    }
}

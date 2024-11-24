package spacewars.model.game.elements.invaders;

import java.util.Random;

public class BossInvader extends Invader{
    private final int points;

    public BossInvader(int x, int y) {
        super(x, y);
        int[] possiblePoints = {75, 100, 250, 500, 999};
        Random random = new Random();
        this.points = possiblePoints[random.nextInt(possiblePoints.length)];
    }

    @Override
    public int getPoints() {
        return points;
    }
}

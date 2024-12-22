package spacewars.model.game.elements.invaders;

import java.util.Random;

public class BossInvader extends Invader {
    private final int points;
    private boolean alive = true;

    public BossInvader(double x, double y) {
        super(x, y);
        this.points = getRandomPoints();
    }


    public int getRandomPoints() {
        int[] possiblePoints = {75, 100, 250, 500, 999};
        double[] probabilities = {0.5, 0.2, 0.15, 0.1, 0.05}; //probabilities must sum to 1

        double randomValue = new Random().nextDouble();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < possiblePoints.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue <= cumulativeProbability) {
                return possiblePoints[i];
            }
        }
        return possiblePoints[possiblePoints.length - 1]; //fallback in case of rounding errors
    }

    @Override
    public int getPoints() {
        return points;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}

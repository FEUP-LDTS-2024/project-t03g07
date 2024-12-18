package spacewars.model.game.elements.invaders;

import spacewars.model.game.Game;

import java.util.Random;

public class BossInvader extends Invader{
    private final int points;
    private Game game;
    private boolean hidden; // Whether the boss is off-screen and waiting to reappear
    private int size = 16;

    public BossInvader(int x, int y, Game game) {
        super(x, y);
        this.points = getRandomPoints();
        this.game = game;
        this.hidden = true; // Initially hidden
    }


    private int getRandomPoints() {
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

    public int getSize() {
        return size;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}

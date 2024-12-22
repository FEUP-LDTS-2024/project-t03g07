package spacewars.model.game.elements.invaders;

import spacewars.model.game.elements.Element;

public abstract class Invader extends Element {

    public Invader(double x, double y) {
        super(x, y);
    }

    public abstract int getPoints();
}

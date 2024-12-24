package spacewars.model.game.elements.invaders;

import spacewars.model.game.elements.Element;

public abstract class Invader extends Element {

    private int size;

    public Invader(double x, double y) {
        super(x, y);
        this.size = 16;
    }

    public abstract int getPoints();

    public int getSize() {
        return size;
    }
}

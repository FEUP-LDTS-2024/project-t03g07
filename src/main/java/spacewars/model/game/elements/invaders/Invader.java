package spacewars.model.game.elements.invaders;

import spacewars.model.game.elements.Element;

public abstract class Invader extends Element {
    public Invader(int x, int y) {
        super(x, y);
    }

    public abstract int getPoints();

    @Override
    public void update() {
    }
}

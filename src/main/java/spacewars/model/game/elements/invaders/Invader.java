package spacewars.model.game.elements.invaders;

import spacewars.model.game.elements.Entity;

public abstract class Invader extends Entity {
    public Invader(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
    }
}

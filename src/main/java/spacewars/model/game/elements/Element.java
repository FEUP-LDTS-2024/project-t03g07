package spacewars.model.game.elements;

import spacewars.model.Position;

public abstract class Element {
    private Position position;

    public Element(double x, double y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void update();
}

package spacewars.model;

public abstract class Entity {
    private Position position;

    public Entity(int x, int y) {
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

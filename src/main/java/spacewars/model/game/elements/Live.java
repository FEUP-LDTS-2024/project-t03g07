package spacewars.model.game.elements;

public class Live extends Element {
    private final int liveId;

    public Live(int x, int y, int liveId) {
        super(x, y);
        this.liveId = liveId;
    }

    public void removeLive() { }

    public int getLive() {
        return liveId;
    }

    @Override
    public void update() { }
}

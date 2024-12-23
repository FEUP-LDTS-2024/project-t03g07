package spacewars.model.game.elements;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LiveTest {
    @Property
    void LivePositionTest(@ForAll int x, @ForAll int y) {
        Live live = new Live(x, y);
        assertEquals(x, live.getPosition().x());
        assertEquals(y, live.getPosition().y());
    }

    @Property
    void SetLivePositionTest(@ForAll int x, @ForAll int y) {
        Live live = new Live(0, 0);
        Position position = new Position(x, y);
        live.setPosition(position);
        assertEquals(x, live.getPosition().x());
        assertEquals(y, live.getPosition().y());
    }
}

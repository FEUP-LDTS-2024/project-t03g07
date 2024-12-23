package spacewars.model.game.elements.invaders.normal_invaders;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.game.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class NormalInvader2Test {

    @Property
    void NormalInvader2InitializationTest(@ForAll double x, @ForAll double y) {
        Game game = mock(Game.class);
        NormalInvader2 normalInvader2 = new NormalInvader2(x, y, game);

        assertEquals(20, normalInvader2.getPoints(), "getPoints should consistently return the same value: 20");
    }
}

package spacewars.model.game.elements.invaders.normal_invaders;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import spacewars.model.game.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class NormalInvader1Test {

    @Property
    void NormalInvader1InitializationTest(@ForAll double x, @ForAll double y) {
        Game game = mock(Game.class);
        NormalInvader1 normalInvader1 = new NormalInvader1(x, y, game);

        assertEquals(1, normalInvader1.getSpeed(), "NormalInvader1 speed should always be 1");

        assertEquals(game, normalInvader1.getGame(), "getGame should consistently return the same value: game");

        assertEquals(10, normalInvader1.getPoints(), "getPoints should consistently return the same value: 10");
    }

    @Property
    void NormalInvader1SetSpeedTest(@ForAll double x, @ForAll double y, @ForAll double speed) {
        Game game = mock(Game.class);
        NormalInvader1 normalInvader1 = new NormalInvader1(x, y, game);

        normalInvader1.setSpeed(speed);

        assertEquals(speed, normalInvader1.getSpeed());
    }
}

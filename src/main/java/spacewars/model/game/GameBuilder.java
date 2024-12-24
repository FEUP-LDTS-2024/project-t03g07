package spacewars.model.game;

import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.invaders.*;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader1;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader2;
import spacewars.model.game.elements.invaders.normal_invaders.NormalInvader3;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    public Player createPlayer(Game game) {
        return new Player(155, 170, game);
    }

    public List<NormalInvader1> createInvaders1(Game game) {
        List<NormalInvader1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new NormalInvader1(64 + i * 20, 110, game));
        }
        return list;
    }

    public List<NormalInvader2> createInvaders2(Game game) {
        List<NormalInvader2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new NormalInvader2(64 + i * 20, 90, game));
        }
        return list;
    }

    public List<NormalInvader3> createInvaders3(Game game) {
        List<NormalInvader3> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new NormalInvader3(64 + i * 20, 70, game));
        }
        return list;
    }

    public BossInvader createBossInvader() {
        return new BossInvader(0, 30);
    }

    public List<Live> createLives() {
        List<Live> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Live(273 + i * 15, 5));
        }
        return list;
    }
}

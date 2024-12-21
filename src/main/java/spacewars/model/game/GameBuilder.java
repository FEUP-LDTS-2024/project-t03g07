package spacewars.model.game;

import spacewars.model.game.elements.Live;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.invaders.*;
import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    public Player createPlayer(Game game) {
        return new Player(155, 170, game);
    }

    public List<Invader1> createInvaders1(Game game) {
        List<Invader1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Invader1(64 + i * 20, 110, game));
        }
        return list;
    }

    public List<Invader2> createInvaders2(Game game) {
        List<Invader2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Invader2(64 + i * 20, 90, game));
        }
        return list;
    }

    public List<Invader3> createInvaders3(Game game) {
        List<Invader3> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Invader3(64 + i * 20, 70, game));
        }
        return list;
    }

    public BossInvader createBossInvader(Game game) {
        return new BossInvader(0, 30, game);
    }

    public List<Live> createLives() {
        List<Live> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Live(273 + i * 15, 5));
        }
        return list;
    }
}

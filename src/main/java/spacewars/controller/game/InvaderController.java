package spacewars.controller.game;

import spacewars.Application;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.elements.bullets.BulletPlayer;
import spacewars.model.game.elements.invaders.Invader;
import spacewars.model.game.elements.invaders.Invader1;

import java.io.IOException;

public class InvaderController extends GameController {
    private long lastMovement;

    public InvaderController(Game game) {
        super(game);
        this.lastMovement = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Invader invader1 : getModel().getInvaders1())
                moveInvaderRight(invader1.getPosition());
            for (Invader invader2 : getModel().getInvaders2())
                moveInvaderRight(invader2.getPosition());
            for (Invader invader3 : getModel().getInvaders3())
                moveInvaderRight(invader3.getPosition());
            Invader bossInvader = getModel().getBossInvader();
            moveInvaderRight(bossInvader.getPosition());


            this.lastMovement = time;
        }
    }

    public void moveInvaderRight(Position position) {
        for (Invader invader1 : getModel().getInvaders1()) {
            invader1.setPosition(new Position(position.getX() + 1, position.getY()));
        }
        for (Invader invader2 : getModel().getInvaders1()) {
            invader2.setPosition(new Position(position.getX() + 1, position.getY()));
        }
        for (Invader invader3 : getModel().getInvaders1()) {
            invader3.setPosition(new Position(position.getX() + 1, position.getY()));
        }
        Invader bossInvader = getModel().getBossInvader();
        bossInvader.setPosition(new Position(position.getX() + 1, position.getY()));
    }

    public void moveInvaderLeft(Position position) {
        for (Invader invader1 : getModel().getInvaders1()) {
            invader1.setPosition(new Position(position.getX() - 1, position.getY()));
        }
        for (Invader invader2 : getModel().getInvaders1()) {
            invader2.setPosition(new Position(position.getX() - 1, position.getY()));
        }
        for (Invader invader3 : getModel().getInvaders1()) {
            invader3.setPosition(new Position(position.getX() - 1, position.getY()));
        }
        Invader bossInvader = getModel().getBossInvader();
        bossInvader.setPosition(new Position(position.getX() - 1, position.getY()));
    }

}

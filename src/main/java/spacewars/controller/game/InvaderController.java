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
    private final int borderLeft;
    private final int borderRight;

    public InvaderController(Game game) {
        super(game);
        this.lastMovement = 0;
        this.borderLeft = 0;
        this.borderRight = 320;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            if(!leftBorderHit(borderLeft)) {
                for (Invader invader1 : getModel().getInvaders1())
                    moveInvaderRight(invader1.getPosition());
                for (Invader invader2 : getModel().getInvaders2())
                    moveInvaderRight(invader2.getPosition());
                for (Invader invader3 : getModel().getInvaders3())
                    moveInvaderRight(invader3.getPosition());
                Invader bossInvader = getModel().getBossInvader();
                moveInvaderRight(bossInvader.getPosition());
            }
            else if(!rightBorderHit(borderRight)) {
                for (Invader invader1 : getModel().getInvaders1())
                    moveInvaderLeft(invader1.getPosition());
                for (Invader invader2 : getModel().getInvaders2())
                    moveInvaderLeft(invader2.getPosition());
                for (Invader invader3 : getModel().getInvaders3())
                    moveInvaderLeft(invader3.getPosition());
                Invader bossInvader = getModel().getBossInvader();
                moveInvaderLeft(bossInvader.getPosition());
            }


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

    public boolean rightBorderHit(int borderRight) {
        Invader invader1 = getModel().getInvaders1().get(0);
        Invader invader2 = getModel().getInvaders2().get(0);
        Invader invader3 = getModel().getInvaders3().get(0);
        return (invader1.getPosition().getX() == borderRight - 1
                || invader2.getPosition().getX() == borderRight - 1
                || invader3.getPosition().getX() == borderRight - 1);
    }

    public boolean leftBorderHit(int borderLeft) {
        Invader invader1 = getModel().getInvaders1().get(0);
        Invader invader2 = getModel().getInvaders2().get(0);
        Invader invader3 = getModel().getInvaders3().get(0);

        return (invader1.getPosition().getX() == borderLeft - 1
                || invader2.getPosition().getX() == borderLeft - 1
                || invader3.getPosition().getX() == borderLeft - 1);
    }

}



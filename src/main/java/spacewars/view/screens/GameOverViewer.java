package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.GameOver;
import spacewars.view.ViewerProvider;
import spacewars.view.texts.TextViewer;

import java.io.IOException;

public class GameOverViewer extends ScreenViewer<GameOver> {
    private final TextViewer textViewer;

    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue
    private static final TextColor finalScoreColor = new TextColor.RGB(255,255,255);      //white
    private static final TextColor GameOverColor = new TextColor.RGB(255,195,0);     //yellow

    public GameOverViewer(GameOver model, ViewerProvider viewerProvider) {
        super(model);
        this.textViewer = viewerProvider.getTextViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        drawGameOver(gui);
        drawFinalScore(gui);
        gui.refresh();
    }

    private void drawFinalScore(GUI gui) {
        Position pos = new Position(95,70);
        textViewer.draw(getModel().getFinalScore(), pos.getX(),pos.getY(),finalScoreColor,gui);
    }

    private void drawGameOver(GUI gui) {
        Position pos = new Position(147,40);
        textViewer.draw(getModel().getGameOverMessage(), pos.getX(),pos.getY(), GameOverColor,gui);
    }
}
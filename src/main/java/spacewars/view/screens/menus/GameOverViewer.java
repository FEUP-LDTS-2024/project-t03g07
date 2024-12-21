package spacewars.view.screens.menus;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.Entry;
import spacewars.model.menu.GameOver;
import spacewars.view.ViewerProvider;
import spacewars.view.menus.EntryViewer;
import spacewars.view.menus.GameOverImageViewer;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.List;

public class GameOverViewer extends ScreenViewer<GameOver> {
    private final TextViewer textViewer;
    private final EntryViewer entryViewer;
    private final GameOverImageViewer gameOverImageViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255,255,255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255,195,0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);           //dark blue
    private static final TextColor finalScoreColor = new TextColor.RGB(255,255,255);      //white
    private static final TextColor newHighScoreColor = new TextColor.RGB(154,3,30);      //dark red

    public GameOverViewer(GameOver model, ViewerProvider viewerProvider) {
        super(model);
        this.entryViewer = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();
        this.gameOverImageViewer = viewerProvider.getGameOverImageViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        gameOverImageViewer.draw(gui, 125, 50);
        drawFinalScore(gui);
        if (getModel().isNewHighScore())
            drawNewHighScore(gui);

        gui.refresh();
    }

    private void drawFinalScore(GUI gui) {
        Position pos = new Position(107, 100);
        textViewer.draw(getModel().getFinalScoreMessage(), pos.x(), pos.y(), finalScoreColor, gui);
    }

    private void drawNewHighScore(GUI gui) {
        Position pos = new Position(130,115);
        textViewer.draw(getModel().getNewHighScoreMessage(), pos.x(),pos.y(),newHighScoreColor,gui);
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
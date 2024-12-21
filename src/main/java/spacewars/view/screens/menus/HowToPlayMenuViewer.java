package spacewars.view.screens.menus;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.Entry;
import spacewars.model.menu.HowToPlayMenu;
import spacewars.view.*;
import spacewars.view.menus.EntryViewer;
import spacewars.view.menus.how_to_play.*;
import spacewars.view.menus.how_to_play.spaceships.DeathStarViewer;
import spacewars.view.menus.how_to_play.spaceships.EmpireFighterViewer;
import spacewars.view.menus.how_to_play.spaceships.StarDestroyerViewer;
import spacewars.view.menus.how_to_play.spaceships.TIEExecutorViewer;
import spacewars.view.screens.ScreenViewer;
import spacewars.view.texts.TextViewer;

import java.io.IOException;
import java.util.List;

public class HowToPlayMenuViewer extends ScreenViewer<HowToPlayMenu> {
    private final EntryViewer entryViewer;
    private final TextViewer textViewer;

    private final ArrowsViewer arrowsViewer;
    private final SpacebarViewer spacebarViewer;

    private final EmpireFighterViewer empireFighterViewer;
    private final TIEExecutorViewer tieExecutorViewer;
    private final StarDestroyerViewer starDestroyerViewer;
    private final DeathStarViewer deathStarViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255,255,255); //white
    public static final TextColor selectedColor = new TextColor.RGB(255,195,0);     //yellow
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);   //dark blue
    private static final TextColor titleColor = new TextColor.RGB(255,195,0);       //yellow
    private static final TextColor textColor = new TextColor.RGB(255,255,255);      //white
    private static final TextColor enigmaColor = new TextColor.RGB(255,195,0);      //yellow

    public HowToPlayMenuViewer(HowToPlayMenu model, ViewerProvider viewerProvider) {
        super(model);

        this.entryViewer = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();

        this.arrowsViewer = viewerProvider.getArrowsViewer();
        this.spacebarViewer = viewerProvider.getSpacebarViewer();

        this.empireFighterViewer = viewerProvider.getEmpireFighterViewer();
        this.tieExecutorViewer = viewerProvider.getTIEExecutorViewer();
        this.starDestroyerViewer = viewerProvider.getStarDestroyerViewer();
        this.deathStarViewer = viewerProvider.getDeathStarViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        drawTitles(gui);
        drawControls(gui);
        drawSpaceShipsAndPoints(gui);

        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for (Entry entry: entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }

    private void drawTitles(GUI gui) {
        drawTitle(gui);
        drawSubtitle(gui);
    }

    private void drawControls(GUI gui) throws IOException {
        drawArrowsAndText(gui);
        drawSpacebarAndText(gui);
    }

    private void drawSpaceShipsAndPoints(GUI gui) throws IOException {
        drawEmpireFighterAndPoints(gui);
        drawTIEExecutorAndPoints(gui);
        drawStarDestroyerAndPoints(gui);
        drawDeathStarAndPoints(gui);
    }


    private void drawSubtitle(GUI gui) {
        Position pos = new Position(223,50);
        textViewer.draw(getModel().getSubtitle(), pos.x(),pos.y(),titleColor,gui);
    }

    private void drawTitle(GUI gui) {
        Position pos = new Position(139,30);
        textViewer.draw(getModel().getTitle(), pos.x(),pos.y(),titleColor,gui);
    }


    private void drawSpacebarAndText(GUI gui) throws IOException {
        spacebarViewer.draw(gui,63,110);
        Position pos = new Position(80,135);
        textViewer.draw(getModel().getSpacebarText(), pos.x(), pos.y(),textColor,gui);
    }

    private void drawArrowsAndText(GUI gui) throws IOException {
        arrowsViewer.draw(gui, 63, 60);
        Position pos = new Position(55,85);
        textViewer.draw(getModel().getArrowText(), pos.x(),pos.y(),textColor,gui);
    }


    private void drawEmpireFighterAndPoints(GUI gui) throws IOException {
        empireFighterViewer.draw(gui,201,60);
        Position pos = new Position(222,65);
        textViewer.draw(getModel().getPointsInvader1(), pos.x(), pos.y(), textColor, gui);
    }

    private void drawTIEExecutorAndPoints(GUI gui) throws IOException {
        tieExecutorViewer.draw(gui,201,80);
        Position pos = new Position(222,85);
        textViewer.draw(getModel().getPointsInvader2(), pos.x(), pos.y(), textColor, gui);
    }

    private void drawStarDestroyerAndPoints(GUI gui) throws IOException {
        starDestroyerViewer.draw(gui,201,100);
        Position pos = new Position(222,105);
        textViewer.draw(getModel().getPointsInvader3(), pos.x(), pos.y(), textColor, gui);
    }

    private void drawDeathStarAndPoints(GUI gui) throws IOException {
        deathStarViewer.draw(gui,201,120);
        Position pos_pointsBoss = new Position(222,125);
        Position pos_pointsText = new Position(236,125);
        textViewer.draw(getModel().getPointsBoss(), pos_pointsBoss.x(), pos_pointsBoss.y(), enigmaColor, gui);
        textViewer.draw(getModel().getTextPoints(),pos_pointsText.x(),pos_pointsText.y(),textColor,gui);
    }
}

package spacewars.model.menu;

import spacewars.model.Position;

import java.util.Arrays;
import java.util.List;

public class HowToPlayMenu extends Menu {
    private final String title;
    private final String subtitle;

    private String arrowText;
    private String spacebarText;

    private String pointsInvader1;
    private String pointsInvader2;
    private String pointsInvader3;
    private String pointsBoss;
    private String textPoints;


    public HowToPlayMenu() {
        title = "HOW TO PLAY";
        subtitle = "Points";
        arrowText = "move left and right";
        spacebarText = "shoot";

        pointsInvader1 = "10 points";
        pointsInvader2 = "20 points";
        pointsInvader3 = "30 points";
        pointsBoss = "???";
        textPoints = "points";
    }

    @Override
    protected List<Entry> createEntries() {
        Position pos = new Position(130,154);
        Entry goBack = new Entry(pos, Entry.TYPE.RETURN_TO_MENU);
        return Arrays.asList(goBack);
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getArrowText() {
        return arrowText;
    }

    public String getSpacebarText() {
        return spacebarText;
    }

    public String getPointsInvader1() {
        return pointsInvader1;
    }

    public String getPointsInvader2() {
        return pointsInvader2;
    }

    public String getPointsInvader3() {
        return pointsInvader3;
    }

    public String getPointsBoss() {
        return pointsBoss;
    }

    public String getTextPoints() {
        return textPoints;
    }
}

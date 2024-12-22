package spacewars.model.game.menu;

import org.junit.jupiter.api.Test;
import spacewars.model.menu.HowToPlayMenu;

import static org.junit.jupiter.api.Assertions.*;

public class HowToPlayMenuTest {
    @Test
    public void getTitleTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String title = howToPlayMenu.getTitle();

        assertNotNull(title, "Title should not be null");

        assertFalse(title.isEmpty(), "Title should not be empty");

        assertEquals("HOW TO PLAY", title, "Title should be 'CREDITS'");
    }

    @Test
    public void getSubTitleTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String subtitle = howToPlayMenu.getSubtitle();

        assertNotNull(subtitle, "Subtitle should not be null");

        assertFalse(subtitle.isEmpty(), "Subtitle should not be empty");

        assertEquals("Points", subtitle, "Subtitle should be 'Points'");
    }

    @Test
    public void getArrowTextTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String arrowText = howToPlayMenu.getArrowText();

        assertNotNull(arrowText, "ArrowText should not be null");

        assertFalse(arrowText.isEmpty(), "ArrowText should not be empty");

        assertEquals("move left and right", arrowText, "ArrowText should be 'move left and right'");
    }

    @Test
    public void getSpacebarTextTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String spacebarText = howToPlayMenu.getSpacebarText();

        assertNotNull(spacebarText, "SpacebarText should not be null");

        assertFalse(spacebarText.isEmpty(), "SpacebarText should not be empty");

        assertEquals("shoot", spacebarText, "SpacebarText should be 'shoot'");
    }

    @Test
    public void getPointsInvader1Test() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String pointsInvader1 = howToPlayMenu.getPointsInvader1();

        assertNotNull(pointsInvader1, "PointsInvader1 should not be null");

        assertFalse(pointsInvader1.isEmpty(), "PointsInvader1 should not be empty");

        assertEquals("10 points", pointsInvader1, "PointsInvader1 should be '10 points'");
    }

    @Test
    public void getPointsInvader2Test() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String pointsInvader2 = howToPlayMenu.getPointsInvader2();

        assertNotNull(pointsInvader2, "PointsInvader2 should not be null");

        assertFalse(pointsInvader2.isEmpty(), "PointsInvader2 should not be empty");

        assertEquals("20 points", pointsInvader2, "PointsInvader2 should be '20 points'");
    }

    @Test
    public void getPointsInvader3Test() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String pointsInvader3 = howToPlayMenu.getPointsInvader3();

        assertNotNull(pointsInvader3, "PointsInvader3 should not be null");

        assertFalse(pointsInvader3.isEmpty(), "PointsInvader3 should not be empty");

        assertEquals("30 points", pointsInvader3, "PointsInvader3 should be '30 points'");
    }

    @Test
    public void getPointsBossTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String pointsBoss = howToPlayMenu.getPointsBoss();

        assertNotNull(pointsBoss, "PointsBoss should not be null");

        assertFalse(pointsBoss.isEmpty(), "PointsBoss should not be empty");

        assertEquals("???", pointsBoss, "PointsBoss should be '???'");
    }

    @Test
    public void getTextPointsTest() {
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        String textPoints = howToPlayMenu.getTextPoints();

        assertNotNull(textPoints, "TextPoints should not be null");

        assertFalse(textPoints.isEmpty(), "TextPoints should not be empty");

        assertEquals("points", textPoints, "TextPoints should be 'points'");
    }

}

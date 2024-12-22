package spacewars.model.game.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.model.menu.CreditsMenu;

import static org.junit.jupiter.api.Assertions.*;

public class CreditsMenuTest {

    private CreditsMenu creditsMenu;

    @BeforeEach
    public void setup() {
        this.creditsMenu = new CreditsMenu();
    }

    @Test
    public void getNamesTest() {
        String[] names = creditsMenu.getNames();

        assertNotNull(names, "Names array should not be null");

        assertEquals(3, names.length, "Names array should have exactly 3 elements");

        assertEquals("Joao Miguel Lopes", names[0], "First name should match");
        assertEquals("Francisca Vilares Portugal", names[1], "Second name should match");
        assertEquals("Pedro Andre Freitas Monteiro", names[2], "Third name should match");
    }

    @Test
    public void getTitleTest() {
        String title = creditsMenu.getTitle();

        assertNotNull(title, "Title should not be null");

        assertFalse(title.isEmpty(), "Title should not be empty");

        assertEquals("CREDITS", title, "Title should be 'CREDITS'");
    }

    @Test
    public void getDetailsTest() {
        String details = creditsMenu.getDetails();

        assertNotNull(details, "Details should not be null");

        assertFalse(details.isEmpty(), "Details should not be empty");

        assertEquals("Class 3 Group 7:", details, "Details should be 'Class 3 Group 7:'");
    }

}

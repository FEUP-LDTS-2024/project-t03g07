package spacewars.model.game.menu;

import org.junit.jupiter.api.Test;
import spacewars.model.menu.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EntryTest {
    @Test
    public void MainMenuEntriesTest(){
        MainMenu mainMenu = new MainMenu();
        List<Entry> entries = mainMenu.createEntries();

        assertNotEquals(Collections.EMPTY_LIST, entries);
    }

    @Test
    public void HowToPlayMenuEntriesTest(){
        HowToPlayMenu howToPlayMenu = new HowToPlayMenu();
        List<Entry> entries = howToPlayMenu.createEntries();

        assertNotEquals(Collections.EMPTY_LIST, entries);
    }

    @Test
    public void GameOverEntriesTest(){
        GameOver gameOver = new GameOver(null,false);
        List<Entry> entries = gameOver.createEntries();

        assertNotEquals(Collections.EMPTY_LIST, entries);
    }

    @Test
    public void CreditsMenuEntriesTest(){
        CreditsMenu creditsMenu = new CreditsMenu();
        List<Entry> entries = creditsMenu.createEntries();

        assertNotEquals(Collections.EMPTY_LIST, entries);
    }
}

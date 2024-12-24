package spacewars.view.screens;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.menu.Entry;
import spacewars.view.menus.EntryViewer;
import spacewars.view.texts.TextViewer;

import static org.mockito.Mockito.*;

public class EntryViewerTest {
    private TextViewer textViewer; // Mock of TextViewer
    private GUI gui;              // Mock of GUI
    private EntryViewer entryViewer; // Class containing the draw method

    @BeforeEach
    void setup() {
        textViewer = mock(TextViewer.class);
        gui = mock(GUI.class);
        entryViewer = new EntryViewer(textViewer); // Assuming constructor injection
    }

    @Test
    void testDrawPLAY() {
        // Arrange
        Entry model = new Entry(new Position(5, 10),Entry.TYPE.PLAY); // Use actual constructor
        TextColor color = mock(TextColor.class);

        // Act
        entryViewer.draw(model, gui, color);

        // Assert
        verify(textViewer).draw("Play", 5, 10, color, gui);
    }

    @Test
    void testDrawHOW_TO_PLAY() {
        // Arrange
        Entry model = new Entry(new Position(5, 10),Entry.TYPE.HOW_TO_PLAY); // Use actual constructor
        TextColor color = mock(TextColor.class);

        // Act
        entryViewer.draw(model, gui, color);

        // Assert
        verify(textViewer).draw("How to Play", 5, 10, color, gui);
    }

    @Test
    void testDrawCREDITS() {
        // Arrange
        Entry model = new Entry(new Position(5, 10),Entry.TYPE.CREDITS); // Use actual constructor
        TextColor color = mock(TextColor.class);

        // Act
        entryViewer.draw(model, gui, color);

        // Assert
        verify(textViewer).draw("Credits", 5, 10, color, gui);
    }

    @Test
    void testDrawQUIT() {
        // Arrange
        Entry model = new Entry(new Position(5, 10),Entry.TYPE.QUIT); // Use actual constructor
        TextColor color = mock(TextColor.class);

        // Act
        entryViewer.draw(model, gui, color);

        // Assert
        verify(textViewer).draw("Quit", 5, 10, color, gui);
    }

    @Test
    void testDrawRETURN_TO_MENU() {
        // Arrange
        Entry model = new Entry(new Position(5, 10),Entry.TYPE.RETURN_TO_MENU); // Use actual constructor
        TextColor color = mock(TextColor.class);

        // Act
        entryViewer.draw(model, gui, color);

        // Assert
        verify(textViewer).draw("Return to menu", 5, 10, color, gui);
    }

}

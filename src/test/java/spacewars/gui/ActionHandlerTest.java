package spacewars.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionHandlerTest {

    private LanternaGUI actionHandler; // Replace with your class's name

    @BeforeEach
    void setUp() throws URISyntaxException, IOException, FontFormatException {
        actionHandler = new LanternaGUI(10, 10); // Replace with your class's name
    }

    @Test
    void testDefaultAction() {
        // No key pressed and no last movement action
        assertEquals(GUI.ACTION.NONE, actionHandler.getNextAction());
    }

    @Test
    void testUpKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_UP);
        assertEquals(GUI.ACTION.UP, actionHandler.getNextAction());
    }

    @Test
    void testDownKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_DOWN);
        assertEquals(GUI.ACTION.DOWN, actionHandler.getNextAction());
    }

    @Test
    void testLeftKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_LEFT);
        assertEquals(GUI.ACTION.LEFT, actionHandler.getNextAction());
    }

    @Test
    void testRightKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_RIGHT);
        assertEquals(GUI.ACTION.RIGHT, actionHandler.getNextAction());
    }

    @Test
    void testSpaceKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_SPACE);
        assertEquals(GUI.ACTION.SHOOT, actionHandler.getNextAction());
    }

    @Test
    void testEscapeKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_ESCAPE);
        assertEquals(GUI.ACTION.QUIT, actionHandler.getNextAction());
    }

    @Test
    void testEnterKeyPress() {
        actionHandler.setKeyPressed(KeyEvent.VK_ENTER);
        assertEquals(GUI.ACTION.SELECT, actionHandler.getNextAction());
    }

    @Test
    void testLastMovementAction() {
        // Simulate holding down a movement key
        actionHandler.setKeyPressed(KeyEvent.VK_LEFT);
        actionHandler.getNextAction(); // Consumes the key press
        assertEquals(GUI.ACTION.LEFT, actionHandler.getNextAction());
    }

    @Test
    void testInvalidLastMovementAction() {
        // Set an invalid last movement action
        actionHandler.setLastMovementAction(-1);
        assertEquals(GUI.ACTION.NONE, actionHandler.getNextAction());
    }
}

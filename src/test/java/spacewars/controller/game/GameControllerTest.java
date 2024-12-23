package spacewars.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spacewars.Application;
import spacewars.controller.game.elements.PlayerController;
import spacewars.controller.game.elements.invaders.BossInvaderController;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader1Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader2Controller;
import spacewars.controller.game.elements.invaders.normal_invaders.NormalInvader3Controller;
import spacewars.gui.GUI;
import spacewars.model.Position;
import spacewars.model.game.Game;
import spacewars.model.game.HighScore;
import spacewars.model.game.elements.Player;
import spacewars.model.game.elements.invaders.BossInvader;
import spacewars.states.GameOverState;
import spacewars.states.MainMenuState;
import spacewars.view.images.ImageLoader;
import spacewars.model.game.elements.Live;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    private GameController controller;
    private Application application;
    private Game game;
    private PlayerController playerController;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        application = mock(Application.class);
        Player player = mock(Player.class);
        playerController = mock(PlayerController.class);
        BossInvader bossInvader = mock(BossInvader.class);

        Position position = new Position(0, 0); // Create a real instance of Position

        when(game.getPlayer()).thenReturn(player);
        when(player.getPosition()).thenReturn(position);
        when(bossInvader.getPosition()).thenReturn(position);
        when(application.getImageLoader()).thenReturn(mock(ImageLoader.class));
        when(game.getBossInvader()).thenReturn(bossInvader);

        controller = new GameController(game);
        controller = spy(controller);

        // Use reflection to set the private playerController field
        try {
            java.lang.reflect.Field playerControllerField = GameController.class.getDeclaredField("playerController");
            playerControllerField.setAccessible(true);
            playerControllerField.set(controller, playerController);

            BossInvaderController bossInvaderController = new BossInvaderController(bossInvader, 320);
            java.lang.reflect.Field bossInvaderControllerField = GameController.class.getDeclaredField("bossInvaderController");
            bossInvaderControllerField.setAccessible(true);
            bossInvaderControllerField.set(controller, bossInvaderController);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testStepLeft() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.LEFT, 0);
        verify(playerController, times(1)).moveLeft();
    }

    @Test
    public void testStepRight() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.RIGHT, 0);
        verify(playerController, times(1)).moveRight();
    }

    @Test
    public void testStepShoot() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.SHOOT, 0);
        verify(playerController, times(1)).shoot();
    }

    @Test
    public void testStepQuit() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.QUIT, 0);
        verify(application, times(1)).setState(isA(MainMenuState.class));
    }

    @Test
    public void testIsGameOverTrue() {
        when(game.getLives()).thenReturn(new ArrayList<>()); // No lives
        assertTrue(controller.isGameOver());
    }

    @Test
    public void testIsGameOverFalse() {
        ArrayList<Live> lives = new ArrayList<>(); // Use the correct type
        lives.add(mock(Live.class)); // Simulate one life remaining
        when(game.getLives()).thenReturn(lives);
        assertFalse(controller.isGameOver());
    }

    @Test
    public void testTransitionToGameOverWithHighScore() throws IOException, URISyntaxException {
        when(game.getRawScore()).thenReturn(150);
        when(game.getScore()).thenReturn("150");

        HighScore.loadHighScore();

        controller.transitionToGameOver(application);

        verify(application, times(1)).setState(isA(GameOverState.class));
        assertEquals(150, HighScore.loadHighScore());
    }

    @Test
    public void testTransitionToGameOverWithoutHighScore() throws IOException, URISyntaxException {
        when(game.getRawScore()).thenReturn(50);
        when(game.getScore()).thenReturn("50");

        HighScore.loadHighScore();

        controller.transitionToGameOver(application);

        verify(application, times(1)).setState(isA(GameOverState.class));
        assertEquals(150, HighScore.loadHighScore());
    }

    @Test
    public void testStepInvaderMovement() throws IOException, URISyntaxException {
        NormalInvader1Controller normalInvader1Controller = mock(NormalInvader1Controller.class);
        NormalInvader2Controller normalInvader2Controller = mock(NormalInvader2Controller.class);
        NormalInvader3Controller normalInvader3Controller = mock(NormalInvader3Controller.class);
        BossInvaderController bossInvaderController = mock(BossInvaderController.class);

        try {
            java.lang.reflect.Field field1 = GameController.class.getDeclaredField("invader1Controller");
            field1.setAccessible(true);
            field1.set(controller, normalInvader1Controller);

            java.lang.reflect.Field field2 = GameController.class.getDeclaredField("invader2Controller");
            field2.setAccessible(true);
            field2.set(controller, normalInvader2Controller);

            java.lang.reflect.Field field3 = GameController.class.getDeclaredField("invader3Controller");
            field3.setAccessible(true);
            field3.set(controller, normalInvader3Controller);

            java.lang.reflect.Field field4 = GameController.class.getDeclaredField("bossInvaderController");
            field4.setAccessible(true);
            field4.set(controller, bossInvaderController);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        controller.step(application, GUI.ACTION.NONE, 1000); // Simulate step call with non-null action

        verify(normalInvader1Controller, times(1)).moveInvaders();
        verify(normalInvader2Controller, times(1)).moveInvaders();
        verify(normalInvader3Controller, times(1)).moveInvaders();
        verify(bossInvaderController, times(1)).moveBoss(anyLong());
    }

    @Test
    public void testUpdateInvaderBullets() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.NONE, 1000); // Simulate step call with non-null action
        verify(game, times(1)).updateInvaderBullets();
    }

    @Test
    public void testRespawnInvaders() throws IOException, URISyntaxException {
        controller.step(application, GUI.ACTION.NONE, 1000); // Simulate step call with non-null action
        verify(game, times(1)).respawnInvaders();
    }

    @Test
    public void testObserversAdded() {
        Game mockGame = mock(Game.class);
        BossInvader mockBossInvader = mock(BossInvader.class);
        Position position = new Position(0, 0); // Create a real instance of Position
        when(mockBossInvader.getPosition()).thenReturn(position);
        when(mockGame.getBossInvader()).thenReturn(mockBossInvader);

        new GameController(mockGame);

        verify(mockGame, times(1)).addObserver(any(NormalInvader1Controller.class));
        verify(mockGame, times(1)).addObserver(any(NormalInvader2Controller.class));
        verify(mockGame, times(1)).addObserver(any(NormalInvader3Controller.class));
    }
}
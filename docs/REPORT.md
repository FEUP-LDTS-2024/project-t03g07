<div align="center">
  <img width=200px src="./assets/logo/logo.png" alt="Logo">
</div>

<h1 style= "text-align: center;">Space Wars</h1>

Space Wars takes you on a nostalgic journey. Test your skills as you dodge enemy fire and strategize to take down waves of relentless spaceships. Try not to die with your 3 lives. Push your limits to achieve a new high score in this highly addictive arcade-style game!

This game was developed as a project for Software Design and Testing Laboratory 2024/2025 at the Faculty of Engineering - University of Porto.

## Group Info (T03G07)

### <img src="https://avatars.githubusercontent.com/u/159019602?v=4" alt="Francisca Portugal" width="20" style="border-radius: 50%; vertical-align: middle;"> Francisca Portugal
- Email: [up202303640@edu.fe.up.pt](mailto:up202303640@edu.fe.up.pt)
- GitHub: [![GitHub badge](https://img.shields.io/badge/GitHub-franpts2-purple?style=flat&logo=github)](https://github.com/franpts2)

### <img src="https://avatars.githubusercontent.com/u/158082419?v=4" alt="Francisca Portugal" width="20" style="border-radius: 50%; vertical-align: middle;"> João Lopes
- Email: [up202307809@edu.fe.up.pt](mailto:up202307809@edu.fe.up.pt)
- GitHub: [![GitHub badge](https://img.shields.io/badge/GitHub-joaolopes15-purple?style=flat&logo=github)](https://github.com/joaolopes15)

### <img src="https://avatars.githubusercontent.com/u/83165668?v=4" alt="Francisca Portugal" width="20" style="border-radius: 50%; vertical-align: middle;"> Pedro Monteiro
- Email: [up202307242@edu.fe.up.pt](mailto:up202307242@edu.fe.up.pt)
- GitHub: [![GitHub badge](https://img.shields.io/badge/GitHub-pedroafmonteiro-purple?style=flat&logo=github)](https://github.com/pedroafmonteiro)

## Mockups
> **Note:** The actual game may differ from the mockups shown below. These mockups are for illustrative purposes only and the final design and features may vary.
<div align="center">
  <img width=600px src="./assets/mockups/main_menu.png" alt="Main Menu Screen Mockup">
  <p><b>Main Menu</b></p>
  <p>‎</p>
  <img width=600px src="./assets/mockups/how_to_play.png" alt="How to Play Screen Mockup">
  <p><b>How to play</b></p>
  <p>‎</p>
  <img width=600px src="./assets/mockups/running_game.png" alt="Running Game Screen Mockup">
  <p><b>Running game</b></p>
  <p>‎</p>
  <img width=600px src="./assets/mockups/game_over.png" alt="Game Over Screen Mockup">
  <p><b>Game Over</b></p>
</div>

## Implemented Features
- **Images:** A way to load images into the game by transforming them into pixels in Lanterna.
- **Model classes:** Classes for the player, invader, bullet, and game.
- **Viewer classes:** Classes for the player, invader, bullet, and game.

## Planned Features
- **Main Menu:** An initial screen that lets the user start the game, know how to play the game, view the credits screen and exit the game.
- **Player and Invader movement:** Making the player move with the arrow keys and the invader move randomly.
- **Player and Invader shooting:** Making the player shoot bullets with the space key and the invader randomly.
- **Score system:** When the player kills a type of invader, the score is incremented by a certain quantity of points. An high score will be saved in a separate file.
- **Lives system:** At the beginning of the game, the player has 3 lives that will be decremented if an invader shoots the player. The game ends when the player rans out of lives.
- **Credits:** The credits are accessible through the main menu, showing the developers of this game.

## UML Diagram
To be done.

## Design

To make our code more organized and maintainable, we are using design patterns. By using design patterns, we can separate the concerns of the game and make it easier to add new features.

### Implemented Design Patterns
- **Model-View-Controller (MVC):** We are using the MVC design pattern to separate the concerns of the game. The model classes are responsible for the game logic, the viewer classes are responsible for the game rendering, and the controller classes are responsible for the game input.
  - Currently, we have implemented the model and viewer classes.
- **Singleton:** We are using the Singleton design pattern to ensure that only one instance of the game is created.

### Planned Design Patterns
- **Factory:** We will be using the Factory design pattern to create the player, invader, and bullet objects.
- **Observer:** We will be using the Observer design pattern to notify the game when the player or invader is hit by a bullet.
- **State:** We will be using the State design pattern to define different states for the game (e.g., running, paused, game over).

---

### Game Loop

The game loop is responsible for updating the game state and rendering the game. 
The game loop runs at 60 frames per second to ensure that the game runs smoothly.
Although the game states are not yet implemented, the game loop is already working.
The loop keeps track of the time elapsed since the last frame and the number of frames rendered in the current second. 
This helps in monitoring the performance and ensuring the game runs smoothly.

### Testing
To be done.


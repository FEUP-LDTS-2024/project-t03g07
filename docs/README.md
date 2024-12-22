## LDTS_T03G07 - SPACE WARS

Space Wars takes you on a nostalgic journey. Test your skills as you dodge enemy fire and strategize to take down waves of relentless spaceships. Try not to die with your 3 lives. Push your limits to achieve a new high score in this highly addictive arcade-style game!

This project was developed by **Francisca Portugal** (up202303640@edu.fe.up.pt), **João Lopes** (up202307809@edu.fe.up.pt) and **Pedro Monteiro** (up202307242@edu.fe.up.pt) for LDTS 2024/25.

For a more detailed version of this description click [here](./docs/README.md).

### IMPLEMENTED FEATURES

- **States** - We have implemented states for our game, meaning we have more control when adding a new screen to the game and the transitions between them. For example, we have different Menu States and the Game State itself for playing.
- **How To Play** - The app has a screen that teaches new players how to play the game, featuring the controls used and the scoring system.
- **Player Movement** - By clicking the left or right arrow keys, the player is able to move freely throughout the screen boundaries.
- **Player Shooting** - By clicking the space bar, the player is able to shoot a bullet hitting or not the invaders, which is good for increasing their score.
- **Invaders Behavior** - Invaders move across the screen dodging the player's bullets. When they are hit by a bullet, they are killed and only respawn after all invaders are killed. Invaders also shoot bullets to try to kill the player through a random mechanism. Everytime they respawn, their speed is increased, making it harder for the player.
- **Boss Invader** - The boss invader is always on the screen and respawns right after it is killed by the player. When it is killed, a random amount of points is given to the player from a pre-defined list.
- **Lives** - The player has a lives system. They start with 3 lives and they decrease everytime an invader hits them. When it reaches 0 lives, the game finishes and a screen appears showing their final score and if they want to play again or not.
- **High Score** - This game has an high score system. Everytime the player reaches a new high score, it is written in a file in the user's computer, meaning their high score is preserved through app restarts.
- **Image Loader** - This app is able to transform PNG images in pixels and then showing them on the screen. This was made to make the game more visually appealing.

### PLANNED FEATURES

- **Sounds** - Implementing sounds in the game would make a more immersive experience for the player. A background song would fit in the retro style that our game aims for and a sound for each interaction would also be a great improvement over the visual appearance that already exists for that action.
- **Leaderboard System** - Having a leaderboard system would allow the player to challenge their friends in a competitive way. It would show a list of the 10 best high scores with a name associated, so they know which score belongs to who.
- **Power-ups and Debuffs** - This would be an interesting addition by allowing the game to have more types of challenges inside.
	- Our ideas for power-ups are, for example, double points for a certain amount of time, increase their lives if they're running low and freeze the invaders for easier killing.
	- Our ideas for debuffs are, for example, lose half of the player's score, decrease their lives and make the invaders for difficult by increasing their speed or the amount of lives that their bullets take from the player.
- **Asteroids** - This would be another way of increasing the game difficulty by adding another obstacle for the player. As the game is taking place in the space, an asteroid that comes out of nowhere could decrease the player's lives if it hits them.
- **Animations** - To make the game more visually appealing, adding animations for, for example, the invader's and player's death, the decreasing of the lives and bullet's would add the perfect touch for the player's experience.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### APPLICATION STATES

**Problem in Context**

The application should know if it is in any type of menu or in the game itself. This could be achieved using a single class with too many if statements to alter its behavior.

This type of implementation is in violation of the **Single Responsibility Principle (SRP).** The SRP states that a class should have only one reason to change, meaning it should only have one job or responsibility. By having a single class handle both the menu states and the game state, we are giving it multiple responsibilities, which makes the code harder to maintain, understand, and extend. Instead, each state should be represented by its own class, adhering to the SRP and making the design cleaner and more modular.


**The Pattern**

We have applied the **State** design pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation. This pattern allowed to address the identified problems because each state has its own subclass, not needing to pass information through other classes for it to transition between screens.

**Implementation**

The implementation of this design pattern can be found in the states package in the source code.

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- If we wanted to add a new state, it is easy as creating a new subclass, allowing for easy expansion.
- Each state is independent from the others.

####

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%

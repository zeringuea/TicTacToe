# TicTacToe
A Tic-Tac-Toe game made with the Swing class using the Model-View-Controller Design. The game is set to have 10 x 10 dimensions
and 5 consecutive markers are needed to win.

The game is first declared by TicTacToeGame, which is the class that declares the model, controller, and the view. From there,
the GameBoard Class creates a GameBoard object, which is specified in the interface iGameBoard. This class uses the Board Position 
object specified in the Board Position Class to create a working game of Tic-Tac-Toe. GameBoard serves as the Model for this project.
GameBoardView contains the View used for this project, which sets up the projects display. Lastly, the Controller class handles user
input and adjusts the view accordingly.

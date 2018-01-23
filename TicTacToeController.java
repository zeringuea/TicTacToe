
/**
 * The TicTacToe controller class will handle communication between the TicTacToeView and the Model (IGameBoard and BoardPosition)
 */
public class TicTacToeController {

    private IGameBoard curGame;
    private char curPlayer;
    private TicTacToeView screen;


    /*@param model is the instance of the IGameBoard implementation that is being used
     *@param view is the screen that is being used for the GUI
     *@requires Model is a functioning implementation of IGameBoard
     *@ensures The correct layout for the IGameBoard implementation is displayed
     */
    TicTacToeController(IGameBoard model, TicTacToeView view)
    {
        this.curGame = model;
        this.screen = view;
    }

    /*@param row is the row position of the selected tile
     *@param col is the col position of the selected tile
     *@requires 0 <= row <= 99 and 0 <= col <= 99
     *@ensures The mark for the corresponding character is placed in view
     */
    public void processButtonClick(int row, int col)
    {
        if(curPlayer == 'X')     //Alternates the mark used for processButtonClick
        {
            screen.setMessage("It is X\'s turn. ");
            curPlayer = '0';
        }
        else
        {
            screen.setMessage("It is 0\'s turn. ");
            curPlayer = 'X';
        }
        BoardPosition bPos = new BoardPosition(row, col, curPlayer);

        if (curGame.checkSpace(bPos)) {     //Places marker if valid location
            curGame.placeMarker(bPos);
            screen.setMarker(row, col, curPlayer);
        }
        else {
            screen.setMessage("Please pick another space. ");       //Prompts user to pick a new spot if invalid space is selected
            if(curPlayer == 'X')
                curPlayer = '0';
            else
                curPlayer = 'X';
        }
        if(curGame.checkForWinner(bPos))               //Checks for a winner
            screen.setMessage("Winner");
    }
}

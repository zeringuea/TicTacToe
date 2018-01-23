

/**
 * This class exists to declare our model, view, and controller objects, connect them, and start the game
 */
public final class TicTacToeGame {

    /**
     * @param args ignored in this program
     */
    public static void main(String[] args)
    {
        int row = 10;
        int col = 10;
        int win = 5;

        IGameBoard model = new GameBoard(row, col, win);
        TicTacToeView view = new TicTacToeView(row, col);
        TicTacToeController controller = new TicTacToeController(model, view);

        view.registerObserver(controller);
    }
}

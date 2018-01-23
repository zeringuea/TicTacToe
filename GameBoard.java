

/*
 * Implementation of the GameBoard object which is specified within IGameBoard
 */

public class GameBoard implements IGameBoard {
    private char[][] board = new char[MAX_SIZE][MAX_SIZE];
    private static int row;
    private static int col;
    private static int win;
    private static final int MIN_VALUE = 0;

    /*@ensures GameBoardFast creates a GameBoardFast object
     *@param r is the number of rows that the GameBoard has
     *@param c is the number of columns that the GameBoard has
     *@param w is the number of spaces required to win
     */
    public GameBoard(int r, int c, int w) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        row = r;
        col = c;
        win = w;
    }

    public boolean checkSpace(BoardPosition pos) {
        int x = pos.getRow();
        int y = pos.getColumn();
        if (x > row - 1 || y > col - 1 || x < MIN_VALUE || y < MIN_VALUE) {
            return false;
        }

        if (board[x][y] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public void placeMarker(BoardPosition lastPos) {
        int x = lastPos.getRow();
        int y = lastPos.getColumn();
        char mark = lastPos.getPlayer();

        board[x][y] = mark;
    }

    public boolean checkForWinner(BoardPosition lastPos) {
        if (checkVerticalWin(lastPos) || checkHorizontalWin(lastPos)
                || checkDiagonalWin(lastPos)) {
            return true;
        } else {
            return false;
        }
    }

    /*@param lastPos is the point that is used for checking if there is a horizontal win
     *@requires lastPos.getColumn() and lastPos.getRow() are integer values
     *@ensures checkHorizontalWin returns true if there is a horizontal win and false otherwise
     */
    private boolean checkHorizontalWin(BoardPosition lastPos) {
        int count = 0;
        int currentRow = lastPos.getRow();
        char mark = lastPos.getPlayer();
        int begin = lastPos.getColumn();
        while (begin > 0 && board[currentRow][begin - 1] == mark) {  //Starts at the first element of the consecutive marks
            begin = begin - 1;
            count++;
            if (count >= win) {
                return true;
            }
        }

        count = 0;

        for (int i = begin; i < begin + win; i++) {   //Traverses through consecutive marks while incrementing inc
            if (board[currentRow][i] == mark) {
                count++;
            }
            if (count >= win) {
                return true;
            }
        }
        return false;
    }

    /*@param lastPos is the point that is used for checking if there is a diagonal win
     *@requires The values of lastPos.getColumn() and lastPos.getRow() are integers
     *@ensures checkVerticalWin returns true if there is a vertical win on the board, if not then it returns false
     */
    private boolean checkVerticalWin(BoardPosition lastPos) {
        int count = 0;
        int currentCol = lastPos.getColumn();
        char mark = lastPos.getPlayer();
        int begin = lastPos.getRow();
        while (begin > 0 && board[begin - 1][currentCol] == mark) {
            begin = begin - 1;
            count++;
            if (count >= 5) {
                return true;
            }
        }

        count = 0;

        for (int i = begin; i < begin + win; i++) {
            if (board[i][currentCol] == mark) {
                count++;
            }
            if (count >= win) {
                return true;
            }
        }
        return false;
    }

    /*@param lastPos is the point that is used for checking if there is a diagonal win
     *@requires The values of lastPos.getColumn() and lastPos.getRow() are integers
     *@ensures checkDiagonalWin returns a boolean value based on whether or not there is a diagonal win
     */
    private boolean checkDiagonalWin(BoardPosition lastPos) {
        for(int check = 0;check < 2; check++) {
            char mark = lastPos.getPlayer();
            int begin1 = lastPos.getRow();
            int begin2 = lastPos.getColumn();
            int count = 0;
            if(check == 0){
                while (begin1 > 0 && begin2 > 0 && board[begin1 - 1][begin2 - 1] == mark) {
                    begin1 -= 1;
                    begin2 -= 1;
                    count++;
                    if(count == win)
                        return true;
                }
            }
            else
            {
                while(begin1 > 0&& begin2 < col - 1 && board[begin1 - 1][begin2 + 1] == mark)
                {
                    begin1 -= 1;
                    begin2 += 1;
                    count++;
                    if(count == win)
                        return true;
                }
            }
            count = 0;
            int j = begin2;
            for (int i = begin1; i < begin1 + win && j < begin2 + win; i++) {
                if (board[i][j] == mark) {
                    count++;
                }

                if (count >= win) {
                    return true;
                }
                if(check == 0 && j < col - 1)
                        j++;
                if(check == 1 && j > 0)
                        j--;
                }
            }
            return false;
    }

    /*@ensures The proper layout for the GameBoard object is printed
     *@returns A string containing the layout of the GameBoard
     */
    @Override
    public String toString() {
        String result = "   ";
        for (int l = 0; l < col; l++) {
            if (l < 10)
                result = result.concat(" " + l + "|");
            else
                result = result.concat(l + "|");
        }
        result = result.concat("\n");
        for (int i = 0; i < row; i++) {
            if (i < 10)
                result = result.concat(" " + i + "|");
            else
                result = result.concat(i + "|");
            for (int j = 0; j < col; j++)
                result = result.concat(board[i][j] + " |");
            result = result.concat("\n");
        }
        return result;
    }
}

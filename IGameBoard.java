

/**
 * IGameBoard represents a 2-dimensional gameboard that has characters
 * on it as markers (X, O). No space on the board can have multiple
 * players, and there can be a clear winner. Board is NUM_ROWS x
 * NUM_COLS in size
 *
 * Initialization ensures: the Board does not have any markers on it
 * Defines: NUM_ROWS: Z
 * Defines: NUM_COLS: Z
 * Constraints: O < NUM_ROWS <= MAX_SIZE
 *                      0 < NUM_COLS <= MAX_SIZE
 */

public interface IGameBoard
{
    int MAX_SIZE = 100;

    /*@param pos is a marker that the function checkSpace is testing
     *@requires that pos.getColumn() and pos.getRow() are integers
     *@ensures A true or false value depending on if the space is valid or not
     */
    boolean checkSpace(BoardPosition pos);
    /*@param marker contains the coordinates and the type of mark that will be placed on the board
     *@requires marker.getColumn() and pos.getRow() are integer values that are within the
     *range Min_Value <= x <= SIZE - 1
     *@ensures that placeMarker adds the marker to the gameboard
     */
    void placeMarker(BoardPosition lastPos);
    /*@param lastPos is the point that is used for checking if there is a win
     *@requires lastPos.getColumn() and lastPos.getRow() are integer values
     *@ensures checkForWinner returns true if there is a win and false otherwise
     */
    boolean checkForWinner(BoardPosition lastPos);
}

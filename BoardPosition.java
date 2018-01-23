
public class BoardPosition
{
    private int row;
    private int column;
    private char character;

    /*@param rowPos is the row number that will be used for the marker
     *@param columnPos is the column number that will be used for the marker
     *@param character determines whether or not the marker is an X or an O
     *@ensures BoardPosition creates a BoardPosition object
     */
    public BoardPosition(int x, int y, char c)
    {
        row = x;
        column = y;
        character = c;
    }

    /*@ensures getRow = row
     *@returns rowPos
     */
    public int getRow(){
        return row;
    }

    /*@ensures getColumnPos() = columnPos
     *@returns columnPos
     */
    public int getColumn(){
        return column;
    }

    /*@ensures getPlayer() = character
     *@returns character
     */
    public char getPlayer(){
        return character;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof BoardPosition)){
            return false;
        }

        BoardPosition pos = (BoardPosition)obj;


        if(pos.getRow() == this.getRow() && pos.getColumn() == this.getColumn()
                && pos.getPlayer() == this.getPlayer() )
            return true;
        else
            return false;
    }
}

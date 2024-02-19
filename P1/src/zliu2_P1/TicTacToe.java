package zliu2_P1;

public class TicTacToe {
    //Create a Game Board.
    private final char[][] arr;
    //To set the size of the game board as a constant.
    private final int SIZE;
    //To hold the piece of player
    private char piece;
    //To count the times playerX has won.
    private int countWinnerX;
    //To count the times playerO has won.
    private int countWinnerO;
    //To count the tie game.
    private int countTie;

    /**
     * Constructor
     * @param size the size of Game Board.
     */
    public TicTacToe(int size) {
        //To initialize the size of game board
        SIZE = size;
        //Create a new 2DArray
        arr = new char[SIZE][SIZE];
        //Initialize times of winning
        countWinnerX = 0;
        countWinnerO = 0;
        countTie = 0;
    }

    /**
     * This method will restart the game
     */
    public void reStart(){
        //To initialize all the spaces
        for(int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                arr[i][j] = ' ';
        //To initialize the piece.
        piece = ' ';
    }

    /**
     * This method will print out the Game Board.
     */
    public void printBoard(){
        //Print out the first line of the game board.
        System.out.print("\n" + " " + 0 + " " + 1 + " " + 2);
        //To print out the Array.
        //Set the row.
        for (int i = 0; i < SIZE; i++){
            //Print out the number of the row.
            System.out.print("\n" + i);
            //To set the column.
            for (int j = 0; j < SIZE; j++) {
                //To print out the value in the same row.
                System.out.print(arr[i][j] + "|");
            }
            //Print out the board line.
            System.out.print("\n_________");
        }
    }

    /**
     * To place the piece on the game board.
     * @param row the row of the piece.
     * @param col the column of the piece.
     */
    public void setPiece(int row, int col){
        //To set the space to the piece.
        arr[row][col] = piece;
    }

    /**
     * This method will check if anyone has won the game.
     * @return boolean if there is a winner
     */
    public boolean hasWinner(){
        //To compare each rows, columns, and diagonal.
        return (arr[0][0] != piece || arr[0][1] != piece || arr[0][2] != piece)
                && (arr[1][0] != piece || arr[1][1] != piece
                || arr[1][2] != piece)
                && (arr[2][0] != piece  || arr[2][1] != piece
                || arr[2][2] != piece)
                && (arr[0][0] != piece || arr[1][0] != piece
                || arr[2][0] != piece)
                && (arr[0][1] != piece || arr[1][1] != piece
                || arr[2][1] != piece)
                && (arr[0][2] != piece || arr[1][2] != piece
                || arr[2][2] != piece)
                && (arr[0][0] != piece || arr[1][1] != piece
                || arr[2][2] != piece)
                && (arr[0][2] != piece || arr[1][1] != piece
                || arr[2][0] != piece);
    }

    /**
     * To check if all the spaces are occupied.
     * @return boolean if the game board is finished by the players.
     */
    public boolean isGameOver(){
        //Set isGameOver to true.
        boolean isGameOver = true;
        //To set the row of the game board.
        int i = 0;
        //To check each space on the board.
        while (i < SIZE) {
            //To check each column in the row.
            for(int j = 0; j < SIZE; j++){
                //If there is empty space, the game is not over.
                if (arr[i][j] == ' ') {
                    isGameOver = false;
                }
            }
            i++; //Move to next row.
        }
        //Return the result.
        return isGameOver;
    }

    /**
     * This method will set the piece for the players
     */
    public void setRole(){
        //If the last piece is X, O will be the next piece to be placed.
        if(piece == 'X') {
            piece = 'O';
        }
        //To set the turn to place the X piece
        else piece = 'X';
    }

    /**
     * This method will the piece (X or O).
     * @return piece the piece that the user is using.
     */
    public char getRole(){
       //Return the piece.
       return piece;
    }

    /**
     * This method will count the number of winning.
     */
    public void setCount(){
        //Count a winner X when the player placed a piece X and won the game.
        if (piece == 'X')
            countWinnerX++;
        //Count a winner O when the player placed a piece O and won the game.
        else if (piece == 'O')
            countWinnerO ++;
    }

    /**
     * This method will count a tie game.
     */
    public void setTie(){
        //Count a tie game when there was no winner.
        countTie++;
    }

    /**
     * This method will print out the Game Stats.
     */
    public void getGameStats(){
        //Print the title of game stats.
        System.out.print("\nGame Stats");
        //Print out the number of winning of the player X.
        System.out.print("\nX has won " + countWinnerX + " game.");
        //Print out the number of winning of the player O.
        System.out.print("\nO has won " + countWinnerO + " game.");
        //Print out the number of tie game.
        System.out.print("\nThere have been " + countTie + " tie games.\n");

    }

    /**
     * This method will check if the location of a piece is bad.
     * @param row the row of the piece.
     * @param col the column of the piece.
     * @return boolean location if the user place the piece on a bad location.
     */
    public boolean isBadlocation(int row, int col){
        //Set the boolean is false.
        boolean location = false;
        //Set location is bad when the space was already taken.
        if (arr[row][col] != ' ')
            location = true;
        //Return the result.
        return location;
    }

}

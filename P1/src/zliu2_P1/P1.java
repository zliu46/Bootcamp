package zliu2_P1;

import java.util.Scanner;
/*
 * Zhou Liu
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
/**
 * This is a program that runs a tic-tac-toe game for two players.
 * The basic game board is a grid of 9 spaces.
 * The program will ask the users to place pieces(X or O).
 * The program will print out the Game Stats when the game is finished
 *
 * @author Zhou Liu
 * @version 1.0
 */
public class P1 {
    /**
     * This is the main method.
     * This method will create a new Tic-Tac-Toe game.
     * This method will get the pieces of each play from the users.
     * Players should follow the rules that placing pieces on the board.
     * Once a player has won the game or all the spaces are occupied,
     * the method will print out the Game Stats.
     * The users are allowed to play as many times as they want.
     * @param args
     */
    public static void main(String[] args) {
        //To hold the pieces.
        char player;
        //To repeat the game.
        char repeat = 'y';
        //To initialize a constant size of the game board.
        final int SIZE = 3;
        //To hold the correct answer
        final char YES = 'y';
        //Create a Scanner Object.
        Scanner keyboard = new Scanner(System.in);
        //Create a new TicTacToe game.
        TicTacToe ticTacToe = new TicTacToe(SIZE);
        //To print out a Welcome Message.
        welcomeMessage();

        //Repeat the program when the user want to run the game.
        while (repeat == YES) {
            //To initialize a TicTocToe game.
            ticTacToe.reStart();
            do {
                //To choose the turn of the player
                ticTacToe.setRole();
                //To get the piece for the player
                player = ticTacToe.getRole();

                int row; //To hold the value of the row
                int col; //To hold the value of the column

                do {
                    //To print out the game board.
                    ticTacToe.printBoard();
                    //To tell the users which turn it is.
                    playerTurn(player);
                    //To get the input of row from the user.
                    row = getRow(keyboard);
                    //To get the input of column from the user.
                    col = getCol(keyboard);
                    //To check if the user placed the piece on the board
                    checkLocation(ticTacToe, row, col);
                    //Ask the user to place the piece again
                    //when the space is taken.
                } while (ticTacToe.isBadlocation(row, col));
                //Placing the piece to the game board.
                ticTacToe.setPiece(row, col);
                //Run the game over and over until all the spaces are occupied
                //or there is a winner.
            } while (!ticTacToe.isGameOver() && ticTacToe.hasWinner());
            //To count how many times players have won
            //And how many times the game was tied.
            setGameStats(ticTacToe); //Set times.
            //To print out the final game board.
            ticTacToe.printBoard();
            //To print out the report of the game
            ticTacToe.getGameStats();
            //Ask users if they want to play the game again.
            System.out.print("\nDo you want to play again? ");
            //Get the answer from the user.
            repeat = keyboard.next().toLowerCase().charAt(0);
        }
        //Print out a Goodbye Message.
        goodbyeMessage();
        //Close Scanner Object.
        keyboard.close();
    }

    /**
     * This is the method to print out a Welcome Message.
     */
    public static void welcomeMessage() {
        //Print Message.
        System.out.print("Welcome to TicTacToe!\n");
    }

    /**
     * This method will get the row of the piece from the user.
     * @param keyboard Scanner Object.
     * @return keyboard.nextInt() The location of row
     */
    public static int getRow(Scanner keyboard) {
        //Get the input of the row.
        System.out.print("\nWhich row? ");
        //return the number of the row.
        return keyboard.nextInt();
    }

    /**
     * This method will get column of the piece from the user.
     * @param keyboard
     * @return keybaord.nextInt() the location of column.
     */
    public static int getCol(Scanner keyboard) {
        //Get the input from the user.
        System.out.print("Which column? ");
        //Return the number of the column.
        return keyboard.nextInt();
    }

    /**
     * This method will print out the turn of each player.
     * @param player the piece of the player
     */
    public static void playerTurn(char player) {

        System.out.print("\n" + player + ", " + " it is your turn.");
    }

    /**
     * This method will print out a Goodbye Message.
     */
    public static void goodbyeMessage() {

        System.out.print("\nThanks for playing!");
    }

    /**
     * This method will check if the user place a piece at a bad location.
     * @param ticTacToe the game board.
     * @param row the row of the piece.
     * @param col the column of the piece.
     */
    public static void checkLocation(TicTacToe ticTacToe, int row, int col) {
        //To print out a message when the location is bad.
        if (ticTacToe.isBadlocation(row, col)) {
            //Tell the user the location is bad and try a new location.
            System.out.print("Bad location, try again...");
        }
    }

    /**
     * This method is to count the result of winning times.
     * @param ticTacToe tictactoe game
     */
    public static void setGameStats(TicTacToe ticTacToe){
        //Count a winning time when there was a winner.
        if (ticTacToe.hasWinner()){
            ticTacToe.setTie();
        }
        //Count a tie game when there were no winners.
        else{
            ticTacToe.setCount();
        }
    }
}

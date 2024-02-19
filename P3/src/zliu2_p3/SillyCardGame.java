package zliu2_p3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the new card game that allows 2 players to play.
 * The game uses a special set of cards that contain the numbers 1 to 13,
 * and there are four copies of each card in the deck.
 * The first person to play all the cards in their hand wins.
 *
 * @author ZhouLiu
 * @version 1.0
 */
public class SillyCardGame {
    /**
     * This is the main method that will get the users' name
     * And run the card game.
     * Users are allowed to play the game as many times as they want
     *
     * @param args
     */
    public static void main(String[] args) {
        //Create a Scanner Object.
        Scanner keyboard = new Scanner(System.in);
        //Prints a welcome message.
        System.out.print("Welcome to the Card Game!\n");
        //To repeat the game.
        final char REPEAT = 'n';
        //Holds the answer.
        char answer;
        int playerNum;
        do {
            System.out.print("How many players?(2-6) ");
            playerNum = keyboard.nextInt();
            keyboard.nextLine();
            ArrayList<String> name = new ArrayList<>();
            //Get the player.
            for(int i = 0; i < playerNum; i++) {
                System.out.print("Enter the first player name: ");
                name.add(keyboard.nextLine());
            }
            //Create a GameModel.
            GameModel game = new GameModel(name);
            //Run the Game.
            game.gamePlay();
            //Ask users if they want to play the game again
            System.out.print("\nPlay again? (no to quit) ");
            answer = keyboard.nextLine().toLowerCase().charAt(0);
        } while (answer != REPEAT);
        //Prints a goodbye message.
        System.out.print("\nThanks for playing!");
        //Close Scanner.
        keyboard.close();
    }
}

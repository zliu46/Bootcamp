package zliu2_p3;

import java.util.ArrayList;
import java.util.Random;

/**
 * This the GameModel class.
 * This class has functions to set the game card deck, players' card deck
 * and to shuffle the card deck.
 * The class also has a method to simulate the card game.
 *
 * @author ZhouLiu
 * @version 1.0
 */
public class GameModel {
    //Holds game cards.
    private ArrayList<Integer> cards = new ArrayList<>();
    //Holds players' names.
    private ArrayList<String> name = new ArrayList<>();
    //Holds players' card decks.
    private ArrayList<Queue<Integer>> playerDeck = new ArrayList<>();
    //Holds the game's card deck.
    private Stack<Integer> cardDeck = new Stack<>();
    //Holds the discard card deck.
    private Stack<Integer> discardDeck = new Stack<>();
    Queue<Integer> player1 = new Queue<>();
    Queue<Integer> player2 = new Queue<>();
    Queue<Integer> player3 = new Queue<>();
    Queue<Integer> player4 = new Queue<>();
    Queue<Integer> player5 = new Queue<>();
    Queue<Integer> player6 = new Queue<>();


    //Holds the turn of players
    private int turn;

    /**
     * Constructor
     * @param playerName's name
     *
     */
    public GameModel(ArrayList<String> playerName){
        for(String player : playerName){
            this.name.add(player);
        }
    }

    /**
     * This method sets which turn of the player  is.
     */
    private void setPlayer(){
        if (turn == 0){
            turn = 1;
        }
        else
            turn = 0;
    }

    /**
     * This method set the game cards
     */
    private void setCards(){
        for(int i = 1; i < 13; i++)
            for (int j = 0; j < 4; j++)
               this.cards.add(i);
    }

    /**
     * This method shuffle the cards and push them onto the card deck.
     */
    private void shuffleDeck() {
        //Create a random object.
        Random rand = new Random();
        //Shuffle the cards.
        for (int i = cards.size(); i > 1; i--) {
            int j = rand.nextInt(i);
            int temp = cards.get(i - 1);
            cards.set(i - 1, cards.get(j));
            cards.set(j, temp);
        }
        //Push each card onto the stack.
        for (Integer card : this.cards) this.cardDeck.push(card);
    }

    /**
     * This method check if the deck is empty.
     * @return boolean if the deck is empty.
     */
    private boolean isDeckEmpty(){return cardDeck.empty();}

    /**
     * This method reset the discard cards to the game's card deck.
     */
    private void resetDeck(){
        //Push each card from the discard deck to the game deck.
        while(!this.discardDeck.empty())
            this.cardDeck.push(this.discardDeck.pop());
    }

    /**
     * This method sets players' card deck.
     */
    private void setPlayerDeck(){
        //Each player dealt with seven cards from the card deck.
        for(int i = 0; i < 7; i++){
            this.player1.enqueue(this.cardDeck.pop());
            this.player2.enqueue(this.cardDeck.pop());
        }
        //Add player card deck to the player deck ArrayList.
        playerDeck.add(player1);
        playerDeck.add(player2);
    }

    /**
     * This method Get a String contains players' cards.
     */
    private String getPlayerDeck(){return this.playerDeck.get(turn).toString();}

    /**
     *
     * @return the discard pile card.
     */
    private Integer getDiscardPile(){
        int card = this.cardDeck.pop();
        this.discardDeck.push(card);
        return card;
    }

    /**
     *
     * @return current card that the player plays
     */
    private Integer getPlayerCurrent(){
        int card = this.playerDeck.get(turn).dequeue();
        this.discardDeck.push(card);
        return card;
    }

    /**
     * This method will push a card from the game deck onto the player's deck.
     */
    private void playerDrawCard(){
           this.playerDeck.get(turn).enqueue(cardDeck.pop());
    }

    /**
     *
     * @return if the player has played all the cards in their hands.
     */
    private boolean hasWinner(){
        if(playerDeck1.empty() || playerDeck2.empty())
            return true;
        else
            return false;
    }

    /**
     * This is the method that runs the card game.
     */
    public void gamePlay(){
        //Set game cards.
        setCards();
        //Shuffle the game cards and push cards onto the card deck.
        shuffleDeck();
        //Set players' card decks.
        setPlayerDeck();
        //Run the game until there is a winner.
        while(!hasWinner()){
            //Set the turn of the player.
            setPlayer();
            //Prints out the player's cards in hands.
            System.out.println("\n\n" + name.get(turn) + "'s turn, cards:\n" + getPlayerDeck() + "|");
            //Check if deck is empty.
            if(isDeckEmpty())
                resetDeck();
            //Get the pile cards.
            int pile = getDiscardPile();
            //Get the current card that the player plays.
            int current = getPlayerCurrent();
            //Prints the pile card.
            System.out.println("discard pile card: " + pile);
            //Prints the player's card.
            System.out.println("Your current cards: " + current);
            //If the player's card is LOWER than the one on the
            // discard stack, the player must take TWO cards from the deal stack
            if(current < pile){
                if(isDeckEmpty())
                    resetDeck();
                System.out.print("Your card is LOWER, pick up 2 cards.");
                playerDrawCard();
                if(isDeckEmpty())
                    resetDeck();
                playerDrawCard();
            }
            //If the card the player plays is EQUAL in number to the one on
            // the top of the discard stack, the player must then take one
            // card from the deal stack
            else if(current == pile){
                if(isDeckEmpty())
                    resetDeck();
                System.out.print("Your card is EQUAL, pick up 1 card.");
                playerDrawCard();
            }
            //if the card the player plays is HIGHER than
            // the one on the top of the discard stack
            else{
                if(isDeckEmpty())
                    resetDeck();
                System.out.print("Your card is HIGHER, turn is over.");
            }
        }
        //Prints out the winning message.
        System.out.print("\nYou have won the game!\n\nThe game has finished.");
    }
}

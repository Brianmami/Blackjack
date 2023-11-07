package coe318.lab5;
/**
 *
 * @author 
 */

import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        //Initialize the instance variable.
        this.cards = new ArrayList();
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
       cards.add(card); //FIX THIS
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        if (!cards.isEmpty()){ //of the arraylist cards is not empty
            
            int testIndex = (int) (Math.random() * cards.size()); //get the index from 0.0 to cards size and change it to int
            
            return cards.remove(testIndex); //removes the card at that index
        } else {
            return null; //FIX THIS
            }
    }
    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(); //use string builder called result to build the appended string
    for (Card card : cards) { //for each loop iterating through the array list cards
        result.append(card.toString()).append(" "); // adding each card to the string with a space following it
    }
    return result.toString().trim(); // Convert the StringBuilder to a String and remove trailing space.
}
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }
}

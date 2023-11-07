package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  //instance variables
  
  private int rank;
  private int suit;
  private boolean faceUp;

  
  public Card(int rank, int suit, boolean faceUp) {
    if (rank >= 2 && rank <=14 && suit >= 0 && suit <= 3) {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = faceUp;
    }
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    
      return faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    return this.rank == c.rank && this.suit == c.suit && this.faceUp == c.faceUp; 
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
    
      if (this.rank < c.rank) {
          return -1;
      } else if (this.rank > c.rank){
          return 1;
      } else {
      
      return this.suit - c.suit;
        }
  }
  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      
      if (rank >= 2 && rank <= 10) {
          return Integer.toString (rank);
      } else {
          switch (rank) {
              case 11 :
                  return "Jack";
              
              case 12 :
                  return "Queen";
               
              case 13 : 
                  return "King";
                 
              case 14 :
                  return "Ace";
                  
              default :
                  return "Wrong";
          }
      }
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    
      switch (suit) {
          case (0) :
              return "Clubs";
              
          case (1) :
              return "Diamonds";
              
          case (2) :
              return "Hearts";
              
          case (3) :
              return "Spades";
              
          default :
              return "no suit";
      }
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
if (!faceUp) {
        return "?";  // If the card is face-down, return "?".
    } else {
        String rankString = getRankString();
        String suitString = getSuitString();
        return rankString + " of " + suitString;  // Return the rank and suit when the card is face-up.
    }
}

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}

/**
 * The Card class holds information about a game card, including suit and number.
 * 
 * @author Alexis Manosca
 */
public class Card
{
    private int number;
    private String suit;
      
    public Card(int number, String suit)
    {
        this.number = number;
        this.suit = suit;
    }

    /**
     * Returns the Card's number
     * @return Card's number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Returns the Card's suit
     * @return Card's suit
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * Returns the Card's number and suit
     * @return A string value of the Card's number and suit
     */
    public String print()
    {
        //Changes 11, 12, and 13 to their face cards and 1 to ace
        if(number == 11)
        {
            return "Jack of " + suit;
        }
        else if(number == 12)
        {
            return "Queen of " + suit;
        }
        else if(number == 13)
        {
            return "King of " + suit;
        }
        else if(number == 1)
        {
            return "Ace of " + suit;
        }
        else
        {
            return number + " of " + suit;
        }
    }

    /**
     * Checks if the given card is the same as the current card
     * @param c The given card to compare the current card with
     * @return A boolean value that says if the Cards are equal 
     */
    public boolean equals(Card c)
    {
        //If both cards have the same number and suit
        if(c.number == this.number && c.suit == this.suit)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
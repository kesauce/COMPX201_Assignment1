public class Card
{
    //Declare variables
    private int number;
    private String suit;
      
    //Constructor
    public Card(int number, String suit)
    {
        //Places arguments into variables
        this.number = number;
        this.suit = suit;
    }

    //Methods
    public int getNumber()
    {
        return number;
    }

    public String getSuit()
    {
        return suit;
    }

    public String print()
    {
        //Changes 11, 12, and 13 to their face cards
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

    //Checks if the given card is the same as the current card
    public boolean equals(Card c)
    {
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
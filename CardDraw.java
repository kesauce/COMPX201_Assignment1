import java.util.Random;
import java.util.ArrayList;


public class CardDraw
{
    //Declaring global variables
    static int NUM_PLAYERS = 10;
    static int NUM_CARDS = 5;
    static int NUM_CARDS_IN_SUIT = 13;
    static CardLinkedList cardDeck = new CardLinkedList();
    static ArrayList<CardLinkedList> playersArrayList = new ArrayList<CardLinkedList>();

    public static void main(String []args)
    {
    
        //Create a new deck of cards
        CreateDeck();

        //Deal the cards among the players
        Deal();
        
        //Display the players hands
        DisplayPlayers();

        //Calculate the winner
        CalculateWinner();

    }

    //Creates a standard deck of cards in the provided card linked list
    public static void CreateDeck()
    {
        //Makes an array of suits
        String[] suitsArray = {"Hearts", "Diamonds", "Spades", "Clubs"};

        //Loops through the suits
        for(String suit : suitsArray)
        {
            //Loops through the card numbers
            for(int i = 1; i <= NUM_CARDS_IN_SUIT; i++)
            {
                //Create a temporary new card
                Card newCard = new Card(i, suit);

                //Add the new card to the list
                cardDeck.addCard(newCard);
            }
        }

        System.out.println("Created deck.");
    }

    //Deals 5 random cards to each player and returns a cardlinkedlist 
    public static void Deal()
    {
        //Create a random class
        Random rand = new Random();

        //For each player
        for(int i = 0; i < NUM_PLAYERS; i++)
        {
            //Create a player linked list of cards
            CardLinkedList playerHand = new CardLinkedList();

            //Get 5 random cards from the deck
            for(int j = 0; j < NUM_CARDS; j++)
            {
                //Find a random card from the deck and create a mew card
                int randomCardIndex = rand.nextInt(cardDeck.getLength());
                Card randomCard = new Card(cardDeck.getCard(randomCardIndex).getNumber(), cardDeck.getCard(randomCardIndex).getSuit());
                
                //Delete that card from the deck
                cardDeck.removeCard(randomCard);

                //Add the card to the player hand
                playerHand.addCard(randomCard);
            }

            //Add the player linked list to the players array
            playersArrayList.add(playerHand);
        }

        System.out.println("Dealt cards.");
    }

    //Prints out to the terminal all the player cards
    public static void DisplayPlayers()
    {
        //Counter
        int playerCount = 1;

        for(CardLinkedList player : playersArrayList)
        {
            //Print to the terminal
            System.out.println("Player " + playerCount + "'s Hand");
            player.print();
            System.out.println("Total points: " + CalculatePoints(player));
            System.out.println("----------");

            //Increment the player count
            playerCount += 1;
        }
    } 

    //Takes in a player and returns the points they received
    public static int CalculatePoints(CardLinkedList player)
    {
        //Make variable
        int points = 0;

        //Make the first card the comparison card
        Card comparisonCard = player.getCard(0);

        //Make a list of all the cards that have been checked
        ArrayList<String> checkedCards = new ArrayList<String>();

        //Loop through the player hand to change the comparison card
        for(int i = 0; i < player.getLength(); i++)
        {
            //Make a duplicate counter
            int duplicateCounter = 0;

            //Change the comparison card to the next card
            comparisonCard = player.getCard(i);

            //Loop through the hand again 
            for (int j = 0; j < player.getLength(); j++)
            {
                //Ensure that the current and comparsion card are not the same variable
                if(!player.getCard(j).print().equals(comparisonCard.print()))
                {
                    //If the current card matches the comparison card number       
                    if(player.getCard(j).getNumber() == comparisonCard.getNumber())
                    {
                        //Increment duplicate counter
                        duplicateCounter++;

                        //Add the found card to the checked cards list
                        checkedCards.add(player.getCard(j).print());
                    }
                }
            }

            //Only add the points if the comparison card has not been checked before
            if(!checkedCards.contains(comparisonCard.print()))
            {
                //Count the points for the comparison card
                points += comparisonCard.getNumber() * Math.pow(10, duplicateCounter);
            }

            //Adds the comparison card to the checked cards list
            checkedCards.add(comparisonCard.print());
            
        }
        return points;
    }

    public static void CalculateWinner()
    {
        //Variables to store the highest points and the winning player index (defaulting to player 1)
        int highestPoints = 0;
        ArrayList<CardLinkedList> winners = new ArrayList<CardLinkedList>();

        //Loop through all the players
        for(CardLinkedList player : playersArrayList)
        {
            //Calculate player points
            int playerPoints = CalculatePoints(player);

            //Replace highscore if highscore is lower and change the winning player
            if(highestPoints < playerPoints)
            {
                winners.clear();
                highestPoints = playerPoints;
                winners.add(player);
            }
            //If another player has the same high score then add them to the players list
            else if(highestPoints == playerPoints)
            {
                winners.add(player);
            }
            
        }

        //Display the winner(s)
        for(CardLinkedList winner : winners)
        {
            System.out.println("The winner(s) are:");
            System.out.println("Player " + (playersArrayList.indexOf(winner)+1) + " with a total of " + highestPoints + " and the following hand: ");
            winner.print();
        }
    }
}
public class Main
{
    public static void main(String [] args)
    {
        //Make new card objects
        Card card1 = new Card(5, "Hearts");
        Card card2 = new Card(7, "Spades");

        //Make a new linked list
        CardLinkedList cardList = new CardLinkedList();
        cardList.addCard(card1);
        cardList.addCard(card2);

        //Print
        cardList.print();
        System.out.println("-----------");
        //System.out.println(cardList.getLength());

        //System.out.println(cardList.hasCard(card1));

        //System.out.println(cardList.isEmpty());

        //System.out.println(cardList.getCard(1).print());
        
        cardList.removeCard(card1);

        //Print
        cardList.print();
    }
}
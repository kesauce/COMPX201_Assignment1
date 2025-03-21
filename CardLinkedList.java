public class CardLinkedList
{
    //Variables
    Node head = null;

    //Methods
    //Checks if the head of the list has a value
    public boolean isEmpty()
    {
        return head == null;
    }

    //Checks how long the list is
    public int getLength()
    {
        Node currentNode = head;
        int counter = 0;

        while(currentNode != null)
        {
            //Increment counter
            counter++;

            //Change the current node to the next
            currentNode = currentNode.next;
        }

        return counter;
    }

    //Checks if the given card is in the list
    public boolean hasCard(Card c)
    {
        Node currentNode = head;
        
        //Loops through the linked lists
        while(currentNode != null)
        {
            if (currentNode.card.equals(c))
            {
                return true;
            }

            //Change the current node to the next
            currentNode = currentNode.next;
        }

        //Returns false if nothing was found
        return false;
    }

    //Gets the card at the given position in the list
    public Card getCard(int target)
    {
        Node currentNode = head;

        //Error checking if target index exists
        if (target < this.getLength())
        {
            for (int i = 0 ; i < target; i++)
            {

                //Change the current node to the next
                currentNode = currentNode.next;
            }
            
            //Returns the card
            return currentNode.card;
        }   

        else
        {
            System.out.println("The entered index is invalid.");
            return null;
        }
        
    }

    //Adds a new card to the head of the list
    public void addCard(Card c)
    {
        //Create a new node and have it point to the previous head
        Node newNode = new Node(c);
        newNode.next = head;

        //Make the head point to the new node
        head = newNode;
    }

    //Removes the first card in the list that matches the given card without changing the order of the list
    public void removeCard(Card c)
    {
        Node currentNode = head;
        Node previousNode = null;

        //Checks if the target card is the head
        if(head.card.equals(c))
        {
            head = head.next;
            return;
        }

        //Checks if the list has the target card
        if (hasCard(c))
        {
            //While not at the end of the loop
            while(currentNode != null)
            {
                //If the target card is found
                if(currentNode.card.equals(c) && !currentNode.card.equals(head))
                {
                    previousNode.next = currentNode.next;
                }

                //Changes the pointers
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            
        }
        else
        {
            System.out.println("Given card is not in the list.");
        }
    }

    //Prints the cards in the list
    public void print()
    {

        Node currentNode = head;

        //Checks if the list is emtpy
        if(isEmpty())
        {
            System.out.println("List is empty.");
            return;
        }

        StringBuilder result = new StringBuilder();

        while(currentNode != null)
        {
            result.append(currentNode.card.print());

            //If there's a next node then add a comma
            if(currentNode.next != null)
            {
                result.append(", ");
            }
            currentNode = currentNode.next;
        }

        //Prints the string
        System.out.println(result.toString());
    }

    //Inner class node
    public class Node
    {
        //Variables
        private Card card;
        private Node next;

        //Constructor
        public Node(Card c)
        {
            this.card = c;
        }
    }
}

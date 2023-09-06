/**
 * A class that implements a list of objects using a linked list.
 * Duplicated entries are allowed.
 *
 * @author Jing Hua Ye
 * @date Oct/30/2021
 * @version 1.0
 */
public class LinkedList<T> implements ListInterface<T>
{
/* =============================================================================
                        HELPER CLASSES
   =============================================================================
 */
    /**
     * A class represents a node, which contains two parts - data and pointer
     * to the next node
     */
    private class Node
    {     //the data of a node
        private T data;
        //pointer to the next node
        private Node next;

        /**
         * To create a new node instance with a specific data
         * @param data the data of a specific node
         */
        public Node(T data)
        {
            this.data = data;
        }

        /**
         * To create a new node instance with a specific data and pointer of
         * the next node
         * @param data the data of a specific node
         * @param next the pointer of a specific next node
         */
        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        /**
         * To get the data of this node
         * @return the data of this Node
         */
        public T getData()
        {
            return data;
        }

        /**
         * To get the pointer of the next node
         * @return the pointer of the next Node
         */
        public Node getNextNode()
        {
            return next;
        }

        /**
         * To set the data of this node
         * @param data the data of this node
         */
        public void setData(T data)
        {
            this.data = data;
        }

        /**
         * To set the pointer of next node
         * @param nextNode the pointer of the next node
         */
        public void setNextNode(Node nextNode)
        {
            this.next = nextNode;
        }
    }
    /* ============================================================================
                            INSTANCE VARIABLES
       ============================================================================
     */
    //the header node
    private Node head;

    //the number of entries in the list
    private int numEntries;

/* ============================================================================
                        CONSTRUCTORS
   ============================================================================
 */
    /**
     * A default constructor
     */
    public LinkedList()
    {
        Node head;
        numEntries = 0;
    }
/* =============================================================================
                       INSTANCE METHODS
   =============================================================================
 */
    /* ---------------------- Getters --------------------------------------------*/
    /**
     * Gets the length of this list.
     * @return the integer number of entries currently in the list
     */
    public int getLength()
    {
        return numEntries;
    }
    /* ---------------------- Other Methods --------------------------------------*/
    /**
     * Add a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry the object to be added as a new entry
     */
    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);

        if (isEmpty())
            this.head = newNode;
            // Add to end of non-empty list
        else
        {
            Node lastNode = getNodeAt(numEntries);
            assert lastNode != null;
            // Make last node reference new node
            lastNode.setNextNode(newNode);
        } // end if

        numEntries++;
    }

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are
     * at the next higher position within the list.
     * The list's size is increased by 1.
     *
     * @param newPosition an integer that specifies the desired position
     * of the new entry
     * @param newEntry the object to be added as a new entry
     * @throws IndexOutOfBoundsException if either newPosition < 1 or
     * mewPosition > getLength() - 1
     */
    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= numEntries + 1) {

            Node newNode = new Node(newEntry);
            if (newPosition == 1)
            {
                newNode.setNextNode(head);
                head = newNode;
            } // case 2: for when list is not empty
            else
            {
                Node nodeBefore = getNodeAt(newPosition - 1);
                assert nodeBefore != null;
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numEntries++;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to add operation");
    }


    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given position
     * are at the next lower position within the list.
     *
     * @param givenPosition an integer that indicates the position of the
     * entry to be removed
     * @return A pointer to the removed entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or
     * givenPosition > getLength()
     */
    public T remove(int givenPosition)
    {
        T res = null;
        if (givenPosition >= 1 && givenPosition <= numEntries)
        {
            if (!isEmpty())
            {
                // Case 1: Remove first entry
                if (givenPosition == 1)
                {
                    // Save entry to be removed
                    res = head.getData();
                    // Remove entry
                    head = head.getNextNode();
                }
                // if ti is not first entry
                else
                {
                    Node nodeBefore = getNodeAt(givenPosition - 1);
                    assert nodeBefore != null;
                    Node nodeToRemove = nodeBefore.getNextNode();
                    // Save entry to be removed
                    res = nodeToRemove.getData();
                    Node nodeAfter = nodeToRemove.getNextNode();
                    // Remove entry
                    nodeBefore.setNextNode(nodeAfter);
                } // end if
            }
            // Update count
            numEntries--;
            // Return removed entry
            return res;
        }
        else
            throw new IndexOutOfBoundsException("Invalid position");
    }

    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition an integer that indicates the position of the entry
     * to be replaced
     * @param newEntry the object that will replace the entry at the position
     * givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or
     * givenPosition > getLength()
     */
    public T replace(int givenPosition, T newEntry)
    { if (givenPosition >= 1 && givenPosition <= numEntries)
    {
        assert !isEmpty();

        Node desiredNode = getNodeAt(givenPosition);
        assert desiredNode != null;
        T originalEntry = desiredNode.getData();
        desiredNode.setData(newEntry);
        return originalEntry;
    }
    else
        throw new IndexOutOfBoundsException("Illegal position given to replace operation");
    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition an integer that indicates the position of the
     * desired entry
     * @return A pointer to the indicated entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or
     * givenPosition > getLength()
     */
    public T getEntry(int givenPosition)
    { if (givenPosition >= 1 && givenPosition <= numEntries)
    {
        assert !isEmpty();
        return getNodeAt(givenPosition).getData();
    }
    else
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry the object that is the desired entry
     * @return true if the list contains anEntry, otherwise false
     */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = head;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
        return found;
    }

    /**
     * Sees whether this list is empty.
     * @return true if the list is empty, otherwise false
     */
    public boolean isEmpty()
    {
        boolean result;

        if (numEntries == 0)
        {
            assert head == null;
            result = true;
        }
        else
        {
            assert head != null;
            result = false;
        } // end if

        return result;
    }

    /**
     * Retrieves all entries that are in this list in the order in which they
     * occur in the list.
     *
     * @return a newly allocation array of all the entries in the list. If the
     * list is empty, the returned array is empty.
     */
    public T[] toArray()
    {   T[] result = (T[])new Object[numEntries];
        int index = 0;
        Node currentNode = head;
        while (index < numEntries && currentNode != null)
        {   result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    /**
     * To remove all nodes in the list
     */
    public void clear()
    {
        head.setNextNode(null);
        numEntries = 0;
    }
/* =============================================================================
                       HELPER METHODS
   =============================================================================
 */
    /**
     * It traverse the whole list until we locate the node at the desired
     * position within the list
     * @param givenPosition an integer that indicates the position of the
     * desired entry
     */
    private Node getNodeAt(int givenPosition)
    { if (head != null && givenPosition >= 1 && givenPosition <= numEntries)
    {  Node currentNode = head;
        for (int counter = 1; counter < givenPosition; counter++)
            if (currentNode != null)
                currentNode = currentNode.getNextNode();
        return currentNode;
    }
        return null;
    }
}

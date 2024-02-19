package zliu2_p3;
import java.util.EmptyStackException;

/**
 * This is the RenderQueue class includes functions below:
 * Queue
 * Append
 * Copy
 * Dequeue
 * Empty
 * Enqueue
 * fromString
 * toString
 *
 * @author Zhou Liu
 * @version 1.0
 */
public class Queue <T> {
    /**
     * This is the node class.
     */
    private class Node{
        //Holds RenderCommand
        T value;
        //Predecessor
        Node prev;
        //Successor。
        Node next;

        /**
         * Constructors
         * @param val RenderCommand
         * @param n point to the next
         * @param p point to the previous
         */
        public Node(T val, Node n, Node p){
            value = val;
            this.next = n;
            this.prev = p;
        }

        /**
         * Constructors
         * @param val RenderCommand
         * To initialize pointer to be null.
         */
        public Node(T val){this(val,null,null);}
    }
    //Head of the queue
    private Node head = null;
    //Tail of the queue
    private Node tail = null;

    /**
     *
     * @return if the queue is empty.
     */
    public boolean empty() {
        return head == null;
    }

    /**
     * Add elements to the queue
     * @param val element
     */
    public void enqueue(T val){
        //Queue is empty
        if (empty())
        {
            //Add element to the head of queue
            this.head = new Node(val);
            //Set tail of the queue
            this.tail = head;
        }
        else
        {
            //To insert the element to the tail.
            this.tail.next = new Node(val, null, tail);
            //Set a new tail of queue.
            tail = tail.next;
        }
    }

    /**
     * Removed element from the queue.
     * @return value of the RenderCommand removed from the queue.
     */
    public T dequeue() {
        //Throws an exception when it's empty
        if (empty()){
            throw new EmptyStackException();
        }else{
            //Holds the head of queue's value.
            T value = head.value;
            //Set a new head of queue.
            head = head.next;
            //if queue is empty after removing
            if (head == null)
                tail = null;
            //Return RenderCommand
            return value;
        }

    }

    /**
     * Add a new queue after the queue
     * @param queue RenderQueue
     */
    public void append(Queue queue) {
        //Add each value from the RenderQueue to this queue
        for(Node p = queue.head; p != null; p = p.next){
            this.enqueue(p.value);
        }
    }

    /**
     * This method copy the current queue
     * @return the copy of current queue
     */
    public Queue copy() {
        //Create a new RenderQueue
        Queue queue = new Queue();
        //Holds the value of head
        Node p = this.head;
        //copy each value to the queue
        while (p != null){
            queue.enqueue(p.value);
            p = p.next;
        }
        //Return queue.
        return queue;
    }

    /**
     * This method turns the RenderQueue to a String
     * @return a String
     */

    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();

        Node p = head;
        while (p != null)
        {
            sBuilder.append("| " + p.value + " ");
            p = p.next;
        }
        return sBuilder.toString();
    }
    public T peek(){
        T value = head.value;
        return value;
    }
}

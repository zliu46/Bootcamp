package generic;

public class Queue<E> {
    // front of the queue
    private Node head;
    // rear of the queue . Good name
    private Node tail;

    /**
     * The Node class is used to implement the doubly linked list.
     * @author Mike McKee
     */
    private class Node {
        /**
         * Hold element of queue.
         */
        public E data;

        /**
         * Points to the previous node in doubly linked list.
         */
        public Node prev;

        /**
         * Points to next node in doubly linked list.
         */
        public Node next;

        /**
         * The Node constructor initializes each instance of the Node class.
         * @param data  The data that is stored in Node
         * @param prev  A pointer to the previous Node
         * @param next  A pointer to the succeeding Node
         */
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * The no-arg constructor initializes each new instance of the class.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Adds items to tail end of queue.
     * @param data  The data that is being added to the queue
     */
    public void enqueue(E data) {
        Node newTail;   //holds new Node for item to be added to end of queue

        newTail = new Node (data, null, null);

        //if the queue is empty
        if (head == null) {
            head = newTail;
            tail = newTail;
        }

        //else the queue is not empty, add to tail
        else {
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
    }

    /**
     * Removes and returns the item at front(head) of queue.
     * @return item at head of queue (the first thing in)
     * @throws IllegalArgumentException user tries to dequeue an empty queue
     */
    public E dequeue() {
        E queueTop;        //holds item at head of queue

        //when user tries to dequeue an empty queue
        if (head == null)
            throw new IllegalArgumentException("You can't pop an empty queue, "
                    + "Silly!");

        queueTop = head.data;

        //when item x is the last item in queue
        if (head.next == null && tail.prev == null) {
            head = null;
            tail = null;
        }

        //if this item is not last in queue
        else {
            head = head.next;
            head.prev = null;
        }
        return queueTop;
    }

    /**
     * Returns the item at front(head) of queue.
     * @return item at head of queue (the first thing in)
     * @throws IllegalArgumentException user tries to peek at an empty queue
     */
    public E peek() {
        E queueTop;        //holds item at head of queue

        //when user tries to peek at an empty queue
        if (head == null)
            throw new IllegalArgumentException("You can't pop an empty queue, "
                    + "Silly!");
        else {
            queueTop = head.data;
            return queueTop;
        }
    }

    /**
     * Returns String representation of a RenderQueue object
     * @return String representation of a RenderQueue object
     * @throws IllegalArgumentException there is an invalid RenderCommand

     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node i = head; i != null; i = i.next) {
            sb.append(i.data);
            sb.append(";");
        }
        return sb.toString();
    }

    /**
     * Appends a copy of the given queue onto the current queue.
     * @param appendQueue A RenderQueue object
     */
    public void append(Queue<E> appendQueue) {
        Queue<E> myCopy;     //address to a copy of RenderQueue

        myCopy = appendQueue.copy();
        while (myCopy.head != null) {
            this.enqueue(myCopy.head.data);
            myCopy.head = myCopy.head.next;
            if (myCopy.head != null)
                myCopy.head.prev = null;
        }
    }

    /**
     * Checks if two queues are equal.
     * @param q2 queue to compare
     * @return true if both queues are equal and false otherwise
     */
    public boolean equals(Queue<E> q2) {
        Node p = head;
        Node p2 = q2.head;

        //while both queues not empty, compare data
        while (p != null && p2 != null) {
            if (p.data != p2.data)
                return false;
            p = p.next;
            p2 = p2.next;
        }


        if ((p == null) && (p2 == null))
            return true;
        else
            return false;
    }

    /**
     * makes a deep copy of the queue.
     * @return a deep copy of a RenderQueue object
     */
    public Queue<E> copy() {
        Node p;         //reference to head Node
        Queue<E> copyObject = new Queue<>();

        for (p = this.head; p != null; p = p.next) {
            copyObject.enqueue(p.data);
        }
        return copyObject;
    }

    /**
     * checks to see if queue is empty.
     * @return true if queue is empty and false otherwise
     */
    public boolean empty() {
        return head == null;
    }
}
package zliu2_p2;

import java.io.File;
import java.util.Scanner;

public class MessageDecoder {
    /**
     The Node class represents a list node.
     */
    private class Node{
        String value;
        int index;
        Node next;

        /**
         * Constructor.
         * @param val The element to store string in this node.
         * @param i The element to store integer in this node.
         * @param n The reference to the next node.
         */
        Node (String val, int i, Node n){
            value = val;
            index = i;
            next = n;
        }

        /**
         * Constructor
         * @param val The element to store in this node.
         * @param i The element to store in this node.
         */
        Node(String val, int i){
            this(val, i, null);
        }
    }

    private Node first; //list head.
    private Node last; //last element in the list.

    /**
     * constructor.
     * To set first and last to null.
     */
    public MessageDecoder()
    {
        first = null;
        last = null;
    }

    /**
     *
     * @return if the head of the list is empty.
     */
    public boolean isEmpty(){return first == null;}

    /**
     * This method will add elements to the list.
     * @param e The element holds a string.
     * @param i The element holds a integer.
     */
    public void add(String e, int i)
    {
        //Create a new node with new elements.
        Node current = new Node(e, i);
        //Check if the list is empty.
        //is the list is empty, add the element to the head of list.
        if (isEmpty()){
            first = current;
            last = first;
        }
        //when the list is not empty, add elements to existing list.
        else{
            //Set a reference to hold the list.
            Node p = first;
            //When the element smaller than the element in the head of list.
            if (current.index < p.index){
                //Add the element before existing list.
                current.next = p;
                //Set the head of list.
                first = current;
            }
            //The element larger than the last element of list.
            else if (current.index > last.index){
                //add element after the last element of list.
                last.next = current;
                //set the tail of list.
                last = current;
            }
            //The element is between the head and the tail of list.
            else{
                //find the place to add the element.
                while (current.index > p.next.index){
                    p = p.next;
                }
                //add the element to the list.
                current.next = p.next;
                p.next = current;
            }
        }
    }

    /**
     * This method gets the plain message.
     * @return str.toString() The plain message.
     */
    public String getPlainTextMessage(){
        //Set a reference to hold the list
        Node p = first;
        //Create a StringBuilder object.
        StringBuilder str = new StringBuilder();
        //Add elements to the String until the end of list.
        while (p != null){
           str.append(p.value);
           //move to the next element of list.
           p = p.next;
        }
        //return String.
        return str.toString();
    }
}


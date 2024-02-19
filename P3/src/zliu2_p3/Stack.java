package zliu2_p3;

import java.util.EmptyStackException;

/**
 * This is the linked list stack class.
 *
 * @author ZhouLiu
 * @version 1.0
 */
public class Stack <T>{
    /**
     * class Node
     */
    public class Node{
        //Holds double
        T operand;
        //Holds pointer.
        Node next;

        /**
         * constructors
         * @param num double that the user enters
         * @param n next node
         */
        Node(T num, Node n){
            operand = num;
            next = n;
        }
    }
    //Holds the top of the stack.
    private Node top = null;

    /**
     * The method to check if the stack is empty.
     * @return is the stack empty.
     */
    public boolean empty()
    {
        return top == null;
    }

    /**
     * The method that stack doubles.
     * @param num double that the user want to stack.
     */
    public void push(T num)
    {
        top = new Node(num, top);
    }

    /**
     * The method to pop the stack.
     * @return the top of the stack
     */
    public T pop()
    {
        //Throws an exception when the stack is empty.
        if (empty())
            throw new EmptyStackException();
        else
        {
            //Holds the top of stack.
            T value = top.operand;
            //Pop the stack.
            top = top.next;
            //Return the value of stack.
            return value;
        }
    }

    /**
     * The method to return the value of the top of stack.
      * @return the value of the top
     */
    public T peek() {
        //Throws an exception when stack is empty.
        if (empty())
            throw new EmptyStackException();
        else
            //return the value.
            return top.operand;

    }
    public String toString()
    {
        StringBuilder sBuilder = new StringBuilder();
        Node p = top;
        while (p != null)
        {
            sBuilder.append(p.operand);
            p = p.next;
            if (p != null)
                sBuilder.append("\n");
        }
        return sBuilder.toString();
    }
}

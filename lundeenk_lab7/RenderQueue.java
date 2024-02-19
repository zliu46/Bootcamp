package lundeenk_lab7;

import java.util.ArrayList;

public class RenderQueue {
    private class Node {
        RenderCommand value;
        Node next;
        Node prev;

        public Node(RenderCommand renderCommand) {
            this.value = renderCommand;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public RenderQueue() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

   public static RenderCommand[] fromString(String string) {
      ArrayList<RenderCommand> output = new ArrayList<RenderCommand>();
      for (int i = 0; i < string.length(); i++) {
         char c = string.charAt(i);
         RenderCommand renderCommand = RenderCommand.FORWARD;
         switch (c) {
            case 'F':
               renderCommand = RenderCommand.FORWARD;
               break;
            case 'R':
               renderCommand = RenderCommand.FORWARD2;
               break;
            case '+':
               renderCommand = RenderCommand.LEFT;
               break;
            case '-':
               renderCommand = RenderCommand.RIGHT;
               break;
            case 'X':
               renderCommand = RenderCommand.IGNORE;
               break;
            case '[':
               renderCommand = RenderCommand.PUSH;
               break;
            case ']':
               renderCommand = RenderCommand.POP;
               break;
         }
         output.add(renderCommand);
      }
      RenderCommand[] arr = new RenderCommand[][output.size()];
       arr = output.toArray(arr);
      return arr;
   }

    public static String toString(RenderQueue queue) {
        String output = "";
        RenderQueue copy = queue.copy();
        while (!copy.empty()) {
            char c = ' ';
            switch (copy.dequeue()) {
                case FORWARD:
                    c = 'F';
                    break;
                case FORWARD2:
                    c = 'R';
                    break;
                case LEFT:
                    c = '+';
                    break;
                case RIGHT:
                    c = '-';
                    break;
                case IGNORE:
                    c = 'X';
                    break;
                case PUSH:
                    c = '[';
                    break;
                case POP:
                    c = ']';
                    break;
            }
            output += c;
        }
        return output;
    }

    public void enqueue(RenderCommand renderCommand) {
        Node node = new Node(renderCommand);
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public RenderCommand dequeue() {
        Node next = this.head.next;
        this.head.next = next.next;
        return next.value;
    }

    public void append(RenderCommand renderCommand) {
        this.enqueue(renderCommand);
    }

    public boolean empty() {
        return this.head.next == this.tail;
    }

    public RenderQueue copy() {
        RenderQueue copy = new RenderQueue();
        Node p = this.head;
        while (p != this.tail) {
            copy.enqueue(p.value);
        }
        return copy;
    }
}

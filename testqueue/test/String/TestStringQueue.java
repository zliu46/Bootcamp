package String;

import String.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringQueue
{

    /**
     * This will test if the method is not empty for a String. Because three variables are loaded
     * in here, it should assert a False on it being empty
     */
    @Test
    void testQueueNotEmptyString()
    {
        Queue stringQue = new Queue();
        stringQue.enqueue("I");
        stringQue.enqueue("love");
        stringQue.enqueue("dogs");
        Assertions.assertFalse(stringQue.empty());
    }


    @Test
    void testQueueEnqueueCountString()
    {
        Queue stringQue = new Queue();
        boolean isEnqueueWork = false;

        String iLoveDogs = "I love dogs";
        String resultStr= new String();

        stringQue.enqueue("I");
        resultStr += "I ";
        stringQue.enqueue("love");
        resultStr += "love ";
        stringQue.enqueue("dogs");
        resultStr += "dogs ";
        //Adding space bc dequeue only return the value
        resultStr = stringQue.dequeue();
        resultStr += " ";
        resultStr += stringQue.dequeue();
        resultStr += " ";
        resultStr += stringQue.dequeue();

        if (resultStr.equals(iLoveDogs))
            isEnqueueWork = true;

        Assertions.assertEquals(true,isEnqueueWork);
    }

    @Test
    void testEnqueueDequeueString()
    {
        Queue stringQue = new Queue();
        stringQue.enqueue("John");
        Assertions.assertEquals("John", stringQue.dequeue());
    }



    @Test
    void testQueueEnqueuePeekString()
    {
        // Put three things in Queue and peek at first value
        Queue stringQue = new Queue();
        stringQue.enqueue("hello");
        Assertions.assertEquals("hello",stringQue.peek());
    }




    @Test
    void testToStringString()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        String testString = new String();
        Queue stringQue = new Queue();
        stringQue.enqueue("ABC");
        testString += "ABC";
        testString += ";";
        stringQue.enqueue("DEF");
        testString += "DEF";
        testString += ";";
        Assertions.assertEquals(testString, stringQue.toString());
    }

    @Test
    void testExceptionDequeue()
    {
        Queue stringQue = new Queue();
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            String testString = stringQue.dequeue();
        });
        String expectedMessage = "Silly!";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testExceptionPeek()
    {
        Queue stringQue = new Queue();
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            String testString = stringQue.peek();
        });
        String expectedMessage = "empty queue";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAppendString()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue stringQue = new Queue();
        Queue appendQue = new Queue();

        stringQue.enqueue("1");
        stringQue.enqueue("2");

        appendQue.enqueue("3");
        appendQue.enqueue("4");

        stringQue.append(appendQue);
        stringQue.dequeue();
        stringQue.dequeue();
        stringQue.dequeue();
        Assertions.assertEquals("4",stringQue.dequeue());
    }

    @Test
    void testRemoteTopOfStack()
    {
        // Create a Stack
        Queue retQueue = new Queue();
        Stack stringStack = new Stack();

        stringStack.push("Tom");
        stringStack.push("Ana");
        stringStack.push("Chen");
        retQueue = Queue.removeTopOfStack(stringStack,"Ana");
        // check the queue to see that there are two items
        Assertions.assertEquals("Chen",retQueue.dequeue());
    }
 }
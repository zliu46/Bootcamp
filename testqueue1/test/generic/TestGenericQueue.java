package generic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
public class TestGenericQueue
{

    /**
     * This will test if the method is not empty for a String. Because three variables are loaded
     * in here, it should assert a False on it being empty
     */
    @Test
    void testQueueNotEmptyString()
    {
        Queue<String> stringQue = new Queue<>();
        stringQue.enqueue("I");
        stringQue.enqueue("love");
        stringQue.enqueue("dogs");
        Assertions.assertFalse(stringQue.empty());
    }

    @Test
    void testQueueNotEmptyDouble()
    {
        Queue<Double> doubleQue = new Queue<>();
        doubleQue.enqueue(1.2);
        doubleQue.enqueue(2.2);
        doubleQue.enqueue(3.2);
        Assertions.assertFalse(doubleQue.empty());
    }


    @Test
    void testQueueEnqueueCountString()
    {
        Queue<String> stringQue = new Queue<>();
        boolean isEnqueueWork = false;

        String iLoveDogs = "I love dogs";
        String resultStr= new String();

        stringQue.enqueue("I");
        resultStr += "I ";
        stringQue.enqueue("love");
        resultStr += "love ";
        stringQue.enqueue("dogs");
        resultStr += "dogs ";

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
        Queue<String> stringQue = new Queue<>();
        stringQue.enqueue("John");
        Assertions.assertEquals("John", stringQue.dequeue());
    }

    @Test
    void testEnqueueDequeueDouble()
    {
        Queue<Double> doubleQue = new Queue<>();
        doubleQue.enqueue(3.14);
        Assertions.assertEquals(3.14, doubleQue.dequeue());
    }

    @Test
    void testQueueEnqueuePeekString()
    {
        // Put three things in Queue and peek at first value
        Queue<String> stringQue = new Queue<>();
        stringQue.enqueue("hello");
        Assertions.assertEquals("hello",stringQue.peek());
    }

    @Test
    void testQueueEnqueuePeekDouble()
    {
        // Put three things in Queue and peek at first value
        Queue<Double> doubleQue = new Queue<>();
        doubleQue.enqueue(1.23456789);
        Assertions.assertEquals(1.23456789,doubleQue.peek());
    }

    @Test
    void testCopyDouble()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue<Double> doubleQue = new Queue<>();
        doubleQue.enqueue(1.23456789);
        doubleQue.enqueue(2.34567890);
        Queue<Double> copyQueue = doubleQue.copy();
        // dequeue the first one and see if it is right
        Assertions.assertEquals(doubleQue.dequeue(), copyQueue.dequeue());
    }

    @Test
    void testCopyInteger()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue<Integer> integerQue = new Queue<>();
        integerQue.enqueue(1);
        integerQue.enqueue(2);
        Queue<Integer> copyQueue = integerQue.copy();
        // dequeue the first one and see if it is right
        Assertions.assertEquals(integerQue.dequeue(), copyQueue.dequeue());

    }

    @Test
    void testEqualsInteger()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue<Integer> integerQue = new Queue<>();
        integerQue.enqueue(1);
        integerQue.enqueue(2);
        Queue<Integer> copyQueue = integerQue.copy();
        // dequeue the first one and see if it is right
        Assertions.assertTrue(integerQue.equals(copyQueue));

    }

    @Test
    void testNotEqualsInteger1()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue<Integer> integerQue = new Queue<>();
        integerQue.enqueue(1);
        integerQue.enqueue(2);
        Queue<Integer> copyQueue = integerQue.copy();
        integerQue.enqueue(3);
        // dequeue the first one and see if it is right
        Assertions.assertFalse(integerQue.equals(copyQueue));
    }

    @Test
    void testNotEqualsInteger2()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        Queue<Integer> integerQue = new Queue<>();
        integerQue.enqueue(1);
        integerQue.enqueue(2);
        Queue<Integer> copyQueue = integerQue.copy();
        integerQue.enqueue(3);
        copyQueue.enqueue(4);
        // dequeue the first one and see if it is right
        Assertions.assertFalse(integerQue.equals(copyQueue));
    }


    @Test
    void testToStringString()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        String testString = new String();
        Queue<String> stringQue = new Queue<>();
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
        Queue<String> stringQue = new Queue<>();
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
        Queue<String> stringQue = new Queue<>();
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
        Queue<String> stringQue = new Queue<>();
        Queue<String> appendQue = new Queue<>();

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
 }
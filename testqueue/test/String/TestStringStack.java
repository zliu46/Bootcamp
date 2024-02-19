package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringStack {
    @Test
    void testStackEmptyString(){
        Stack stringStack = new Stack();
        stringStack.push("I");
        stringStack.push("love");
        stringStack.push("dogs");
        Assertions.assertFalse(stringStack.empty());
    }
    void testStackPushCountString()
    {
        Stack stringStack = new Stack();
        boolean isStackWork = false;

        String iLoveDogs = "I love dogs";
        String resultStr= new String();

        stringStack.push("I");
        resultStr += "I ";
        stringStack.push("love");
        resultStr += "love ";
        stringStack.push("dogs");
        resultStr += "dogs ";
        //Adding space bc dequeue only return the value
        resultStr = stringStack.pop();
        resultStr += " ";
        resultStr += stringStack.pop();
        resultStr += " ";
        resultStr += stringStack.pop();

        if (resultStr.equals(iLoveDogs))
            isStackWork = true;

        Assertions.assertEquals(true,isStackWork);
    }
    @Test
    void testPushPopString()
    {
        Stack stringStack = new Stack();
        stringStack.push("John");
        Assertions.assertEquals("John", stringStack.pop());
    }
    @Test
    void testStackPushPeekString()
    {
        // Put three things in Queue and peek at first value
        Stack stringStack = new Stack();
        stringStack.push("hello");
        Assertions.assertEquals("hello",stringStack.peek());
    }
    @Test
    void testToStringString()
    {
        // Build a Queue
        // Copy it
        // Test the equals on it
        String testString = new String();
        Stack stringStack = new Stack();
        stringStack.push("ABC");
        testString += "ABC";
        testString += ";";
        stringStack.push("DEF");
        testString += "DEF";
        testString += ";";
        Assertions.assertEquals(testString, stringStack.toString());
    }
    @Test
    void testExceptionDequeue()
    {
        Stack stringStack = new Stack();
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            String testString = stringStack.pop();
        });
        String expectedMessage = "Silly!";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testExceptionPeek()
    {
        Stack stringStack = new Stack();
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            String testString = stringStack.peek();
        });
        String expectedMessage = "empty queue";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}

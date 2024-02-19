/**
	This program demonstrates how you cannot use
	the == operator to compare two objects and
	determine whether they contain the same values.
*/

public class BadStockCompare
{
   public static void main(String[] args)
   {
      // Create two Stock objects with the same values.
      stock company1 = new stock("XYZ", 9.62);
      stock company2 = new stock("XYZ", 9.62);
      
      // Use the == operator to compare the objects.
      // (This is a mistake.)
      if (company1 == company2)
         System.out.println("Both objects are the same.");
      else
         System.out.println("The objects are different.");
   }
}
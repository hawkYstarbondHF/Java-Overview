// DO NOT IMPORT PACKAGES THAT ARE NOT ALREADY INCLUDED
import java.io.*;
import java.util.Scanner;

/**
 * Assignment that provides an overview of basic features
 * of the Java programming language.
 *
 * This code will be executed by running the following commands from the console:
 * javac JavaOverview.java
 * java JavaOverview      
 * 
 * See instructions in the README on how to run unit tests from the command line.
 * You can also run JavaOverviewTest.java as a JUnit5 test in Eclipse.
 *
 * I recommend using either Eclipse or GitHub codespaces to work on this code. 
 * If you use Eclipse, make sure the unit tests from the command line
 * execute successfully before submitting.
 * 
 * You are expected to complete all exercises according
 * to the specifications. Do not change the names or headers
 * for any existing methods. You may add new methods, and
 * will specifically be required to for some exercises.        
 * All methods that you create should have public access.
 * Absolutely all methods in this file must have complete
 * Javadoc style header comments with all appropriate tags,
 * such as return and param, filled out. Additional documentation
 * is required within method bodies as appropriate. Some
 * method stubs currently return a dummy result to allow
 * compilation, but you will need to replace these with
 * proper return values. Whenever console output is required,        
 * all formatting must match the specification exactly.
 * 
 * @author Jacob Schrum, Last modified 6/11/2023                        
 * @author ADD YOUR NAME, ADD DATE
 */
public class JavaOverview {                

	/**
	 * Launches code for all exercises. Do not change.
	 * @param args Not used
	 */
	public static void main(String[] args) {               
		printDivider(1);
		exercise1();
		printDivider(2);
		exercise2();             
		printDivider(3);
		exercise3();
		printDivider(4);     
		exercise4();
		printDivider(5);          
		exercise5();
		printDivider(6);
		exercise6();
	}
	
	/**
	 * Prints a dividing line between each exercise.
	 * @param exerciseNumber Problem number printed in output
	 */              
	public static void printDivider(int exerciseNumber) {
		System.out.println("--Exercise "+exerciseNumber+"----------------------------------");
	}  
	   
///////////////////////////////////////////////////////
	
	/**
	 * Exercise 1: Loops
	 * 6 points functionality, 4 points documentation 
	 * 
	 * Write code inside of this method that computes the sum of all numbers between
	 * 200 and 1287 inclusive that are divisible by 13. You will both print your result,
	 * AND return it directly from the method. The format of your printed output should
	 * be a single line with carriage return, and look like the following:
	 * 
	 * The sum is: XXX
	 * 
	 * where XXX is the resulting sum.
	 *
	 * @return Computed sum
	 */
	public static int exercise1() {
		// TODO: Write according to the specification above.
		return -1; // TODO: Change
	}

///////////////////////////////////////////////////////

	/**
	 * Exercise 2: Strings
	 * 6 points functionality, 7 points documentation
	 * 
	 * Define a method called "firstLongerShorter" that takes
	 * two String parameters that each have at least one
	 * character. Throw an IllegalArgumentException if this
	 * precondition is not satisfied. This method will
	 * return a String consisting of exactly two characters:
	 * The first character of the longer String, followed
	 * by the first character of the shorter String.
	 * If both Strings have equal length, then the first
	 * character of the first String parameter should come
	 * first in the result.
	 * 
	 * After defining your method, uncomment the test calls
	 * below which call your method. Note that your method
	 * must work for any valid input, not just for these
	 * examples.
	 */
	public static void exercise2() {
		// TODO: Uncomment to test your completed method.
		//       Turn in your code with these lines uncommented. 
//		System.out.println(firstLongerShorter("Hello","Bye"));
//		System.out.println(firstLongerShorter("Bye","Hello"));
//		System.out.println(firstLongerShorter("1","abc"));
//		System.out.println(firstLongerShorter("abc","1"));
//		System.out.println(firstLongerShorter("abc","123"));
//		System.out.println(firstLongerShorter("123","abc"));
	}

///////////////////////////////////////////////////////

	/**
	 * Exercise 3: Arrays
	 * 8 points functionality, 7 points documentation
	 * 
	 * Define a method called "moveToEnd" that takes an array of integers
	 * and an index within that array. Modify the array so the item at the 
	 * designated index is now at the end of the array, and items at later 
	 * indices are now shifted one position to the left. All items originally
	 * in the array are still present.
	 * 
	 * Test your method by completing the code below. This code should
	 * create an int array called oneToTen containing 1, 2, ..., 10 in
	 * order, and then send it to your moveToEnd method with an index 
	 * of 4. Afterward, print the contents of oneToTen to the console 
	 * on a single line with a carriage return at the end, and a comma 
	 * and space between each entry. The result should look like the following:
	 * 
	 * 1, 2, 3, 4, 6, 7, 8, 9, 10, 5
	 */
	public static void exercise3() {
		// TODO: Define the array oneToTen here
		
		// TODO: Uncomment this line to test your method.
		//       Turn in your code with this line uncommented.
		//moveToEnd(oneToTen, 4);
		
		// TODO: Print the array contents here
	}

///////////////////////////////////////////////////////

	/**
	 * Exercise 4: Recursion
	 * 10 points functionality, 6 points documentation
	 * 
	 * Define a sequence in the following way. The first three
	 * numbers are 1, 2, and 3. Every subsequent number is the sum of
	 * the previous number, and the number two entries before that
	 * one. So, the first few numbers in the sequence are:
	 * F(0) = 1
	 * F(1) = 2
	 * F(2) = 3
	 * F(3) = 1+3 = 4
	 * F(4) = 2+4 = 6
	 * 
	 * This sequence is similar to, but different from the Fibonacci
	 * sequence. You will write two methods defining this sequence.
	 * One uses pure recursion, the other uses dynamic programming.
	 * You may have been exposed to dynamic programming in Algorithms,
	 * or even in Computer Science II depending on who taught the course.
	 * If you have not been exposed to this concept before (or you want
	 * a refresher), you should search for examples of how dynamic
	 * programming is used to calculate the Fibonacci sequence. Note that
	 * your dynamic programming solution should not use recursion at all.
	 * This is not a strict requirement of dynamic programming, but it
	 * is a requirement of this assignment.
	 * 
	 * The method stubs for each approach are provided below. Once they
	 * are complete, you can uncomment the code in this method to test
	 * them. Note that these methods should throw IllegalArgumentExceptions
	 * for inappropriate inputs.
	 */
	public static void exercise4() {
		// TODO: Uncomment to test your completed methods.
		//       Turn in your code with these lines uncommented. 
//		System.out.println(recursiveSeq(5));
//		System.out.println(dynamicSeq(5));
//		System.out.println(recursiveSeq(8));
//		System.out.println(dynamicSeq(8));
//		System.out.println(recursiveSeq(15));
//		System.out.println(dynamicSeq(15));
	}
	
	/**
	 * Recursively compute the sequence described in the comment for
	 * exercise 4.
	 * @param n Position in the sequence
	 * @return n-th value in the sequence
	 */
	public static long recursiveSeq(int n) {
		return -1; // TODO: Change this
	}

	/**
	 * Compute the sequence described in the comment for
	 * exercise 4 using dynamic programming. This will require
	 * the use of an auxiliary array. DO NOT USE RECURSION!
	 * @param n Position in the sequence
	 * @return n-th value in the sequence
	 */
	public static long dynamicSeq(int n) {
		return -1; // TODO: Change this
	}

///////////////////////////////////////////////////////

	/**
	 * Exercise 5: File I/O
	 * 10 points functionality, 6 points documentation
	 * 
	 * This method should read from the file "numbers.txt" which
	 * contains only integers, exactly one per line. The method should
	 * compute and print the maximum and average of the numbers in the file.
	 * The maximum should be formatted as an int, but the average should be
	 * formatted as a double (compute a floating point average). The output
	 * will consist of exactly two lines, each followed by a carriage return.
	 * Here is an example:
	 * 
	 * Maximum value: XXX
	 * Average value: XXX
	 * 
	 * where the XXX portions will be replaced with actual values calculated
	 * from the file. Note that your code must work for arbitrary input files,
	 * not just the provided example. However, you can assume the file is
	 * named "numbers.txt". If a file with this name does not exist, then
	 * do not crash with an exception. Instead, print the error message below
	 * followed by a carriage return:
	 * 
	 * The file "numbers.txt" does not exist. Exiting.
	 *  
	 */
	public static void exercise5() {
		// TODO: Write according to the specification above.
	}

///////////////////////////////////////////////////////

	/**
	 * Exercise 6: Classes
	 * 10 points functionality, 10 points documentation
	 * 
	 * Implement a class inside of this method called "Employee"
	 * that is defined in the following way:
	 * - A private instance variable of type double defining how much
	 *   the employee is paid per hour.
	 * - A private instance variable of type int defining the number
	 *   of worked hours that the employee has not been paid for yet.
	 * - A constructor that defines the hourly rate and sets worked
	 *   hours to 0.
	 * - A method called "work" with an int parameter that increases
	 *   the number of worked but unpaid hours by the specified number.
	 * - A method called "getUnpaidHours" that returns the number of
	 *   worked but unpaid hours.
	 * - A method "pay" that resets the unpaid worked hours to 0 and
	 *   returns a double which is the amount the employee should be
	 *   paid for the worked hours (multiply the rate by the hours).
	 */
	public static void exercise6() {
		/**
		 * TODO: Descriptive comment.
		 */
		class Employee {
			// TODO: Define the class as described above.
		}
		
		// TODO: Uncomment to test your completed class.
		//       Turn in your code with these lines uncommented. 
//		Employee e1 = new Employee(8.25);
//		e1.work(8);
//		e1.work(8);
//		e1.work(8);
//		e1.work(8);
//		e1.work(8);
//		int hours1 = e1.getUnpaidHours();
//		double paycheck1 = e1.pay();
//		System.out.printf("Employee 1 earns $%.2f for %d hours of work.\n",paycheck1,hours1);
//		e1.work(10);
//		e1.work(8);
//		e1.work(8);
//		int hours2 = e1.getUnpaidHours();
//		double paycheck2 = e1.pay();
//		System.out.printf("Employee 1 earns $%.2f for %d hours of work.\n",paycheck2,hours2);
//		
//		Employee e2 = new Employee(15.10);
//		e2.work(8);
//		e2.work(10);
//		e2.work(10);
//		e2.work(6);                
//		e2.work(6);
//		int hours3 = e2.getUnpaidHours();
//		double paycheck3 = e2.pay();
//		System.out.printf("Employee 2 earns $%.2f for %d hours of work.\n",paycheck3,hours3);
	}
}   

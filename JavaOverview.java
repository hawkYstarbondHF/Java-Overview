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
 * @author Eleanor Wagner, 09/06/2024
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
		int sum = 0; // sum to be computed
		
		// 208 is the next divisible by 13 number starting at 200, increment by 13s
		for(int i = 208; i <= 1287; i+=13) {
			sum += i;
		}
		System.out.println("The sum is: " + sum); // print sum
		
		return sum;
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
		System.out.println(firstLongerShorter("Hello","Bye"));
		System.out.println(firstLongerShorter("Bye","Hello"));
		System.out.println(firstLongerShorter("1","abc"));
		System.out.println(firstLongerShorter("abc","1"));
		System.out.println(firstLongerShorter("abc","123"));
		System.out.println(firstLongerShorter("123","abc"));
	}

	/**
	 * Throw IllegalArgumentException instead of NullPointerException:
	 * https://www.geeksforgeeks.org/null-pointer-exception-in-java/#:~:text=Case%202%20%3A%20Keeping%20a%20Check%20on%20the%20arguments%20of%20a%20method
	 * Main inspiration taken was to check both strings for null in addition to length
	 * 
	 * String Reference: 
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
	 * 
	 * Takes two strings and returns the first character of each based on 
	 * string length. The longer string first, followed by the shorter string
	 * If the strings are the same length, the first String parameter is first. 
	 * 
	 * Throws an IllegalArgumentException if either parameter isn't a string, 
	 * is null, or is less than 1 character.
	 * 
	 * @param first first string to check
	 * @param second second string to check
	 * @return string of 2 characters
	 */
	public static String firstLongerShorter(String first, String second) throws IllegalArgumentException {
		// ensuring parameter strings have at least 1 character
		if(first == null || second == null || first.length() == 0 || second.length() == 0) { throw new IllegalArgumentException(); }
		
		String str = ""; // string to be returned
		
		// determine which string is longer to be added first
		if(first.length() >= second.length()) { // first is longer/the same
			str += first.charAt(0);
			str += second.charAt(0);
		}
		else { // second is longer, add second to str first
			str += second.charAt(0);
			str += first.charAt(0);
		}

		return str;
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
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	/**
	 * Array Reference:
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#fill-long:A-long-
	 * 
	 * This method creates an array from 1 to 10 and calls helper method moveToEnd(int[],int).
	 * The resulting array is printed out with a space and comma between each element.
	 * 
	 */
	public static void exercise3() {
		int oneToTen[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // array to be used

		moveToEnd(oneToTen, 4); // call to helper method
		
		for(int i = 0; i < 9; i++) { // prints array's contents with appropriate spacing
			System.out.print(oneToTen[i] + ", ");
		}
		System.out.println(oneToTen[9]); // no comma + carriage 
	}

	/**
	 * This method takes an array and rearranges it so that the element
	 * at the given index is moved to the end and the others are shifted to 
	 * the left.
	 * 
	 * @param a integer array to be rearranged
	 * @param x the index of the element to be moved
	 */
	public static void moveToEnd(int[] a, int x) {
		int temp = a[x]; // the array element to be moved
		
		// starts at the element to be moved's index
		for(int i = x; i < a.length-1; i++) {
			a[i] = a[i+1]; // overwrite indices to the left
		}
		a[a.length-1] = temp; // add temp to the end
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
		System.out.println(recursiveSeq(5));
		System.out.println(dynamicSeq(5));
		System.out.println(recursiveSeq(8));
		System.out.println(dynamicSeq(8));
		System.out.println(recursiveSeq(15));
		System.out.println(dynamicSeq(15));
	}
	
	/**
	 * Recursively compute the sequence described in the comment for
	 * exercise 4.
	 * @param n Position in the sequence
	 * @return n-th value in the sequence
	 */
	public static long recursiveSeq(int n) {
		if(n < 0) { throw new IllegalArgumentException(); } // ensure appropriate input
		
		// base cases of indices 0, 1, and 2
		if(n <= 2) { return n + 1; }
		else { // recursive call and addition
			return recursiveSeq(n-3)+recursiveSeq(n-1); // returns n-th value 
		}
	}

	/**
	 * Compute the sequence described in the comment for
	 * exercise 4 using dynamic programming. This will require
	 * the use of an auxiliary array. DO NOT USE RECURSION!
	 * @param n Position in the sequence
	 * @return n-th value in the sequence
	 */
	public static long dynamicSeq(int n) {
		if(n < 0) { throw new IllegalArgumentException(); } // ensure appropriate input

		long arr[] = new long[n]; // auxiliary array of length n
		
		if(n < 3) { return n+1; } // 3 base cases
		else {
			for(int i = 0; i < n; i++) { // fill in auxiliary array 
				if(i < 3) { arr[i] = i + 1; } // first are the 3 base cases
				else {
					arr[i] = arr[i-3] + arr[i-1]; // assign sum of previous element with the 2 before it
				}
			}
		}

		return arr[n-3]+arr[n-1]; // returns n-th value
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
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 
	 * Using String: 
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
	 * 
	 * Using Scanner:
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
	 * 
	 */
	public static void exercise5() {
		try {
			// open/create new scanner to read the file
			Scanner scan = new Scanner(new File("numbers.txt")); 

			// start max & sum off with the first value from the file
			int max = Integer.valueOf(scan.next()); // convert String to int
			double sum = (double)max; // keep double type
			int num = 1; // track to calculate average

			while(scan.hasNext()) { // iterate through the file
				int temp = Integer.valueOf(scan.next()); // newest integer
				if(temp > max) { max = temp; } // check against max
				
				sum += temp; // add to sum
				num++; // increment
			}
			scan.close(); // close Scanner

			// print results according to format
			System.out.println("Maximum value: " + max);
			System.out.println("Average value: " + sum/num);
		}
		catch (FileNotFoundException e) { // exception & message specified above
			System.out.println("The file \"numbers.txt\" does not exist. Exiting.");
		}
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
		 * Class for keeping track of employees, their respective salaray,
		 * number of hours worked, and whether they have been paid for each hour.
		 */
		class Employee {
			private double salary;
			private int unpaidHours;
			/**
			 * Constructor to initialize an employee and set their number of hours
			 * worked to 0. 
			 * 
			 * @param x this employee's salary ($ per hour)
			 */
			Employee(double x) {
				salary = x;
				unpaidHours = 0;
			}
			/**
			 * This method adds the passed in number to the total number
			 * of hours worked since last payment.
			 * 
			 * @param hours number of hours worked 
			 */
			public void work(int hours) {
				unpaidHours += hours;
			}
			/**
			 * Returns the number of unpaid hours.
			 * 
			 * @return integer number of hours
			 */
			public int getUnpaidHours() {
				return unpaidHours;
			}
			/**
			 * This method pays all of the currently unpaid hours according to
			 * the employee's salary. Then it resets the number of unpaid hours 
			 * to 0.
			 * 
			 * @return integer of the employee's paycheck
			 */
			public double pay() {
				double payment = unpaidHours * salary;
				unpaidHours = 0;
				return payment;
			}
		}

		// provided testing
		Employee e1 = new Employee(8.25);
		e1.work(8);
		e1.work(8);
		e1.work(8);
		e1.work(8);
		e1.work(8);
		int hours1 = e1.getUnpaidHours();
		double paycheck1 = e1.pay();
		System.out.printf("Employee 1 earns $%.2f for %d hours of work.\n",paycheck1,hours1);
		e1.work(10);
		e1.work(8);
		e1.work(8);
		int hours2 = e1.getUnpaidHours();
		double paycheck2 = e1.pay();
		System.out.printf("Employee 1 earns $%.2f for %d hours of work.\n",paycheck2,hours2);
		
		Employee e2 = new Employee(15.10);
		e2.work(8);
		e2.work(10);
		e2.work(10);
		e2.work(6);                
		e2.work(6);
		int hours3 = e2.getUnpaidHours();
		double paycheck3 = e2.pay();
		System.out.printf("Employee 2 earns $%.2f for %d hours of work.\n",paycheck3,hours3);
	}

}   

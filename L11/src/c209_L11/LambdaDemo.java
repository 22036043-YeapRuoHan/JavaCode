package c209_L11;

public class LambdaDemo {

	public static void main(String[] args) {

//		// Preparing lambda expressions to test for even numbers
//		NumberChecker checkEven = (x) -> (x % 2) == 0; // test for even numbers
//
//		// Allow user to enter some input and test the input
//		int a = Helper.readInt("Enter a number to check if it is even> ");
//		System.out.println(checkEven.test(a));

		
		
		
		//TODO P10 LambdaDemo Task 1: 
		//Write the code to prepare lambda expressions to test for positive numbers
		NumberChecker checkPositive = (x) -> x > 0;
		//TODO P10 LambdaDemo Task 2: 
		//Allow user to enter some input and test the input
		int b = Helper.readInt("Enter a number to check if it is positive> ");
		System.out.println(checkPositive.test(b));

	}

}


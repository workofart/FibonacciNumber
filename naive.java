/**
 * fib_a class will be used to for computing Fibonacci numbers up until 7 using the naive method
 * @author Hanxiang Pan
 * @studentnumber 250608428
 *
 */
public class naive {

	/**
	 * The main function that will print out the fibonacci number F (i * 5), where 0 <= i <= 7
	 * 
	 */
	public static void main(String[] args) {	
		for (int i = 0; i<=7; i++){
			System.out.println("i: " + i);
			System.out.println("The result is: " + f(i * 5));
			System.out.println("-------------------------");
		}
	} // end main method
	
	/**
	 * The recursive function using the fibonacci definition in the question
	 * @param n - the input, fibonacci number we want to compute for
	 * @return - the fibonacci result based on the fibonacci input number
	 */
	public static int f(int n){
		// F(0) = 0 F(1) = 1
		if (n < 2){
			return n;
		}
		else
			return f(n-1)+f(n-2);
	}

}

/**
 * Compute fibonacci numbers up until 300 in 10 increments in linear time
 * @author Hanxiang Pan
 * @studentnumber 250608428
 */
public class linear {

	public static void main(String[] args) {
		linear tester = new linear();

		for (int i = 0; i<=30; i++){
			System.out.println("i: " + i);
			System.out.println("The result is: " + tester.f2(i*10).getFirst());
			System.out.println("-------------------------");
		} // end for loop
	}

	
	/**
	 * f2 function will calculate the fibonacci numbers and return a pair of fibnonacci numbers F(n-1) and F(n-2)
	 * @param n - the input, fibonacci number we want to compute for
	 * @return - a pair of type BigNum integers
	 */
	public Pair f2(int n){

		// initialize and declare variables
		Pair fib;
		fib = new Pair();
		
		// temporary BigNums to store the intermediary values
		BigNum n1 = new BigNum(0);
		BigNum n2 = new BigNum(0);
		
		// F(0) = 0
		if (n == 0){
			fib.setFirst(new BigNum(0)); // set the first element in the pair of fib numbers
			fib.setSecond(new BigNum(0)); // set the second element in the pair of fib numbers
		}
		
		// F(1) = 1
		else if (n == 1){
			fib.setFirst(new BigNum(1)); // set the first element in the pair of fib numbers
			fib.setSecond(new BigNum(0)); // set the second element in the pair of fib numbers
		}
		
		// if the n value is something other than 0 or 1
		else {
			fib = f2(n-1); // recursively call the f2 function
			n1 = fib.getFirst();
			n2 = fib.getSecond();
			fib.setFirst(BigNum.add(n1, n2)); // set the sum of the two Bigintegers to the first element in the pair 
			fib.setSecond(n1); // the the second element of the pair		
		}
		return fib; // return the pair of fib numbers
		
	}
	
	/**
	 * Pairs class that will handle pair values used by the fib_b class for calculating fibonacci numbers in linear time
	 * @author Hanxiang Pan
	 *
	 */
	private class Pair{
		private BigNum value1;
		private BigNum value2;
		
		/**
		 * Constructor for pairs, initialize both values to zero
		 *
		 */
		private Pair(){
			value1 = new BigNum(0);
			value2 = new BigNum(0);
		} // end constructor
		
		/**
		 * getFirst method will retrieve the first value in the pair of BigNum values
		 * @return - first value in the BigNum pair
		 */
		private BigNum getFirst(){
			return value1;
		} // end getFirst method

		/**
		 * getSecond method will retrieve the second value in the pair of BigNum values
		 * @return - second value in the BigNum pair
		 */
		private BigNum getSecond(){
			return value2;
		} // end getSecond method
		
		/**
		 * setFirst method will set the first value in the pair of BigNum values to v1
		 * @param - v1 the BigNum value we want to assign to the first value in the pair
		 */
		private void setFirst(BigNum v1){
			value1 = v1;
		} // end setFirst method

		/**
		 * setSecond method will set the second value in the pair of BigNum values to v2
		 * @param - v2 the BigNum value we want to assign to the second value in the pair
		 */
		private void setSecond(BigNum v2){
			value2 = v2;
		} // end setSecond method
		
	} // end pairs class

} // end fib_b class

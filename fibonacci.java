import java.math.BigInteger;
public class fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibonacci tester = new fibonacci();
		for (int i = 1; i <= 30; i++){
			System.out.println("i: " + i);
			System.out.println("Result: " + tester.fib(i*10));
		}
		
	}

	
	public BigInteger fib(int n) {
	  /* Declare an array to store fibonacci numbers. */
	  BigInteger [] f = new BigInteger[n+1];
	  int i;
	 
	  /* 0th and 1st number of the series are 0 and 1*/
	  f[0] = BigInteger.ZERO;
	  f[1] = BigInteger.ONE;
	 
	  for (i = 2; i <= n; i++)
	  {
	      /* Add the previous 2 numbers in the series
	         and store it */
	      f[i] = f[i-1].add(f[i-2]);
	  }
	 
	  return f[n];
	} // end fib function
	 
}

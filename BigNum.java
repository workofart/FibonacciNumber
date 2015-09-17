/**
 * BigNum class is used to create and add integers that exceed the limit of the primitive type (int)
 * Operations:
 * init_array
 * grow
 * toString
 * add
 * @author Hanxiang Pan
 * @studentnumber 250608428
 *
 */
public class BigNum
{

	/** The array that will store the digits of the BigNum. */
	private int[] digits;

	/** The configuration for the length of each BigNum integer (including leading 0's)
	 */
	private static final int ARRAY_SIZE = 1024; // use the length of f(300) = 64


	/**
	 * init_array method will fill the array with 0
	 * @param array - the array that will be initialized to contain all 0's
	 */
	public static void init_array(int[] array) {
		for (int i = 0; i < array.length; i++){
			array[i] = 0; // fill the array with 0
		}
	}

	/**
	 * BigNum constructor that will construct a BigNum object that represents the integers stored in the "input" string
	 * @param input - a string representation of the BigNum object/integer.
	 */
	public BigNum(String input) {

		// initialize the array "digits" that is the lenght of the "input" string
		digits = new int [input.length()];

		// initialize the two pointers for filling the digits array
		int i = 0, j = 0; 

		init_array(digits); // fill the array with 0's

		// fill the digits of "digits" array with the digits in the "input" string
		for (i = input.length()-1, j = 0; i >= 0 && j < input.length(); i--, j++){
			// fill the array backwards. E.g. 12345 is filled as [0]->5, [1]->4, [2]->3, [3]->2, [4]->1
			// and convert the string into a integer
			digits [j] = input.charAt(i) - '0'; 
		}

	} // end constructor

	/**
	 * BigNum constructor will construct a BigNum object that represents the integer "n" in the argument
	 * @param n - the integer, primitive type (int)
	 */
	public BigNum(int n) {
		// Converts the integer n into a String,
		// then calls the other BigNum constructor for conversion.
		this(n + "");
	}

	/**
	 * getDigits method will return the BigNum's individual digits stored in the global variable "digits"
	 * @return - digits that contains the specified BigNum's individual digits
	 */
	public int[] getDigits() {
		return digits;
	} // end getDigits method

	/**
	 * grow method will change the BigNum's array size to the "size" argument
	 * @param size - integer that specifies the new size of the array
	 */
	public void grow(int size) {
		int[] newDigits = new int[size]; // new size for storing digits
		
		// copy the old digits values to the temporary "newDigits" array
		for (int i = 0; i < digits.length; i++) {
			newDigits[i] = digits[i];
		}
		digits = newDigits; // copy the "newDigits" array contents back into the original array

	} // end grow method

	/**
	 * toString method will return a string representation of the BigNum object.
	 * This method will remove the leading zeros created by the initialization of 
	 * the BigNum object.
	 * @return - a string representation of the BigNum object
	 */
	public String toString() {		
		String temp = "";
		
		// Concatenate the individual digits into a single string
		for (int i = digits.length-1; i >= 0 ; i --){
    		temp = temp.concat(String.valueOf(digits[i]));
		} // end for loop
		
		// remove the leading zeros 
    	temp = temp.replaceFirst("^0+", "");
    	
		return temp;
	} // end toString method

	/**
	 * add method will add two BigNum objects together and return the sum of "n1" and "n2"
	 * @param n1 - first BigNum object to be added
	 * @param n2 - second BigNum object to be added
	 * @return - a BigNum object representing the sum of "n1" and "n2"
	 */
	public static BigNum add(BigNum n1, BigNum n2) {
		// grow n1, n2 to the bigger size of the two, will create leading zeros
		int n1_length = n1.getDigits().length;
		int n2_length = n2.getDigits().length;
		n1.grow(Math.max(n1_length+1, n2_length+1));
		n2.grow(Math.max(n1_length+1, n2_length+1));
		
		// create a new BigNum object with initial value of zero
		BigNum sum = new BigNum(0); 
		int carry = 0;
		int [] temp_a = n1.getDigits(); // convert the big num into an int array
		int [] temp_b = n2.getDigits();
		int digit_a = 0;
		int digit_b = 0;
		
		// grow the sum BigNum to the ARRAY_SIZE
		sum.grow(ARRAY_SIZE);
		
		int [] sum_digits = sum.getDigits(); // convert the sum to an int array containing the digits in each bucket
		int i = 0; // pointers in array temp_a and temp_b
		int pos = 0; // position pointers in sum_digits array, initialized as the length greater of temp_a or temp_b

		// adds individual digits of n1 and n2 
		for (i = 0 ; i < temp_a.length; i++){
			digit_a  = temp_a[i];
			digit_b  = temp_b[i];

			// case of no carry
			if (carry == 0){
				if (digit_a + digit_b >= 10){
					carry = 1;
					sum_digits[pos] = digit_a + digit_b - 10; // record
				}
				else {
					sum_digits [pos] = digit_a + digit_b;
				}
			} // end - no carry

			// case of carry
			else {
				if (digit_a + digit_b + 1 >= 10){
					carry = 1;
					sum_digits [pos] = digit_a + digit_b - 10 + 1;
				}
				else {
					carry = 0; // reset carry for next digit addition
					sum_digits [pos] = digit_a + digit_b + 1;
				}
			}
			pos ++;
		} // end for loop for adding each digit

		// convert digit to string and to BigNum
		String temp = ""; // temp storage for string
		
		// create a string representation of the sum_digits store it in "temp" string
		for (int z = sum_digits.length-1; z >= 0 ; z --){
			temp = temp.concat(String.valueOf(sum_digits[z]));
		} // end for loop
		
		// remove the leading zeros from temp
		temp = temp.replaceFirst("^0+", "");
		
		sum = new BigNum(temp); // int array conversion to a bigNum object, then store it into the sum variable
		
		return sum;
	} // end add method

} // end BigNum
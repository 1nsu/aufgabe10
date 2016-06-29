import java.util.Arrays;

/**
 * 
 * @author Jan Kulose, s0557320@htw-berlin.de
 *
 */
public class Bonus {
	
	/**
	 * Draws a rectangle with a given height and width
	 * @param a height
	 * @param b width
	 */
	public static void drawRectangle(int a, int b) {
		
		// no rectangle to draw if either a or b is 0
		if (a <= 0 || b <= 0) {
			return;
		}
		
		// first row
		for (int i = 1; i <= b; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		// middle rows with white spaces
		for (int i = 1; i < a-1; i++) {
			for (int n = 1; n <= b; n++) {
				if (n == 1 || n == b) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// last row only when a > 1
		if (a > 1) {
			for (int i = 1; i <= b; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints prime numbers up to a given limit
	 * @param limit the maximum value to check for primes
	 */
	public static void printPrimeNumbers(int limit) {
		/* 
		 * Sieving primes with given limit -> converting boolean array to int array ->
		 * converting int array content to string -> printing string
		 */
		System.out.println(Arrays.toString( convertBooleanArrayToInt( sievingPrimes(limit) ) ));
	}
	
	/**
	 * Converts a boolean array of the type
	 * 		bool[0] == false, bool[1] == true, bool[2] == false, bool[3] == true
	 * to the Integer array
	 * 		int[0] == 1, int[1] == 3
	 * @param boolArray given boolean array
	 * @return integer array
	 */
	private static int[] convertBooleanArrayToInt(boolean[] boolArray) {
		// int for counting number of true boolean array values
		int i = 0;
		
		// counting true boolean array values
		for (int j = 0; j < boolArray.length; j++) {
			if (boolArray[j]) {
				i++;
			}
		}
		
		// creating integer array with the correct size
		int[] intPrimeArray = new int[i];
		
		// resetting int counter for next use
		i = 0;
		
		// writing index of each true boolean array value into int array
		for (int j = 0; j < boolArray.length; j++) {
			if (boolArray[j]) {
				intPrimeArray[i++] = j;
			}
		}
		
		// returning int array
		return intPrimeArray;
	}
	
	private static boolean[] sievingPrimes(int limit) {
		// initially assume all integers are prime (true)
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= limit; i++) {

            // if i is prime, then mark multiples of i as nonprime (false)
            // suffices to consider multiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= limit; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        
        // returning boolean array with prime number indexes as true valued
        return isPrime;
	}
}

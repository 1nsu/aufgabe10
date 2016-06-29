
/**
 * Assignment 10, due on 29.06.2016
 * @author Jan Kulose, s0557320@htw-berlin.de
 *
 */
public class Assignment10 {
	
	/**
	 * Does what Arrays.toString does: creates String out of Array values.
	 * @param a Array to convert
	 * @return String of array content
	 */
	public static String convertArrayToString(int[] a) {
		String output = "[";
		for (int i = 0; i < a.length-1; i++) {
			output += a[i] + ", ";
		}
		output += a[a.length-1] + "]";
		return output;
	}
	
	/**
	 * Does what Arrays.toString does: creates String out of Array values.
	 * @param a Array to convert
	 * @return String of array content
	 */
	public static String convertArrayToString(double[] a) {
		String output = "[";
		for (int i = 0; i < a.length-1; i++) {
			output += a[i] + ", ";
		}
		output += a[a.length-1] + "]";
		return output;
	}

	/**
	 * Reverses the given array
	 * @param a the given array
	 * @return the reversed array
	 */
	public static double[] reverseDoubleArray(double[] a) {
		// creating return array
		double[] returnarray = new double[a.length];
		
		// copying parameter array in return array in reverse
		for (int i=0; i<a.length; i++) {
			returnarray[returnarray.length-1-i] = a[i];
		}
		
		// returning reversed array
		return returnarray;
	}
	
	/**
	 * Calculates the average of the values of an array
	 * @param a the given array
	 * @return the average
	 */
	public static double avgOfArray(double[] a) {
		double avg = 0;
		
		// catch division by zero
		if (a.length < 1) {
			return 0;
		}
		
		// add all array values together
		for (double i : a) {
			avg += i;
		}
		
		// divide sum of all values by number of values
		avg /= a.length;
		
		// returning average
		return avg;
	}
	
	/**
	 * Calculates the difference of the biggest and smallest integer values of a given array
	 * @param a the given integer array
	 * @return the difference
	 */
	public static int differenceOfMinMaxIntValue(int[] a) {
		// setting min and max for the purpose of comparison to value of index 0
		int min = a[0],
			max = a[0];
		
		// difference only viable for at least two values
		if (a.length < 2) {
			return 0;
		}
		
		// comparing min/max value with every value of the array, setting min/max accordingly
		for (int i : a) {
			if (min > i) {
				min = i;
			} else if (max < i) {
				max = i;
			}
		}
		
		// returning difference
		return max-min;
	}
	
	/**
	 * Prints a given two dimensional integer array in table form.
	 * @param a the given two dimensional int array
	 */
	public static void printTwoDimArray(int[][] a) {
		/*
		 * The method figures out the amount of white spaces needed
		 * to have a cleanly and easily readable table for the two
		 * dimensional array and prints it afterwards.
		 */
		
		int maxValue = 0, // maximum value of any index as absolute number
			lowValue = 0, // lowest value of any index, used for formatting
			maxIndexY = 0, // maximum index value of inner array
			digitCount = 0, // digits of the highest value inside the arrays, used for formatting
			digitCountIndexX = countDigits(a.length); // maximum count of digits for the outer array index
		
		// going through value of every index to find the biggest value (as an absolute number)
		// and to check for a number lesser than 0, information used for formatting
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (Math.abs(a[i][j]) > maxValue) {
					maxValue = a[i][j];
				}
				if (a[i][j] < lowValue) {
					lowValue = a[i][j];
				}
			}
		}
		
		// checking the max index size of the inner array
		for (int i = 0; i < a.length; i++) {
			if ((maxIndexY+1) < a[i].length) {
				maxIndexY = a[i].length-1;
			}
		}
		
		// determining the amount of spaces needed for formatting for the value column
		digitCount += countDigits(maxValue);
		
		// increasing the amount of spaces by one if there are any negative numbers ("-" sign!)
		if (lowValue < 0) {
			digitCount++;
		}
		
		// printing [i] with variable space length
		System.out.print("[");
		for (int i = 1; i < digitCountIndexX; i++) {
			System.out.print(" ");
		}
		System.out.print("i] ");
		
		// printing inner indexes at the top row with variable space length
		for (int i = 0; i <= maxIndexY; i++) {
			System.out.printf("[%" + digitCount + "d]", i);
		}
		System.out.println();
		
		// going through each outer index
		for (int i = 0; i < a.length; i++) {
			// printing the outer index number in brackets
			System.out.printf("[%" + digitCountIndexX + "d] [", i);
			// going through each inner index
			for (int j = 0; j < a[i].length-1; j++) {
				// printing value of each inner index array except the last one
				System.out.printf("%" + digitCount + "d, ", a[i][j]);
			}
			// printing the last value and closing the brackets
			System.out.printf("%" + digitCount + "d]%n", a[i][a[i].length-1]);
		}
	}
	
	/**
	 * Helping method to count the digits
	 * @param a int to be counted
	 * @return number of digits as int
	 */
	private static int countDigits(int a) {
        int digits = 0;
        while (a != 0) {
            digits++;
            a /= 10;
        }
        return digits;
	}
}

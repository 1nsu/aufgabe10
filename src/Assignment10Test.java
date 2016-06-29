
/**
 * Assignment 10, due on 29.06.2016
 * @author Jan Kulose, s0557320@htw-berlin.de
 *
 */
public class Assignment10Test {
	public static void main(String[] args) {
		// Test arrays
		double[] doubleArrayTest = {1.2, 5.0, 2.0, 7.0, 10.7};
		int[] intArrayTest = {1, 5, 7, 4, 9};
		int[][] multiTestArray = new int[120][];
		
		// randomizing values for multiTestArray
		for (int i = 0; i < multiTestArray.length; i++) {
			multiTestArray[i] = new int[(int)(Math.random()*120.0)+1];
			for (int j = 0; j < multiTestArray[i].length; j++) {
				multiTestArray[i][j] = (int)(Math.random()*200000 -100000);
			}
		}

		System.out.println("Array before reversal:\n" + Assignment10.convertArrayToString(doubleArrayTest));
		doubleArrayTest = Assignment10.reverseDoubleArray(doubleArrayTest);
		System.out.println("And after:\n" + Assignment10.convertArrayToString(doubleArrayTest));
		
		System.out.println("Average of Array:\n" + Assignment10.avgOfArray(doubleArrayTest));
		
		System.out.println("Difference between highest and lowest value of int-array:\n" + Assignment10.differenceOfMinMaxIntValue(intArrayTest));
		
		System.out.println("Two dimensional array output: ");
		Assignment10.printTwoDimArray(multiTestArray);
	}
}

import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;

/*
*
* O(cs) = O (n <- to map the input array to the range array)
*		  + O (k <- to apply the cummulative f(x) to the map array)
*		  + O (n <- to populate the final array)
* Hence, this makes:
* 	O(2*n) + O(k) = O(n) + O(k) = O(n+k) // for the time complexity
* 	O(n+k) // for the space complexity
*/

public class CountingSort {

	public CountingSort() {}

	public int[] sort(int[] input, int from, int to) {

		// First create an array 
		// of the size of the range of the numbers.
		int[] mapOfCounts = new int[to+1];
		int[] result = new int[input.length];
		int currentElement;
		int i;
		// Cycle down the input array and count
		// the numbers in the count-map array.
		for (i=0; i<input.length; i++) {
			currentElement = input[i];
			mapOfCounts[currentElement]++;
		}

		// Augment the count array.
		for (i=1; i<mapOfCounts.length; i++) {
			mapOfCounts[i] += mapOfCounts[i-1];
		}

		for (i=0; i<input.length; i++) {
			currentElement = input[i];
			result[mapOfCounts[currentElement]-1] = currentElement;
			mapOfCounts[currentElement]--;
		}

		System.out.println(Arrays.toString(mapOfCounts));
		return result;
	}

	public static void main(String[] args) {

		CountingSort counting = new CountingSort();
		Scanner sc = new Scanner(System.in);
		
		int from;
		int to;

		int[] input = null;

		System.out.println("Give me the range of the data to sort");
		System.out.print("X = "); from = sc.nextInt();
		System.out.println();
		System.out.print("Y = "); to = sc.nextInt();

		// Clear the \n
		sc.nextLine();

		System.out.println("Input the array to sort:");
		input = Arrays.stream(sc.nextLine().trim().split(" |,"))
					  .mapToInt(Integer::parseInt)
					  .toArray();


		System.out.println("Result\n" 
							+ Arrays.toString(counting.sort(input, from, to)));
	}
}
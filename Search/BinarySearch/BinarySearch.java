import java.util.Scanner;
import java.util.Arrays;

/*
 * @author Konstantin Dimitrov
 */

/*
	Complexity:
   	Best case: O(1)
   	Worst case: O(logn), where n is the number of array elements
   	Average case: O(logn)
*/
public class BinarySearch {

	BinarySearch(){};


	public static void main(String[] args) {
		
		System.out.println("\nEnter sorted space-delimited list of numbers:\n");
		Scanner input = new Scanner(System.in);
		String listNumbers = input.nextLine();
		String[] listArray = listNumbers.split(" ");
		int[] arrayNumbers = Arrays.stream(listArray)
								   .mapToInt(Integer::parseInt)
								   .toArray();

		
		System.out.println("\n Input a number to find:\n\n");
		int numberToFind = input.nextInt();

		int lo, mid, hi;

		lo = 0; hi = arrayNumbers.length;

		while (lo <= hi) {

			mid = (lo+hi) / 2;

			if (arrayNumbers[mid] == numberToFind) {
				System.out.println("Number " + arrayNumbers[mid] + " found at index " + mid);
				break;
			}

			else if (numberToFind < arrayNumbers[mid]) {
				hi = mid -1;
			}

			else if (numberToFind > arrayNumbers[mid]) {
				lo = mid + 1;
			}

			else {
				System.out.println("Oops, something went wrong.");
				break;
			}
		}
	}
}
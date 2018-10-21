import java.util.Scanner;
import java.util.Arrays;

public class LinearSearch {

	LinearSearch(){};

	public static void main(String[] args) {

		System.out.println("\nEnter a sorted array: \n");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] stringified = input.split(" ");

		// Convert the string array into an int array.
		int[] arrayInput = Arrays.stream(stringified)
								 .mapToInt(Integer::parseInt)
								 .toArray();

		System.out.println("\n Enter a value to look for: \n");
		int valueToFind = sc.nextInt();

		int i;
		for (i=0; i<arrayInput.length; i++) {
			if (arrayInput[i] == valueToFind) {
				System.out.println("Value " + arrayInput[i] 
									+ " found at index " + i + ".");
				break;
			}
		}

		sc.close();
	}
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class BubbleSort {

	public BubbleSort(){};

	public int[] sort(int[] arr) {

		int i, j, temp;

		// Offset from the back.
		for (i=0; i<arr.length-1; i++) {
 
			for (j=1; j<arr.length-i; j++) {
				
				if (arr[j-1] > arr[j]) {
					// Swap them
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		// Input
		Scanner sc = new Scanner(System.in);
		int[] input = null;
		BubbleSort bubble = new BubbleSort();

		System.out.println("Welcome to BubbleSort!\n");
		System.out.println("Input your array:");

		// Take the array to sort
		input = Arrays.stream(sc.nextLine().split(" |,"))
					  .mapToInt(Integer::parseInt)
					  .toArray();


		System.out.println("Your sorted array is: \n" + Arrays.toString(bubble.sort(input)));
	}
}
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class SelectionSort {

	public SelectionSort(){};

	public int[] sort(int[] arr) {

		int minimumInd = 0;
		int temp;

		for (int i=0; i<arr.length-1; i++) {

			for (int j=i+1; j<arr.length; j++) {
				minimumInd = i;

				if (arr[j]<arr[minimumInd]) {
					temp = arr[minimumInd];
					arr[minimumInd] = arr[j];
					arr[j] = temp;  
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		// Input
		Scanner sc = new Scanner(System.in);
		int[] input = null;
		SelectionSort selection = new SelectionSort();

		System.out.println("Input your array:");

		// Take the array to sort
		input = Arrays.stream(sc.nextLine().split(" |,"))
					  .mapToInt(Integer::parseInt)
					  .toArray();


		System.out.println("Your sorted array is: \n" + Arrays.toString(selection.sort(input)));
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuickSort {

	private String[] stringInput = null;
	private int[] arrayToSort = null;
	private int pivot, partitionPoint,
						 	leftIndex, rightIndex;
	private int minAssertedIndex; // The value of .

  private static int breaker=0;

	public QuickSort(String rawInput) 
	{
		stringInput = rawInput.split(" ");
		arrayToSort = new int[stringInput.length];

		for (int i=0; i<stringInput.length; i++)
			arrayToSort[i] = Integer.parseInt(stringInput[i]);

		// The scanning indices
		leftIndex = 1;	// Looks for greater than pivot
		rightIndex = arrayToSort.length-1;
	}

	private void swapValues(int indexA, int indexB) {
		int temp;

		temp = arrayToSort[indexB];
		arrayToSort[indexB] = arrayToSort[indexA];
		arrayToSort[indexA] = temp;
	} 

	public int partition_lomuto(int leftIndex, int rightIndex) {

		pivot = arrayToSort[rightIndex];
		minAssertedIndex = leftIndex;

		for (int j=leftIndex; j<=rightIndex-1; j++) {
			if (arrayToSort[j] <= pivot) {
				swapValues(minAssertedIndex, j);
				minAssertedIndex++;
			}
		}
		swapValues(minAssertedIndex, rightIndex); // rightIndex - the index of the pivot

		return minAssertedIndex;
	}

	public void quickSort(int start, int end) {
		
		if (start < end) {
			partitionPoint = partition_lomuto(start, end);
			quickSort(start, partitionPoint-1);	// On left of the pivot.
			quickSort(partitionPoint, end);	// On right of the pivot.
		}
	}

	public void printArray() {
		for (int i=0; i<arrayToSort.length; i++) {
			System.out.print(arrayToSort[i] + " ");
		}
		System.out.print("\n");
	}


	public static void main(String[] args)
	{
		String rawInput = null;
		QuickSort qs = null;

		System.out.println("Input numbers to sort (space delimited):");

		// Get the input from the console.
		// That is 'try with resources' from java 7.
		try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
			qs = new QuickSort(input.readLine());
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		// Sort the arrayToSort
		qs.quickSort(0, qs.arrayToSort.length-1);

		qs.printArray();
	}
}
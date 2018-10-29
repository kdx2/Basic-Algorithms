import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {

	static int[] array = null;

	public MergeSort(int[] array) {
		this.array = array;
	}

	public static void merge(int[] arr, int start, int mid, int end) {


		// Make temp arrays for the left and the right part
		// for the ones we are merging.
		int leftArrSize = mid - start + 1;
		int rightArrSize = end - mid;
		int[] left = new int[leftArrSize]; 
		int[] right = new int[rightArrSize];

		for (int i=0; i<leftArrSize; i++) {
			left[i] = arr[start + i];
		}
		for (int n=0; n<rightArrSize; n++) {
			right[n] = arr[mid + n + 1];
		}

		// Iterator indices for both subarrays and for the array we are sorting.
		int i = 0; int j=0; int k=start;

		// Compare the arrays
		while (i<leftArrSize && j<rightArrSize)
		{
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++; k++;
			}
			else {
				arr[k] = right[j];
				j++; k++;
			}
		}

		// Copy the remainders of the left array.
		while (i < leftArrSize) {
			arr[k] = left[i];
			i++; k++;
		}

		while (j < rightArrSize) {
			arr[k] = right[j];
			j++; k++;
		}
		
	}

	public static void partition_merge_sort(int arr[], int start, int end) {


		if (start < end)
		{
			int mid = (start+end) / 2;
			// Recursively partition the array into sub-halves.
			partition_merge_sort(arr, start, mid);
			partition_merge_sort(arr, mid+1, end);

			merge(arr, start, mid, end);
		}
	}
	public void printArray () {
		System.out.println("\n\nSorted array:");
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] input = null;

		System.out.println("Enter array to sort: ");

		try {
			input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} catch (Exception e) {
			System.out.println("Input error: " + e.getMessage());
		} finally {
			sc.close();
		}

		MergeSort ms = new MergeSort(input);

		System.out.println("Your array is:");
		System.out.println(Arrays.toString(input));
		partition_merge_sort(input, 0, input.length-1);

		ms.printArray();
	}
}
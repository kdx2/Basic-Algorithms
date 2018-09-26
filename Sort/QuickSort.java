import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuickSort {

	private String[] stringInput = null;
	private int[] arrayToSort = null;

	public QuickSort(String rawInput) 
	{
		stringInput = rawInput.split(" ");
		arrayToSort = new int[stringInput.length];

		for (int i=0; i<stringInput.length; i++) 
		{
			arrayToSort[i] = Integer.parseInt(stringInput[i]);
		}
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


	}
}
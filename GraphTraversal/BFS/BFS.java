import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class BFS {

	List<Integer> LIFO = null;
	HashMap<Integer,Boolean> visited = null;

	public BFS(){
		LIFO = new LinkedList<Integer>(); // for the BFS
	};

	public void breadthFirstSearch(List<List<Integer>> graph, int numberNodes)
	{

		// Initializa the hashmap
		visited = new HashMap<Integer, Boolean>(numberNodes);

		// Initialize a node to start from.
		int currentNode = graph.get(0).get(0);

		LIFO.add(currentNode);
		visited.put(currentNode, true);
		System.out.println("Visited: ");
		System.out.println(currentNode + " ");

		while (!lifo.isEmpty()) {
			
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		BFS b = new BFS();

		int[] adjacencyList;
		String inputLine;
		boolean terminate = false;

		System.out.println("Define a graph via an adjucency list");
		System.out.println("The input must be of the shape: ");
		System.out.println("startNode# adjacentNode1# adjacentNode2# OR startNode#, adjacentNode1#, adjacentNode2#... ");
		System.out.println("...to finish inputting just press Enter twice...");
		
		int currentElementIndex;
		
		// Create the graph.
		while (!terminate) {

			// Get input
			inputLine = sc.nextLine();
			// Check if it's a termination
			if (inputLine.length() == 0) {
				terminate = true;
				continue;
			}
			adjacencyList = Arrays.stream(inputLine.split(" |,"))
									.mapToInt(Integer::parseInt)
										.toArray();
		
			graph.add(new ArrayList<Integer>(adjacencyList.length));
			currentElementIndex = 0;
			// Populate
			for (int a : adjacencyList)
				graph.get(currentElementIndex).add(a);
		}

		// Start the BFS.
		b.breadthFirstSearch(graph, graph.size());
	}
}
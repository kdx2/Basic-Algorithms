import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;

public class BFS {

	LinkedList<Integer> LIFO = null;
	HashMap<Integer,Boolean> willBeVisited = null;

	public BFS(){
		LIFO = new LinkedList<Integer>(); // for the BFS
	};

	public void breadthFirstSearch(List<List<Integer>> graph, int numberNodes)
	{

		// Initializa the hashmap
		willBeVisited = new HashMap<Integer, Boolean>(numberNodes);

		// Initialize the hashmap
		for (int i=0; i<numberNodes; i++) {
			willBeVisited.put(i, false);
		}

		// Initialize a node to start from.
		int currentNode = graph.get(0).get(0);

		LIFO.add(currentNode);
		/*The logic should be.
		 * Look at the head node of the stack. Print it.
		 * Add the head's adj. elems. to the stack.
		 * Mark them as willBeVisited.
		 * Pop this node.
		*/
		willBeVisited.put(currentNode, true);
		int nodeToPush;
		System.out.println("\nTraversal: ");
		int breaker = 0;
		while (!LIFO.isEmpty() && breaker < 20) {
			currentNode = LIFO.getFirst();

			System.out.print(" -> " + currentNode);

			int i;
			for (i=0; i<graph.get(currentNode).size(); i++)
			{
				// Check its adj. list.
				nodeToPush = graph.get(currentNode).get(i);
				if (!willBeVisited.get(nodeToPush)) {
					LIFO.addLast(nodeToPush);
					willBeVisited.put(nodeToPush, true);
				}
			}
			LIFO.removeFirst();
			breaker++;
		}
		System.out.println();
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		List<List<Integer>> graph = new LinkedList<List<Integer>>();
		BFS b = new BFS();

		int[] adjacencyList;
		String inputLine;
		boolean terminate = false;

		System.out.println("Define a graph via an adjucency list");
		System.out.println("The input must be of the shape: ");
		System.out.println("startNode# adjacentNode1# adjacentNode2# OR startNode#, adjacentNode1#, adjacentNode2#... ");
		System.out.println("...to finish inputting just press Enter twice...");
		
		int currentElementIndex=0;
		
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
			// Populate
			for (int a : adjacencyList)
				graph.get(currentElementIndex).add(a);

			currentElementIndex++;
		}
		
		// Sort the graph.
		Collections.sort(graph, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> a, List<Integer> b) {
				return a.get(0).compareTo(b.get(0));
			}
		});
		// That is a second way of doing the same.
		// graph.sort((aList1, aList2) -> Integer.compare(aList1.get(0), aList2.get(0)));

		System.out.println("Vertical length of list: " + graph.size());

		for (List<Integer> a : graph)
			System.out.println(a.toString());

		// Start the BFS.
		b.breadthFirstSearch(graph, graph.size());
	}
}
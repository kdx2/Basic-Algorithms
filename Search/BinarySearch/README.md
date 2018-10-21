## Binary Search
It is a fundamental search algorithm in Computer Science with the following complexities:

* Worst case: O(log n)
* Average case: O(log n)
* Best case: O(1)

NB: n is the number of items in the array.

## How the algorithm works
*Given a sorted array*:

I. Simple explanation
We take an array and always check if the middle point has the value we're looking for. If it doesn't, we look to the left or the right of the mid point,
effectively halving the array. Repeat, until success or fail.

II. Detailed version
1. keep track on the low and high indices, where low = 0, high = array.size
2. while low is still to the left of high, or coinciding do:
3. 	find the mid index between the two
4.	if it's to the left of mid index, set high to mid-1
5.	else if the element is to the right of mid, set low to mid+1		
6. 	else if the mid element is the value we are searching for, return it
7.	else, the value searched for is not present in this array

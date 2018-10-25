
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreams {

	public static void main(String[] args) {

		ForkJoinPool pool = ForkJoinPool.commonPool();
		// Check how many threads we have reserved.
		System.out.println(pool.getParallelism());

		// Make a stream of parallel Pythagorean theorem calcs.
		Arrays.asList(1, 2, 10, 20, 100, 303, 470, 1000)
			  .parallelStream()
			  .filter(x -> {
			  				System.out.println("Filter on thread " 
			  								  + Thread.currentThread()
			  								  			.getName());
			  				return x > 50;})
			  .map(x -> {System.out.println("Map sqrt on thread " 
			  								  + Thread.currentThread()
			  								  			.getName());
			  		return Math.sqrt(x);})
			  .forEach(System.out::println);
	}
}
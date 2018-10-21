// This algorithm will try to find the maximum of a convex function.
// The user inputs a square function's coeficients, and the algorithm
// is trying to find the maximum of that function.

import java.util.Scanner;
import java.lang.Math;

public class TernarySearch {

	TernarySearch(){};

	public static double f(double[] poly, double x) {

		return poly[0]*(x*x) + poly[1]*x + poly[2];
	}

	public static void ternarySearch(double[] poly, double l, double r) {

		final int PRECISION = 200;

		double x = 0;
		double m1, m2;	// The mid points.
		double fm1 = 0.0;
		double fm2 = 0.0;

		// The search algorithm
		int i;
		for (i=0; i<PRECISION; i++)
		{
			// (Re) Partition the function down the x - axis.
			m1 = (2*l + r) / 3; // Because, m1=l + (r-l)/3
			m2 = (2*r + l) / 3;

			// Calculate the mid points' values.
			fm1 = f(poly, m1);
			fm2 = f(poly, m2);

			System.out.println("l: " + l + "; r: " + r);

			if (fm1 < fm2)
				l = m1;
			else
				r = m2;
		}
		x = l;
		System.out.println("Answer: \nroot = " + x + " max = " + f(poly, x));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double[] array = new double[3];

		System.out.println("Enter three coeficients of -a, b, c\n");

		System.out.print("-a = ");
		array[0] = sc.nextDouble();
		System.out.print("b = ");
		array[1] = sc.nextDouble();
		System.out.print("c = ");
		array[2] = sc.nextDouble();

		if (array[0] >  0) {
			array[0] = - array[0];
			System.out.println("WARNING: a = " + -array[0] 
							   + " corrected to " + array[0] + ".\n");
		}

		System.out.println("Write the search interval: ");
		System.out.print("From: ");
		double start = sc.nextDouble();
		System.out.println("; To: ");
		double end = sc.nextDouble();

		System.out.println("Solving polynomial: f(x) = "
						 + array[0] + "x^2" + " + " 
						 + array[1] + "x" + " + " + array[2]
						 + ", searching for argmaxX in ["
						 + start + "; " + end + "]" + "\n");


		ternarySearch(array, start, end);
	}
}
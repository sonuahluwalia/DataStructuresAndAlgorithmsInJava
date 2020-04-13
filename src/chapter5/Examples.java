package chapter5;

import chapter4.Vector;

public class Examples {
	public static void diffTable(int n)
	// pre: n >= 0
	// post: print difference table of width n
	{
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				System.out.print(row - col + " ");
			}
			System.out.println();
		}
	}

	public static void multTable(int n)
	// pre: n >= 0
	// post: print multiplication table
	{
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(row * col + " ");
			}
			System.out.println();
		}
	}

	public static Vector<Integer> buildVector1(int n)
	// pre: n >= 0
	// post: construct a vector of size n of 1..n
	{
		Vector<Integer> v = new Vector<Integer>(n); // 1
		for (int i = 0; i < n; i++)
		// 2
		{
			v.add(i);
			// 3
		}
		return v;
		// 4
	}

	public static Vector<Integer> buildVector2(int n)
	// pre: n >= 0
	// post: construct a vector of size n of 1..n
	{
		Vector<Integer> v = new Vector<Integer>(n);
		for (int i = 0; i < n; i++)
		// 2
		{
			v.add(0, i);
			// 3
		}
		return v;
		// 4
	}

	public static Vector<Vector<Integer>> factTable(int n)
	// pre: n > 0
	// post: returns a table of factors of values 1 through n
	{
		Vector<Vector<Integer>> table = new Vector<Vector<Integer>>();
		for (int i = 1; i <= n; i++) {
			Vector<Integer> factors = new Vector<Integer>();
			for (int f = 1; f <= i; f++) {
				if ((i % f) == 0) {
					factors.add(f);
				}
			}
			table.add(factors);
		}
		return table;
	}

	static int findSpace(String s)
	// pre: s is a string, possibly containing a space
	// post: returns index of first space, or -1 if none found
	{
		int i;
		for (i = 0; i < s.length(); i++) {
			if (' ' == s.charAt(i))
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		// diffTable(5);
		// multTable(4);

//		Vector<Integer> v = buildVector1(5);
//		for (Integer x : v) {
//			System.out.println(x);
//
//		}

//		Vector<Integer> v1 = buildVector2(5);
//		for (Integer x : v1) {
//			System.out.println(x);
//
//		}

//		Vector<Vector<Integer>> v2 = factTable(5);
//		for (Vector<Integer> v3 : v2) {
//			for (Integer i : v3) {
//				System.out.println(i);
//			}
//		}
//	
		String s = "This is good sunday";
		int position = findSpace(s)+1;
		System.out.println("Space in the string \" "+ s + " \" is at "
				+ "position " + position);
	
	}
}

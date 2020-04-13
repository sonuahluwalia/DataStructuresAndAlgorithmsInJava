package chapter5;

import chapter1.Assert;
import chapter4.Vector;

public class Recursion {

	public static int sum1(int n)
	// pre: n >= 0
	// post: compute the sum of 0..n
	{
		int result = 0;
		for (int i = 1; i <= n; i++) {

			result = result + i;
		}
		return result;
	}

	public static int sum2(int n)
	// pre: n >= 0
	// post: compute the sum of 0..n
	{
		if (n < 1)
			return 0;
		else
			return sum1(n - 1) + n;
	}

	public static int sum3(int n)
	// pre: n >= 0
	// post: compute the sum of 0..n
	{
		if (n < 1)
			return 0;
		// base case
		else
			return sum3(n - 1) + n; // reduction, progress, solution
	}

	public final static int LETTER = 41;
	public final static int CARD = 26;
	public final static int PENNY = 1;

	public static int stampCount(int amount)
	// pre: amount >= 0
	// post: return *number* of stamps needed to make change
	// (only use letter, card, and penny stamps)
	{
		int minStamps;
		Assert.pre(amount >= 0, "Reasonable amount of change.");
		if (amount == 0)
			return 0;
		// consider use of a penny stamp
		minStamps = 1 + stampCount(amount - PENNY);
		// consider use of a post card stamp
		if (amount >= CARD) {
			int possible = 1 + stampCount(amount - CARD);
			if (minStamps > possible)
				minStamps = possible;
		}
		// consider use of a letter stamp
		if (amount >= LETTER) {
			int possible = 1 + stampCount(amount - LETTER);
			if (minStamps > possible)
				minStamps = possible;
		}
		return minStamps;
	}

	public static int stampCount1(int amount)
	// pre: amount >= 0
	// post: return *number* of stamps needed to make change
	// (only use letter, post card, and penny stamps)
	{
		return stampCount1(amount, new int[amount + 1]);
	}

	protected static int stampCount1(int amount, int answer[])
	// pre: amount >= 0; answer array has length >= amount
	// post: return *number* of stamps needed to make change
	// (only use letter, post card, and penny stamps)
	{
		int minStamps;
		Assert.pre(amount >= 0, "Reasonable amount of change.");
		if (amount == 0)
			return 0;
		if (answer[amount] != 0)
			return answer[amount];
		// consider use of a penny stamp
		minStamps = 1 + stampCount1(amount - 1, answer);
		// consider use of a post card stamp
		if (amount >= CARD) {
			int possible = 1 + stampCount1(amount - CARD, answer);
			if (minStamps > possible)
				minStamps = possible;
		}
		// consider use of a letter stamp
		if (amount >= LETTER) {
			int possible = 1 + stampCount1(amount - LETTER, answer);
			if (minStamps > possible)
				minStamps = possible;
		}
		answer[amount] = minStamps;
		return minStamps;
	}

	public static void main(String[] args) {
//		int n = 3;
//		System.out.println("Sum of 0.." + n + " = "+sum3(n));

//		Vector<Integer> v = new Vector<>();
//		for (int i = 0; i < 3; i++) {
//			v.add(i, i + 1);
//		}
//		for (int i = 0; i < 3; i++) {
//			v.add(i, i + 1);
//		}

//		for(Integer i: v) {
//			System.out.println("Vector contains: " + i);
//			
//		}
//		v.print();

		System.out.println(stampCount1(28));

	}
}

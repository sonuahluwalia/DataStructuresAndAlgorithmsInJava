package chapter5;

import chapter1.Assert;

public class MathInduction {

	static public int fibo(int n)
	// pre: n is a nonnegative integer
	// post: result is the ith term from the sequence
	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, . . .

	{

		Assert.pre(n >= 0, "Index is nonnegative.");
		// when n < 2, return n
		if (n == 0)
			return 0;
		// line 1
		else if (n == 1)
			return 1;
		// line 2
		// complex, self-referential case:
		else
			return fibo(n - 2) + fibo(n - 1);
		// line 3
	}
	
	public static void main(String[] args) {
		System.out.println(fibo(3));
	}
}

package chapter4;

import chapter3.Vector;

public class LongWords {

	public static void main(String[] args) {
		Vector longWords = new Vector();
		int i;
		for (i = 0; i < args.length; i++) {
			if (args[i].length() > 4) {
				longWords.add(args[i]); // line 12
			}
		}

		for (i = 0; i < longWords.size(); i++) {
			String word = (String) longWords.get(i); // line 31
			System.out.println(word + ", length " + word.length());
		}
	}
}

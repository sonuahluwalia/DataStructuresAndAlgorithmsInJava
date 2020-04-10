package chapter4;

public class LongWords3 {
	public static void main(String[] args) {
		Vector<String> longWords = new Vector<String>();
		int i;
		for (i = 0; i < args.length; i++) {
			if (args[i].length() > 4) {
				longWords.add(args[i]); // line 12
			}
		}
		for (i = 0; i < longWords.size(); i++) {
			String word = longWords.get(i); // line 31
			System.out.println(word + ", length " + word.length());
		}
	}
}

package chapter4;

public class LongWords2 {

	public static void main(String[] args) {
		StringVector longWords = new StringVector();
		int i;
		for (i = 0; i < args.length; i++) {
			if (args[i].length() > 4) {
				longWords.add(args); // line 12
			}
		}
//		for (i = 0; i < longWords.size(); i++) {
//			String word = longWords.get(i); // line 31
//			System.out.println(word + ", length " + word.length());
//		}
//		
		for (i = 0; i < longWords.size(); i++) {
			String[] word = (String[]) longWords.get(i); // line 31
			System.out.println(word + ", length " + word.length);
		}
		
	}
}

package chapter3;
public class WordList {

	protected Vector theList;
	protected static java.util.Random generator = new java.util.Random();
	
	public WordList(int n) {
		theList = new Vector(n);
		
	}

	public String selectAny() {
		int i = Math.abs(generator.nextInt()) % theList.size();
		return (String) theList.get(i);
	}

	public static void main(String[] args) {

		Vector theList;
		String targetWord;
		//java.util.Random generator = new java.util.Random();
		theList = new Vector(10);
		theList.add("clarify");
		theList.add("entered");
		theList.add("clerk");
		while (theList.size() != 0) {
			{
				// select a word from the theList
				int index = Math.abs(generator.nextInt()) % theList.size();
				targetWord = (String) theList.get(index);
				System.out.println(targetWord);
				System.out.println("Size of the Vector is "+ theList.size());
			}
			// ... play the game using targetWord ...
			theList.remove(targetWord);
		}
	}
}

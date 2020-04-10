package chapter3;
import java.util.Scanner;

import chapter1.Association;

public class WordFrequency {
	public static void main(String args[]) {
		Vector vocab = new Vector(3);
		Scanner s = new Scanner(System.in);
		int i;
		// for each word on input
		while (s.hasNext()) {
			Association wordInfo; // word-frequency association
			String vocabWord;
			// word in the list
			// read in and tally instance of a word
			String word = s.next();
			for (i = 0; i < vocab.size(); i++) {
				// get the association
				wordInfo = (Association) vocab.get(i);
				// get the word from the association
				vocabWord = (String) wordInfo.getKey();
				if (vocabWord.equals(word)) {
					// match: increment integer in association
					Integer f = (Integer) wordInfo.getValue();
					wordInfo.setValue(new Integer(f.intValue() + 1));
					break;
				}
			}
			// mismatch: add new word, frequency 1.
			if (i == vocab.size()) {
				vocab.add(new Association(word, new Integer(1)));
			}
		}

		// print out the accumulated word frequencies
		for (i = 0; i < vocab.size(); i++)

		{
			Association wordInfo = (Association) vocab.get(i);
			System.out.println(wordInfo.getKey() + " occurs " + 
			wordInfo.getValue() + " times.");
		}
	}

}

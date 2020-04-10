package chapter4;

import chapter3.Vector;

public class StringVector extends Vector implements Cloneable {

	protected String elementData[];
	// the data
	protected int elementCount;
	// number of elements in vector

	public void add(String obj) {
		ensureCapacity(elementCount + 1);
		elementData[elementCount] = obj;
		elementCount++;
	}
	
//	public String get(int index) {
//
//		// pre: 0 <= index && index < size()
//		// post: returns the element stored in location index
//		{
//			return elementData[index];
//		}
//	}

}

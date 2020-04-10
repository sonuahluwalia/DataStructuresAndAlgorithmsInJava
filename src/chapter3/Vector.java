package chapter3;
import java.util.AbstractList;

import chapter1.Assert;

public class Vector extends AbstractList implements Cloneable {
	protected Object elementData[];
	protected int elementCount;

	protected int capacityIncrement;

	// the rate of growth for vector
	public Vector(int initialCapacity, int capacityIncr)
	// pre: initialCapacity >= 0, capacityIncr >= 0
	// post: constructs an empty vector with initialCapacity capacity
	// that extends capacity by capacityIncr, or doubles if 0
	{
		Assert.pre(initialCapacity >= 0 && capacityIncr >= 0, "Neither capacity nor increment should be negative.");
		elementData = new Object[initialCapacity];
		elementCount = 0;
		capacityIncrement = capacityIncr;
	}

	// the data
	// number of elements in vector
	public Vector()
	// post: constructs a vector with capacity for 10 elements
	{
		this(10); // call one-parameter constructor
	}

	public Vector(int initialCapacity)
	// pre: initialCapacity >= 0
	// post: constructs an empty vector with initialCapacity capacity
	{
		Assert.pre(initialCapacity >= 0, "Initial capacity should not be negative.");
		elementData = new Object[initialCapacity];
		elementCount = 0;
	}

	public boolean add(Object obj)
	// post: adds new element to end of possibly extended vector
	{
		ensureCapacity(elementCount + 1);
		elementData[elementCount] = obj;
		elementCount++;
		return true;
	}

	public boolean remove(Object element) {
// post: element equal to parameter is removed and returned
		int index = 0;
		boolean flag = false;
		while (index < elementCount) {
			index++;
			if (element.equals(elementData[elementCount])) {
				flag = true;
				break;
			}
		}
		if(flag) {
			remove(index);
			return flag;
		} else {
			return flag;
		}
	}
	public Object get(int index) {

		// pre: 0 <= index && index < size()
		// post: returns the element stored in location index
		{
			return elementData[index];
		}
	}

	public void add(int index, Object obj)
	// pre: 0 <= index <= size()
	// post: inserts new value in vector with desired index,
	// moving elements from index to size()-1 to right
	{
		int i;
		ensureCapacity(elementCount + 1);
		// must copy from right to left to avoid destroying data
		for (i = elementCount; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		// assertion: i == index and element[index] is available
		elementData[index] = obj;
		elementCount++;
	}

	public boolean isEmpty()
	// post: returns true iff there are no elements in the vector
	{
		return size() == 0;
	}

	public Object remove(int where)
	// pre: 0 <= where && where < size()
	// post: indicated element is removed, size decreases by 1
	{
		Object result = get(where);
		elementCount--;
		while (where < elementCount) {
			elementData[where] = elementData[where + 1];
			where++;
		}
		elementData[elementCount] = null; // free reference
		return result;
	}

	public Object set(int index, Object obj)

	// pre: 0 <= index && index < size()
	// post: element value is changed to obj; old value is returned
	{
		Object previous = elementData[index];
		elementData[index] = obj;
		return previous;
	}

	public int size()
	// post: returns the size of the vector
	{
		return elementCount;
	}

	public void ensureCapacity(int minCapacity)
	// post: the capacity of this vector is at least minCapacity
	{
		if (elementData.length < minCapacity) {
			int newLength = elementData.length; // initial guess
			if (capacityIncrement == 0) {
				// increment of 0 suggests doubling (default)
				if (newLength == 0)
					newLength = 1;
				while (newLength < minCapacity) {
					newLength *= 2;
				}
			} else {
				// increment != 0 suggests incremental increase
				while (newLength < minCapacity) {
					newLength += capacityIncrement;
				}
			}
			// assertion: newLength > elementData.length.
			Object newElementData[] = new Object[newLength];
			int i;
			// copy old data to array
			for (i = 0; i < elementCount; i++) {
				newElementData[i] = elementData[i];
			}
			elementData = newElementData;
			// garbage collector will (eventually) pick up old elementData
		}
		// assertion: capacity is at least minCapacity
	}
}
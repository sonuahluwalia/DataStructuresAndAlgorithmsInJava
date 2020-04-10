package chapter4;

import java.util.AbstractList;

import chapter1.Assert;

public class Vector<E> extends AbstractList<E> implements Cloneable {
	private Object elementData[];
	// the data
	protected int elementCount;
	// number of elements in vector
	protected int capacityIncrement;
	// the rate of growth for vector
	protected E initialValue; // new elements have this value

	protected final static int defaultCapacity = 10; // def't capacity, must be>0

	public Vector() {
		elementData = new Object[defaultCapacity];
		elementCount = 0;
		
	}
	// post: constructs a vector with capacity for 10 elements

	public Vector(int initialCapacity) {
	}
	// pre: initialCapacity >= 0
	// post: constructs an empty vector with initialCapacity capacity

	public Vector(int initialCapacity, int capacityIncr) {
		// pre: initialCapacity >= 0, capacityIncr >= 0
		// post: constructs an empty vector with initialCapacity capacity
		// that extends capacity by capacityIncr, or doubles if 0

	}

	public Vector(int initialCapacity, int capacityIncr, E initValue) {
		// pre: initialCapacity, capacityIncr >= 0
		// post: constructs empty vector with capacity that begins at
		// initialCapacity and extends by capacityIncr or doubles
		// if 0. New entries in vector are initialized to initValue.

		Assert.pre(initialCapacity >= 0, "Nonnegative capacity.");
		capacityIncrement = capacityIncr;
		elementData = new Object[initialCapacity];
		elementCount = 0;
		initialValue = initValue;

	}

	public boolean add(E obj) {
		// post: adds new element to end of possibly extended vector
		ensureCapacity(elementCount + 1);
		elementData[elementCount] = obj;
		elementCount++;
		return true;
	}

	public boolean remove(Object element) {
		return false;
	}
	// post: element equal to parameter is removed and returned

	public boolean contains(Object elem) {
		return false;
	}
	// post: returns true iff Vector contains the value
	// (could be faster, if orderedVector is used)

	public E get(int index) {
		// pre: 0 <= index && index < size()
		// post: returns the element stored in location index
		return (E) elementData[index];
	}

	public void insertElementAt(E obj, int index) {
	}
	// pre: 0 <= index <= size()
	// post: inserts new value in vector with desired index,
	// moving elements from index to size()-1 to right

	public E remove(int where) {
		return null;
	}
	// pre: 0 <= where && where < size()
	// post: indicated element is removed, size decreases by 1

	public E set(int index, E obj) {
		// pre: 0 <= index && index < size()
		// post: element value is changed to obj; old value is returned
		Assert.pre(0 <= index && index < elementCount, "index is within bounds");
		E previous = (E) elementData[index];
		elementData[index] = obj;
		return previous;
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
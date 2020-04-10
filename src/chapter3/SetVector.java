package chapter3;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

import chapter1.Assert;

public class SetVector extends AbstractSet {

	protected Vector data; // the underlying vector

	public SetVector()
	// post: constructs a new, empty set
	{
		data = new Vector();
	}

	public SetVector(Collection other)
	// post: constructs a new set with elements from other
	{
		this();
		addAll(other);
	}

	public boolean remove(Object e)
	// pre: e is non-null object
	// post: e is removed from set, value returned
	{
		return data.remove(e);
	}

	public boolean add(Object e)
	// pre: e is non-null object
	// post: adds element e to set
	{
		if (!data.contains(e)) {
			data.add(e);
			return true;
		} else {
			return false;
		}
	}

	public boolean addAll(Collection other)
	// pre: other is a non-null structure
	// post: add all elements of other to set, if needed
	{
		Iterator yourElements = other.iterator();
		while (yourElements.hasNext()) {
			add(yourElements.next());
		}
		return true;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

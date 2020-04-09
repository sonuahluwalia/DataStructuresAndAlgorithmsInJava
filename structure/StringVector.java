// An implementation of extensible arrays of Strings.  Silly.
// (c) 2006 duane a. bailey

import structure.Assert;
import java.util.Iterator;
import java.util.Collection;

/**
 * @version $Id: StringVector.java 17 2006-08-08 19:56:30Z bailey $
 */
public class StringVector implements Cloneable
{
    /**
     * The data associated with the vector.  The size of the
     * array is always at least as large as the vector.  The array
     * is only extended when necessary.
     */
    protected String elementData[];     // the data
    /**
     * The actual number of elements logically stored within the
     * vector.  May be smaller than the actual length of the array.
     */
    protected int elementCount;         // number of elements in vector
        /*
    ...
    */
    /**
     * The size of size increment, should the vector become full.
     * 0 indicates the vector should be doubled when capacity of
     * the array is reached.
     */
    protected int capacityIncrement;    // the rate of growth for vector
    /**
     * The initial value of any new elements that are appended to the
     * vector.  Normally null.  Be aware that references used in this
     * way will result in multiple references to a single object.
     */
    protected String initialValue;      // new elements have this value
    /**
     * The default size of the vector; may be overridden in
     * the {@link #Vector(int)} constructor.
     */
    protected final static int defaultCapacity = 10; // def't capacity, must be>0

    /**
     * Construct an empty vector.
     * 
     * @post constructs a vector with capacity for 10 elements
     */
    public StringVector()
    {
        this(10); // call one-parameter constructor
    }
    
    /**
     * Construct an empty vector capable of storing <code>initialCapacity</code>
     * values before the vector must be extended.
     *
     * @pre initialCapacity >= 0
     * @post constructs an empty vector with initialCapacity capacity
     * @param initialCapacity The size of vector before reallocation is necessary
     */
    public StringVector(int initialCapacity)
    {
        Assert.pre(initialCapacity >= 0,"Nonnegative capacity.");
        elementData = new String[initialCapacity];
        elementCount = 0;
        capacityIncrement = 0;
        initialValue = null;
    }

    /**
     * Construct a vector with initial capacity, and growth characteristic.
     *
     * @pre initialCapacity >= 0, capacityIncr >= 0
     * @post constructs an empty vector with initialCapacity capacity
     *    that extends capacity by capacityIncr, or doubles if 0
     * 
     * @param initialCapacity The initial number of slots in vector.
     * @param capacityIncr The size of growth of vector.
     * @see #capacityIncrement
     */
    public StringVector(int initialCapacity, int capacityIncr)
    {
        Assert.pre(initialCapacity >= 0, "Nonnegative capacity.");
        elementData = new String[initialCapacity];
        elementCount = 0;
        capacityIncrement = capacityIncr;
        initialValue = null;
    }

    /**
     * Construct a vector with initial size, growth rate and default
     * value.
     *
     * @pre initialCapacity, capacityIncr >= 0
     * @post constructs empty vector with capacity that begins at
     *       initialCapacity and extends by capacityIncr or doubles
     *       if 0.  New entries in vector are initialized to initValue.
     * 
     * @param initialCapacity The initial number of slots in vector.
     * @param capacityIncr The size of the increment when vector grows.
     * @param initValue The initial value stored in vector elements.
     */
    public StringVector(int initialCapacity, int capacityIncr, String initValue)
    {
        Assert.pre(initialCapacity >= 0, "Nonnegative capacity.");
        capacityIncrement = capacityIncr;
        elementData = new String[initialCapacity];
        elementCount = 0;
        initialValue = initValue;
    }
    
    public StringVector(Collection c)
    {
        this(c.size());
        Iterator i = c.iterator();
        int pos = 0;
        while (i.hasNext())
        {
            set(pos++,(String)i.next());
        }
    }


    /**
     * Ensure that the vector is capable of holding at least
     * minCapacity values without expansion.
     *
     * @post the capacity of this vector is at least minCapacity
     * 
     * @param minCapacity The minimum size of array before expansion.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (elementData.length < minCapacity) {
            int newLength = elementData.length; // initial guess
            if (capacityIncrement == 0) {
                // increment of 0 suggests doubling (default)
                if (newLength == 0) newLength = 1;
                while (newLength < minCapacity) {
                    newLength *= 2;
                }
            } else {
                // increment != 0 suggests incremental increase
                while (newLength < minCapacity)
                {
                    newLength += capacityIncrement;
                }
            }
            // assertion: newLength > elementData.length.
            String newElementData[] = new String[newLength];
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

    /**
     * Add an element to the high end of the array, possibly expanding
     * vector.
     *
     * @post adds new element to end of possibly extended vector
     * 
     * @param obj The object to be added to the end of the vector.
     */
    public void add(String obj)
    {
        ensureCapacity(elementCount+1);
        elementData[elementCount] = obj;
        elementCount++;
    }
    
    /**
     * Add an element to the high end of the array, possibly expanding
     * vector.
     *
     * @post adds new element to end of possibly extended vector
     * 
     * @param obj The object to be added to the end of the vector.
     */
    public void addElement(String o)
    {
        add(o);
    }
    
    /**
     * Remove an element, by value, from vector.
     *
     * @post element equal to parameter is removed and returned
     * @param element the element to be removed.
     * @return the element actually removed, or if none, null.
     */
    public String remove(String element)
    {
        String result = null;
        int i = indexOf(element);
        if (i >= 0)
        {
            result = get(i);
            remove(i);
        }
        return result;
    }

    /**
     * Determine the capacity of the vector.  The capacity is always
     * at least as large as its size.
     *
     * @post returns allocated size of the vector
     * 
     * @return The size of the array underlying the vector.
     */
    public int capacity()
    {
        return elementData.length;
    }

    /**
     * Construct a shallow copy of the vector.  The vector
     * store is copied, but the individual elements are shared
     * objects.
     *
     * @post returns a copy of the vector, using same objects
     * 
     * @return A copy of the original vector.
     */
    public Object clone()
    {
        StringVector copy = null;
        try {
            copy = (StringVector)super.clone();
            copy.elementData = elementData.clone();
        } catch (java.lang.CloneNotSupportedException e) { Assert.fail("Vector cannot be cloned."); }
        return copy;
    }

    /**
     * Determine if a value appears in a vector.
     *
     * @post returns true iff Vector contains the value
     *       (could be faster, if orderedVector is used)
     * 
     * @param elem The value sought.
     * @return True iff the value appears in the vector.
     */
    public boolean contains(String elem)
    {
        int i;
        for (i = 0; i < elementCount; i++) {
            if (elem.equals(elementData[i])) return true;
        }
        return false;
    }

    /**
     * Copy the contents of the vector into an array.
     * The array must be large enough to accept all the values in
     * the vector.
     *
     * @pre dest has at least size() elements
     * @post a copy of the vector is stored in the dest array
     * 
     * @param dest An array of size at least size(). 
     */
    public void copyInto(String dest[])
    {
        int i;
        for (i = 0; i < elementCount; i++) {
            dest[i] = elementData[i];
        }
    }

    /**
     * Fetch the element at a particular index.
     * The index of the first element is zero.
     *
     * @pre 0 <= index && index < size()
     * @post returns the element stored in location index
     * 
     * @param index The index of the value sought.
     * @return A reference to the value found in the vector.
     */
    public String elementAt(int index)
    {
        return get(index);
    }


    /**
     * Fetch the element at a particular index.
     * The index of the first element is zero.
     *
     * @pre 0 <= index && index < size()
     * @post returns the element stored in location index
     * 
     * @param index The index of the value sought.
     * @return A reference to the value found in the vector.
     */
    public String get(int index)
    {
        return elementData[index];
    }

    /**
     * Construct a iterator over the elements of the vector.
     * The iterator considers elements with increasing
     * index.
     *
     * @post returns an iterator allowing one to
     *       view elements of vector
     * @return an iterator to traverse the vector.
     */
    public Iterator iterator()
    {
        return new StringVectorIterator(this);
    }

    /**
     * Get access to the first element of the vector.
     *
     * @pre vector contains an element
     * @post returns first value in vector
     * 
     * @return Access to the first element of the vector.
     */
    public String firstElement()
    {
        return get(0);
    }

    /**
     * Assuming the data is not in order, find the index of a
     * value, or return -1 if not found.
     *
     * @post returns index of element equal to object, or -1; starts at 0
     * 
     * @param elem The value sought in vector.
     * @return The index of the first occurrence of the value.
     */
    public int indexOf(String elem)
    {
        return indexOf(elem,0);
    }

    /**
     * Assuming the data is not in order, find the index of a value
     * or return -1 if the value is not found.  Search starts at index.
     *
     * @post returns index of element equal to object, or -1; starts at index
     * 
     * @param elem The value sought.
     * @param index The first location considered.
     * @return The index of the first location, or -1 if not found.
     */
    public int indexOf(String elem, int index)
    {
        int i;
        for (i = index; i < elementCount; i++)
        {
            if (elem.equals(elementData[i])) return i;
        }
        return -1;
    }

    /**
     * Insert an element at a particular location.
     * Vector is grown as needed
     *
     * @pre 0 <= index <= size()
     * @post inserts new value in vector with desired index,
     *   moving elements from index to size()-1 to right
     * 
     * @param obj The value to be inserted.
     * @param index The location of the new value.
     *
     */
    public void insertElementAt(String obj, int index)
    {
        add(index,obj);
    }

    /**
     * Insert an element at a particular location.
     * Vector is grown as needed
     *
     * @pre 0 <= index <= size()
     * @post inserts new value in vector with desired index,
     *   moving elements from index to size()-1 to right
     * 
     * @param obj the value to be inserted.
     * @param index the location of the new value.
     */
    public void add(int index, String obj)
    {
        int i;
        ensureCapacity(elementCount+1);
        // must copy from right to left to avoid destroying data
        for (i = elementCount; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        // assertion: i == index and element[index] is available
        elementData[index] = obj;
        elementCount++;
    }
    /* A recursive version of insertion of element at
    public void add(int index, String value)
    // pre: 0 <= index <= size()
    // post: inserts new value in vector with desired index
    //   moving elements from index to size()-1 to right
    {
        if (index >= size()) {
            add(value); // base case: add at end
        } else {
            String previous = get(index); // work
            add(index+1,previous);  // progress through recursion
            set(index,value);  // work
        }
    }
    */

    /**
     * Determine if the Vector contains no values.      
     *
     * @post returns true iff there are no elements in the vector
     * 
     * @return True iff the vector is empty.
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Fetch a reference to the last value in the vector.
     *
     * @pre vector is not empty
     * @post returns last element of the vector
     * 
     * @return A reference to the last value.
     */
    public String lastElement()
    {
        return get(elementCount-1);
    }

    /**
     * Search for the last occurrence of a value within the
     * vector.  If none is found, return -1.
     *
     * @post returns index of last occurrence of object in the vector, or -1
     * 
     * @param obj The value sought.
     * @return The index of the last occurrence in the vector.
     */
    public int lastIndexOf(String obj)
    {
        return lastIndexOf(obj,elementCount-1);
    }

    /**
     * Find the index of the last occurrence of the value in the vector before
     * the indexth position.
     *
     * @pre index >= 0
     * @post returns the index of last occurrence of object at or before
     *       index
     * 
     * @param obj The value sought.
     * @param index The last acceptable index.
     * @return The index of the last occurrence of the value, or -1 if none.
     */
    public int lastIndexOf(String obj, int index)
    {
        int i;
        for (i = index; i >= 0; i--) {
            if (obj.equals(elementData[i])) return i;
        }
        return -1;
    }

    /**
     * Remove all the values of the vector.
     *
     * @post vector is empty
     */
    public void clear()
    {
        setSize(0);
    }

    /**
     * Remove all the elements of the vector.
     * Kept for compatibility with java.util.Vector.
     *
     * @post vector is empty
     *
     * @see #clear
     */
    public void removeAllElements()
    {
        setSize(0);
    }

    /*
     * Remove an element, by value, from vector.
     *
     * @post element equal to parameter is removed
     * 
     * @param element The element to be removed.
     * @return The element actually removed, or if none, null.

    public boolean removeElement(String element)
    {
        int where = indexOf(element);
        if (where == -1) return false;
        remove(where);
        return true;
    }
*/

    /**
     * Remove an element at a particular location.
     *
     * @pre 0 <= where && where < size()
     * @post indicated element is removed, size decreases by 1
     * 
     * @param where The location of the element to be removed.
     */
    public void removeElementAt(int where)
    {
        remove(where);
    }

    /**
     * Remove an element at a particular location.
     *
     * @pre 0 <= where && where < size()
     * @post indicated element is removed, size decreases by 1
     * 
     * @param where The location of the element to be removed.
     */
    public String remove(int where)
    {
        String result = get(where);
        elementCount--;
        while (where < elementCount) {
            elementData[where] = elementData[where+1];
            where++;
        }
        elementData[elementCount] = null; // free reference
        return result;
    }

    /**
     * Change the value stored at location index.
     *
     * @pre 0 <= index && index < size()
     * @post element value is changed to obj
     * 
     * @param obj The new value to be stored.
     * @param index The index of the new value.
     */
    public void setElementAt(String obj, int index)
    {
        set(index,obj);
    }

    /**
     * Change the value stored at location index.
     *
     * @pre 0 <= index && index < size()
     * @post element value is changed to obj; old value is returned
     * 
     * @param obj The new value to be stored.
     * @param index The index of the new value.
     */
    public String set(int index, String obj)
    {
        String previous = elementData[index];
        elementData[index] = obj;
        return previous;
    }

    /**
     * Explicitly set the size of the array.
     * Any new elements are initialized to the default value.
     *
     * @pre newSize >= 0
     * @post vector is resized, any new elements are initialized
     * 
     * @param newSize The ultimate size of the vector.
     */
    public void setSize(int newSize)
    {
        int i;
        if (newSize < elementCount) {
            for (i = newSize; i < elementCount; i++) elementData[i] = null;
        } else {
            for (i = elementCount; i < newSize; i++)
                elementData[i] = initialValue;
        }
        elementCount = newSize;
    }

    /**
     * Determine the number of elements in the vector.
     *
     * @post returns the size of the vector
     * 
     * @return The number of elements within the vector.
     */
    public int size()
    {
        return elementCount;
    }

    /**
     * Trim the vector to exactly the correct size.
     *
     * @post minimizes allocated size of vector
     */
    public void trimToSize()
    {
        String newElementData[] = new String[elementCount];
        copyInto(newElementData);
        elementData = newElementData;
    }

    /**
     * Determine a string representation for the vector.
     *
     * @post returns a string representation of vector
     * 
     * @return A string representation for the vector.
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        int i;

        sb.append("<Vector:");
        for (i = 0; i < size(); i++)
        {
            sb.append(" "+get(i));
        }
        sb.append(">");
        return sb.toString();
    }
    /*
    public void print()
    // post: print the elements of the vector
    {
        printFrom(0);
    }
    
    protected void printFrom(int index)
    // pre: index <= size()
    // post: print elements indexed between index and size()
    {
        if (index < size()) {
            System.out.println(get(index));
            printFrom(index+1);
        }
    }
    */
}


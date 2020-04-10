package chapter4;

public class Association<K, V> {
	protected K theKey; // the key of the key-value pair
	protected V theValue; // the value of the key-value pair
	/*
	 * for example: Association<String,Integer> personAttribute = new
	 * Assocation<String,Integer>("Age",34);
	 */

	public Association(K key, V value) {
	}

	// pre: key is non-null
	// post: constructs a key-value pair
	public V getValue() {
		return theValue;
	}

	// post: returns value from association
	public K getKey() {
		return theKey;
	}
	// post: returns key from association

	public V setValue(V value) {
		V oldValue = theValue;
		theValue = value;
		return oldValue;
	}
}
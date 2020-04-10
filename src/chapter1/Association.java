package chapter1;
import java.util.Map;

public class Association implements Map.Entry {

	protected Object theKey; // the key of the key-value pair
	protected Object theValue; // the value of the key-value pair

	public Association(Object key, Object value)
	// pre: key is non-null
	// post: constructs a key-value pair
	{
		// Assert.pre(key != null, "Key must not be null.");
		theKey = key;
		theValue = value;
	}

	public Association(Object key)
	// pre: key is non-null
	// post: constructs a key-value pair; value is null
	{
		this(key, null);
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return theKey;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return theValue;
	}

	@Override
	public Object setValue(Object value) {
		// TODO Auto-generated method stub
		Object oldValue = theValue;
		theValue = value;
		return oldValue;
	}

}

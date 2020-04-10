package chapter1;

public class Assert {
	static public void pre(boolean test, String message) {
		// pre: result of precondition test
		// post: does nothing if test true, otherwise abort w/message
		if(!test) {
			new Exception(message);			
		}
	}
	static public void post(boolean test, String message) {
		// pre: result of postcondition test
		// post: does nothing if test true, otherwise abort w/message
		if(!test) {
			new Exception(message);			
		}
	}
	static public void condition(boolean test, String message) {
		// pre: result of general condition test
		// post: does nothing if test true, otherwise abort w/message
		if(!test) {
			new Exception(message);			
		}
	}
	static public void invariant(boolean test, String message) {
	// pre: result of an invariant test
	// post: does nothing if test true, otherwise abort w/message
		if(!test) {
			new Exception(message);			
		}
	}
	static public void fail(String message) {
	// post: throws error with message
		new Exception(message);
	}
}

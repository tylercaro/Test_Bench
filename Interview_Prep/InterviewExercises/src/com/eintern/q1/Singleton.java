
/*
 * Example of Double-Checked-Locking Singleton
 */
package com.eintern.q1;

public class Singleton {

	// volatile keyword means that access to the variable acts as thought it is
	// in a synchronized block
	private static volatile Singleton uniqueInstance;

	private Singleton() {
	};

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					
					uniqueInstance = new Singleton();
				}
			}
		}

		return uniqueInstance;
	}

}

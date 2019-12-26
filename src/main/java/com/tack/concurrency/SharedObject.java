package com.tack.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
	private Lock lock = new ReentrantLock();
	private int counter = 0;

	public Integer perform() {
		lock.lock();
		try {
			// Critical section here
			counter++;
			return counter;
		} finally {
			lock.unlock();
		}
	}

	public int getCounter() {
		return counter;
	}
}

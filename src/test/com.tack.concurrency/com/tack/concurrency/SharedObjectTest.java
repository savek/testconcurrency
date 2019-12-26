package com.tack.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharedObjectTest {

	@Test
	public void perform() throws InterruptedException {
		final int MAX_SIZE = 1000;
		final SharedObject sharedObject = new SharedObject();

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Callable<Integer>> callables = new ArrayList<>();

		for (int k = 0; k < MAX_SIZE; k++)
			callables.add(()-> sharedObject.perform());

		executorService.invokeAll(callables);
		executorService.shutdown();

		assertEquals(MAX_SIZE, sharedObject.getCounter());
	}
}

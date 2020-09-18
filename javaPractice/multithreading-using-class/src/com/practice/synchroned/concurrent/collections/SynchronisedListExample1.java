package com.practice.synchroned.concurrent.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sun.source.tree.AssertTree;

public class SynchronisedListExample1 {
	public static void main(String[] args) throws InterruptedException {
		Collection<Integer> al = Collections.synchronizedCollection(new ArrayList<Integer>());
		// List<Integer> al = Collections.synchronizedList(new ArrayList<Integer>());
		Thread t1 = new Thread(() -> {
			al.addAll(Arrays.asList(1, 2, 3, 4));
			System.out.println("List after " + Thread.currentThread().getName() + " adds elments-1,2,3,4 ");
		}, "thread1");
		Thread t2 = new Thread(() -> {
			al.addAll(Arrays.asList(5, 6, 7));
			System.out.println("List after " + Thread.currentThread().getName() + " adds elments-5,6,7");
		}, "thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}

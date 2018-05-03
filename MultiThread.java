package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThread {

	public static void main(String[] a) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<String> list = Arrays.asList(new String[] { "arya", "arunika" });
		List<Future<Integer>> fl = new ArrayList<>();
		for(String name: list){
			Task task = new Task(name);
			Future<Integer> f = es.submit(task );
			fl.add(f);
		}
		es.shutdown();
		for(Future<Integer> f: fl){
			System.out.println(f.get());
		}
	}
}


class Task implements Callable<Integer> {
	String name;
	Task(String name){
		this.name= name;
	}
	public Integer call() throws InterruptedException {
		System.out.println(name);
		Thread.sleep(1000);
		return name.length();
	}
}

package com.ud.classic.pochub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolConductor {

	public static void main(String[] args) {
		System.out.println("Start of the application");
		//testSimpleThreadPool();
		//testCachedPoolexexutor();
		testsinglePoolexexutor();
		System.out.println("End of the application");

	}
	
	/*
	 * Simple Thread Pool example 
	 * 
	 * Method                            Description
	 * ------                            -------------------------------------------
       newFixedThreadPool(int)           Creates a fixed size thread pool.
       newCachedThreadPool()             Creates a thread pool that creates new 
                                         threads as needed, but will reuse previously 
                                         constructed threads when they are available
       newSingleThreadExecutor()          Creates a single thread. 
	 */
	
	public static void testSimpleThreadPool () {
		System.out.println("############################# Stepping into testSimpleThreadPool");
		
		ExecutorService  executorFixedThreadPool = Executors.newFixedThreadPool(2);
		
		
		Thread theadTask = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread is running");
				try {
					Thread.sleep(10000L);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		};
		
		int counter = 1;
		int maxTaskCounter = 10;
		
		for (;true;) {
			
			//Submit the Task to execute -
			executorFixedThreadPool.execute(theadTask);
			
			if (counter == maxTaskCounter) {
				break;
			}
			counter++;
		}
		
		System.out.println("Submitting the tasks");
		//Shutting the Pool
		executorFixedThreadPool.shutdown ();
		System.out.println("Pool is down");
		
		System.out.println("############################# Stepping out from testSimpleThreadPool");
	}
	
	
	public static void testCachedPoolexexutor () {
		
		System.out.println("############################# Stepping into testCachedPoolexexutor");
		
		ExecutorService  executorFixedThreadPool = Executors.newCachedThreadPool();
		
		
		Thread theadTask = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread is running");
				try {
					Thread.sleep(5000l);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("End of the thread ");
				
			}
		};
		
		int counter = 1;
		int maxTaskCounter = 10;
		
		for (;true;) {
			
			//Submit the Task to execute -
			executorFixedThreadPool.execute(theadTask);
			
			if (counter == maxTaskCounter) {
				break;
			}
			counter++;
		}
		
		System.out.println("Submitting the tasks");
		//Shutting the Pool
		executorFixedThreadPool.shutdown ();
		System.out.println("Pool is down");
		
		System.out.println("############################# Stepping into testCachedPoolexexutor");
	}
	
    public static void testsinglePoolexexutor () {
		
		System.out.println("############################# Stepping into testsinglePoolexexutor");
		
		ExecutorService  executorFixedThreadPool = Executors.newSingleThreadExecutor();
		
		
		Thread theadTask = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread is running");
				try {
					Thread.sleep(10000L);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("End of the thread ");
				
			}
		};
		
		int counter = 1;
		int maxTaskCounter = 10;
		
		for (;true;) {
			
			//Submit the Task to execute -
			executorFixedThreadPool.execute(theadTask);
			
			if (counter == maxTaskCounter) {
				break;
			}
			counter++;
		}
		
		System.out.println("Submitting the tasks");
		//Shutting the Pool
		executorFixedThreadPool.shutdown ();
		System.out.println("Pool is down");
		
		System.out.println("############################# Stepping into testsinglePoolexexutor");
	}
	
	
	

}

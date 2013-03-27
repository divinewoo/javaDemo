package com.demo1.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService exc = Executors.newFixedThreadPool(1);

		Runnable call1 = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					for (int i = 0; i < 5; i++) {
						System.out.println("Call1...");
						throw new RuntimeException("asdfasfsadf");
//						Thread.sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Runnable call2 = new Runnable() {
			public void run() {

				for (int i = 0; i < 5; i++) {
					try {
						System.out.println("Call2...");
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
			}
		};

		exc.execute(call1);
		exc.execute(call2);

		System.out.println("Main,,,,");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		exc.shutdownNow();
		try {
			boolean bool = exc.awaitTermination(10000, TimeUnit.SECONDS);
			System.out.println("====" + bool);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("I am wrong!!!!");
		}
	}
}

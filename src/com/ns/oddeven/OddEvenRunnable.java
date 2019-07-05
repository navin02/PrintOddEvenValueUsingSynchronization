package com.ns.oddeven;

public class OddEvenRunnable implements Runnable {

	public int PRINT_NUMBER_UPTO = 10;
	static int number = 1;
	int remainder;
	static Object lock = new Object();

	public OddEvenRunnable(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBER_UPTO) {
			synchronized (lock) {
				while (number % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}

	}

}

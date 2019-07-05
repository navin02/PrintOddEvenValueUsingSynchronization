package com.ns.producer;

public class OddEvenImpl {
	private volatile int number = 1;
	// private boolean isOdd = true;
	private int maxCount;

	public OddEvenImpl(int maxCount) {
		this.maxCount = maxCount;
	}

	public synchronized void printOdd() throws InterruptedException {

		while (number < maxCount) {
			// while (!isOdd) {

			if (number % 2 == 0) {
				System.out.println("odd waiting count " + number);
				this.wait();
				System.out.println("odd notify count " + number);
			}
			// }

			System.out.println(Thread.currentThread().getName() + "  " + number);
			number++;
			this.notifyAll();
			// isOdd = false;
		}
	}

	public synchronized void printEven() throws InterruptedException {

		while (number < maxCount) {
			// while (isOdd) {
			if (number % 2 != 0) {
				System.out.println("even waiting count " + number);
				this.wait();
				System.out.println("even notify count " + number);
			}
			// }

			System.out.println(Thread.currentThread().getName() + "  " + number);
			number++;
			this.notifyAll();
			// isOdd = true;

		}
	}
}

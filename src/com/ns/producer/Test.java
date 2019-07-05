package com.ns.producer;

public class Test {
	public static void main(String[] args) {
		OddEvenImpl impl = new OddEvenImpl(10);
		OddNumberProducer oddNumberProducer = new OddNumberProducer(impl);
		EvenNumberProducer evenNumberProducer = new EvenNumberProducer(impl);
		Thread oddWorkerThread = new Thread(oddNumberProducer, "odd thread");
		Thread evenWorkerThread = new Thread(evenNumberProducer, "even thread");
		oddWorkerThread.start();
		evenWorkerThread.start();
	}
}

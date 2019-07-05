package com.ns.producer;

public class OddNumberProducer implements Runnable {
	private OddEvenImpl oddEvenImpl;

	public OddNumberProducer(OddEvenImpl impl) {
		this.oddEvenImpl = impl;
	}

	@Override
	public void run() {
		try {
			this.oddEvenImpl.printOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

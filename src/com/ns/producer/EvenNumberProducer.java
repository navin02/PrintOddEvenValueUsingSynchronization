package com.ns.producer;

public class EvenNumberProducer implements Runnable {

	private OddEvenImpl impl;

	public EvenNumberProducer(OddEvenImpl impl) {
		this.impl = impl;
	}

	@Override
	public void run() {
		try {
			this.impl.printEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

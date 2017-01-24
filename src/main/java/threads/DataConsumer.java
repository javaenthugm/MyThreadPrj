package main.java.threads;

import java.util.concurrent.BlockingQueue;

import main.java.pojo.Invoice;

public class DataConsumer implements Runnable {

	private final BlockingQueue<Invoice> invoiceQueue;
	
	public DataConsumer(BlockingQueue<Invoice> invQ) {
			this.invoiceQueue = invQ;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				Invoice inv = invoiceQueue.take();
				Thread.sleep(1000);
				runRule1(inv);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void runRule1(Invoice i){
		System.out.println(Thread.currentThread().getName()+" -  "+ i + " and Size - " +invoiceQueue.size());
	}

}

package main.java.threads;

import java.util.concurrent.BlockingQueue;

import main.java.pojo.Invoice;

public class DataProducer implements Runnable {

	private final BlockingQueue<Invoice> invoiceQueue;

	public DataProducer(BlockingQueue<Invoice> invBQ) {
		this.invoiceQueue = invBQ;
	}

	@Override
	public void run() {

		while (true) {
			Invoice inv = new Invoice(Thread.currentThread().getId(), Thread
					.currentThread().getId() + 100);
			try {
				Thread.sleep(100);

				invoiceQueue.put(inv);
				System.out
						.println(Thread.currentThread().getName()
								+ "-Producing Invoices and Size-"
								+ invoiceQueue.size());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();

			}
		}

	}

}

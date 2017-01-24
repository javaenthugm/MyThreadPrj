package test.java.app;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import main.java.pojo.Invoice;
import main.java.threads.DataConsumer;
import main.java.threads.DataProducer;
import main.java.utils.logger.LogWriter;

public class MainApp {
	
	public static void main(String args[]) throws InterruptedException{
		BlockingQueue<Invoice> bQueue = new LinkedBlockingQueue<>(10);
		
		/*new Thread(new DataProducer(bQueue)).start();
		new Thread(new DataConsumer(bQueue)).start();*/
		
		LogWriter logger = new LogWriter(new PrintWriter(System.out));
		logger.start();
		logger.log("Starting Main App");
		
		
		ExecutorService prodExec = Executors.newFixedThreadPool(2);
		ExecutorService consExec = Executors.newFixedThreadPool(4);
	
		for(int i=0;i<3;i++){
			prodExec.execute(new DataProducer(bQueue));
		}
		
		for(int i=0;i<3;i++){
			consExec.execute(new DataConsumer(bQueue));
		}
		
		
		
		
		try {
			prodExec.awaitTermination(3, TimeUnit.MINUTES);
			consExec.awaitTermination(3, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prodExec.shutdownNow();
		consExec.shutdownNow();
	}

}

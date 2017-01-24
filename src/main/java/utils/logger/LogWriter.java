package main.java.utils.logger;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class LogWriter {
	
	private final BlockingQueue<String> queue;
	private final LoggerThread logger;
	
	public LogWriter(Writer writer){
		
		this.queue = new LinkedBlockingDeque<String>(100);
		this.logger = new LoggerThread(writer);
	}
	
	public void start(){
		logger.start();
	}
	
	public void log(String msg) throws InterruptedException{
		queue.put(msg);
	}
	
	public void shutDown(String msg)throws InterruptedException{
		queue.put("SHUTDOWN");
	}
	
	private class LoggerThread extends Thread{
		private final PrintWriter writer;
		
		public LoggerThread(Writer writer){
			this.writer = (PrintWriter) writer;
		}
		
		
		public void run(){
			try {
				String item=null;
				while((item=queue.take())!="SHUTDOWN"){
					writer.println("LOGGER THREAD:" + item);
				}
			}catch (InterruptedException ignored) {
				ignored.printStackTrace();
			}finally{
				writer.println("Shutting down Logger");
				writer.close();
				
			}
		}
	}
	
	

}

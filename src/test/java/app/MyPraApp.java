package test.java.app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import main.java.pojo.Vendor;
import main.java.threads.EventLogGen;
import main.java.utils.logger.LogWriter;

public class MyPraApp {
	
	static final List<Vendor> vendors = new ArrayList<>();
	
	
	static final String[] rules = {"rule-01","rule-02","rule-03","rule-04","rule-05"};
	
	public MyPraApp(){
		for(int i=0;i<1000;i++){
			vendors.add(new Vendor(i+"", "venname-"+i));
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException{
	
		MyPraApp mApp = new MyPraApp();
		

		
		LogWriter logger = new LogWriter(new PrintWriter(System.out,true));
		//logger.start();
		//logger.log("Starting Main App");
		
		
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		//ExecutorService exec = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
		
		for(final Vendor v : vendors){
			for(String rule: rules){
				exec.execute(new EventLogGen(v, rule));
			}
		}
		
		
		/*if(exec instanceof ThreadPoolExecutor){
			ThreadPoolExecutor tp = (ThreadPoolExecutor)exec;
		}else{
			System.out.println("Not an instance of ThreadPoolExecutor");
		}*/
		
		try {
			//exec.awaitTermination(1, TimeUnit.SECONDS);
			
			exec.shutdown();
			
			
		}/*catch (InterruptedException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}*/catch(Exception ignored){
			
		}finally{
			//logger.shutDown("SHUTDOWN");
		}
		
		
	}

}

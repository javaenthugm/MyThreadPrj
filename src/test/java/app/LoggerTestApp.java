package test.java.app;

import java.io.PrintWriter;

import main.java.utils.logger.LogWriter;

public class LoggerTestApp {
	
	public static void main(String args[]) throws InterruptedException{
			LogWriter log = new LogWriter(new PrintWriter(System.out, true));
			
			log.start();
			log.log("Hello");
		
	}

}

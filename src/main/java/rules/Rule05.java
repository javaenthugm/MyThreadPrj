package main.java.rules;

import main.java.pojo.Vendor;

public class Rule05  implements RuleImplementor{

	@Override
	public void runRule(Vendor v) {
		
		try {
			System.out.println(v.getVenname() +" -Running rule-05");
			Thread.sleep(10);
			System.out.println(v.getVenname() +" -Rule-05 - Events to EventLog Table");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

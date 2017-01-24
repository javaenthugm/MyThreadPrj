package main.java.rules;

import main.java.pojo.Vendor;

public class Rule02  implements RuleImplementor{

	@Override
	public void runRule(Vendor v) {
		
		try {
			System.out.println(v.getVenname() +" -Running rule-02");
			Thread.sleep(1000);
			System.out.println(v.getVenname() +" -Rule-02 - Events to EventLog Table");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

package main.java.rules;

import main.java.pojo.Vendor;

public class Rule01  implements RuleImplementor{

	@Override
	public void runRule(Vendor v) {
		
		try {
			System.out.println(v.getVenname() +" -Running rule-01");
			Thread.sleep(1000);
			System.out.println(v.getVenname() +" -Rule-01 - Events to EventLog Table");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

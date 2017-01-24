package main.java.rules;

import main.java.pojo.Vendor;

public class Rule04  implements RuleImplementor{

	@Override
	public void runRule(Vendor v) {
		
		try {
			System.out.println(v.getVenname() +" -Running rule-04");
			Thread.sleep(4000);
			System.out.println(v.getVenname() +" -Rule-04 - Events to EventLog Table");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

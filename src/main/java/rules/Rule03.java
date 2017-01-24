package main.java.rules;

import main.java.pojo.Vendor;

public class Rule03  implements RuleImplementor{

	@Override
	public void runRule(Vendor v) {
		
		try {
			System.out.println(v.getVenname() +" -Running rule-03");
			Thread.sleep(500);
			System.out.println(v.getVenname() +" -Rule-03 - Events to EventLog Table");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

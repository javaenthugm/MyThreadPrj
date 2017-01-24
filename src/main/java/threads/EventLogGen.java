package main.java.threads;

import java.util.HashMap;
import java.util.Map;

import main.java.pojo.Vendor;
import main.java.rules.Rule01;
import main.java.rules.Rule02;
import main.java.rules.Rule03;
import main.java.rules.Rule04;
import main.java.rules.Rule05;
import main.java.rules.RuleImplementor;

public class EventLogGen implements Runnable{
	
	final Vendor vendor;
	final String rule;
	
	Map<String, RuleImplementor> ruleMap = new HashMap<>();
	
	
	public EventLogGen(Vendor v, String rule){
		this.vendor = v;
		this.rule = rule;
		ruleMap.put("rule-01", new Rule01());
		ruleMap.put("rule-02", new Rule02());
		ruleMap.put("rule-03", new Rule03());
		ruleMap.put("rule-04", new Rule04());
		ruleMap.put("rule-05", new Rule05());
		
	}
	
	public void run(){
		RuleImplementor rI = ruleMap.get(rule);
		rI.runRule(vendor);
	}

}

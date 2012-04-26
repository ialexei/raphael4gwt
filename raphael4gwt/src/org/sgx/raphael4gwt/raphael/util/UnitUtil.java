package org.sgx.raphael4gwt.raphael.util;

import java.util.LinkedList;
import java.util.List;

public class UnitUtil {
	
List<String> failures;
List<String> passes;

public UnitUtil() {
	failures=new LinkedList<String>();
	passes=new LinkedList<String>();
}
public void assertEquals(Object espected, Object actual, String msg) {
	
	String passMsg = msg, 
		failMsg = msg+" fail espected="+espected+" but actual was: "+actual;
	
	if(espected==null&&actual==null) {
		passes.add(passMsg);
	}
	else if(espected==null&&actual!=null||espected!=null&&actual==null) {
		failures.add(failMsg);
	}
	else if(espected!=null&&actual!=null) {
		if(espected.equals(actual)) {
			passes.add(passMsg);
		}
		else {
			failures.add(failMsg);
		}
	}
	else {
		failures.add(failMsg);
	}
}
public List<String> getFailures() {
	return failures;
}
public void setFailures(List<String> failures) {
	this.failures = failures;
}
public List<String> getPasses() {
	return passes;
}
public void setPasses(List<String> passes) {
	this.passes = passes;
}
public String printResults() {
	String s = "";
	if(getFailures()==null||getFailures().size()==0) {
		s+="No failures. ";
	}
	else {
		s+="Failures "+getFailures().size()+": ";
		for(String f : getFailures()) {
			s+="\n"+f;
		}
	}
	return s;
}

}

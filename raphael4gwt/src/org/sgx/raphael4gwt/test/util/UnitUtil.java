package org.sgx.raphael4gwt.test.util;

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
	if(espected==null&&actual==null) {
		passes.add(msg);
	}
	else if(espected==null&&actual!=null||espected!=null&&actual==null) {
		failures.add(msg);
	}
	else if(espected!=null&&actual!=null) {
		if(espected.equals(actual)) {
			passes.add(msg);
		}
		else {
			failures.add(msg);
		}
	}
	else {
		failures.add(msg);
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

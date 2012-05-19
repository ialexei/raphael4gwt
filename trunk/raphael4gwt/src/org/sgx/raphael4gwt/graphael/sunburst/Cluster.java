package org.sgx.raphael4gwt.graphael.sunburst;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * artificial java helper for defining sunburst clusters. 
 * Avoid loops !
 * @author sg
 *
 */
public class Cluster {
String name;
Cluster[]children;
double value;

public Cluster(String name, double value) {
	super();
	this.name = name;
	this.value = value;
}


public Cluster(String name, Cluster[] children) {
	super();
	this.name = name;
	this.children = children;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Cluster[] getChildren() {
	return children;
}
public void setChildren(Cluster[] children) {
	this.children = children;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}

public JavaScriptObject toNative() {
	JavaScriptObject o = JavaScriptObject.createObject();
	if(getChildren()==null)
		JsUtil.put(o, getName(), getValue());
	else {
		JavaScriptObject childVal = JavaScriptObject.createObject();
		for(Cluster child : getChildren()) {
			JsUtil.put(childVal, child.getName(), child.toNative());
		}
		JsUtil.put(o, getName(), childVal);
	}
	return o;
}

public static JavaScriptObject toNativeArray(Cluster[] c) {
	JavaScriptObject childVal = JavaScriptObject.createObject();
	for(Cluster child : c) {
		JsUtil.put(childVal, child.getName(), child.toNative());
	}
	return childVal;	
}

}

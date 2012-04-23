package org.sgx.raphael4gwt.graphael.bar;

import com.google.gwt.core.client.JavaScriptObject;

public class Bar extends JavaScriptObject {
	protected Bar(){}	
	public native final double getX()/*-{
		return this.x;
	}-*/;
	public native final double getY()/*-{
		return this.y;
	}-*/;
	public native final double getValue()/*-{
		return this.value;
	}-*/;
}

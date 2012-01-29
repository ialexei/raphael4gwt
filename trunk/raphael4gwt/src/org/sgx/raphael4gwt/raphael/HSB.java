package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;

public class HSB extends JavaScriptObject {
protected HSB(){}
public final native int getHue()/*-{
	return this.h;
}-*/;
public final native int getSaturation()/*-{
	return this.s;
}-*/;
public final native int getBrightness()/*-{
	return this.b;
}-*/;

}

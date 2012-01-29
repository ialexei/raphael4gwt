package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;


public class HSL extends JavaScriptObject {
protected HSL(){}
public final native int getHue()/*-{
	return this.h;
}-*/;
public final native int getSaturation()/*-{
	return this.s;
}-*/;
public final native int getLuminosity()/*-{
	return this.l;
}-*/;

}

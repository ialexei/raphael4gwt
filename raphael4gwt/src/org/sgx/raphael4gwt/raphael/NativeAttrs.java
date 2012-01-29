package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * the native javascript object for raphael attrs
 * @author sg
 *
 */
public class NativeAttrs extends JavaScriptObject {
	
	protected NativeAttrs(){};
	
	public final native String getFill()/*-{
		return this.fill;
	}-*/;
	public final native void setFill(String fill)/*-{
		this["fill"] = fill;
	}-*/;

	
	
}

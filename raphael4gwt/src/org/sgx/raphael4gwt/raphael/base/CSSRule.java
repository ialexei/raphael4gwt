package org.sgx.raphael4gwt.raphael.base;


import com.google.gwt.core.client.JsArrayMixed;
/**
 * for CSS extension - see raphael-ext.js
 * @author sg
 *
 */
public class CSSRule extends JsArrayMixed {
	
	protected CSSRule(){}
	
	public native final String getSelector()/*-{
		return this[0]; 
	}-*/;
	
	public native final Attrs getValue()/*-{
		return this[1]; 
	}-*/;


}

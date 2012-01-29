package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * red, green, blue color notation
 * @author sg
 *
 */
public class RGB extends JavaScriptObject {
protected RGB(){}

//public int r, g, b, h, s, v, l;
//public boolean error;
//public String hex;
public final native boolean isError()/*-{
return this.error;
}-*/;
public final native int getRed()/*-{
	this.r;
}-*/;
public final native int getGreen()/*-{
	return this.g;
}-*/;
public final native int getBlue()/*-{
	return this.b;
}-*/;
/**
 * 
 * @return color in HTML/CSS format: #••••••
 */
public final native String getHex()/*-{
	return this.hex;
}-*/;

}

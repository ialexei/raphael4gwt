package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;
/**
x:numbertop left corner x<br/>  
y:numbertop left corner y<br/>  
width: width<br/>  
height: height <br/>   
   TODO: if I don not use $wnd.Math.round() for ensure int gwt compielr complains in devmode.
 * @author sg
 *
 */
public class Rectangle extends JavaScriptObject {
	protected Rectangle(){}
	
	public native final double getWidth()/*-{
		return this.width;
	}-*/;
	public native final double getHeight()/*-{
		return this.height;
	}-*/;
	public native final double getX()/*-{
		return this.x;
	}-*/;
	public native final double getY()/*-{
		return this.y;
	}-*/;
	
}

package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * 1. x:numbertop left corner x
   2. y:numbertop left corner y
   3. width:numberwidth
   4. height:numberheight 
   
   TODO: if I don not use $wnd.Math.round() for ensure int gwt compielr complains in devmode.
 * @author sg
 *
 */
public class Rectangle extends JavaScriptObject {
	protected Rectangle(){}
//	public final int x=0, y=0, width=0, height=0;
	public native final int getWidth()/*-{
		return $wnd.Math.round(this.width);
	}-*/;
	public native final int getHeight()/*-{
		return $wnd.Math.round(this.height);
	}-*/;
	public native final int getX()/*-{
		return $wnd.Math.round(this.x);
	}-*/;
	public native final int getY()/*-{
		return $wnd.Math.round(this.y);
	}-*/;
	
	
//	public int javaAttr;

}

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
	public native final void setWidth(double w)/*-{
		this.width=w;
	}-*/;
	public native final double getHeight()/*-{
		return this.height;
	}-*/;
	public native final void setHeight(double h)/*-{
		this.height=h;
	}-*/;
	public native final double getX()/*-{
		return this.x;
	}-*/;
	public native final void setX(double x)/*-{
		this.x=x;
	}-*/;
	public native final double getY()/*-{
		return this.y;
	}-*/;
	public native final void setY(double y)/*-{
		this.y=y;
	}-*/;
	
	public native final String print()/*-{
		return "Rect("+this.x+", "+this.y+", "+this.width+", "+this.height+")";
	}-*/;
}

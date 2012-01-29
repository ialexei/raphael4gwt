package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * 1. x:numbertop left corner x
   2. y:numbertop left corner y
   3. width:numberwidth
   4. height:numberheight 
 * @author sg
 *
 */
public class Rectangle extends JavaScriptObject {
	protected Rectangle(){}
//	public final int x=0, y=0, width=0, height=0;
	public native final int getWidth()/*-{
		return this.width;
	}-*/;
	public native final int getHeight()/*-{
		return this.height;
	}-*/;
	public native final int getX()/*-{
		return this.x;
	}-*/;
	public native final int getY()/*-{
		return this.y;
	}-*/;
//	public int javaAttr;

}

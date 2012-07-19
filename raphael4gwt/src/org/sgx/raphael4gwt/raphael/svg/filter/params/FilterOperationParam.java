package org.sgx.raphael4gwt.raphael.svg.filter.params;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * an overlay for svg filter operation params
 * @author sg
 *
 */
public abstract class FilterOperationParam extends JavaScriptObject {
protected FilterOperationParam(){}

//double x, y, width, height; 
//String result=null, in=null;

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

public native final double getWidth()/*-{
return this.width; 
}-*/;
public native final void setWidth(double width)/*-{
this.width=width; 
}-*/;

public native final double getHeight()/*-{
return this.height; 
}-*/;
public native final void setHeight(double height)/*-{
this.height=height; 
}-*/;

public native final String getResult()/*-{
return this.result; 
}-*/;
public native final void setResult(String result)/*-{
this.result=result; 
}-*/;

public native final String getIn()/*-{
return this["in"]; 
}-*/;
public native final void setIn(String in_)/*-{
this["in"]=in_; 
}-*/;
}

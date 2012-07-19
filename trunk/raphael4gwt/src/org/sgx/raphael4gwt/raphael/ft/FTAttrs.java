package org.sgx.raphael4gwt.raphael.ft;

import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.core.client.JavaScriptObject;

public class FTAttrs extends JavaScriptObject {
protected FTAttrs() {}
public final native void setRotate(double rotate)/*-{
	this.rotate=rotate; 
}-*/;
public final native void setScale(String scaleString)/*-{
	this.scale=scaleString; 
}-*/;
public final native static FTAttrs create()/*-{
	return {}; 
}-*/;
public final native FTAttrs fill(String f)/*-{
	this["fill"]=f; 
	return this; 
}-*/;
public final native FTAttrs stroke(String s)/*-{
	this["stroke"]=s; 
	return this; 
}-*/;
public final native FTAttrs strokeWidth(int w)/*-{
	this["stroke-width"]=w; 
	return this; 
}-*/;

}

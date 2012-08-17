package org.sgx.raphael4gwt.raphael.ft;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
/**
 * 
 * @author sg
 *
 */
public class FTSubject extends FreeTransform {
	protected FTSubject(){}
	
public native final JsArray<Shape> getItems()/*-{
return this.items;
}-*/;
public native final Shape getSubject()/*-{
return this.subject;
}-*/;

public native final JavaScriptObject attrs()/*-{
return this.attrs;
}-*/;

public native final int getX()/*-{
	return Math.round(this.attrs.x);
}-*/;
public native final int getY()/*-{
return Math.round(this.attrs.y);
}-*/;
public native final int getWidth()/*-{
return Math.round(this.attrs.size.x);
}-*/;
public native final int getHeight()/*-{
return Math.round(this.attrs.size.y);
}-*/;
public native final int getCx()/*-{
return Math.round(this.attrs.center.x);
}-*/;
public native final int getCy()/*-{
return Math.round(this.attrs.center.y);
}-*/;
public native final double getRotate()/*-{
return this.attrs.rotate;
}-*/;
public native final double getScaleX()/*-{
return this.attrs.scale.x;
}-*/;
public native final double getScaleY()/*-{
return this.attrs.scale.y;
}-*/;
public native final int getTranslateX()/*-{
return Math.round(this.attrs.translate.x);
}-*/;
public native final int getTranslateY()/*-{
return Math.round(this.attrs.translate.y);
}-*/;


}

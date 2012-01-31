package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

public class MatrixTransf extends JavaScriptObject {
protected MatrixTransf(){}
public final native int getDx()/*-{
	return this.dx;
}-*/;
public final native int getDy()/*-{
	return this.dy;
}-*/;
public final native float getScaleX()/*-{
	return this.scalex;
}-*/;
public final native float getScaleY()/*-{
	return this.scaley;
}-*/;
public final native float getShear()/*-{
	return this.shear;
}-*/;
public final native float getRotate()/*-{
	return this.rotate;
}-*/;
public final native float isSimple()/*-{
	return this.isSimple;
}-*/;

}

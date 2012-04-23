package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

public class Matrix extends JavaScriptObject {
	
protected Matrix(){}
/**
 * Adds given matrix to existing one. 
 * @param b
 */
public final native void add(Matrix b)/*-{
	return this.add(b);
}-*/;
/**
 * Adds given matrix to existing one. 
 * @param a
 * @param b
 * @param c
 * @param d
 * @param e
 * @param f
 */
public final native void add(float a, float b, float c, float d, float e, float f)/*-{
	return this.add(a, b, c, d, e, f);
}-*/;
/**
 * Returns copy of the matrix 
 */
public final native Matrix clone()/*-{
	return this.clone();
}-*/;
/**
 * Returns inverted version of the matrix 
 * @return
 */
public final native Matrix invert()/*-{
	return this.invert();
}-*/;
/**
 * Rotates the matrix 
 * @param a
 * @param x
 * @param y
 */
public final native void rotate(float a, float x, float y)/*-{
	this.rotate(a, x, y);
}-*/;

public final native void scale(float x, float y)/*-{
	this.scale(x, y);
}-*/;
public final native void scale(float x, float y, int cx, int cy)/*-{
	this.scale(x, y, cx, cy);
}-*/;
/**
 * Splits matrix into primitive transformations 
 * @return
 */
public final native MatrixTransf split()/*-{
	return this.split();
}-*/;
/**
 * Splits matrix into primitive transformations 
 * @return
 */
public final MatrixTransf getTransformations() {
	return split();
}
/**
 * Return transform string that represents given matrix 
 * @return transform string
 */
public final native String toTransformString()/*-{
	return this.toTransformString();
}-*/;
/**
 * Translate the matrix 
 * @param x
 * @param y
 * @return
 */
public final native String translate(int x, int y)/*-{
	return this.translate(x, y);
}-*/;
public final native int x(int x, int y)/*-{
	return this.x(x, y);
}-*/;
public final native int y(int x, int y)/*-{
return this.y(x, y);
}-*/;
}

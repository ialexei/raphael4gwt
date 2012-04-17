package org.sgx.raphael4gwt.raphael.ft;

import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
/**
 * https://github.com/ElbertF/Raphael.FreeTransform
 * @author sg
 *
 */
public class FTOptions extends JavaScriptObject {
protected FTOptions(){}

public static final native FTOptions create()/*-{
return {"attrs": {}};
}-*/;

/**Sets the attributes of the handle (default: { fill: '#000', stroke: '#000' }).*/
public native final Attrs getAttrs()/*-{
	return this.attrs;
}-*/;
/**Sets the attributes of the handle (default: { fill: '#000', stroke: '#000' }).*/
public native final void setAttrs(Attrs a)/*-{	
	this["attrs"]=a;
}-*/;
/**gets the distance of the handles from the center of the element (num times radius, default: 1.2).*/
public native final double getDistance()/*-{	
	this.distance;
}-*/;
/**sets the distance of the handles from the center of the element (num times radius, default: 1.2).*/
public native final void setDistance(double dist)/*-{	
	this.distance=dist;
}-*/;

//public native final void setFillColor(String c)/*-{
//	this["attrs"]["fill"]=c;
//}-*/;
//public native final void setStrokeColor(String c)/*-{
//this["attrs"]["fill"]=c;
//}-*/;
//public native final String getFillColor()/*-{
//	return this.attrs.fill;
//}-*/;

/**
 * Limits the drag area of the handle (default: dimensions of the paper).*/
public native final void setBoundary(Rectangle r)/*-{
	this.boundary=r==null?false:r;
}-*/;
/**
 * Limits the drag area of the handle (default: dimensions of the paper).*/
public native final Rectangle getBoundary()/*-{
	if(this.boundary==false)return null;
	else return this.boundary;
}-*/;

/**
 * Enables/disables dragging (default: true).
 * @return
 */
public native final boolean isDrag()/*-{
	return this.drag;
}-*/;
/**
 * Enables/disables dragging (default: true).
 * @param d
 */
public native final void setDrag(boolean d)/*-{
	return this.drag=d;
}-*/;

/**
 * Enables/disables Rotate the subject by dragging (default: false).
 * @return
 */
public native final boolean isDragRotate()/*-{
	return this.dragRotate;
}-*/;
/**
 * Enables/disables Rotate the subject by dragging (default: false).
 * @param d
 */
public native final void setDragRotate(boolean d)/*-{
	return this.dragRotate=d;
}-*/;

/**
 * Enables/disables Scale the subject by dragging (default: false).
 * @return
 */
public native final boolean isDragScale()/*-{
	return this.dragScale;
}-*/;
/**
 * Enables/disables Scale the subject by dragging (default: false).
 * @param d
 */
public native final void setDragScale(boolean d)/*-{
	return this.dragScale=d;
}-*/;

/**
 * Set grid size for aligning elements (default: false).
 * pass/return negative in case of disabled grid size
 */
public native final int getGridSize()/*-{
	if(!this.grid)return -1;
	else return this.gridSnap;
}-*/;
/**
 * Set grid size for aligning elements (default: false).
 * pass/return negative in case of disabled grid size
 * @param i
 */
public native final void setGridSize(int i)/*-{
	if(i<0) this.grid=false;
	else this.grid=i;
}-*/;


/**
 * Snap edges to grid when num pixels away from grid (default: value of grid).
 * pass/return negative in case of use default value
 */
public native final int getGridSnap()/*-{
	if(!this.gridSnap)return -1;
	else return this.gridSnap;
}-*/;
/**
 * Snap edges to grid when num pixels away from grid (default: value of grid).
 * pass/return negative in case of use default value
 * @param i
 */
public native final void setGridSnap(int i)/*-{
	if(i<0) this.gridSnap=false;
	else this.gridSnap=i;
}-*/;

/**Scale axes together or individually (default: false)*/
public native final boolean isKeepRatio()/*-{
	return this.keepRatio;
}-*/;
/**Scale axes together or individually (default: false)*/
public native final void setKeepRatio(boolean kr)/*-{
	this.keepRatio = kr;
}-*/;

/**Enables/disables rotating (default: true).*/
public native final boolean isRotate()/*-{
	return this.rotate;
}-*/;
/**Enables/disables rotating (default: true).*/
public native final void setRotate(boolean kr)/*-{
	this.rotate = kr;
}-*/;
/**Limit the range of rotation (default: [ -180, 180 ])*/
public native final JsArrayInteger getRotateRange()/*-{
	return this.rotateRange;
}-*/;
/**Limit the range of rotation (default: [ -180, 180 ])*/
public native final void setRotateRange(int a1, int a2)/*-{
	return this.rotateRange=[a1, a2];
}-*/;

/**
 * Rotate with n degree increments (default: false).
 * pass/return negative in case of use default value
 */
public native final int getRotateSnap()/*-{
	if(!this.rotateSnap)return -1;
	else return this.rotateSnap;
}-*/;
/**
 * Rotate with n degree increments (default: false).
 * pass/return negative in case of use default value
 * @param i
 */
public native final void setRotateSnap(int i)/*-{
	if(i<0) this.rotateSnap=false;
	else this.rotateSnap=i;
}-*/;

/**Enables/disables scaling (default: true).*/
public native final boolean isScale()/*-{
	return this.scale;
}-*/;
/**Enables/disables scaling (default: true).*/
public native final void setScale(boolean kr)/*-{
	this.scale = kr;
}-*/;

/**Limit the range of rotation (default: [ -180, 180 ])*/
public native final JsArrayInteger getScaleRange()/*-{
	if(!this.scaleRange)return null;
	else return this.scaleRange;
}-*/;
/**Limit the range of rotation (default: [ -180, 180 ])*/
public native final void setScaleRange(int a1, int a2)/*-{
	if(a1<0||a2<0)this.scaleRange=false;
	else this.scaleRange=[a1, a2];
}-*/;
}

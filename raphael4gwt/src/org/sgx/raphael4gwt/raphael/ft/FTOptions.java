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



//public final native FTAttrs attrs()/*-{
//	return this.attrs; 
//}-*/;



public static final native FTOptions create()/*-{
	return {scale: [ 'axisX', 'axisY', 'bboxCorners', 'bboxSides' ]};
}-*/;



////animate 
////animate: true|{ delay: num, easing: string }|false
////Animate transformations. Works best in combination with apply() (see the functions section below).
////Default: { delay: 700, easing: 'linear' }
//public final native FTOptions setAnimate(FTAnim anim)/*-{
//	this.animate = anim.@org.sgx.raphael4gwt.raphael.ft.FTAnim::toNative();
//	return this;  
//}-*/;
//public final native FTAnim getAnimate()/*-{
//	if(!this.animate) {
//		return { delay: 700, easing: 'linear' }; 
//	}
//	else {
//		return @org.sgx.raphael4gwt.raphael.ft.FTAnim::fromNative(Lcom/google/gwt/core/client/JavaScriptObject;)(this.animate); 
//	}
//}-*/;




//attrs 

/**Sets the attributes of the handle (default: { fill: '#000', stroke: '#000' }).*/
public native final FTAttrs attrs()/*-{
	return this.attrs;
}-*/;
/**Sets the attributes of the handle (default: { fill: '#000', stroke: '#000' }).*/
public native final FTOptions setAttrs(FTAttrs a)/*-{	
	this["attrs"]=a;
	return this; 
}-*/;



//boundary: { x: int, y: int, width: int, height: int }|false
//Limits the drag area of the handles.
//Default: dimensions of the paper

/**
 * Limits the drag area of the handle (default: dimensions of the paper).*/
public native final FTOptions setBoundary(Rectangle r)/*-{
	this.boundary=r==null?false:r;
	return this; 
}-*/;
/**
 * Limits the drag area of the handle (default: dimensions of the paper).*/
public native final Rectangle getBoundary()/*-{
	if(this.boundary==false)return null;
	else return this.boundary;
}-*/;




//distance
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



//drag
//drag: true|[ 'center', 'self' ]|false
//Enables/disables dragging.
//Default: [ 'center', 'self' ]
public static final String DRAG_CENTER="center", DRAG_SELF="self"; 
/**
 * Enables/disables dragging (default: true).
 * @return
 */
public native final String[] getDrag()/*-{
	if(!this.drag)
		return null; 
	else {
		return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaStringArray(Lcom/google/gwt/core/client/JsArrayString;)(this.drag); 
	}
}-*/;
/**
 * Enables/disables dragging (default: true).
 * @param d
 */
public native final void setDrag(boolean d)/*-{
	return this.drag=d;
}-*/;
/**an array withone or more DRAG_* consts
 * Enables/disables dragging (default: true).
 * @param d
 */
public native final FTOptions setDrag(String[] s)/*-{
	this.drag = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(s);
	return this; 
}-*/;

/**
 * Sets the radius of the handles in pixels.Default: 5
 * @return
 */
public native final int size() /*-{
return this.size; 
}-*/;

/**
 * Sets the radius of the handles in pixels.Default: 5
 * @param val
 * @return this - for setter chaining
 */
public native final FTOptions size(int val) /*-{
this.size = val; 
return this; 
}-*/;

///**
// * Enables/disables Rotate the subject by dragging (default: false).
// * @return
// */
//public native final boolean isDragRotate()/*-{
//	return this.dragRotate;
//}-*/;
///**
// * Enables/disables Rotate the subject by dragging (default: false).
// * @param d
// */
//public native final void setDragRotate(boolean d)/*-{
//	return this.dragRotate=d;
//}-*/;

///**
// * Enables/disables Scale the subject by dragging (default: false).
// * @return
// */
//public native final boolean isDragScale()/*-{
//	return this.dragScale;
//}-*/;
///**
// * Enables/disables Scale the subject by dragging (default: false).
// * @param d
// */
//public native final void setDragScale(boolean d)/*-{
//	return this.dragScale=d;
//}-*/;

///**
// * Set grid size for aligning elements (default: false).
// * pass/return negative in case of disabled grid size
// */
//public native final int getGridSize()/*-{
//	if(!this.grid)return -1;
//	else return this.gridSnap;
//}-*/;
///**
// * Set grid size for aligning elements (default: false).
// * pass/return negative in case of disabled grid size
// * @param i
// */
//public native final void setGridSize(int i)/*-{
//	if(i<0) this.grid=false;
//	else this.grid=i;
//}-*/;


///**
// * FTSnap edges to grid when num pixels away from grid (default: value of grid).
// * pass/return negative in case of use default value
// */
//public native final int getGridSnap()/*-{
//	if(!this.gridSnap)return -1;
//	else return this.gridSnap;
//}-*/;
///**
// * FTSnap edges to grid when num pixels away from grid (default: value of grid).
// * pass/return negative in case of use default value
// * @param i
// */
//public native final void setGridSnap(int i)/*-{
//	if(i<0) this.gridSnap=false;
//	else this.gridSnap=i;
//}-*/;

/**Scale axes together or individually (default: false)*/
public native final boolean isKeepRatio()/*-{
	return this.keepRatio;
}-*/;
/**Scale axes together or individually (default: false)*/
public native final FTOptions setKeepRatio(boolean kr)/*-{
	this.keepRatio = kr;
	return this; 
}-*/;



//snap
//snap: { rotate: num, scale: num, drag: num }:
//Snap transformations to num degrees (rotate) or pixels (scale, drag).
//Default: { rotate: 0, scale: 0, drag: 0 }
/**
 * Snap transformations to num degrees (rotate) or pixels (scale, drag).
 * @param s
 * @return
 */
public native final FTOptions setSnap(FTSnap s)/*-{
	this.snap=s.@org.sgx.raphael4gwt.raphael.ft.FTSnap::toNative()(); 
	return this; 
}-*/;
/**
 * Snap transformations to num degrees (rotate) or pixels (scale, drag).
 * @return current snap
 */
public native final FTSnap getSnap()/*-{
	return @org.sgx.raphael4gwt.raphael.ft.FTSnap::fromNative(Lcom/google/gwt/core/client/JavaScriptObject;)(this.snap);
}-*/;

//snapDist: { rotate: num, scale: num, drag: num }
//Snap distance in degrees (rotate) or pixels (scale, drag).
//Default: { rotate: 0, scale: 0, drag: 7 }

/**
 * Snap transformations to num degrees (rotate) or pixels (scale, drag).
 * @param s
 * @return
 */
public native final FTOptions setSnapDist(FTSnap s)/*-{
	this.snapDist=s.@org.sgx.raphael4gwt.raphael.ft.FTSnap::toNative()(); 
	return this; 
}-*/;
/**
 * Snap transformations to num degrees (rotate) or pixels (scale, drag).
 * @return current snap
 */
public native final FTSnap getSnapDist()/*-{
	return @org.sgx.raphael4gwt.raphael.ft.FTSnap::fromNative(Lcom/google/gwt/core/client/JavaScriptObject;)(this.snapDist);
}-*/;




//rotate 

//rotate: true|[ 'axisX', 'axisY', 'self' ]|false
//
//Enables/disables rotating.
//
//Default: [ 'axisX', 'axisY' ]
		
/**Enables/disables rotating (default: true).*/
public native final boolean isRotate()/*-{
	return this.rotate;
}-*/;
/**Enables/disables rotating (default: true).*/
public native final void setRotate(boolean kr)/*-{
	this.rotate = kr;
}-*/;

public static final String ROTATE_AXISX="axisX", ROTATE_AXISY="axisY", ROTATE_SELF="self"; 
/**
 * config rotate
 * s an array of SCALE_* consts
 * @param s
 */
public native final void setRotate(String[] s)/*-{
	this.rotate = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(s);
//	this.rotate = kr;
}-*/;



//snap 
//snap: { rotate: num, scale: num, drag: num }:
//FTSnap transformations to num degrees (rotate) or pixels (scale, drag).
//Default: { rotate: 0, scale: 0, drag: 0 }



///**Limit the range of rotation (default: [ -180, 180 ])*/
//public native final JsArrayInteger getRotateRange()/*-{
//	return this.rotateRange;
//}-*/;
///**Limit the range of rotation (default: [ -180, 180 ])*/
//public native final void setRotateRange(int a1, int a2)/*-{
//	return this.rotateRange=[a1, a2];
//}-*/;

///**
// * Rotate with n degree increments (default: false).
// * pass/return negative in case of use default value
// */
//public native final int getRotateSnap()/*-{
//	if(!this.rotateSnap)return -1;
//	else return this.rotateSnap;
//}-*/;
///**
// * Rotate with n degree increments (default: false).
// * pass/return negative in case of use default value
// * @param i
// */
//public native final void setRotateSnap(int i)/*-{
//	if(i<0) this.rotateSnap=false;
//	else this.rotateSnap=i;
//}-*/;





//scale 
//scale: true|[ 'axisX', 'axisY', 'bboxCorners', 'bboxSides' ]|false
//
//Enables/disables scaling.
//
//Default: [ 'axisX', 'axisY', 'bboxCorners', 'bboxSides' ]

/**Enables/disables scaling (default: true).*/
public native final boolean isScale()/*-{
	return this.scale;
}-*/;
/**Enables/disables scaling (default: true).*/
public native final void setScale(boolean kr)/*-{
	this.scale = kr;
}-*/;

public static final String SCALE_AXISX="axisx", 
	SCALE_AXISY="axisy", 
	SCALE_BBOXCORNERS="bboxCorners" , 
	SCALE_BBOXSIDES = "bboxSides"; 

/**config scale
 * @param s an array of some SCALE_*consts
 */
public native final void setScale(String [] s)/*-{
	this.scale = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(s);
}-*/;

///**Limit the range of rotation (default: [ -180, 180 ])*/
//public native final JsArrayInteger getScaleRange()/*-{
//	if(!this.scaleRange)return null;
//	else return this.scaleRange;
//}-*/;
///**Limit the range of rotation (default: [ -180, 180 ])*/
//public native final void setScaleRange(int a1, int a2)/*-{
//	if(a1<0||a2<0)this.scaleRange=false;
//	else this.scaleRange=[a1, a2];
//}-*/;





//range
public native final void setRange(double rotateMin, double rotateMax, 
		double scaleMin, double scaleMax)/*-{
	this.range = {"rotate": [rotateMin, rotateMax], "scale": [scaleMin, scaleMax]}; 
}-*/;
public native final void setRangeRotate(double rotateMin, double rotateMax)/*-{
	var scale = this.range.scale ? this.range.scale : [0,99999]; 
	this.range = {"rotate": [rotateMin, rotateMax], "scale": scale}; 
}-*/;
public native final void setRangeScale(double scaleMin, double scaleMax)/*-{
	var rotate = this.range.rotate ? this.range.rotate : [-180, 180]; 
	this.range = {"rotate": rotate, "scale": [scaleMin, scaleMax]}; 
}-*/;



public static final String DRAW_BBOX="bbox", DRAW_CIRCLE = "circle"; 
/**
 * Additional elements to draw.
 * @param draw - a string containing DRAW_* consts
 * Default: false */
public native final FTOptions setDraw(String[] draw)/*-{
	if(!draw)
		this.draw = false; 
	else 
		this.draw = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(draw);
		
	return this; 
}-*/;



}
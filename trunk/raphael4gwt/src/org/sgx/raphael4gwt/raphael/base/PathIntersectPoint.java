package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
/**
 * @see http://raphaeljs.com/reference.html#Raphael.pathIntersection
 * this is returned by Raphael.pathIntersection(path1, path2) : 
 * <pre>
   . x:number - x coordinate of the point
   . y:number - y coordinate of the point
   . t1:number - t value for segment of path1
   . t2:number - t value for segment of path2
   . segment1 number - order number for segment of path1
   . segment2:number - order number for segment of path2
   . bez1:array - eight coordinates representing beziér curve for the segment of path1
   . bez2:array - eight coordinates representing beziér curve for the segment of path2 
   </pre>
 * @author sg
 *
 */
public final class PathIntersectPoint extends JavaScriptObject {
	
	protected PathIntersectPoint(){}
	
//double x, y, t1, t2, segment1, segment2;
//JsArray<Point> bez1, bez2;
	
	
public native final double getX()/*-{
	return this.x;
}-*/;

//public native final void setX(double x)/*-{
//	this.x = x;
//}-*/;

public native final double getY()/*-{
	return this.y;
}-*/;

//public native final void setY(double y) {
//	this.y = y;
//}
public native final double getT1()/*-{
	return this.t1;
}-*/;

//public native final void setT1(double t1) {
//	this.t1 = t1;
//}
public native final double getT2()/*-{
	return this.t2;
}-*/;

//public native final void setT2(double t2) {
//	this.t2 = t2;
//}
public native final double getSegment1()/*-{
	return this.segment1;
}-*/;

//public native final void setSegment1(double segment1) {
//	this.segment1 = segment1;
//}
public native final double getSegment2()/*-{
	return this.segment2;
}-*/;

//public native final void setSegment2(double segment2) {
//	this.segment2 = segment2;
//}
public native final JsArray<Point> getBez1()/*-{
	return this.bez1;
}-*/;

//public native final void setBez1(JsArray<Point> bez1) {
//	this.bez1 = bez1;
//}
public native final JsArray<Point> getBez2()/*-{
	return this.bez2;
}-*/;

//public native final void setBez2(JsArray<Point> bez2) {
//	this.bez2 = bez2;
//}	

}

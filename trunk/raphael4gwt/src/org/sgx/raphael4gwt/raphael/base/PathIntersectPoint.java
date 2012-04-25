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
public class PathIntersectPoint extends JavaScriptObject {
double x, y, t1, t2, segment1, segment2;
JsArray<Point> bez1, bez2;
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public double getT1() {
	return t1;
}
public void setT1(double t1) {
	this.t1 = t1;
}
public double getT2() {
	return t2;
}
public void setT2(double t2) {
	this.t2 = t2;
}
public double getSegment1() {
	return segment1;
}
public void setSegment1(double segment1) {
	this.segment1 = segment1;
}
public double getSegment2() {
	return segment2;
}
public void setSegment2(double segment2) {
	this.segment2 = segment2;
}
public JsArray<Point> getBez1() {
	return bez1;
}
public void setBez1(JsArray<Point> bez1) {
	this.bez1 = bez1;
}
public JsArray<Point> getBez2() {
	return bez2;
}
public void setBez2(JsArray<Point> bez2) {
	this.bez2 = bez2;
}	

}

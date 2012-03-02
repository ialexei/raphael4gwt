package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.base.Point;

public class Path extends Shape {
protected Path(){}
/**
 * Return coordinates of the point located at the given length on the given path
 * @param length
 * @return
 */
public final native Point getPointAtLength(int length)/*-{
	return this.getPointAtLength(length);
}-*/;
/**
 * Return coordinates of the point located at the given length on the given path
 * @param length
 * @return
 */
public final native Point getPointAtLength(double length)/*-{
	return this.getPointAtLength(length);
}-*/;
/**
 * Return subpath of a given element from given length to given length
 * @param from position of the start of the segment
 * @param to position of the end of the segment
 * @return pathstring for the segment
 */ 
public final native String getSubpath(int from, int to)/*-{
	return this.getSubpath(from, to);
}-*/;
/**
 * @return length of the path in pixels.
 */
public final native double getTotalLength()/*-{
	return this.getTotalLength();
}-*/;


}

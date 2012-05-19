package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.graphael.GShape;

public class Bar extends GShape {
	protected Bar(){}	
	public native final double getX()/*-{
		return this.x;
	}-*/;
	public native final double getY()/*-{
		return this.y;
	}-*/;
	public native final double getValue()/*-{
		return this.value;
	}-*/;
	public native final void setValue(double v)/*-{
		this.value=v;
	}-*/;
	public native final double getWidth()/*-{
		return this.w||0;
	}-*/;
	public native final double getHeight()/*-{
		return this.h||0;
	}-*/;
}

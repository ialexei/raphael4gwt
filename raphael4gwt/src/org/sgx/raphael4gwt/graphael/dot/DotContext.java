package org.sgx.raphael4gwt.graphael.dot;

public class DotContext extends DotChart {
protected DotContext(){}
public final native double getX()/*-{
	return this.x;
}-*/;
public final native double getY()/*-{
	return this.y;
}-*/;
public final native double getValue()/*-{
	return this.value;
}-*/;
public final native double getR()/*-{
	return this.r;
}-*/;

}

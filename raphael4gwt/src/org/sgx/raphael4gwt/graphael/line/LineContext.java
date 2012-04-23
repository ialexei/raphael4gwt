package org.sgx.raphael4gwt.graphael.line;



public final class LineContext extends LineChart {
	
protected LineContext(){}

public native final double getX()/*-{
	return this.x;
}-*/;

public native final double[]  getY()/*-{
//	return this.y;
	return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaDoubleArray(Lcom/google/gwt/core/client/JsArrayNumber;)(this.y);
}-*/;

public native final double[] getValues()/*-{
//	return this.values;
	return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaDoubleArray(Lcom/google/gwt/core/client/JsArrayNumber;)(this.values);
}-*/;

public native final LineChart getChart()/*-{
	return this;
}-*/;


}

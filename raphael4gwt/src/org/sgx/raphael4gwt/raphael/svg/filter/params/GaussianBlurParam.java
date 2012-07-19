package org.sgx.raphael4gwt.raphael.svg.filter.params;
/**
 * 
 * @author sg
 *
 */
public class GaussianBlurParam extends FilterOperationParam {
protected GaussianBlurParam(){}
public static final native GaussianBlurParam create(double[]stdDeviation)/*-{
	return {
		"stdDeviation": @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([D)(stdDeviation) 
	}; 
}-*/;
public static final native GaussianBlurParam create(double stdDeviation)/*-{
return {
	"stdDeviation": stdDeviation
}; 
}-*/;
public native final String getStdDeviation()/*-{
return this.stdDeviation; 
}-*/;
public native final void setStdDeviation(String stdDeviation)/*-{
this.stdDeviation=stdDeviation; 
}-*/;
}

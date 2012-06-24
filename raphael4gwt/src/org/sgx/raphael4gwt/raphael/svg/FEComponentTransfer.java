package org.sgx.raphael4gwt.raphael.svg;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * java datatype for representing a feComponentTransfer SVG filter. 
 * @see Shape.componentTransfer()
 * @author sg
 *
 */
public class FEComponentTransfer extends JavaScriptObject {
public static final String TYPE_LINEAR = "linear"; 

protected FEComponentTransfer(){}

//double redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept;

//public final native static FEComponentTransfer create(
//		double redSlope, double redIntercept, String redType, 
//		double greenSlope, double greenIntercept, String greenType,
//		double blueSlope, double blueIntercept, String blueType
//		)/*-{
//	return  {
//		funcR: {slope: redSlope, intercept: redIntercept, type: redType}, 
//		funcG: {slope: greenSlope, intercept: greenIntercept, type: greenType},
//		funcB: {slope: blueSlope, intercept: blueIntercept, type: blueType}
//	}; 
//}-*/;

//public final native double getRedSlope()/*-{
//	return this.funcR.slope;
//}-*/;
//public final native double getRedIntercept()/*-{
//	return this.funcR.intercept;
//}-*/;



//private JavaScriptObject nativeValue = null; 

//public JavaScriptObject toNative() {
////	if(nativeValue==null) {
////		nativeValue  = _toNative(redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept); 
////	}
//	return _toNative(redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept); 
//}
//
//private final native static JavaScriptObject _toNative(double redSlope2, double redIntercept2,
//	double blueSlope2, double blueIntercept2, double greenSlope2, double greeIntercept2)/*-{
//	
//	return  {
//		funcR: {slope: redSlope2, intercept: redIntercept2}, 
//		funcG: {slope: greenSlope2, intercept: greenIntercept2},
//		funcB: {slope: blueSlope2, intercept: blueIntercept2}
//	}; 


}

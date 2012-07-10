package org.sgx.raphael4gwt.raphael.svg.filter.trash;
//package org.sgx.raphael4gwt.raphael.svg;
//
//import com.google.gwt.core.client.JavaScriptObject;
//
///**
// * java datatype for representing a feComponentTransfer SVG filter. 
// * @see Shape.componentTransfer()
// * 
//el.componentTransferLinear("brightness1", OBJ(new Object[] { 
//	"funcR", OBJ(new Object[] { "slope", factor, "intercept", 0}), 
//	"funcG", OBJ(new Object[] { "slope", factor, "intercept", 0}), 
//	"funcB", OBJ(new Object[] { "slope", factor, "intercept", 0}) })
//);		
//		
//usage: ashape.componentTransferLinear("name1", FEComponentTransfer.create(0.5, 0, 0.5, 0, 0.5, 0, 0.5, 0));
// 
//TODO: make this an overlay type for efficiency.
// * @author sg
// *
// */
//public class FEComponentTransferLinear extends FEComponentTransfer {
//
//protected FEComponentTransferLinear(){}
//
////double redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept;
//
//public final native static FEComponentTransferLinear create(double redSlope, double redIntercept,
//		double blueSlope, double blueIntercept, double greenSlope, double greenIntercept)/*-{
//	return  {
//		funcR: {slope: redSlope, intercept: redIntercept}, 
//		funcG: {slope: greenSlope, intercept: greenIntercept},
//		funcB: {slope: blueSlope, intercept: blueIntercept}
//	}; 
//}-*/;
//
//
//
////private JavaScriptObject nativeValue = null; 
//
////public JavaScriptObject toNative() {
//////	if(nativeValue==null) {
//////		nativeValue  = _toNative(redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept); 
//////	}
////	return _toNative(redSlope, redIntercept, blueSlope, blueIntercept, greenSlope, greeIntercept); 
////}
////
////private final native static JavaScriptObject _toNative(double redSlope2, double redIntercept2,
////	double blueSlope2, double blueIntercept2, double greenSlope2, double greeIntercept2)/*-{
////	
////	return  {
////		funcR: {slope: redSlope2, intercept: redIntercept2}, 
////		funcG: {slope: greenSlope2, intercept: greenIntercept2},
////		funcB: {slope: blueSlope2, intercept: blueIntercept2}
////	}; 
//
//
//}

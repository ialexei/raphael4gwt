package org.sgx.raphael4gwt.raphael.svg.filter.trash.ops;
//package org.sgx.raphael4gwt.raphael.svg.filter.ops;
//
//import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
//import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
//
//import com.google.gwt.core.client.JavaScriptObject;
//import com.google.gwt.core.client.JsArrayMixed;
//
///**
// * parent filter operation - contain common filter operation attributes 
// * (http://www.w3.org/TR/SVG/filters.html#CommonAttributes)
// * like x, y, width, height, in, result, etc. 
// * @author sg
// *
// */
//public abstract class FilterOpDef {
//	public abstract String getFilterOperationName();
////	public static final String INPUT_SOURCEGRAPHIC="SourceGraphic"; 
//	//TODO: othersSourceGraphic | SourceAlpha | BackgroundImage | BackgroundAlpha | FillPaint | StrokePaint | <filter-primitive-reference>"
//	
//	public FilterOpDef() {
//		x=0; y=0; width=Integer.MAX_VALUE; height=Integer.MAX_VALUE; result=null; in=null; 
//	}
//double x=0, y=0, width=Integer.MAX_VALUE, height=Integer.MAX_VALUE;
//String result=null, in=null; 
//
///**
// * @return the filter op native object representation 
// * subclasses must override this and call super.toNative to concatenate 
// * concrete filter op params.  
// * */
//public FilterOperationParam toNative() {
//	FilterOperationParam o = JavaScriptObject.createObject().cast(); 
//	JsUtil.put(o, "x", x);
//	JsUtil.put(o, "y", y); 
//	JsUtil.put(o, "width", width);
//	JsUtil.put(o, "height", height);
//	if(result!=null)
//		JsUtil.put(o, "result", result);
//	if(in!=null)
//		JsUtil.put(o, "in", in);
//	
//	return o; 
//}
//
//
//}

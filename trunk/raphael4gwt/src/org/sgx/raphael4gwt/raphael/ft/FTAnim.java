//package org.sgx.raphael4gwt.raphael.ft;
//
//import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
//
//import com.google.gwt.core.client.JavaScriptObject;
///**
// * animation datatype for free transform plugin
// * @author sg
// *
// */
//public class FTAnim{
//	
//int delay; 
//String easing;
//
//
//public FTAnim(int delay, String easing) {
//	super();
//	this.delay = delay;
//	this.easing = easing;
//}
//public int getDelay() {
//	return delay;
//}
//public void setDelay(int delay) {
//	this.delay = delay;
//}
//public String getEasing() {
//	return easing;
//}
//public void setEasing(String easing) {
//	this.easing = easing;
//} 
//
//public JavaScriptObject toNative() {
//	JavaScriptObject o = JavaScriptObject.createObject();
//	JsUtil.put(o, "easing", getEasing());
//	JsUtil.put(o, "delay", getDelay());
//	return o; 
//}
//
//public static FTAnim fromNative(JavaScriptObject o) {
//	return new FTAnim(JsUtil.getInt(o, "delay"), JsUtil.getString(o, "easing")); 
//}
//}

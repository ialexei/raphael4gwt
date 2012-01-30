package org.sgx.raphael4gwt.raphael.jsutil;

import java.util.Map;

import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

public class JsUtil {
	public static native <T> T get(JavaScriptObject o, Object p)/*-{
	//	$wnd.alert("in prop "+o+" - "+p+" - "+o.getAttribute(p));
		return o[p];
	}-*/;
	public static native Object put(JavaScriptObject o, Object pname, Object val)/*-{
	//	$wnd.alert("in prop "+o+" - "+p+" - "+o.getAttribute(p));
		o[pname]=val;
	}-*/;
	public static native JsArrayString props(JavaScriptObject o)/*-{
		var props = [];
		for(var i in o) {
			props.push(i+"");;
		}
		return props;
	}-*/;
	public static native JavaScriptObject empty()/*-{
		return {};
	}-*/;
	
	public static  JavaScriptObject obj(Map<String, Object> props) {
		JavaScriptObject o = empty();
		for(String k : props.keySet()) {
			Object val = props.get(k);
			put(o, k, val);
		}
		return o;
	}
	public static  JavaScriptObject obj(Object...m) {
		return obj(Util.toMap2(m));
	}
	public static native JavaScriptObject arrayEmpty()/*-{
		return [];
	}-*/;
	
	public static native JavaScriptObject arrayPush(JavaScriptObject arr, JavaScriptObject o)/*-{
		arr.push(o);
		return arr;
	}-*/;
//	public static JsArray<JavaScriptObject> toArray(JavaScriptObject ...objs) {
//		JsArray<JavaScriptObject> a = (JsArray<JavaScriptObject>) JsArray.createArray();
//		for (int i = 0; i < objs.length; i++) {
//			a.push(objs[i]);
//		}
//		return a;
//	}
	public static JsArrayNumber toJsArrayNumber(int[] a) {
		JsArrayNumber jsa = (JsArrayNumber) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}

	
	
	
	

	
//	public static native Object apply(JavaScriptObject func, Object thisArg, 
//			Object[] params)/*-{
//		$wnd.alert("aboutto");
//		return func.apply(thisArg, params);
//		$wnd.alert("afterthat");
//	}-*/;
//	

}

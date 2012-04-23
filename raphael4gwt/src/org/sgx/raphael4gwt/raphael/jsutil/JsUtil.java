package org.sgx.raphael4gwt.raphael.jsutil;

import java.util.Map;

import org.sgx.raphael4gwt.graphael.bar.BarContext;
import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
/**
 * javascript related utilities
 * @author sg
 *
 */
public class JsUtil {
	public static native <T> T get(JavaScriptObject o, Object p)/*-{
		return o[p];
	}-*/;
	public static native Object put(JavaScriptObject o, Object pname, Object val)/*-{
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
	public static JavaScriptObject obj(Object...m) {
		return obj(Util.toMap2(m));
	}
	public static native JavaScriptObject arrayEmpty()/*-{
		return [];
	}-*/;
	
	public static native JavaScriptObject arrayPush(JavaScriptObject arr, JavaScriptObject o)/*-{
		arr.push(o);
		return arr;
	}-*/;

	public static JsArrayNumber toJsArrayNumber(int[] a) {
		JsArrayNumber jsa = (JsArrayNumber) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}

	
	public static JsArrayNumber toJsArray(double[]a) {
		JsArrayNumber jsa = (JsArrayNumber) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}
	public static JsArrayString toJsArray(String[] a) {
		JsArrayString jsa = (JsArrayString) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}
	public static JsArray toJsArray(JavaScriptObject[] ja) {
		JsArray jsa = (JsArray) JsArray.createArray();
		for(JavaScriptObject t : ja) {
			jsa.push(t);
		}
		return jsa;
	}
	
	public static JsArray to2DJsArray(double[][] ja) {
		JsArray jsa = (JsArray) JsArray.createArray();
		if(ja==null)
			return jsa;
		for (int i = 0; i < ja.length; i++) {
			jsa.push(toJsArray(ja[i]));
		}
		return jsa;
	}
	public static JsArray to2DJsArray(String[][] ja) {
		JsArray jsa = (JsArray) JsArray.createArray();
		if(ja==null)
			return jsa;
		for (int i = 0; i < ja.length; i++) {
			jsa.push(toJsArray(ja[i]));
		}
		return jsa;
	}
	public final native static void putBoolean(JavaScriptObject o, String prop,
			boolean b)/*-{
		if(b) {
//			$wnd.alert("putBoolean: "+prop+" - true");
			o[prop]=true;
		}
		else {
//			$wnd.alert("putBoolean: "+prop+" - false");
			o[prop]=false;
		}
		
	}-*/;
	public final native static void putNumber(JavaScriptObject o, String prop, 
			double v) /*-{
		o[prop]=v;
	}-*/;


	public static double[] toJavaDoubleArray(JsArrayNumber a) {
		if(a==null)return null;
		double[] dd = new double[a.length()];
		for (int i = 0; i < dd.length; i++) {
			dd[i]=a.get(i);
		}
		return dd;
	}
//	public static String dump(JavaScriptObject o) {
//		String s = "(";
////		o.
//		return s+")";
//	}
}

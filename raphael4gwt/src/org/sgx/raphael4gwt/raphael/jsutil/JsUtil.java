package org.sgx.raphael4gwt.raphael.jsutil;

import java.util.Map;

import org.sgx.raphael4gwt.raphael.base.CSSRule;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
/**
 * javascript related utilities
 * @author sg
 *
 */
public class JsUtil {
	/**
	 * usefull for setting breakpoints in firebug from java.
	 */
	public static native void firebug()/*-{
		$wnd.r4g._firebug();
	}-*/;

	public static native <T> T get(JavaScriptObject o, Object p)/*-{
		return o[p];
	}-*/;

	public static native String getString(JavaScriptObject o, String s)/*-{
		return o[s]; 
	}-*/;

	public static native int getInt(JavaScriptObject o, String s)/*-{
		return o[s]; 
	}-*/;

	
	public static native JavaScriptObject put(JavaScriptObject o, Object pname, Object val)/*-{
		o[pname]=val;
		return o; 
	}-*/;
	public static native JavaScriptObject put(JavaScriptObject o, Object pname, int val)/*-{
		o[pname]=val;
		return o; 
	}-*/;
	public static native JavaScriptObject put(JavaScriptObject o, Object pname, double val)/*-{
		o[pname]=val;
		return o; 
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

	public static boolean arrayContains(JsArray<JavaScriptObject> a, 
			JavaScriptObject val) {
		for (int i = 0; i < a.length(); i++) {
			JavaScriptObject o = a.get(i);
			if(o!=null&&o.equals(val))
				return true;
		}
		return false;
	}
	
	public static boolean arrayContains(JsArrayMixed a, String val) {
		for (int i = 0; i < a.length(); i++) {
			String o = a.getString(i);
			if(o!=null&&o.equals(val))
				return true;
		}
		return false;
	}
	
	public static boolean arrayContains(JsArrayString a, 
			String val) {
		for (int i = 0; i < a.length(); i++) {
			String o = a.get(i);
			if(o!=null&&o.equals(val))
				return true;
		}
		return false;
	}
	public static boolean arrayContains(JsArrayNumber a, 
			String val) {
		for (int i = 0; i < a.length(); i++) {
			Number o = a.get(i);
			if(o!=null&&o.equals(val))
				return true;
		}
		return false;
	}
	public static JsArrayNumber toJsArrayNumber(int[] a) {
		JsArrayNumber jsa = (JsArrayNumber) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}
//	public static JsArrayMixed toJsArrayJavaObject(Object[] a) {
//		JsArrayMixed jsa = (JsArrayMixed) JsArray.createArray();
//		for (int i = 0; i < a.length; i++) {
//			jsa.push((JavaScriptObject) a[i]);
//		}
//		return jsa;
//	}
	
	public static JsArrayNumber toJsArray(double[]a) {
		if(a==null)
			return null;
		JsArrayNumber jsa = (JsArrayNumber) JsArrayNumber.createArray();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}
	public static JsArrayString toJsArray(String[] a) {
		if(a==null)
			return null;
		JsArrayString jsa = JsArrayNumber.createArray().<JsArrayString>cast();
		for (int i = 0; i < a.length; i++) {
			jsa.push(a[i]);
		}
		return jsa;
	}
	public static JsArray toJsArray(JavaScriptObject[] ja) {
		if(ja==null)
			return null;
		JsArray jsa = (JsArray) JsArray.createArray();
		for(JavaScriptObject t : ja) {
			jsa.push(t);
		}
		return jsa;
	}
	public static JavaScriptObject toJsObject(Object ... ja) {
		if(ja==null)
			return null;
		JavaScriptObject jso = JsArray.createObject();
		for (int i = 0; i < ja.length; i+=2) {
			put(jso, ja[i], ja[i+1]); 
		}
		return jso;
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
	public static String[] toJavaStringArray(JsArrayString a) {
		if(a==null)return null;
		String[] dd = new String[a.length()];
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

	public static native JavaScriptObject evalObject(String s)/*-{
		return $wnd.eval("("+s+")");
	}-*/;

	public static String print(JsArrayMixed a) {
		String s = "JSArray[";
		for(int i = 0; i<a.length(); i++) {
			s+=a.getString(i)+", ";
		}
		return s+"]";
	}

	public static String print(NativeEvent e) {
		return "Event "+e.getType()+"("+e.getScreenX()+", "+e.getScreenY()+")"; 
	}

	public static native final void arrayRemoveItem(JsArray<?> a, int i)/*-{
		a.splice(i, 1)
	}-*/;

	public static native double getDouble(JavaScriptObject o, String p)/*-{
		return o[p]; 
	}-*/;

	public static native final String dump(JavaScriptObject obj, boolean printValues)/*-{
		var s = "{"; 
		for(var i in obj) {
			s+=i+(printValues ? ": "+obj[i] : "")+", "; 
		}
		return s+"}"; 
	}-*/;






	
}

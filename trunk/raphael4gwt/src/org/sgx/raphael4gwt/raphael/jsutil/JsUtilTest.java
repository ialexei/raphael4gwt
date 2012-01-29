package org.sgx.raphael4gwt.raphael.jsutil;

import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;


public class JsUtilTest extends TestBase {
	
	public void testGetAndPut() {
		JavaScriptObject o1 = JsUtil.obj(Util.toMap2(new Object[]{
			"firstname", "sebastian", 
			"lastname", "gurin"
		}));
		
		assertEquals("sebastian", JsUtil.get(o1, "firstname"));
		assertEquals("gurin", JsUtil.get(o1, "lastname"));
		
		assertTrue(JsUtil.get(o1, "arrayedProp")==null);
		JsUtil.put(o1, "arrayedProp", new String[]{"hello", "world"});
		assertTrue(JsUtil.get(o1, "arrayedProp")!=null);
		String[]p1 = JsUtil.get(o1, "arrayedProp");
		assertTrue(p1!=null);
		assertEquals(2, p1.length);
		assertEquals("hello", p1[0]);
		assertEquals("world", p1[1]);
	}
	

	public void testProps() {
		JavaScriptObject o1 = JsUtil.obj(Util.toMap2(new Object[]{
			"firstname", "sebastian", 
			"lastname", "gurin"
		}));
		JsArrayString props = JsUtil.props(o1);
		for (int i = 0; i < props.length(); i++) {
			assertTrue(props.get(i).equals("firstname")||props.get(i).equals("lastname"));
		}
	}
	
	
	
	
	
//	public void testApply() {
//		JavaScriptObject sumFunc = getSumFunc();
//		JavaScriptObject arr1 = JsUtil.arrayEmpty();
//		System.out.println("jjj: "+JsUtil.apply(sumFunc, JsUtil.empty(), new Integer[]{1, 2}));
////		assertEquals(3,JsUtil.apply(sumFunc, JsUtil.empty(), new Integer[]{1, 2}));
//		
////		JavaScriptObject afunc1 = getAlertFunc();
////		JsUtil.apply(afunc1, JsUtil.empty(), null);
//		
//		JavaScriptObject o1 = JsUtil.empty();
//		String msg1 = "hello world";
//		JsUtil.put(o1, "prop1", msg1);
//		JavaScriptObject pmf1 = getPropFunct();
//		assertEquals(msg1, JsUtil.apply(pmf1, o1, null));
////		o = JavaScriptObject.createObject();
//	}
	
//	public void testJsFunction() {
//		JsFunction<String> getStrFunc = getStrFunc();
//		assertEquals("hello", getStrFunc.apply());
//		assertEquals("hello", getStrFunc.apply(null, null));
//		assertEquals("hello", getStrFunc.apply(JsUtil.empty(), null));
//		System.out.println("HHHHH: " +getStrFunc.apply());
//	}
//	private static native <T>JsFunction<T> getStrFunc()/*-{
//		return function() {return "hello"; };
//	}-*/;
//	private static native JavaScriptObject getPropFunct()/*-{
//		return function() {return this.prop1; };
//	}-*/;
//	private static native JavaScriptObject getSumFunc()/*-{
//		return function(a, b) {return a+b+""; };
//	}-*/;
	
	
	
	
//	public void testJsFuncAndRunnables() {
//		Runnable0 r = new Runnable0() {
//			@Override
//			public JavaScriptObject run0() {
//				System.out.println("FROM RUNNABLE!");
//				return null;
//			}
//		};
//		JsFunction<Object> jsFunc = r.asJsFunction();
//		jsFunc.call();
//	}
//	
	
	
//	private static native JavaScriptObject getAlertFunc()/*-{
////		alert("hello");
//		return {};
//	}-*/;
	
	
//	public void testNative1() {
//		Bean1 b1 = new Bean1("seba", "g");
//		j
//		native1(b1);
//	}
	
	
//	public native static void native1(JavaScriptObject.)/*-{
//		var dump = function(o) {
//			var s = "{";
//			for(var i in o) {
//				s+=i+", ";
//			}
//			return s+"}";
//		};
//		$wnd.alert(dump(r));
//		var method1 = r.@org.sgx.gwtraphaljstest.client.js.AbstractRunnable::getParamCount();
//		$wnd.alert(dump(method1));
////		var pcount = r.@org.sgx.gwtraphaljstest.client.js.AbstractRunnable::getParamCount()();
//	
//	}-*/;
	
	
	
}

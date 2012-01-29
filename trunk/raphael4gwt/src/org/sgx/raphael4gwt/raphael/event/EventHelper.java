package org.sgx.raphael4gwt.raphael.event;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * internal helper. mantains a map between MouseEventListener java objects and native javascript functions.
 * mainly needed for unregister events, like unclick, etc. for finding the native function from a MouseEventListener
 * @author sg
 *
 */
public class EventHelper {
	
	static JavaScriptObject mouseEventsListeners = JsUtil.empty();
	
	public static void putMouseEventListener(MouseEventListener l,JavaScriptObject f) {
		JsUtil.put(mouseEventsListeners, l, f);
	}
	public static JavaScriptObject removeMouseEventListener(MouseEventListener l) {
		JavaScriptObject o = JsUtil.get(mouseEventsListeners, l);
		JsUtil.put(o, l, null);
		return o;
	}
	public static JavaScriptObject getMouseEventListener(MouseEventListener l) {
		return JsUtil.get(mouseEventsListeners, l);
	}
	
	
	
	static JavaScriptObject hoverListeners = JsUtil.empty();
	
	public static void putHoverListener(HoverListener l,JavaScriptObject hin, JavaScriptObject hout) {
		JsArray<JavaScriptObject> a = (JsArray<JavaScriptObject>) JsArray.createArray();
		a.push(hin);
		a.push(hout);
		JsUtil.put(hoverListeners, l, a);
	}
	public static JsArray<JavaScriptObject> removeHoverListener(HoverListener l) {
		JsArray<JavaScriptObject> o = JsUtil.get(hoverListeners, l);
		JsUtil.put(o, l, null);
		return o;
	}
	public static JsArray<JavaScriptObject> getHoverListener(HoverListener l) {
		return JsUtil.get(hoverListeners, l);
	}
}

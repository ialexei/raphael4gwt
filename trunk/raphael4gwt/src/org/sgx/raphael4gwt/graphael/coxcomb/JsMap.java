package org.sgx.raphael4gwt.graphael.coxcomb;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * an utility for working with objects which properties values are other objects of the same type, like
 * 
 * <pre>
 * { 
 *         disease  : {
 *           color : "#E9E581",
 *           opacity : 0.8,
 *           fontColor: "#000",
 *         },
 *         wounds : {
 *           color: "#DE1B1B",
 *           opacity: 0.7,
 *           fontColor: "#fff"
 *         }, 
 *         etc
 *     }
 * </pre>
 * 
 * @author sg
 * 
 */
public class JsMap<T extends JsObject> extends JsObject {

	protected JsMap() {
	}

	public static final native <T extends JsObject> JsMap<T> create()/*-{
		return {};
	}-*/;

	public static final native <T extends JsObject> JsMap<T> create(JavaScriptObject o)/*-{
		return o;
	}-*/;

	public final native JsMap<T> put(String key, T val)/*-{
		this[key] = val;
		return this;
	}-*/;

	public final native T get(String key)/*-{
		return this[key];
	}-*/;

	public final native JsArrayString keys()/*-{
		return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::objProps(Lcom/google/gwt/core/client/JavaScriptObject;)(this); //gethis.@org.sgx.raphael4gwt.raphael.jsutil.JsObject::objProps()();
	}-*/;

	public final native JsArrayString keysCol()/*-{
		var r = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::objProps(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
		return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaCollection(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
	}-*/;
}

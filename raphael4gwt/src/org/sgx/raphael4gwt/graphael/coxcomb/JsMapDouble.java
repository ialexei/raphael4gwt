package org.sgx.raphael4gwt.graphael.coxcomb;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * This class represents a JavaScriptObject which keys are of type string and values only of type number.
 * 
 * @author sg
 * 
 */
public class JsMapDouble extends JsObject {

	protected JsMapDouble() {
	}

	public static final native JsMapDouble create()/*-{
		return {};
	}-*/;

	public static final native JsMapDouble create(JavaScriptObject o)/*-{
		return o;
	}-*/;

	public final native JsMapDouble put(String key, double val)/*-{
		this[key] = val;
		return this;
	}-*/;

	public final native double get(String key)/*-{
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

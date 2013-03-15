package org.sgx.raphael4gwt.raphy.client.line;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * this represent a point in the line's data, including value and options. 
 * Use toNative() to translate it to the proper native value, this is
 * 
 * <pre>
 * [x, y, {tooltip: "ss"}]
 * </pre>
 * 
 * @author sg
 * 
 */
public class Point extends JsObject {
	protected Point(){}
	public static native final Point create(int x, int y) /*-{
		return {"x": x, "y": y}; 
	}-*/;
	public native final JavaScriptObject toNative() /*-{
		return [ this["x"], this["y"], {
			"tooltip" : this["tooltip"]
		} ];
	}-*/;
	public static JavaScriptObject toNative(Point [] p) {
		JsArray<JavaScriptObject>a = JsArray.createArray().cast();
		for (int i = 0; i < p.length; i++) {
			a.push(p[i].toNative()); 
		}
		return a;
	}
	/**
	 * 
	 * @return
	 */
	public native final double x() /*-{
		return this["x"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Point x(double val) /*-{
		this["x"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final double y() /*-{
		return this["y"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Point y(double val) /*-{
		this["y"] = val;
		return this;
	}-*/;

	/**
	 * custom tooltip label on a particular point. default: the point's y value
	 * 
	 * @return
	 */
	public native final String tooltip() /*-{
		return this["tooltip"];
	}-*/;

	/**
	 * custom tooltip label on a particular point. default: the point's y value
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Point tooltip(String val) /*-{
		this["tooltip"] = val;
		return this;
	}-*/;

	/**
	 * show dot + tooltip as active on page load
	 * 
	 * @return
	 */
	public native final boolean show_dot() /*-{
		return this["show_dot"];
	}-*/;

	/**
	 * show dot + tooltip as active on page load
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Point show_dot(boolean val) /*-{
		this["show_dot"] = val;
		return this;
	}-*/;

	/**
	 * don't render a dot + tooltip on this point
	 * 
	 * @return
	 */
	public native final boolean no_dot() /*-{
		return this["no_dot"];
	}-*/;

	/**
	 * don't render a dot + tooltip on this point
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Point no_dot(boolean val) /*-{
		this["no_dot"] = val;
		return this;
	}-*/;
}

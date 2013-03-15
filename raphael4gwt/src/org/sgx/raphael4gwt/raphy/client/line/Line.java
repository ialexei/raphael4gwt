package org.sgx.raphael4gwt.raphy.client.line;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;

public class Line extends JsObject {
	protected Line() {
	}

	public static native final Line create() /*-{
		return {};
	}-*/;

	/**
	 * the native line data, something like [[1, 305],[2, 336],[3, 378],[4, 449],[5, 635],[6, 935],[7, 782]],
	 * 
	 * @return
	 */
	public native final JavaScriptObject data() /*-{
		return this["data"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Line data(JavaScriptObject val) /*-{
		this["data"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Line data(Point... val) /*-{
		this["data"] = @org.sgx.raphael4gwt.raphy.client.line.Point::toNative([Lorg/sgx/raphael4gwt/raphy/client/line/Point;)(val);
		return this;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Line data(double[][] data) /*-{
		this["data"] = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([[D)(data); //@org.sgx.raphael4gwt.raphy.client.line.Point::toNative([Lorg/sgx/raphael4gwt/raphy/client/line/Point;)(val);
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final LineOpts options() /*-{
		return this["options"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Line options(LineOpts val) /*-{
		this["options"] = val;
		return this;
	}-*/;
}

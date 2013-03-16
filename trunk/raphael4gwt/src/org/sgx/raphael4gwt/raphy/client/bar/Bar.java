package org.sgx.raphael4gwt.raphy.client.bar;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

public class Bar extends JsObject {
	protected Bar() {
	}

	public static native final Bar create() /*-{
		return {};
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String label() /*-{
		return this["label"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Bar label(String val) /*-{
		this["label"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final double value() /*-{
		return this["value"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Bar value(double val) /*-{
		this["value"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final BarOpts options() /*-{
		return this["options"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Bar options(BarOpts val) /*-{
		this["options"] = val;
		return this;
	}-*/;
}

package org.sgx.raphael4gwt.raphy.client.bar;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

public class BarOpts extends JsObject {
	protected BarOpts() {
	}

	public static native final BarOpts create() /*-{
		return {};
	}-*/;

	/**
	 * width of the bars
	 * 
	 * @return
	 */
	public native final int bar_width() /*-{
		return this["bar_width"];
	}-*/;

	/**
	 * width of the bars
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarOpts bar_width(int val) /*-{
		this["bar_width"] = val;
		return this;
	}-*/;

	/**
	 * how far apart to place bars
	 * 
	 * @return
	 */
	public native final int bar_spacing() /*-{
		return this["bar_spacing"];
	}-*/;

	/**
	 * how far apart to place bars
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarOpts bar_spacing(int val) /*-{
		this["bar_spacing"] = val;
		return this;
	}-*/;

	/**
	 * color of the bar's fill
	 * 
	 * @return
	 */
	public native final String bar_color() /*-{
		return this["bar_color"];
	}-*/;

	/**
	 * color of the bar's fill
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarOpts bar_color(String val) /*-{
		this["bar_color"] = val;
		return this;
	}-*/;

	/**
	 * how much to round the bars (0 makes square bars)
	 * 
	 * @return
	 */
	public native final int rounding() /*-{
		return this["rounding"];
	}-*/;

	/**
	 * how much to round the bars (0 makes square bars)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarOpts rounding(int val) /*-{
		this["rounding"] = val;
		return this;
	}-*/;
}
